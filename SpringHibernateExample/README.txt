Das Projekt enthält ein Beispiel eines Springboot-Servers, 
der einen Web-Service (der unter Port 8080 angesprochen werden kann) implementiert, mit dem Personen, Objekte 
und Reservierungen verwaltet werden können. Es können neue Personen 
und Objekte ( inkl. Bestätigung) erstellt sowie bestehende Einträge abgerufen werden. 
Zudem ermöglicht der Web-Service das Anlegen von Reservierungen für 
Objekte durch Personen, wobei der Zeitraum auf Zeitkonflikte geprüft wird, um Dopplungen zu verhindern.
Auch bestehende Reservierungen können abgerufen werden.

Zu Beginn müssen über das XAMPP Control Panel die Module Apache(Port: 80,443) und MySQL(Port:3306) gestartet werden. 
Unter localhost/phpmyadmin muss anschließend eine Datenbank mit dem Namen "knoblauch_rupprich_javape" angelegt werden.
Der Server kann über einen Browser unter Port 8080 angesprochen werden. Mithilfe von Hibernate wird eine
Datenbank angebunden, was die explizite SQL-Programmierung überflüssig macht.

Es handelt sich um ein installationsfähiges Maven-Projekt: 
Unter src/main/resources/application.properties sind die 
Zugangsdaten zur Datenbank (root und ohne Passwort) angegeben.
Unter src/main/resources/data.sql finden Sie eine .sql-Datei, mit der
die Tabellen und Testdaten für Person, Objekt und Reservierung bei der Ausführung als SpringBootApp angelegt werden.

Die Datei pom.xml führt alle notwendigen Libraries auf, 
die automatisch installiert werden.

Nachdem das Projekt via Git(smart Import) importiert wurde, starten Sie die Klasse SpringhibernateApplication, dann sollten 
die in den Kommentaren der Klassen Person-, Objekt- und ReservierungController angegebenen 
URLs funktionieren.

Knoblauch/Rupprich 10/24