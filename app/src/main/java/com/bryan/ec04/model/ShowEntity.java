package com.bryan.ec04.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "show")
public class ShowEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "show_name")
    public String updated_at;
    @ColumnInfo(name = "banner")
    public String regular;

    @ColumnInfo(name = "date")
    public String created_at;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "alt_description")
    public String alt_description;

    @ColumnInfo(name = "likes")
    public String likes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String name) {
        this.updated_at = name;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getCreate_at() {
        return created_at;
    }

    public void setCreate_at(String create_at) {
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
