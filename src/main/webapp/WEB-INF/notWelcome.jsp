<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Page d'accueil" />
    </jsp:include>
    <body>
        <h1 style="color: red">Veuillez vérifier vos identifiants</h1>

        <br />

        <a href="LoginServlet" >Page de connexion</a>
    </body>
</html>
