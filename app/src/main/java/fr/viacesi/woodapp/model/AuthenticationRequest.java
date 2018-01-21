package fr.viacesi.woodapp.model;


import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private String login;
    private String password;

    public AuthenticationRequest() {

    }

    public AuthenticationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
