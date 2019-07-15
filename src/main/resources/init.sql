-- dropping already existing tables
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS institution CASCADE;
DROP TABLE IF EXISTS major CASCADE;
DROP TABLE IF EXISTS institution_major CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS company CASCADE;
DROP TABLE IF EXISTS company_position;
DROP TABLE IF EXISTS position CASCADE;
DROP TABLE IF EXISTS note CASCADE;
DROP TABLE IF EXISTS application CASCADE;

-- dropping already existing enums
DROP TYPE IF EXISTS application_status CASCADE;
DROP TYPE IF EXISTS user_type CASCADE;
DROP TYPE IF EXISTS profile_status CASCADE;
DROP TYPE IF EXISTS institution_type CASCADE;
DROP TYPE IF EXISTS gender CASCADE;

-- creating enums
CREATE TYPE user_type AS ENUM ('ADMIN', 'USER');
CREATE TYPE institution_type AS ENUM ('UNIVERSITY', 'HIGH_SCHOOL');
CREATE TYPE profile_status AS ENUM ('ACTIVE', 'INACTIVE');
CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');
CREATE TYPE application_status AS ENUM ('HIRED', 'FIRED', 'DECLINED', 'INTERVIEW', 'REVIEW');

-- creating tables
CREATE TABLE company (
  id   serial PRIMARY KEY,
  name varchar(40)
);

CREATE TABLE users (
  id          serial PRIMARY KEY,
  company_id  int REFERENCES company (id),
  email       varchar(40) UNIQUE,
  password    varchar(100), -- length is defined for hashed passwords
  first_name  varchar(40),
  middle_name varchar(40),
  last_name   varchar(40),
  type        user_type
);

CREATE TABLE institution (
  id   serial PRIMARY KEY,
  name varchar(40),
  type institution_type
);

CREATE TABLE major (
  id   serial PRIMARY KEY,
  name varchar(40)
);

CREATE TABLE institution_major (
  institution_id int REFERENCES institution (id),
  major_id       int REFERENCES major (id)
);

CREATE TABLE profile (
  id             serial PRIMARY KEY,
  email          varchar(40) UNIQUE,
  gender         gender,
  first_name     varchar(40),
  middle_name    varchar(40),
  last_name      varchar(40),
  date_of_birth  varchar(10), -- date of birth
  phone          varchar(20),
  country        varchar(20),
  zip            varchar(10),
  city           varchar(20),
  address        varchar(40),
  institution_id int REFERENCES institution (id),
  major_id       int REFERENCES major (id),
  student_id     int,
  ss_number      int, -- social security number (taj)
  tax_number     int,
  status         profile_status
);

CREATE TABLE position (
  id   serial PRIMARY KEY,
  name varchar(40)
);

CREATE TABLE company_position (
  company_id  int REFERENCES company (id),
  position_id int REFERENCES position (id)
);

CREATE TABLE application (
  id          serial PRIMARY KEY,
  profile_id  int REFERENCES profile (id),
  position_id int REFERENCES position (id),
  status      application_status
);

CREATE TABLE note (
  id             serial PRIMARY KEY,
  application_id int REFERENCES application (id),
  user_id        int REFERENCES users (id),
  message        TEXT,
  created_at     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- creating triggers


-- test inserts

INSERT INTO major (name)
VALUES ('Not set');

INSERT INTO institution (name, type)
VALUES ('Not set', 'UNIVERSITY');

INSERT INTO institution (name, type)
VALUES ('University of California', 'UNIVERSITY');

INSERT INTO institution (name, type)
VALUES ('Stanford University', 'UNIVERSITY');

INSERT INTO major (name)
VALUES ('Law');

INSERT INTO major (name)
VALUES ('Economics');

INSERT INTO company (name)
VALUES ('MEISZ');

INSERT INTO users (company_id, email, password, type)
VALUES (1, 'admin@admin.com', 'Admin1234', 'ADMIN');

INSERT INTO profile (email,
                     gender,
                     first_name,
                     middle_name,
                     last_name,
                     date_of_birth,
                     institution_id,
                     major_id,
                     student_id,
                     ss_number,
                     tax_number,
                     status)
VALUES ('trump@test.com', 'MALE', 'Donald', NULL, 'Trump', '1946-01-01', 1, 1, 123, 1234, 12345, 'ACTIVE');

INSERT INTO profile (email,
                     gender,
                     first_name,
                     middle_name,
                     last_name,
                     date_of_birth,
                     institution_id,
                     major_id,
                     student_id,
                     ss_number,
                     tax_number,
                     status)
VALUES ('nixon@test.com', 'MALE', 'Richard', NULL, 'Nixon', '1913-01-01', 2, 1, 123, 1234, 12345, 'ACTIVE');

INSERT INTO profile (email,
                     gender,
                     first_name,
                     middle_name,
                     last_name,
                     date_of_birth,
                     institution_id,
                     major_id,
                     student_id,
                     ss_number,
                     tax_number,
                     status)
VALUES ('gwb@test.com', 'MALE', 'George', 'W.', 'Bush', '1946-01-01', 2, 2, 123, 1234, 12345, 'ACTIVE');

INSERT INTO profile (email,
                     gender,
                     first_name,
                     middle_name,
                     last_name,
                     date_of_birth,
                     institution_id,
                     major_id,
                     student_id,
                     ss_number,
                     tax_number,
                     status)
VALUES ('mt@test.com', 'FEMALE', 'Milena', NULL, 'Trump', '1970-01-01', 1, 1, 123, 1234, 12345, 'ACTIVE');

SELECT *
FROM profile;
SELECT *
FROM address;
SELECT *
FROM phone;
