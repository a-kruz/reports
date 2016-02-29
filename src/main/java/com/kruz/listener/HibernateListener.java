package com.kruz.listener;

import java.net.URL;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {
 
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try { 
            URL url = HibernateListener.class.getResource("/hibernate.cfg.xml");
            Configuration config = new Configuration().configure(url);
            SessionFactory factory = config.buildSessionFactory();

            /* save the Hibernate session factory into serlvet context */
            sce.getServletContext().setAttribute("SessionFactory", factory);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        SessionFactory sf = (SessionFactory) sce.getServletContext()
            .getAttribute("SessionFactory");
        
        sf.close();
    }

}
