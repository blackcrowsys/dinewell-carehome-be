DROP DATABASE IF EXISTS DINEWELL_CARE;
CREATE DATABASE DINEWELL_CARE
  CHARACTER SET UTF8;
Z
CREATE USER 'DINEWELL_CARE'@'localhost'
  IDENTIFIED BY 'DINEWELL_CARE';
GRANT ALL ON DINEWELL_CARE.* TO DINEWELL_CARE;
