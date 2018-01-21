package fr.viacesi.woodapp.model;

/**
 * Created by Numalama on 19/01/2018.
 */

public class UserRessources {
    private Integer id;
    private Integer type;
    private String nom;
    private String login;
    private String password;



    public UserRessources(){

    }

    public UserRessources(Integer id, Integer type, String nom, String login, String password){
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.login = login;
        this.password = password;

    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }






}
