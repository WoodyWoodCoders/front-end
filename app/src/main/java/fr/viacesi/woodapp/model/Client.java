package fr.viacesi.woodapp.model;

import java.util.Date;

/**
 * Created by 1797531 on 03/02/2018.
 */

public class Client {
    private Integer id;
    private Integer paiement;
    private String nom;
    private Integer telephone;
    private String adresse;
    private Integer cp;
    private String ville;
    private String dateCrea;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaiement() {
        return paiement;
    }

    public void setPaiement(Integer paiement) {
        this.paiement = paiement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(String dateCrea) {
        this.dateCrea = dateCrea;
    }
}
