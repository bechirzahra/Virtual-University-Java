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
public class Stage {
    private int idStage;
    private String nomEntreprise;
    private String duree;
    private String domaine;
    private Date date;
    private String description;
    private Etudiant etudiant;
    private ChefEntreprise chefEntreprise;

    public Stage() {
    }

    public Stage(int idStage, String nomEntreprise, String duree, String domaine, Date date, String description, Etudiant etudiant, ChefEntreprise chefEntreprise) {
        this.idStage = idStage;
        this.nomEntreprise = nomEntreprise;
        this.duree = duree;
        this.domaine = domaine;
        this.date = date;
        this.description = description;
        this.etudiant = etudiant;
        this.chefEntreprise = chefEntreprise;
    }
   

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public ChefEntreprise getChefEntreprise() {
        return chefEntreprise;
    }

    public void setChefEntreprise(ChefEntreprise chefEntreprise) {
        this.chefEntreprise = chefEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
        
    
}
