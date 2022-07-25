package fr.m2i.javawebapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowRequestHeaders extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // On récupère la collection des noms des headers contenues dans la requête
        Enumeration<String> headersName = request.getHeaderNames();

        // On créer deux liste que l'on va pouvoir manipuler dans le jsp de façon simple
        List<String> headerNameList = new ArrayList();
        List<String> headerValueList = new ArrayList();

        // On parcours la collection -> tant qu'il y a des éléments dans la collection
        while (headersName.hasMoreElements()) {
            // On stock l'élément courant (le nom du header) et on décale le curseur de 1
            String name = headersName.nextElement();

            // On ajoute le nom du header
            headerNameList.add(name);
            // On ajoute la valeur du header
            headerValueList.add(request.getHeader(name));
        }

        // On passe par des attributs pour les utiliser côté JSP
        request.setAttribute("headersName", headerNameList);
        request.setAttribute("headersValue", headerValueList);

        this.getServletContext().getRequestDispatcher("/showRequestHeaders.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
