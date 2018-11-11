SET statement_timeout = 0;
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
-- create extension pgcrypto;

create table users (
  guid uuid,
  viber_id character varying(50),
  viber_name character varying(100),
  viber_avatar character varying(256),
  viber_country character varying(50),
  viber_language character varying(50),
  viber_api_version character varying(50),
  grade_book_number character varying(50),
  created_at date,
  updated_at date,
  subscribed boolean
);

ALTER table users OWNER TO dbuser;
