package mapeo;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres Lanzoni
 */
public class CategoryPredict {
    private String id;
    private String name;
    private List<CategoryPred> path_from_root;
    private String probability;
    private List<String> shipping_modes;
    
    public CategoryPredict(final String id, final String name, List<CategoryPred> path_from_root, String probability, List<String> shipping_modes) {
        this.id = id;
        this.name = name;
        this.path_from_root = path_from_root;
        this.probability = probability;
        this.shipping_modes = shipping_modes;
    }
    
    public CategoryPredict(){
        super();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CategoryPred> getPath_from_root() {
        return path_from_root;
    }

    public String getProbability() {
        return probability;
    }

    public List<String> getShipping_modes() {
        return shipping_modes;
    }
}
