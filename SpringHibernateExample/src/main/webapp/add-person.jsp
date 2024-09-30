<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Neue Person hinzufügen</title>
</head>
<body>
    <h2>Neue Person hinzufügen</h2>
    <form action="${pageContext.request.contextPath}/persondemo/addPerson" method="GET">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="vorname">Vorname:</label>
        <input type="text" id="vorname" name="vorname" required><br>
        <label for="age">Alter:</label>
        <input type="number" id="age" name="age" required><br>
        <button type="submit">Person hinzufügen</button>
    </form>
    <a href="index.jsp">Zurück zur Startseite</a>
</body>
</html>
