-- Tabelle person erstellen, wenn sie noch nicht existiert
CREATE TABLE IF NOT EXISTS `person` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `age` INT,
    `name` VARCHAR(255),
    `vorname` VARCHAR(255)
) AUTO_INCREMENT = 100;

-- Tabelle objekt erstellen, wenn sie noch nicht existiert
CREATE TABLE IF NOT EXISTS `objekt` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255)
) AUTO_INCREMENT = 100;

-- Tabelle reservierung erstellen, wenn sie noch nicht existiert
CREATE TABLE IF NOT EXISTS `reservierung` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `details` VARCHAR(255),
    `end_datum` DATETIME,
    `start_datum` DATETIME,
    `objekt_id` INT,
    `person_id` INT,
    FOREIGN KEY (`objekt_id`) REFERENCES `objekt`(`id`),
    FOREIGN KEY (`person_id`) REFERENCES `person`(`id`)
) AUTO_INCREMENT = 100;

-- Überprüfen, ob bereits Daten in der person-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `person` (`age`, `name`, `vorname`)
SELECT 25, 'Petra', 'Test' WHERE NOT EXISTS (SELECT 1 FROM `person` WHERE `name` = 'Petra' AND `vorname` = 'Test');

INSERT INTO `person` (`age`, `name`, `vorname`)
SELECT 43, 'Monster', 'Tester' WHERE NOT EXISTS (SELECT 1 FROM `person` WHERE `name` = 'Monster' AND `vorname` = 'Tester');

-- Überprüfen, ob bereits Daten in der objekt-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `objekt` (`name`)
SELECT 'Haus' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Haus');

INSERT INTO `objekt` (`name`)
SELECT 'Autor' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Autor');

INSERT INTO `objekt` (`name`)
SELECT 'Fahrrad' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Fahrrad');

-- Überprüfen, ob bereits Daten in der reservierung-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `reservierung` (`details`, `end_datum`, `start_datum`, `objekt_id`, `person_id`)
SELECT 'Hausausleihen', '2004-07-18 20:00:00', '2004-07-18 18:00:00', 100, 100
WHERE NOT EXISTS (SELECT 1 FROM `reservierung` WHERE `details` = 'Hausausleihen' AND `person_id` = 100 AND `objekt_id` = 100);






