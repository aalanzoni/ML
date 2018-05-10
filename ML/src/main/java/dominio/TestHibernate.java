/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 *
 * @author Andres Lanzoni
 */
public class TestHibernate {
    
    static Session sessionObj;

    static SessionFactory sessionFactoryObj;
       

	public static void main(String[] args) {
            System.out.println(".......ARRANCAAAA.......\n");
            try {
                SessionFactory sessionFactory;

                Configuration configuration = new Configuration();
                configuration.configure();
                ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                
                Producto producto = new Producto(new Long("1"),1,"AL1","un nombre");
                System.out.println("1");
                
                Session session=sessionFactory.openSession();
                System.out.println("2");
                
                session.beginTransaction();
                System.out.println("3");
                session.save(producto);
                System.out.println("4");
                session.getTransaction().commit();
                System.out.println("5");
        
                session.close();
                System.out.println("6");
                sessionFactory.close();
                System.out.println("7");

            } catch(Exception sqlException) {
                System.err.println("Error: ");
                sqlException.printStackTrace();
                if(null != sessionObj.getTransaction()) {
                        System.out.println("\n.......Transaction Is Being Rolled Back.......");
                        sessionObj.getTransaction().rollback();
                }
                sqlException.printStackTrace();
            } finally {
                if(sessionObj != null) {
                        sessionObj.close();
                }
                System.exit(0);
            }

	}   
    
}
