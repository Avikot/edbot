package com.diploma.edbot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Optional;

public class RecreateDatabaseHelper {

    public static String jdbcUrlForHostAndDb(String host, String databaseName) {
        return "jdbc:postgresql://" + host + ":5432/" + databaseName;
    }

    public static void recreateDatabase(String host) throws SQLException, IOException {

        DataSource postgresDatasource = datasourceForPostgres(jdbcUrlForHostAndDb(host,"postgres"));

        Path currentFolder = Paths.get("./").toAbsolutePath();
        String setupFolder = findSetupFolder(currentFolder).toString();

        ScriptUtils.executeSqlScript(
                postgresDatasource.getConnection(),
                new EncodedResource(new FileSystemResource(setupFolder + "/db_integration_test/edbot_empty_recreate_db.sql")),
                false, //continueOnError,
                true,  //ignoreFailedDrops,
                "--",  //commentPrefix,
                ";",   //separator,
                "/*",  //blockCommentStartDelimiter,
                "*/"   //blockCommentEndDelimiter
        );

        DataSource integrationDatasource = datasourceForPostgres(jdbcUrlForHostAndDb(host,"edbot_tests"));

        Flyway flyway = new Flyway();
        flyway.setTable("db_migration");
        flyway.setPlaceholderPrefix("#{");
        flyway.setDataSource(integrationDatasource);
        flyway.setLocations(
                "filesystem:" + setupFolder + "/db_migration/",
                "filesystem:" + setupFolder + "/db_integration_test/");
        flyway.migrate();

    }

    public static Path findSetupFolder(Path currentFolder) throws IOException {
        Optional<Path> setupFolder =
                Files.list(currentFolder).filter(Files::isDirectory)
                        .filter(dir -> "setup".equals(dir.getFileName().toString()))
                        .findAny();

        if (setupFolder.isPresent()) {
            return setupFolder.get();
        } else {
            return findSetupFolder(currentFolder.getParent());
        }
    }

    public static HikariDataSource datasourceForPostgres(String url) {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername("postgres");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(50);
        config.setIdleTimeout(60_000);
        config.setAutoCommit(true);

        return new HikariDataSource(config);
    }

    public static HikariDataSource datasourceForDbuser(String url) {
        HikariDataSource basicDataSource = datasourceForPostgres(url);
        basicDataSource.setUsername("dbuser");
        return basicDataSource;
    }
}
