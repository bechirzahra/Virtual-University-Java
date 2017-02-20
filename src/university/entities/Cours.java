/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Cours {
    private int idCours;
    private Date date;
    private String nomCours;
    private Module module;
    private Enseignant enseignant;
    private ResponsableModule responsableModule;
    private int valider;
    private String cheminCours;

    public Cours() {
    }

    public Cours(int idCours, Date date, String nomCours, Module module, Enseignant enseignant, ResponsableModule responsableModule,int valider,String cheminCours) {
        this.idCours = idCours;
        this.date = date;
        this.nomCours = nomCours;
        this.module = module;
        this.enseignant = enseignant;
        this.responsableModule = responsableModule;
        this.valider = valider;
        this.cheminCours=cheminCours;
    }

  

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public ResponsableModule getResponsableModule() {
        return responsableModule;
    }

    public void setResponsableModule(ResponsableModule responsableModule) {
        this.responsableModule = responsableModule;
    }

    public int getValider() {
        return valider;
    }

    public void setValider(int valider) {
        this.valider = valider;
    }

    public String getCheminCours() {
        return cheminCours;
    }

    public void setCheminCours(String cheminCours) {
        this.cheminCours = cheminCours;
    }
    
        @Override
    public String toString() {
        return "Cours{" + "idCours=" + idCours + ", date=" + date + ", nomCours=" + nomCours + ", module=" + module + ", enseignant=" + enseignant + ", responsableModule=" + responsableModule + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCours;
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
        final Cours other = (Cours) obj;
        if (this.idCours != other.idCours) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
