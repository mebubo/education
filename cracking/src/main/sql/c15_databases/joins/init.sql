CREATE TABLE department
(
 DepartmentID INT,
 DepartmentName VARCHAR(20)
);

CREATE TABLE employee
(
 LastName VARCHAR(20),
 Country VARCHAR(20),
 DepartmentID INT
);

INSERT INTO department VALUES(31, 'Sales');
INSERT INTO department VALUES(33, 'Engineering');
INSERT INTO department VALUES(34, 'Clerical');
INSERT INTO department VALUES(35, 'Marketing');

INSERT INTO employee VALUES('Rafferty', 'Australia', 31);
INSERT INTO employee VALUES('Jones', 'Australia', 33);
INSERT INTO employee VALUES('Heisenberg', 'Australia', 33);
INSERT INTO employee VALUES('Robinson', 'US', 34);
INSERT INTO employee VALUES('Smith', 'Germany', 34);
INSERT INTO employee VALUES('John', 'Germany', NULL);
