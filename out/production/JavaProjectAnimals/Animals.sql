CREATE DATABASE Human_friends;
use Human_friends;

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
id INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(30),
Type VARCHAR(30),
Actions VARCHAR(100),
Birthday DATE
);


DROP TABLE IF EXISTS Pack_Animals;
CREATE TABLE Pack_Animals (
id INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(30),
Type VARCHAR(30),
Actions VARCHAR(100),
Birthday DATE
);

INSERT INTO Pets (Name, Type, Actions, Birthday) VALUES 
('Fido', 'Dog', 'Sit Stay Fetch', '2022-01-01'),
('Whiskers', 'Cat', 'Sit Pounce', '2023-07-05'),
('Hammy', 'Hamster', 'Roll Hide', '2021-06-07'),
('Buddy', 'Dog', 'Sit Paw Bark', '2018-09-09'),
('Pudge', 'Cat', 'Sit Pounce Scratch', '2023-02-20'),
('Bella', 'Dog', 'Sit Roll Stay', '2019-11-11'),
('Oliver', 'Chicken', 'Gawk Run', '2023-08-08');

SELECT * FROM Pets;

INSERT INTO Pack_Animals (Name, Type, Actions, Birthday) VALUES 
('Thunder', 'Horse', 'Trot Canter Gallop', '2015-08-09'),
('Sandy', 'Camel', 'Walk Load', '2018-09-09'),
('Dum', 'Donkey', 'Walk Carry Load Bray', '2017-04-04'),
('Blaze', 'Horse', 'Trot Canter', '2014-09-07'),
('Burrito', 'Goat', 'Eat Run Hide', '2019-04-05'),
('Ca', 'Camel', 'Walk Run', '2015-08-14');

DELETE FROM Pack_Animals WHERE Type = 'Camel';
SELECT * FROM Pack_Animals;

DROP TABLE IF EXISTS Horses_Donkeys;
CREATE TABLE Horses_Donkeys AS
SELECT * FROM Human_friends.Pack_Animals WHERE Type IN ('Horse', 'Donkey');

SELECT * FROM Horses_Donkeys;

DROP TABLE IF EXISTS Young_Animals;
CREATE TABLE Young_Animals AS
SELECT *,
		TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age
FROM Pets
WHERE DATEDIFF(CURDATE(), Birthday) > 365 AND DATEDIFF(CURDATE(), Birthday) < 730;

SELECT * FROM Young_Animals;

DROP TABLE IF EXISTS All_Animals;
CREATE TABLE All_Animals AS
SELECT 'Pets' AS Source, p.*
FROM Pets p
UNION ALL
SELECT 'Pack_Animals' AS Source, pa.*
FROM Pack_Animals pa;

SELECT * FROM All_Animals;







