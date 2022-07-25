<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Formulaire nombre premier" />
    </jsp:include>
    <body>
        <h1>Prime Number</h1>

        <form method="POST">
            <label for="start">Début :</label>
            <input type="number" name="start" />

            <br />

            <label for="end">Fin :</label>
            <input type="number" name="end" />

            <br />

            <input type="submit" value="Valider" />
        </form>

        <c:set var="start" value="${param.start}" />
        <c:set var="end" value="${param.end}" />

        <c:if test="${start != null && end != null}">

            <c:forEach var="current" begin="${start}" end="${end}">

                <c:set var="flag" value="0" />
                <c:forEach var="i" begin="2" end="${current / 2}">

                    <c:if test="${current % i == 0 && current != i}">
                        <c:set var="flag" value="1" />
                    </c:if>

                </c:forEach>

                <c:if test="${flag == 0}">
                    <c:out value="${current}" /> nombre premier
                    <br />
                </c:if>

                <c:if test="${flag != 0}">
                    <c:out value="${current}" /> nombre non premier
                    <br />
                </c:if>

            </c:forEach>

        </c:if>
    </body>
</html>
