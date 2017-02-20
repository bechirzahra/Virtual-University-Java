/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Examen {
    private int idExamen;
    private int duree;
    private Date date;
    private User enseignant;
    private Module module;
    private int heure;
    private int minute;
    private List<QuestionExamen> questions = new ArrayList<QuestionExamen>();

    public Examen(int idExamen, int duree, Date date, User enseignant, Module module, int heure, int minute) {
        this.idExamen = idExamen;
        this.duree = duree;
        this.date = date;
        this.enseignant = enseignant;
        this.module = module;
        this.heure = heure;
        this.minute = minute;
    }

    public Examen() {
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(User enseignant) {
        this.enseignant = enseignant;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public List<QuestionExamen> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionExamen> questions) {
        this.questions = questions;
    }


    
}
