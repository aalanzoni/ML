/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Andres Lanzoni
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*final List<Site> sites = SiteHandler.getInstance().getAllMeliSite();

        for (final Site site: sites) {
            System.out.println(site);
        }
        
        final List<Site> categories = SiteHandler.getInstance().getAllMeliCategories();

        for (final Site site: categories) {
            System.out.println(site);
        }
        
        //Site{id='MLA1168', name='Música, Películas y Series'}
        final List<Site> childrens = SiteHandler.getInstance().getAllMeliChildrenForCategories("MLA1168");
        for (final Site chield: childrens) {
            System.out.println(chield);
        }*/ 
        CategoryPredict category = SiteHandler.getInstance().getPredictCategories("tablet samsung galaxy tab 4");

        System.err.println("Catogoria: "+ category.getName());
        
        List<CategoryPred> cat = category.getPath_from_root();
        
        for (Iterator<CategoryPred> ca = cat.iterator(); ca.hasNext();) {
            CategoryPred next = ca.next();
            System.err.println("camino: " + next.getName());
        }
    }

}
