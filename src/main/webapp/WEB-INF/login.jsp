<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Page de connexion" />
    </jsp:include>
    <body>

        <form method="POST">
            <fieldset>
                <legend>Formulaire de connexion</legend>
                <p>
                    <label>Email : </label>
                    <input type="text" name="email" placeholder="email@email.com" required />

                    <br />
                    
                    <label>Mot de passe : </label>
                    <input type="password" name="password" required />
                </p>
                <input type="submit" value="Connexion" />
            </fieldset>
            <c:if test="${error != null}">
                <p style="color:red;"><c:out value="${error}" /></p>
            </c:if>
        </form>

    </body>
</html>
