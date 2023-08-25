package com.bryan.ec04.model;

public class Dessert extends MenuModel{
    private String dsrt_description;
    private String dsrt_ingredients;
    public Dessert(String updated_at, String regular, String created_at, String description, String alt_description, String likes, String dsrt_description, String dsrt_ingredients) {
        super(updated_at, regular, created_at,description, alt_description, likes);
        this.dsrt_description = dsrt_description;
        this.dsrt_ingredients = dsrt_ingredients;
    }

    public String getDsrt_description() {
        return dsrt_description;
    }

    public void setDsrt_description(String dsrt_description) {
        this.dsrt_description = dsrt_description;
    }

    public String getDsrt_ingredients() {
        return dsrt_ingredients;
    }

    public void setDsrt_ingredients(String dsrt_ingredients) {
        this.dsrt_ingredients = dsrt_ingredients;
    }
}
