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






