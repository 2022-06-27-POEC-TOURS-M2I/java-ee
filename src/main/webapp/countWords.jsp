<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Formulaire compteur de mot" />
    </jsp:include>
    <body>

        <form method="GET" action="CountWordsServlet">
            <label>Insérez une phrase : </label>
            <input type="text" name="sentence" value="" />
            <input type="submit" value="Nombre de mots" />
        </form>

        <c:if test="${number != null}">
            <p><c:out value="${number}" /></p>
        </c:if>

    </body>
</html>
