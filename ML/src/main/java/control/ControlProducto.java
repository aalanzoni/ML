/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dominio.Producto;
import dominio.SingletonDB;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Andres Lanzoni
 */
public class ControlProducto {
    
    public ControlProducto() {
        super();
    }
    
    public final boolean existeProductoCodigo(String codigo)throws Exception{
        return true;
    }
    
    public final void bajaProducto(int empresa, String codigo)throws Exception{
        
    }
    
    public List<Producto> getProductosSinCategoria() throws Exception{
        
        Session session = SingletonDB.getSession();
        
        session.beginTransaction();
        
        //List<Producto> productos = session.createQuery( "from Producto where sucursal_producto = 1" ).list();
        List<Producto> productos = session.createQuery( "from Producto where codcate_pub_producto is NULL" ).list();
        for (Iterator<Producto> iterator = productos.iterator(); iterator.hasNext();) {
            Producto next = iterator.next();
            System.out.println("producto: "+ next.getCodigo());
        }
        
        session.getTransaction().commit();
        
        if (productos.isEmpty())
            return null;
        else
            return productos;
        //session.close();
    }
    
    public static void main(String a[]){
        ControlProducto cp = new ControlProducto();
        try{
            cp.getProductosSinCategoria();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
}
