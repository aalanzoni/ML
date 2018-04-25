/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        }*/ 
        
        //Site{id='MLA1168', name='Música, Películas y Series'}
        final List<Site> childrens = SiteHandler.getInstance().getAllMeliChildrenForCategories("MLA1168");
        for (final Site chield: childrens) {
            System.out.println(chield);
        } 
    }

}
