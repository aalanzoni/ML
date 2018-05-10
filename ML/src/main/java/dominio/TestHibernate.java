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
                Session session = SingletonDB.getSession();

                Producto producto = new Producto(1,"Alicante 6","no nombre");
                
                session.beginTransaction();
                session.save(producto);
                session.getTransaction().commit();
                
                producto = new Producto(1, "lalala", "dos");
                session.beginTransaction();
                session.save(producto);
                session.getTransaction().commit();
                
                session.close();

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
