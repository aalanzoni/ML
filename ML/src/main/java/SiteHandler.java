/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/**
 *
 * @author Andres Lanzoni
 */
public class SiteHandler {
    //Nombre de los campos que vamos a obtener informacion
     private static final String ID_KEY = "id";
     private static final String NAME_KEY = "name";
     private static final String RESULTS_KEY = "results";
     private static final String PAGINS_KEY = "paging";
     //Creamos una unica instancia de Meli.
     private final Meli meli;

     private static final SiteHandler instance = new SiteHandler();

     private SiteHandler() {
         //Aca creamos el objecto Meli con la información de su aplicación.
         meli = new Meli(new Long("4532553168555750"), 
                  "CaVD3Vt6MEYMPcFH81TYxxm3ZPTzEjBK");
     }

     public static SiteHandler getInstance() {
         return instance;
     }

     public List<Site> getAllMeliSite()  {
         //Todos los sites.
         final List<Site> newSites = new ArrayList<Site>();
         try {
             //Aqui realizamos la consulta de todos los sites.
             final Response response = meli.get("/sites/");
             //Objeto gson que sirve para "parsear" los resultados.
             final Gson gson = new Gson();
             //Convertimos desde JSON a Java creando una lista de StringMap
             final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);
             //Convertimos los objectos StringMap a Site.
             for (final StringMap<String> entries : sites) {
                 newSites.add(new Site(entries.get(ID_KEY), entries.get(NAME_KEY)));
             }
         } catch (MeliException ex) {
             //Logger error en la respuesta
             System.out.println("Error " + ex.getMessage());
         } catch (IOException e) {
             //Logger error en la transformacion usando de gson.
             System.out.println("Error " + e.getMessage());
         }
         return newSites;
     }
     
      public List<Site> getAllMeliCategories()  {
         //Todos los sites.
         final List<Site> newSites = new ArrayList<Site>();
         try {
             //Aqui realizamos la consulta de todos las catogorias de Argentina.
             final Response response = meli.get("/sites/MLA/categories");
             //Objeto gson que sirve para "parsear" los resultados.
             final Gson gson = new Gson();
             //Convertimos desde JSON a Java creando una lista de StringMap
             final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);
             //Convertimos los objectos StringMap a Site.
             for (final StringMap<String> entries : sites) {
                 newSites.add(new Site(entries.get(ID_KEY), entries.get(NAME_KEY)));
             }
         } catch (MeliException ex) {
             //Logger error en la respuesta
             System.out.println("Error " + ex.getMessage());
         } catch (IOException e) {
             //Logger error en la transformacion usando de gson.
             System.out.println("Error " + e.getMessage());
         }
         return newSites;
     }
      
     public List<Site> getAllMeliChildrenForCategories(String category)  {
         //Todos los sites.
         final List<Site> newSites = new ArrayList<Site>();
         try {
             //Aqui realizamos la consulta de todos las catogorias de Argentina.
             final String path = "/sites/MLA/search?category=" + category;
             //https://api.mercadolibre.com/sites/MLA/search?category=MLA5726

             System.out.println("" + path);
             final Response response = meli.get(path);
             //Objeto gson que sirve para "parsear" los resultados.
             final Gson gson = new Gson();
             //Convertimos desde JSON a Java creando una lista de StringMap
             final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);
             //Convertimos los objectos StringMap a Site.
             for (final StringMap<String> entries : sites) {
                 newSites.add(new Site(entries.get(RESULTS_KEY), entries.get(NAME_KEY)));
             }
         } catch (MeliException ex) {
             //Logger error en la respuesta
             System.out.println("Error " + ex.getMessage());
         } catch (IOException e) {
             //Logger error en la transformacion usando de gson.
             System.out.println("Error " + e.getMessage());
         }
         return newSites;
     }
     
     public CategoryPredict getPredictCategories(String product) {                  
         CategoryPredict category = new CategoryPredict();
         try {             
             String path = new String("");

             path = "/sites/MLA/category_predictor/predict";
             
             System.out.println("Path: " + path);
             
             FluentStringsMap params = new FluentStringsMap();
             params.add("title", product.toLowerCase());
             final Response response = meli.get(path, params);
             System.err.println("uri: "+ response.getUri());
             final Gson gson = new Gson();
             
             int status_code = response.getStatusCode();
             
             if (status_code == 200){
                 category = gson.fromJson(response.getResponseBody(), CategoryPredict.class);
             }
             else{
                 System.err.println("uri: "+ response.getUri());
                 System.err.println("Error");
                 return null;
             }
         } catch (MeliException ex) {
             //Logger error en la respuesta
             System.out.println("Error " + ex.getMessage());
         } catch (IOException e) {
             //Logger error en la transformacion usando de gson.
             System.out.println("Error " + e.getMessage());
         }         
         return category;
     }
     
     
}
