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
public class Statistique {
    private int idStatistique;
    private String titre;
    private Date date;

    public Statistique() {
    }

    public Statistique(int idStatistique, String titre, Date date) {
        this.idStatistique = idStatistique;
        this.titre = titre;
        this.date = date;
    }

    public int getIdStatistique() {
        return idStatistique;
    }

    public void setIdStatistique(int idStatistique) {
        this.idStatistique = idStatistique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
