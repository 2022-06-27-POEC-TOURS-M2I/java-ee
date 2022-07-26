package fr.m2i.javawebapp;

import fr.m2i.javawebapp.distributor.Distributeur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DistributorServlet extends HttpServlet {

    private final Distributeur distributeur = Distributeur.getInstance();

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
        setDistributorAttribute(request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/distributor.jsp").forward(request, response);
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

        addCredit(request);
        buyProduct(request);
        setDistributorAttribute(request);

        this.getServletContext().getRequestDispatcher("/WEB-INF/distributor.jsp").forward(request, response);
    }

    private void addCredit(HttpServletRequest request) {

        String addOne = request.getParameter("addOne");
        String addTwo = request.getParameter("addTwo");

        if (addOne == null && addTwo == null) {
            return;
        }

        int amount = addOne != null ? 1 : 2;

        distributeur.insererArgent(amount);
        // distributeur.setCredit(distributeur.getCredit() + amount);
    }
    
    private void buyProduct(HttpServletRequest request) {

        String productId = request.getParameter("productId");

        if (productId == null || "".equals(productId)) {
            return;
        }

        distributeur.commanderProduit(Integer.parseInt(productId));
    }

    private void setDistributorAttribute(HttpServletRequest request) {
        request.setAttribute("credit", distributeur.getCredit());
        request.setAttribute("stock", distributeur.getStock());
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
