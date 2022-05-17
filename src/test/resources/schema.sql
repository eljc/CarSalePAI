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