<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Personen-View</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
 		<h2>Personen</h2>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Alter</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        Es sind ${anzahl} Personen gespeichert.
        <a href="add-person">Neue Person</a>
        
        <p>${errorMessage}</p>
    </body>
</html>