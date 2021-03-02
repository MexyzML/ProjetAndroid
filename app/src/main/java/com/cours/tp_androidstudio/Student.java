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
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNom() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return avatar;
    }

    public void setPrenom(String prenom) {  this.prenom = prenom; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
