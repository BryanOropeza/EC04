package com.bryan.ec04.model;

public class MenuModel {

    private String updated_at;
    private String regular;
    private String created_at;


    private String description;


    private String alt_description;


    private String likes;

    public MenuModel(String updated_at, String regular, String create_at, String description, String alt_description, String likes) {
        this.updated_at = updated_at;
        this.regular = regular;
        this.created_at = create_at;
        this.description = description;
        this.alt_description = alt_description;
        this.likes = likes;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String create_at) {
        this.created_at = create_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public void setAlt_description(String alt_description) {
        this.alt_description = alt_description;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
