CREATE TABLE companies (
  c_name VARCHAR(64) NOT NULL,
  c_matrix VARCHAR (2048) NOT NULL,
  CONSTRAINT c_name_pk PRIMARY KEY (c_name)
);