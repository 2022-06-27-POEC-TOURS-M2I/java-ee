<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Venez voir votre IP" />
    </jsp:include>
    <body>
        <h1>Bonjour ${clientName} !</h1>
        <h1>Votre adresse IP : ${clientIP}</h1>
    </body>
</html>
