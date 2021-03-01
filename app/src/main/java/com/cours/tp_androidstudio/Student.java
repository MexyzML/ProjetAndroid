package com.cours.tp_androidstudio;

import org.json.JSONObject;

public class Student {
    private String nom;
    private String prenom;
    private String email;
    private String avatar;

    public Student(JSONObject o){
        nom=o.optString("nom","");
        prenom=o.optString("prenom","");
        email=o.optString("email","");
        avatar=o.optString("avatar","");

    }
}
