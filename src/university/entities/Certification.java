/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Certification {
    private int idCertification;
    private String duree;
    private Date dateObtention;
    private String nomCertif;
    private Admin admin;

    public Certification() {
    }

    public Certification(int idCertification, String duree, Date dateObtention, String nomCertif, Admin admin) {
        this.idCertification = idCertification;
        this.duree = duree;
        this.dateObtention = dateObtention;
        this.nomCertif = nomCertif;
        this.admin = admin;
    }

  
    public  Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
  
    public int getIdCertification() {
        return idCertification;
    }

    public void setIdCertification(int idCertification) {
        this.idCertification = idCertification;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getNomCertif() {
        return nomCertif;
    }

    public void setNomCertif(String nomCertif) {
        this.nomCertif = nomCertif;
    }



    
    
}
