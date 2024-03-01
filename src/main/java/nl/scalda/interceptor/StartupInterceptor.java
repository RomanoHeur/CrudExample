package nl.scalda.interceptor;

import nl.scalda.persistence.factories.DAOFactories;
import nl.scalda.persistence.factories.DAOFactory;
import nl.scalda.persistence.util.HibernateSessionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupInterceptor implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateSessionManager.destroy();
    }
}
