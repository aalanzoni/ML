/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Andres Lanzoni
 */
public class SingletonDB {
    private static Session session = null;
    
    public static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        if(session == null){
            session = configuration.buildSessionFactory(serviceRegistry).openSession();
        }
        else{
            session = configuration.buildSessionFactory(serviceRegistry).getCurrentSession();
        }
        return session;
    }
    
}
