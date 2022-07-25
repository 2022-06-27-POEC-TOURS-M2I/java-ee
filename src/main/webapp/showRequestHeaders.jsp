<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Contenu des headers" />
    </jsp:include>
    <body>

        <table>
            <tr>
                <th>Nom</th>
                <th>Valeur</th>
            </tr>

            <%
                List<String> headersName = (List) request.getAttribute("headersName");
                List<String> headersValue = (List) request.getAttribute("headersValue");
                
                for (int i = 0; i < headersName.size(); i++) {
                    out.println("<tr><td>" + headersName.get(i) + "</td>");
                    out.println("<td>" + headersValue.get(i) + "</td></tr>");
                }
            %>

        </table>

    </body>
</html>
