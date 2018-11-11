/*SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

-- drop extension pgcrypto;
create extension pgcrypto;


CREATE TABLE faculties (
                         guid character varying(50),
                         parent character varying(50),
                         name character varying(500) NOT NULL
);


ALTER TABLE faculties OWNER TO dbuser;


INSERT INTO faculties VALUES ('0', null, 'rshu');

ALTER TABLE ONLY faculties
  ADD CONSTRAINT pk_organizations PRIMARY KEY (guid);


ALTER TABLE ONLY faculties
  ADD CONSTRAINT uq_organizations_guid UNIQUE (guid);

ALTER TABLE faculties OWNER TO dbuser;

CREATE TABLE users (
                     guid uuid not null default gen_random_uuid(),
                     username VARCHAR(100) NOT NULL,
                     password VARCHAR(100) NOT NULL,
                     email text,
                     full_name VARCHAR(250),
                     faculty_guid varchar(36) NOT NULL,
                     role VARCHAR(100)
);

ALTER TABLE users OWNER TO dbuser;

alter table users ADD CONSTRAINT fk_users_orgs FOREIGN KEY(faculty_guid)
  REFERENCES faculties(guid)
    ON DELETE CASCADE;

insert into public.users values (default, 'botadm', crypt('botadm', gen_salt('bf')), 'botadm@test.email', 'botadm', (select guid from faculties where name = 'rshu'), 'botadm');
*/