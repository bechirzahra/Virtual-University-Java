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
public class ResultatCertif {
    private Etudiant etudiant;
    private Certification certification;
    private float note;

    public ResultatCertif() {
    }
    
    public ResultatCertif(Etudiant etudiant, Certification certification, float note) {
        this.etudiant = etudiant;
        this.certification = certification;
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
    
    
    
}
