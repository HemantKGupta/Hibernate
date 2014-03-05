1. Start derby database in network mode

2.connect to following url by client driver 

jdbc:derby://localhost:1527/applicationManagedSE;create=true

3. Create a table and populate it using following command

DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (ID INTEGER NOT NULL, NAME VARCHAR(255), SALARY BIGINT, STARTDATE DATE, PRIMARY KEY (ID));

INSERT INTO EMPLOYEE (ID, NAME, SALARY, STARTDATE) VALUES (1, 'Joan', 59000, {d '2003-04-16'});

4. Run EmployeeClient as java app