package fr.m2i.javawebapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    private ServletContext context;

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthFilter init");
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        // On cast en HttpServletRequest pour ensuite récupérer la session
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        // On vérifie qu'un user est connecté
        boolean isLoggedIn = session != null && session.getAttribute("user") != null;

        // Si pas conntecté on affiche la page notWelcome
        if (!isLoggedIn) {
            this.context.log("User not connected");
            request.getRequestDispatcher("/WEB-INF/notWelcome.jsp").forward(request, response);
            return;
        }

        // Tout va bien on passe on filter suivant
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // we can close resources here
    }
}
