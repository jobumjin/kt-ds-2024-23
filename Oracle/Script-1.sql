ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER WATCHA IDENTIFIED BY WATCHA;
ALTER USER WATCHA DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;
ALTER USER WATCHA TEMPORARY TABLESPACE temp;
GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO WATCHA;
GRANT CREATE SYNONYM, CREATE DATABASE LINK, RESOURCE, UNLIMITED TABLESPACE TO WATCHA;



