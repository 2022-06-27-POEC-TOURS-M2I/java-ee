<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Page d'accueil" />
    </jsp:include>
    <body>
        <h1>Bonjour <c:out value="${sessionScope.user.email}"/>, vous etes un <c:out value="${sessionScope.user.role}"/> ! </h1>
        
        <br />

        <a href="LogoutServlet" >Déconnexion</a>
    </body>
</html>
