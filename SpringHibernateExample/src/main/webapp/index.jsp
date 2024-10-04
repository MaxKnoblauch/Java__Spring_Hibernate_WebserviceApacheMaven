<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Startseite</title>
    <style>
        body {
            background-color: #f2f2f2; /* Leichter grauer Hintergrund */
            font-family: 'Roboto', sans-serif; /* Modernere Schriftart */
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #4CAF50; /* Dunkler Grünton für die Kopfzeile */
            color: white;
            padding: 15px 0;
            text-align: center;
            font-size: 24px;
        }

        .container {
            max-width: 1200px; /* Maximale Breite des Inhalts */
            margin: 20px auto; /* Zentrierter Inhalt */
            padding: 20px;
            background-color: white; /* Weißer Hintergrund */
            border-radius: 8px; /* Abgerundete Ecken */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Sanfter Schatten */
        }

        h1, h2, h3 {
            color: #333; /* Dunkelgraue Farbe für Überschriften */
            margin-bottom: 20px; /* Abstand unter den Überschriften */
        }

        h2 {
            border-bottom: 2px solid #4CAF50; /* Grüner Balken unter den Unterüberschriften */
            padding-bottom: 10px;
        }

        form {
            background-color: #f9f9f9; /* Heller Hintergrund für das Formular */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 30px; /* Abstand unter jedem Formular */
        }

        label {
            font-size: 14px;
            font-weight: bold;
            color: #666;
            display: block;
            margin-bottom: 8px; /* Abstand unter Labels */
        }

        input[type="text"],
        input[type="number"],
        input[type="datetime-local"] {
            width: 100%; /* Eingabefelder auf volle Breite setzen */
            padding: 10px;
            margin-bottom: 20px; /* Abstand unter den Eingabefeldern */
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box; /* Box-Sizing-Modell verwenden */
            transition: border-color 0.3s ease; /* Sanfter Übergang für Rahmenfarbe */
        }

        input[type="text"]:focus,
        input[type="number"]:focus,
        input[type="datetime-local"]:focus {
            border-color: #4CAF50; /* Grüner Rahmen bei Fokussierung */
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Sanfter Übergang für Hover-Effekt */
        }

        input[type="submit"]:hover {
            background-color: #45a049;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Schatteneffekt beim Hover */
        }

        .link-section h3 {
            font-size: 18px;
            margin: 20px 0 10px;
        }

        .link-section a {
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease; /* Sanfter Übergang für Linkfarbe */
        }

        .link-section a:hover {
            color: #0056b3; /* Dunklerer Blauton beim Hover */
            text-decoration: underline;
        }

        footer {
            text-align: center;
            margin-top: 40px;
            padding: 20px;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>

<header>
    Willkommen zur Reservierungsverwaltung
</header>

<div class="container">
   

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

    <div class="link-section">
        <h3><a href="${pageContext.request.contextPath}/personen">Liste aller Personen anzeigen</a></h3>
    </div>

    <h2>Objekte verwalten</h2>
    <!-- Formular zur Erfassung eines neuen Objekts -->
    <form action="/objekte" method="post">
        <label for="objektName">Objektname:</label>
        <input type="text" id="objektName" name="name" required>

        <input type="submit" value="Objekt hinzufügen">
    </form>

    <div class="link-section">
        <h3><a href="/objekte">Liste aller Objekte anzeigen</a></h3>
    </div>

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

    <div class="link-section">
        <h3><a href="/reservierungen">Liste aller Reservierungen anzeigen</a></h3>
    </div>
</div>

<footer>
    &copy; 2024 Reservierungsverwaltung
</footer>

</body>
</html>

