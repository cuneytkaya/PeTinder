INSERT INTO Customer (FirstName, LastName, Email, Phone, Active, CreatedOnUtc, LastLoginDateUtc, IsAdmin, AdditionalInformation, Password)
VALUES
('John', 'Doe', 'admin@petinder.com', '1234567890', TRUE, '2022-01-01', '2022-01-05', TRUE, 'Additional info for John Doe', '111'),
('Jane', 'Smith', 'jane.smith@petinder.com', '9876543210', TRUE, '2022-02-01', '2022-02-10', FALSE, 'Additional info for Jane Smith', '111'),
('David', 'Johnson', 'david.johnson@petinder.com', '5555555555', TRUE, '2022-03-01', '2022-03-15', FALSE, 'Additional info for David Johnson', '111'),
('Sarah', 'Williams', 'sarah.williams@petinder.com', '4444444444', TRUE, '2022-04-01', '2022-04-20', FALSE, 'Additional info for Sarah Williams', '111'),
('Michael', 'Brown', 'michael.brown@petinder.com', '7777777777', TRUE, '2022-05-01', '2022-05-12', FALSE, 'Additional info for Michael Brown', '111'),
('Emily', 'Jones', 'emily.jones@petinder.com', '2222222222', TRUE, '2022-06-01', '2022-06-25', FALSE, 'Additional info for Emily Jones', '111'),
('Daniel', 'Taylor', 'daniel.taylor@petinder.com', '8888888888', TRUE, '2022-07-01', '2022-07-08', FALSE, 'Additional info for Daniel Taylor', '111'),
('Olivia', 'Miller', 'olivia.miller@petinder.com', '3333333333', TRUE, '2022-08-01', '2022-08-17', FALSE, 'Additional info for Olivia Miller', '111'),
('William', 'Anderson', 'william.anderson@petinder.com', '6666666666', TRUE, '2022-09-01', '2022-09-29', FALSE, 'Additional info for William Anderson', '111'),
('Sophia', 'Thomas', 'sophia.thomas@petinder.com', '9999999999', TRUE, '2022-10-01', '2022-10-11', FALSE, 'Additional info for Sophia Thomas', '111'),
('James', 'Harris', 'james.harris@petinder.com', '1111111111', TRUE, '2022-11-01', '2022-11-14', FALSE, 'Additional info for James Harris', '111'),
('Ava', 'Clark', 'ava.clark@petinder.com', '4444444444', TRUE, '2022-12-01', '2022-12-05', FALSE, 'Additional info for Ava Clark', '111'),
('Benjamin', 'Walker', 'benjamin.walker@petinder.com', '7777777777', TRUE, '2023-01-01', '2023-01-09', FALSE, 'Additional info for Benjamin Walker', '111'),
('Mia', 'Hall', 'mia.hall@petinder.com', '2222222222', TRUE, '2023-02-01', '2023-02-18', FALSE, 'Additional info for Mia Hall', '111'),
('Ethan', 'Young', 'ethan.young@petinder.com', '8888888888', TRUE, '2023-03-01', '2023-03-07', FALSE, 'Additional info for Ethan Young', '111'),
('Charlotte', 'Allen', 'charlotte.allen@petinder.com', '3333333333', TRUE, '2023-04-01', '2023-04-21', FALSE, 'Additional info for Charlotte Allen', '111');


INSERT INTO workcontext (id, activeLanguageCode, activeCustomerId)
VALUES (1, 'tr', 0);

INSERT INTO pet (name, petTypeId, dateOfBirth, vaccinated, additionalInformation, customerId)
VALUES
('Max', 10, '2020-01-01', true, 'Additional information for Max', 1),
('Bella', 20, '2019-03-15', false, 'Additional information for Bella', 1),
('Charlie', 10, '2022-05-10', true, 'Additional information for Charlie', 2),
('Lucy', 10, '2021-07-20', false, 'Additional information for Lucy', 3),
('Cooper', 20, '2018-11-05', true, 'Additional information for Cooper', 4),
('Luna', 10, '2020-02-14', true, 'Additional information for Luna', 4),
('Rocky', 20, '2017-06-30', false, 'Additional information for Rocky', 5),
('Sadie', 20, '2020-08-25', true, 'Additional information for Sadie', 6),
('Bailey', 10, '2019-09-10', false, 'Additional information for Bailey', 7),
('Daisy', 10, '2020-04-02', true, 'Additional information for Daisy', 7),
('Milo', 20, '2019-12-12', false, 'Additional information for Milo', 8),
('Stella', 10, '2021-03-18', true, 'Additional information for Stella', 9),
('Buddy', 10, '2018-07-05', true, 'Additional information for Buddy', 9),
('Coco', 20, '2020-09-22', false, 'Additional information for Coco', 10);

