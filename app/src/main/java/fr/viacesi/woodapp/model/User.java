package fr.viacesi.woodapp.model;

import java.util.List;

/**
 * Created by Numalama on 19/01/2018.
 */

public class User {
   private UserRessources data;

    public User(){

    }
    public User(UserRessources data){
        this.data = data;
    }
    public UserRessources getUser() {
        return data;
    }

    public void setUser(UserRessources data) {
        this.data = data;
    }
}
