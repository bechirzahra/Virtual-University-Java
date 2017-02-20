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
public class QuestionExamen {
    private int idQuestion;
    private String corps;
    private String choix1;
    private String choix2;
    private String choix3;
    private String choix4;
    private String bonneReponse;
    private int barem;
    private Examen examen;

    public QuestionExamen() {
    }

    public QuestionExamen(int idQuestion, String corps, String choix1, String choix2, String choix3, String choix4, String bonneReponse, int barem, Examen examen) {
        this.idQuestion = idQuestion;
        this.corps = corps;
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.choix3 = choix3;
        this.choix4 = choix4;
        this.bonneReponse = bonneReponse;
        this.barem = barem;
        this.examen = examen;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }
    

    public String getChoix1() {
        return choix1;
    }

    public void setChoix1(String choix1) {
        this.choix1 = choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public void setChoix2(String choix2) {
        this.choix2 = choix2;
    }

    public String getChoix3() {
        return choix3;
    }

    public void setChoix3(String choix3) {
        this.choix3 = choix3;
    }

    public String getChoix4() {
        return choix4;
    }

    public void setChoix4(String choix4) {
        this.choix4 = choix4;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public int getBarem() {
        return barem;
    }

    public void setBarem(int barem) {
        this.barem = barem;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

   
    
    
}
