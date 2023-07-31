CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  Email VARCHAR(100),
  Phone VARCHAR(20),
  Active BOOLEAN,
  CreatedOnUtc DATE,
  LastLoginDateUtc DATE,
  IsAdmin BOOLEAN,
  AdditionalInformation VARCHAR(255),
  Password VARCHAR(100)
);

CREATE TABLE WorkContext (
    id INT PRIMARY KEY,
    activeLanguageCode VARCHAR(255),
    activeCustomerId INT
);

CREATE TABLE pet (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  petTypeId INT NOT NULL,
  dateOfBirth DATE NOT NULL,
  vaccinated BOOLEAN NOT NULL,
  additionalInformation VARCHAR(255),
  customerId INT NOT NULL,
  FOREIGN KEY (customerId) REFERENCES customer (id)
);

CREATE TABLE MatchHistory (
id INT AUTO_INCREMENT PRIMARY KEY,
sourceCustomerId INT,
  sourcePetId INT,
  targetPetId INT,
  isMatchSelected BOOLEAN
);
