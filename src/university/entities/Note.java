/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

/**
 *
 * @author LENOVO
 */
public class Note {
    private Etudiant etudiant;
    private Examen examen;
    private int noteE;

    public Note() {
    }

    public Note(Etudiant etudiant, Examen examen, int noteE) {
        this.etudiant = etudiant;
        this.examen = examen;
        this.noteE = noteE;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public int getNoteE() {
        return noteE;
    }

    public void setNoteE(int noteE) {
        this.noteE = noteE;
    }

   

    

    
    
}
