<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Startseite</title>
</head>
<body>
<h1>Willkommen auf der Startseite</h1>

<h2>Personenverwaltung</h2>
<!-- Formular zur Erfassung einer neuen Person -->
<form action="/personen" method="post">
    <label for="vorname">Vorname:</label><br>
    <input type="text" id="vorname" name="vorname"><br>
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="age">Alter:</label><br>
    <input type="number" id="age" name="age"><br><br>
    <input type="submit" value="Person hinzufügen">
</form>

<!-- Link zur Auflistung aller Personen -->
<h3><a href="/personen">Liste aller Personen anzeigen</a></h3>

<h2>Objekte verwalten</h2>
<!-- Formular zur Erfassung eines neuen Objekts -->
<form action="/objekte" method="post">
    <label for="objektName">Objektname:</label><br>
    <input type="text" id="objektName" name="name"><br><br>
    <input type="submit" value="Objekt hinzufügen">
</form>

<!-- Link zur Auflistung aller Objekte -->
<h3><a href="/objekte">Liste aller Objekte anzeigen</a></h3>

<h2>Reservierungen verwalten</h2>
<!-- Formular zur Erfassung einer neuen Reservierung -->
<form action="/reservierungen" method="post">
    <label for="personId">Person ID:</label><br>
    <input type="number" id="personId" name="personId"><br>
    <label for="objektId">Objekt ID:</label><br>
    <input type="number" id="objektId" name="objektId"><br>
    <label for="details">Details:</label><br>
    <input type="text" id="details" name="details"><br><br>
    <input type="submit" value="Reservierung hinzufügen">
</form>

<!-- Link zur Auflistung aller Reservierungen -->
<h3><a href="/reservierungen">Liste aller Reservierungen anzeigen</a></h3>

</body>
</html>
