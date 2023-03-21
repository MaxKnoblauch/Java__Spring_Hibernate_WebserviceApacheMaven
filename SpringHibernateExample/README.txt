Das Projekt enthält ein Beispiel eines Springboot-Servers, 
der einen Web-Service implementiert, mit dem Personen-Objekte 
(Instanzen der Klasse Person) angelegt und abgerufen werden können. 
Der Server kann mit einem Browser unter Port 8080 angesprochen 
werden und liefert JSON-Objekte als Antwort. Mit Hibernate wird 
eine Datenbank angeschlossen, damit es nicht mehr notwendig ist, 
explizit in SQL zu programmieren.

Es handelt sich um ein Maven-Projekt: 
Unter src/main/resources/application.properties müssen die 
Zugangsdaten zu einer Datenbank  (z.B. MySQL / MariaDB) angegeben 
werden. Im Stammverzeichnis finden Sie eine .sql-Datei, mit der
die Tabelle angelegt wird und Daten bereit gestellt werden.

Die Datei pom.xml führt alle notwendigen Libraries auf, 
die automatisch installiert werden.

Starten Sie die Klasse SpringhibernateApplication, dann sollten 
die in den Kommentaren der Klasse PersonController angegebenen 
URLs funktionieren.

Rolf Assfalg 03/2023
