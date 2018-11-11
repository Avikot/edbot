REVOKE CONNECT ON DATABASE edbot_tests FROM PUBLIC, dbuser;
SELECT
  pg_terminate_backend(pid)
FROM
  pg_stat_activity
WHERE
  datname = 'edbot_tests';

DROP DATABASE IF EXISTS edbot_tests;
CREATE DATABASE edbot_tests WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
ALTER DATABASE edbot_tests OWNER TO dbuser;