package com.bryan.ec04.data.retrofit.response;

import com.bryan.ec04.model.MenuModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowResponse {

    @SerializedName("menu")
    public List<MenuModel> menuList;

    public List<MenuModel> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuModel> menuList) {
        this.menuList = menuList;
    }
}
