Das Projekt enthält ein Beispiel eines Springboot-Servers, 
der einen Web-Service implementiert, mit dem Personen, Objekte 
und Reservierungen verwaltet werden können. Es können neue Personen 
und Objekte erstellt sowie bestehende Einträge abgerufen werden. 
Zudem ermöglicht der Web-Service das Anlegen von Reservierungen für 
Objekte durch Personen, wobei der Zeitraum auf Zeitkonflikte geprüft wird, um Dopplungen zu verhindern.

Der Server kann über einen Browser unter Port 8080 angesprochen werden
und liefert JSON-Objekte als Antwort. Mithilfe von Hibernate wird eine
Datenbank angebunden, was die explizite SQL-Programmierung überflüssig macht.

Es handelt sich um ein Maven-Projekt: 
Unter src/main/resources/application.properties sind die 
Zugangsdaten zur Datenbank (root und ohne Passwort) angegeben.
Im Stammverzeichnis finden Sie eine .sql-Datei, mit der
die Tabelle angelegt wird und Daten bereit gestellt werden.

Die Datei pom.xml führt alle notwendigen Libraries auf, 
die automatisch installiert werden.

Starten Sie die Klasse SpringhibernateApplication, dann sollten 
die in den Kommentaren der Klasse PersonController angegebenen 
URLs funktionieren.

Knoblauch/Rupprich 09/24