-- Tabelle person erstellen, wenn sie noch nicht existiert
CREATE TABLE IF NOT EXISTS `person` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `age` INT,
    `name` VARCHAR(255),
    `vorname` VARCHAR(255)
) AUTO_INCREMENT = 1;

-- Tabelle objekt erstellen, wenn sie noch nicht existiert
CREATE TABLE IF NOT EXISTS `objekt` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255)
) AUTO_INCREMENT = 1;

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
) AUTO_INCREMENT = 1;

-- Überprüfen, ob bereits Daten in der person-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `person` (`age`, `name`, `vorname`)
SELECT 25, 'Petra', 'Maier' WHERE NOT EXISTS (SELECT 1 FROM `person` WHERE `name` = 'Petra' AND `vorname` = 'Maier');

INSERT INTO `person` (`age`, `name`, `vorname`)
SELECT 43, 'Helmut', 'Baum' WHERE NOT EXISTS (SELECT 1 FROM `person` WHERE `name` = 'Helmut' AND `vorname` = 'Baum');

INSERT INTO `person` (`age`, `name`, `vorname`)
SELECT 33, 'Moni', 'Mueller' WHERE NOT EXISTS (SELECT 1 FROM `person` WHERE `name` = 'Moni' AND `vorname` = 'Mueller');


-- Überprüfen, ob bereits Daten in der objekt-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `objekt` (`name`)
SELECT 'Buch' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Buch');

INSERT INTO `objekt` (`name`)
SELECT 'Auto' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Auto');

INSERT INTO `objekt` (`name`)
SELECT 'Fahrrad' WHERE NOT EXISTS (SELECT 1 FROM `objekt` WHERE `name` = 'Fahrrad');

-- Überprüfen, ob bereits Daten in der reservierung-Tabelle existieren und nur hinzufügen, wenn sie nicht existieren
INSERT INTO `reservierung` (`details`, `end_datum`, `start_datum`, `objekt_id`, `person_id`)
SELECT 'BuchAusleihen', '2004-07-18 20:00:00', '2004-07-18 18:00:00', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM `reservierung` WHERE `details` = 'BuchAusleihen' AND `person_id` = 1 AND `objekt_id` = 1);

INSERT INTO `reservierung` (`details`, `end_datum`, `start_datum`, `objekt_id`, `person_id`)
SELECT 'AutoAusleihen', '2004-07-18 20:00:00', '2004-07-18 18:00:00', 2, 2
WHERE NOT EXISTS (SELECT 1 FROM `reservierung` WHERE `details` = 'AutoAusleihen' AND `person_id` = 2 AND `objekt_id` = 2);






