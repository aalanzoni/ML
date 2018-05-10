/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/**
 *
 * @author Andres Lanzoni
 */
public class TestHibernate {
    
    static Session sessionObj;

    static SessionFactory sessionFactoryObj;
    
    public  Connection getConexion(){
        
        Connection con=null;
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          //String connectionUrl = "jdbc:sqlserver://ANDRES-NOTE:1433;" +
          String connectionUrl = "jdbc:sqlserver://SERVIDOR2008\\MSSQL2012:49270;" +
            "databaseName=ml-hs;user=sa;password=hs;";
          con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
        return con;
    }
    
    private static SessionFactory buildSessionFactory() {
            // Creating Configuration Instance & Passing Hibernate Configuration File
            Configuration configObj = new Configuration();
            configObj.configure("hibernate.cfg.xml");

            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 

            // Creating Hibernate SessionFactory Instance
            sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
            return sessionFactoryObj;
    }    

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
//                    TestHibernate t = new TestHibernate();
//                    Connection c = t.getConexion();
//                    System.out.println("Connection: " + c);
                    sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			for(int i = 101; i <= 105; i++) {
                            Producto userObj = new Producto();
                            userObj.setCodigo("12");
                            userObj.setNombre("Editor " + i);


                            sessionObj.save(userObj);
			}
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
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
