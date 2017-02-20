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
public class QuestionCertif {
    private int idQCertif;
    private Certification certification;

    public QuestionCertif() {
    }

    public QuestionCertif(int idQCertif, Certification certification) {
        this.idQCertif = idQCertif;
        this.certification = certification;
    }

    public int getIdQCertif() {
        return idQCertif;
    }

    public void setIdQCertif(int idQCertif) {
        this.idQCertif = idQCertif;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }
    
    
    
}
