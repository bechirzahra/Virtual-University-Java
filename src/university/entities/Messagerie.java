package university.entities;

import university.entities.User;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chaima
 */
public class Messagerie {

    public Messagerie() {
       
    }

    public int getId() {
        return idMess;
    }

    public void setId(int id) {
        this.idMess = idMess;
    }
    int idMess;
    private User userRecepteur;
    private User userEmeteur; 
    private String contenu ;
    private boolean vue ;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public Messagerie(User userRecepteur, User userEmeteur, String contenu, boolean vue,int idMess) {
        this.userRecepteur = userRecepteur;
        this.userEmeteur = userEmeteur;
        this.contenu = contenu;
        this.vue = vue;
        this.idMess=idMess;
    }

    public User getUserRecepteur() {
        return userRecepteur;
    }

    public void setUserRecepteur(User userRecepteur) {
        this.userRecepteur = userRecepteur;
    }

    public User getUserEmeteur() {
        return userEmeteur;
    }

    public int getIdMess() {
        return idMess;
    }

    public void setIdMess(int idMess) {
        this.idMess = idMess;
    }

    public void setUserEmeteur(User userEmeteur) {
        this.userEmeteur = userEmeteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isVue() {
        return vue;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }
    
    
}
