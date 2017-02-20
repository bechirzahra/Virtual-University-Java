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
public class AncienExamen {
    
    private int idAncienExamen;
    private Date date;
    private Enseignant enseignant;
    private Module module;

    public AncienExamen() {
    }

    public AncienExamen(int idAncienExamen, Date date, Enseignant enseignant, Module module) {
        this.idAncienExamen = idAncienExamen;
        this.date = date;
        this.enseignant = enseignant;
        this.module = module;
    }


    public int getIdAncienExamen() {
        return idAncienExamen;
    }

    public void setIdAncienExamen(int idAncienExamen) {
        this.idAncienExamen = idAncienExamen;
    }
 

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    
   
    
    
    
}
