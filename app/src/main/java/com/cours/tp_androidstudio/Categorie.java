package com.cours.tp_androidstudio;

import org.json.JSONObject;

public class Categorie {
    private String categorie_id;
    private String title;
    private String products_url;

    public Categorie(JSONObject o){
        categorie_id = o.optString("categorie_id","");
        title = o.optString("title","");
        products_url = o.optString("products_url","");
    }


    public String getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(String categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducts_url() {
        return products_url;
    }

    public void setProducts_url(String products_url) {
        this.products_url = products_url;
    }
}
