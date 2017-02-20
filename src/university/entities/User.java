/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

import java.sql.Date;
import java.util.Objects;



/**
 *
 * @author LENOVO
 */

public class User {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String email;
    private String password;
    private int locked;
    private String roles;
    private String sexe;
    private String nom;
    private String prenom;
    private Date naissance;
    private String cheminImage;


    public User() {
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public User(Integer id, String username, String email, String password, String roles, String sexe, String nom, String prenom, Date naissance, String cheminImage,int locked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.cheminImage = cheminImage;
        this.locked = locked;
    }
    

     public User(Integer id) {
        this.id = id;
    }
    
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
        
    
     @Override
    public String toString() {
        return nom + " " + prenom ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.roles);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }
    
    
    
    

}