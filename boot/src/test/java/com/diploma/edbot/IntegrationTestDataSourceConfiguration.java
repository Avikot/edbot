package com.diploma.edbot;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class IntegrationTestDataSourceConfiguration {
    private static String host = "127.0.0.1";

    static {
        try {
            RecreateDatabaseHelper.recreateDatabase(host);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean("dataSource")
    @Profile("integrationTest")
    public HikariDataSource datasourceForIntegrationTests() {
        String jdbcUrl = RecreateDatabaseHelper.jdbcUrlForHostAndDb(host, "edbot_tests");
        return RecreateDatabaseHelper.datasourceForDbuser(jdbcUrl);
    }

}
