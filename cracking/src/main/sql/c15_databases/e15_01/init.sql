CREATE TABLE Apartments(AptID INT PRIMARY KEY, UnitNumber VARCHAR(30), BuildingID INT);

CREATE TABLE Buildings (BuildingID INT, ComplexID INT, BuildingName VARCHAR(30), Address VARCHAR(30));

CREATE TABLE Tenants (TenantID INT, TenantName VARCHAR(30));

CREATE TABLE Complexes (ComplexID INT, ComplexName VARCHAR(30));

CREATE TABLE AptTenants (TenantID INT, AptID INT);

CREATE TABLE Requests (RequestID INT, Status VARCHAR(30), AptID INT, Description VARCHAR(30));


INSERT INTO Apartments VALUES (1, '1', 10);
INSERT INTO Apartments VALUES (2, '2', 10);
INSERT INTO Apartments VALUES (3, '3', 10);
INSERT INTO Apartments VALUES (4, '4', 20);
INSERT INTO Apartments VALUES (5, '5', 10);
INSERT INTO Apartments VALUES (6, '6', 20);
INSERT INTO Apartments VALUES (7, '7', 10);

INSERT INTO Buildings VALUES (10, 1, 'Residence Oxford', 'Rue Henri Poincaré 85');
INSERT INTO Buildings VALUES (20, 1, 'Residence Thesa', 'Rue Henri Poincaré 75');

INSERT INTO Complexes VALUES (1, 'Saint-Philippe');

INSERT INTO Tenants VALUES (100, 'Sophie');
INSERT INTO Tenants VALUES (101, 'Ann');
INSERT INTO Tenants VALUES (102, 'Irène');

INSERT INTO AptTenants VALUES (100, 1);
INSERT INTO AptTenants VALUES (101, 2);
INSERT INTO AptTenants VALUES (102, 3);
INSERT INTO AptTenants VALUES (100, 4);

INSERT INTO Requests VALUES (1000, 'Open', 5, 'Studio');
INSERT INTO Requests VALUES (1001, 'Closed', 6, 'Studio');
INSERT INTO Requests VALUES (1001, 'Open', 7, 'Studio');
