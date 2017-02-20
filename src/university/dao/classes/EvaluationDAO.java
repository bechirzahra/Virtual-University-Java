/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.dao.classes;

import university.GUI.Authentification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import university.entities.Evaluation;
import university.technique.MyConnection;
import java.sql.Date;
import university.entities.Cours;
import university.entities.Etudiant;

/**
 *
 * @author LENOVO
 */
public class EvaluationDAO {
    
        private Connection connection;

    public EvaluationDAO() {
        connection = MyConnection.getInstance();
    }

    
    
    
    public void insertObject(Evaluation evaluation, int idCours) {
        String requete = "insert into evaluation (idEtudiant,idCours,commentaire,note,date) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Authentification.idPersonneAutentfie);
            ps.setInt(2, idCours);
            ps.setString(3, evaluation.getCommentaire());          
            ps.setInt(4, evaluation.getNote());          
            ps.setDate(5, (Date) evaluation.getDate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    
    
    public void deleteObject(Evaluation evaluation, int idEtud, int idCours) {
String requete = "delete from evaluation where idEtudiant ='"+idEtud+"' and idCours='"+idCours+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
  
            ps.executeUpdate();
            System.out.println("evaluation supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }
   
    public Evaluation findObjectById(int idE, int idC) {
    Evaluation evaluation = new Evaluation();
        String requete = "select idEtudiant,idCours,commentaire from evaluation where idEtudiant=? and idCours = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, idE);
            ps.setInt(2, idC);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Etudiant e = new Etudiant();
                EtudiantDAO eDao = new EtudiantDAO();
                Cours c = new Cours();
                CoursDAO cDao = new CoursDAO();
                e = eDao.findObjectById(resultat.getInt(1));
                c = cDao.findObjectById(resultat.getInt(2));
                evaluation.setCommentaire(resultat.getString(3));                
               // evaluation.setNote(resultat.getInt(4));
            }
            return evaluation;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du evaluation " + ex.getMessage());
            return null;
        }    }


    public List<Evaluation> DisplayAllObject() {

        List<Evaluation> listeevaluation = new ArrayList<Evaluation>();

        String requete = "select * from evaluation";
      
        EtudiantDAO aO = new EtudiantDAO();
        CoursDAO cdao = new CoursDAO();
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Evaluation evaluation = new Evaluation();
                
                Etudiant etu = aO.findObjectById(resultat.getInt(1));
                evaluation.setEtudiant(etu);
                
                Cours cours = cdao.findObjectById(resultat.getInt(2));
                
                evaluation.setCours(cours);
                evaluation.setCommentaire(resultat.getString(3));
                evaluation.setNote(resultat.getInt(4));
                evaluation.setDate(resultat.getDate(5));
                
                listeevaluation.add(evaluation);
            }
            return listeevaluation;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des evaluations " + ex.getMessage());
            return null;
        }    }

    
}
