/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import university.entities.Examen;
import university.entities.QuestionExamen;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class QuestionExamenDAO {
     private Connection conn;
     
     public QuestionExamenDAO(){
    conn = MyConnection.getInstance();
}
     
     public void insertObject(QuestionExamen q) {
 String requete = "insert into questionexamen (corps,choix1,choix2,choix3,choix4,bonneReponse,barem,idExamen) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, q.getCorps());
            ps.setString(2, q.getChoix1() );
            ps.setString(3,q.getChoix2());
            ps.setString(4, q.getChoix3());
            ps.setString(5, q.getChoix4());
            ps.setString(6, q.getBonneReponse());
            ps.setInt(7, q.getBarem());
            ps.setInt(8, q.getExamen().getIdExamen());         
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }
     
     
     public QuestionExamen findObjectById(int id) {
         QuestionExamen quest = new QuestionExamen();
        String requete = "select * from questionexamen where idQuestion = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                quest.setIdQuestion(resultat.getInt(1));
                quest.setChoix1(resultat.getString(2));
                quest.setChoix2(resultat.getString(3));
                quest.setChoix3(resultat.getString(4));
                quest.setChoix4(resultat.getString(5));
                quest.setBonneReponse(resultat.getString(6));
                quest.setBarem(resultat.getInt(7));

                ExamenDAO exdao = new ExamenDAO();
                Examen ex = new Examen();
                
                ex= exdao.findObjectById(resultat.getInt(8));
                quest.setExamen(ex);
                
                
            }
            return quest;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du quest " + ex.getMessage());
            return null;
        }    }
     
     
     public List<QuestionExamen> DisplayByIdExamen(int id){
         
          List<QuestionExamen> liste = new ArrayList<QuestionExamen>();
          
          String requete = "select * from questionexamen where idExamen=?";
          
          try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                QuestionExamen ques = new QuestionExamen();
                
                ques.setIdQuestion(resultat.getInt(1));
                ques.setCorps(resultat.getString(2));
                ques.setChoix1(resultat.getString(3));
                ques.setChoix2(resultat.getString(4));
                ques.setChoix3(resultat.getString(5));
                ques.setChoix4(resultat.getString(6));
                ques.setBonneReponse(resultat.getString(7));
                ques.setBarem(resultat.getInt(8));
                
         //       Examen ex = new Examen();
           //     ExamenDAO exdao = new ExamenDAO();
                
          //      ex= exdao.findObjectById(resultat.getInt(8));

          //      ques.setExamen(ex);
                
               
                
                liste.add(ques);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des quest " + ex.getMessage());
            return null;
        }


     }
    
     
     
     
}
