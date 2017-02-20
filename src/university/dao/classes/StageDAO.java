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
import university.GUI.Authentification;
import university.dao.interfaces.IDAO;
import university.entities.Stage;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class StageDAO implements IDAO<Stage>{
    
    private Connection connection;
   
    public StageDAO() {
        connection = MyConnection.getInstance();
    }
    @Override
    public void insertObject(Stage stage) {
        String requete = "insert into stage (nomEntreprise,duree,domaine,date,description,idChefEntreprise) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, stage.getNomEntreprise());
            ps.setString(2, stage.getDuree());
            ps.setString(3, stage.getDomaine());
            ps.setDate(4, (java.sql.Date) stage.getDate());
            ps.setString(5,  stage.getDescription());            
            ps.setInt(6, Authentification.idPersonneAutentfie);

            
            ps.executeUpdate();
            
            
               try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
              
                System.err.println("hethiiiiiiiii"+generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

            
        } catch (SQLException ex) {
            Logger.getLogger(StageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateObject (Stage s) {
        String requete = "update stage set nomEntreprise=?, duree=?, domaine=?,date=?, description=? where idStage='"+s.getIdStage()+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, s.getNomEntreprise());
            ps.setString(2, s.getDuree());
            ps.setString(3, s.getDomaine());
            ps.setDate(4, s.getDate());
            ps.setString(5, s.getDescription());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteObject (Stage s) {
        String requete = "delete from stage where idStage = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, s.getIdStage());
            ps.executeUpdate();
            System.out.println("stage supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    public Stage findObjectById(int id) {
        Stage stage = new Stage();
        String requete = "select * from stage where idStage = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                stage.setIdStage(resultat.getInt(1));
                stage.setNomEntreprise(resultat.getString(2));
                stage.setDuree(resultat.getString(3));
                stage.setDomaine(resultat.getString(4));
                stage.setDate(resultat.getDate(5));
                stage.setDescription(resultat.getString(6));
            }
            return stage;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du stage " + ex.getMessage());
            return null;
        }
    }
    //
    public Stage findObejectByTitre(String tit) {
        Stage stage = new Stage();
        String requete = "select * from stage where domaine=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, tit);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                stage.setIdStage(resultat.getInt(1));
               stage.setDomaine(resultat.getString(2));
            }
            return stage;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du stage " + ex.getMessage());
            return null;
        }
    }
    public List<Stage> DisplayAllObject() {
        List<Stage> listedestage = new ArrayList<Stage>();
        String requete = "select idStage,nomEntreprise,duree,domaine,date,description from stage";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Stage stage = new Stage();
                stage.setIdStage(resultat.getInt(1));
                stage.setNomEntreprise(resultat.getString(2));
                stage.setDuree(resultat.getString(3));
                stage.setDomaine(resultat.getString(4));
                stage.setDate(resultat.getDate(5));
                stage.setDescription(resultat.getString(6));
                listedestage.add(stage);
            }
            return listedestage;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stages " + ex.getMessage());
            return null;
        }
    }
    
     public List<Stage> DisplayAllObjectById() {
        List<Stage> listedestage = new ArrayList<Stage>();
        String requete = "select idStage,nomEntreprise,duree,domaine,date,description from stage where idChefEntreprise='"+Authentification.idPersonneAutentfie+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Stage stage = new Stage();
                stage.setIdStage(resultat.getInt(1));
                stage.setNomEntreprise(resultat.getString(2));
                stage.setDuree(resultat.getString(3));
                stage.setDomaine(resultat.getString(4));
                stage.setDate(resultat.getDate(5));
                stage.setDescription(resultat.getString(6));
                listedestage.add(stage);
            }
            return listedestage;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stages " + ex.getMessage());
            return null;
        }
    }
    
    
    
}
