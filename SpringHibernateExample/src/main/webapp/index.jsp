<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Startseite</title>
    <style>
        body {
            background-color: #FFC0CB; /* Rosa Hintergrund */
            font-family: Arial, sans-serif; /* Schriftart */
            margin: 0; /* Keine Standardabstände */
            padding: 20px; /* Innenabstand */
        }

        h1 {
            color: #333; /* Dunkelgraue Farbe für die Überschrift */
        }

        h2 {
            color: #666; /* Hellgraue Farbe für die Unterüberschriften */
        }

        form {
            background-color: #ffffff; /* Weißer Hintergrund für das Formular */
            padding: 15px; /* Innenabstand im Formular */
            border-radius: 5px; /* Abgerundete Ecken */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* Schatteneffekt */
            margin-bottom: 20px; /* Abstand unter dem Formular */
        }

        label {
            display: block; /* Label blockweise darstellen */
            margin: 10px 0 5px; /* Abstand für Labels */
        }

        input[type="text"],
        input[type="number"],
        input[type="datetime-local"] {
            width: 100%; /* Eingabefelder auf volle Breite setzen */
            padding: 8px; /* Innenabstand in den Eingabefeldern */
            border: 1px solid #ccc; /* Rahmen */
            border-radius: 4px; /* Abgerundete Ecken für die Eingabefelder */
            box-sizing: border-box; /* Box-Sizing-Modell verwenden */
        }

        input[type="submit"] {
            background-color: #4CAF50; /* Grüner Hintergrund für den Button */
            color: white; /* Weiße Schriftfarbe */
            border: none; /* Kein Rahmen */
            padding: 10px 15px; /* Innenabstand für den Button */
            border-radius: 5px; /* Abgerundete Ecken */
            cursor: pointer; /* Hand-Cursor beim Hover */
            transition: background-color 0.3s; /* sanfter Übergang bei Hover */
        }

        input[type="submit"]:hover {
            background-color: #45a049; /* Dunklerer Grünton beim Hover */
        }

        a {
            color: #007BFF; /* Linkfarbe */
            text-decoration: none; /* Keine Unterstreichung */
        }

        a:hover {
            text-decoration: underline; /* Unterstreichung beim Hover */
        }
    </style>
</head>
<body>
<h1>Willkommen zur Reservierungsverwaltung</h1>

<h2>Personen verwalten</h2>
<!-- Formular zur Erfassung einer neuen Person -->
<form action="/personen" method="post">
    <label for="vorname">Vorname:</label>
    <input type="text" id="vorname" name="vorname" required>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="age">Alter:</label>
    <input type="number" id="age" name="age" required>

    <input type="submit" value="Person hinzufügen">
</form>

<!-- Link zur Auflistung aller Personen -->
<h3><a href="${pageContext.request.contextPath}/personen">Liste aller Personen anzeigen</a></h3>

<h2>Objekte verwalten</h2>
<!-- Formular zur Erfassung eines neuen Objekts -->
<form action="/objekte" method="post">
    <label for="objektName">Objektname:</label>
    <input type="text" id="objektName" name="name" required>

    <input type="submit" value="Objekt hinzufügen">
</form>

<!-- Link zur Auflistung aller Objekte -->
<h3><a href="/objekte">Liste aller Objekte anzeigen</a></h3>

<h2>Reservierungen verwalten</h2>
<!-- Formular zur Erfassung einer neuen Reservierung -->
<form action="/reservierungen" method="post">
    <label for="details">Details:</label>
    <input type="text" id="details" name="details" required>

    <label for="personId">Person ID:</label>
    <input type="number" id="personId" name="personId" required>

    <label for="objektId">Objekt ID:</label>
    <input type="number" id="objektId" name="objektId" required>

    <label for="startDatum">Startdatum:</label>
    <input type="datetime-local" id="startDatum" name="startDatum" required>

    <label for="endDatum">Enddatum:</label>
    <input type="datetime-local" id="endDatum" name="endDatum" required>

    <input type="submit" value="Reservierung hinzufügen">
</form>

<!-- Link zur Auflistung aller Reservierungen -->
<h3><a href="/reservierungen">Liste aller Reservierungen anzeigen</a></h3>

</body>
</html>

