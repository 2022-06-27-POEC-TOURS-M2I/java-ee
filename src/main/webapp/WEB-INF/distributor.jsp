<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Meilleur distributeur" />
    </jsp:include>
    <body>

        <h2>Crédit restant : <c:out value="${credit}" /></h2>

        <table>
            <caption>Liste des produit</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach var="product" items="${stock}">
                <tr>
                    <td><c:out value="${product.getId()}"/></td>
                    <td><c:out value="${product.getNom()}"/></td>
                    <td><c:out value="${product.getQuantite()}"/></td>
                    <td><c:out value="${product.getPrix()}"/></td>
                </tr>
            </c:forEach>

        </table>

        <br />

        <form method="POST">
            <fieldset>
                <legend>Ajouter du crédit</legend>
                <p>
                    <label>Montant : </label>
                    <input type="number" name="credit" />
                </p>
                <input type="submit" value="Ajouter" />
            </fieldset>
            <c:if test="${creditError != null}">
                <p style="color:red;"><c:out value="${creditError}" /></p>
            </c:if>
        </form>

        <br />

        <form method="POST">
            <fieldset>
                <legend>Acheter un produit</legend>
                <input type="number" name="productId" />
                <input type="submit" value="Acheter"/>
            </fieldset>
            <c:if test="${productError != null}">
                <p style="color:red;"><c:out value="${productError}" /></p>
            </c:if>
            <c:if test="${insufficientError != null}">
                <p style="color:red;"><c:out value="${insufficientError}" /></p>
            </c:if>
        </form>

    </body>
</html>
