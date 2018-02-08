USE DINEWELL_CARE;

CREATE TABLE TITLE (
  CODE CHAR(4) NOT NULL UNIQUE,
  NAME VARCHAR(10),
  PRIMARY KEY (CODE)
)
  ENGINE = InnoDB;

CREATE TABLE RESIDENT (
  ID         VARCHAR(250) NOT NULL,
  TITLE       CHAR(4),
  FIRSTNAME  VARCHAR(50)  NOT NULL,
  MIDDLENAME VARCHAR(100),
  SURNAME    VARCHAR(50),
  PRIMARY KEY (ID),
  FOREIGN KEY (TITLE) REFERENCES TITLE (CODE)
)
  ENGINE = InnoDB;

INSERT INTO TITLE VALUES
  ('Mr', 'Mr'),
  ('Miss', 'Miss'),
  ('Mrs', 'Mrs'),
  ('Sir', 'Sir'),
  ('Lord', 'Lord'),
  ('Dr', 'Doctor'),
  ('Prof', 'Professor'),
  ('Lady', 'Lady'),
  ('Dame', 'Dame'),
  ('Rbb', 'Rabbi'),
  ('Ms', 'Ms');

INSERT INTO RESIDENT VALUES
  ('5893cb52-1a31-402b-9331-d008ae563ab1', 'Mr', 'Ramon', 'Singh', 'Skywalker');