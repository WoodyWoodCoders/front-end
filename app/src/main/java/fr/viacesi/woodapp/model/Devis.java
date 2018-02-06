package fr.viacesi.woodapp.model;

import java.io.Serializable;

/**
 * Created by 1797531 on 04/02/2018.
 */

public class Devis implements Serializable {
    private Integer id;
    private User utilisateur;
    private String dateCrea;
    private String nom;
    private String reference;
    private Integer status;
    private Integer client;

    public Devis() {

    }



    public Devis( String dateCrea, String nom, String reference, int status, int client) {
        this.utilisateur = utilisateur;
        this.dateCrea = dateCrea;
        this.nom = nom;
        this.reference = reference;
        this.status = status;
        this.client = client;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(String dateCrea) {
        this.dateCrea = dateCrea;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }
    //private Integer paiement;
    //private List partis;

}
