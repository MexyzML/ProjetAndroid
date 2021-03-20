package com.cours.tp_androidstudio;

import org.json.JSONObject;

public class Student {
    private String nom;
    private String prenom;
    private String email;
    private String avatar;
    private String groupe;

    public Student(JSONObject o){
        avatar = o.optString("avatar","");
        nom = o.optString("nom","");
        prenom = o.optString("prenom","");
        email = o.optString("email","");
        groupe = o.optString("groupe","");
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
        return prenom;
    }

    public void setPrenom(String prenom) {  this.prenom = prenom; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {  this.groupe = groupe; }


}
