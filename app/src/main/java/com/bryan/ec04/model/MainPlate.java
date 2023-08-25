package com.bryan.ec04.model;

public class MainPlate  extends MenuModel{


    private String ingredients;
    public MainPlate(String updated_at, String regular, String created_at, String description, String alt_description, String likes, String ingredients) {
        super(updated_at, regular, created_at, description, alt_description, likes);
        this.ingredients = ingredients;
    }


    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
