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
public class Evaluation {
    private Etudiant etudiant;
    private Cours cours;
    private String commentaire;
    private int note;
    private Date date;

    public Evaluation() {
    }

    public Evaluation(Etudiant etudiant, Cours cours, String commentaire, Date date,int note) {
        this.etudiant = etudiant;
        this.cours = cours;
        this.commentaire = commentaire;
        this.date = date;
        this.note=note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    
    
}
