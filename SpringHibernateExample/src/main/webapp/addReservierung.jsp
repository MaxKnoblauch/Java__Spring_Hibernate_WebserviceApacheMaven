<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Neue Reservierung hinzufügen</title>
</head>
<body>
    <h2>Neue Reservierung hinzufügen</h2>
    <form action="${pageContext.request.contextPath}/persondemo/addReservierungToPerson" method="GET">
        <label for="personId">Person ID:</label>
        <input type="number" id="personId" name="personId" required><br>
        <label for="reservierungDetails">Reservierungsdetails:</label>
        <input type="text" id="reservierungDetails" name="reservierungDetails" required><br>
        <label for="startDatum">Startdatum (z.B. 2024-09-30T10:00):</label>
        <input type="text" id="startDatum" name="startDatum" required><br>
        <label for="endDatum">Enddatum (z.B. 2024-09-30T12:00):</label>
        <input type="text" id="endDatum" name="endDatum" required><br>
        <button type="submit">Reservierung hinzufügen</button>
    </form>
    <a href="index.jsp">Zurück zur Startseite</a>
</body>
</html>
