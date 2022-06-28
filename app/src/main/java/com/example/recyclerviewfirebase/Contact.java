package com.example.recyclerviewfirebase;

public class Contact {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String image;

    public Contact(int id, String nom, String prenom, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public Contact(String nom, String prenom, String tel) {

        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;

    }

    public Contact(int i, String string, String cursorString) {
    }

    public Contact(int id, String nom, String prenom, String tel, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.image = image;
    }

    public Contact() {

    }

    public void setImage(String image) {
        this.image = image;
    }

    public Contact(String nom, String tel) {
        this.nom=nom;
        this.tel=tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getImage() {
        return image;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
