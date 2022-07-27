package fr.m2i.javawebapp.listener;

import fr.m2i.javawebapp.session.UserDb;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LifecycleListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(LifecycleListener.class.getName());

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Logs de démarrage
        logger.info("---- App started ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App started ----");

        // On récupère le servlet context via le servlet context event passé en paramètre
        ServletContext ctx = sce.getServletContext();
        
        // On récupère les identifiants de la base de donnée stockés dans le web.xml en context-param
        String dbUser = ctx.getInitParameter("dbUser");
        String dbPass = ctx.getInitParameter("dbPass");
        
        // On récupère l'instance de notre base de donnée
        UserDb userDb = UserDb.getInstance(dbUser, dbPass);

        // Si elle est null c'est que les identifiants sont mauvais
        if (userDb == null) {
            logger.severe("/!\\ Impossible de se connecter à la base de donnée /!\\");
            return; // On s'arrête là
        }

        // Si on arrive ici c'est que la connexion à la base de donnée s'est bien passée -> les identifiants sont bons
        
        // On garde dans les attributs du servlet context l'instance de notre base de donnée
        ctx.setAttribute("userDb", userDb);

        logger.info("---- Init done ----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("---- App stopped ----");
        logger.info(dtf.format(LocalDateTime.now()));
        logger.info("---- App stopped ----");
    }
}
