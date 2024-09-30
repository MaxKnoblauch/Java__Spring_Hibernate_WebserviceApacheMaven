<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Neues Objekt hinzufügen</title>
</head>
<body>
    <h2>Neues Objekt hinzufügen</h2>
    <form action="${pageContext.request.contextPath}/objektdemo/addObjekt" method="GET">
        <label for="name">Objekt Name:</label>
        <input type="text" id="name" name="name" required><br>
        <button type="submit">Objekt hinzufügen</button>
    </form>
    <a href="index.jsp">Zurück zur Startseite</a>
</body>
</html>
