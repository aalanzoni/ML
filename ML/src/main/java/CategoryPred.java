/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres Lanzoni
 */
public class CategoryPred {
    private final String id;
    private final String name;
    private final String predict;
    
    
    public CategoryPred(String id, String name, String predict){
        this.id = id;
        this.name = name;
        this.predict = predict;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPredict() {
        return predict;
    }
    
    
    @Override
    public String toString() {
        return "CategoryPred{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", predict='" + predict + '\'' +
                '}';
    }
}
