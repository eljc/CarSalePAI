-- carsale.makes definition
drop table if exists MAKES;

CREATE TABLE MAKES (
  id bigint auto_increment,
  make_name VARCHAR(250) NOT NULL
);

-- carsale.models definition

drop table if exists MODELS;

CREATE TABLE MODELS (
  id bigint AUTO_INCREMENT,
  model_name varchar(250) NOT NULL,
  style varchar(255) DEFAULT NULL,
  make_id bigint DEFAULT NULL
);

-- carsale.`user` definition
drop table if exists USER;

CREATE TABLE USER (
  id bigint AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL
);

-- carsale.roles definition
drop table if exists ROLES;

CREATE TABLE ROLES (
  id bigint AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL  
);

-- carsale.user_roles definition
drop table if exists USER_ROLES;

CREATE TABLE USER_ROLES (
  user_id bigint NOT NULL,
  roles_id bigint NOT NULL
 )