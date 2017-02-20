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
import university.dao.interfaces.IDAO;
import university.entities.Etudiant;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class EtudiantDAO implements IDAO<Etudiant>{
    
     private Connection connection;

    public EtudiantDAO() {
        connection = MyConnection.getInstance();
    }
    
    public void insertObject(Etudiant e) {
       String requete = "insert into User (id,nom,prenom,username,password,roles) values (?,?,?,?,?,'Etudiant')";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getUsername());
            ps.setString(5, e.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void updateObject (Etudiant e) {
       String requete = "update User set username = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, e.getUsername());
            ps.setInt(2, e.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }  
    }

    public void deleteObject (Etudiant e) {
    String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            System.out.println("User supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        } 
    }

    public Etudiant findObjectById(int id) {
        Etudiant e = new Etudiant();
        String requete = "select id,nom,prenom,username,password,roles from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                e.setId(resultat.getInt(1));
               e.setNom(resultat.getString(2));
               e.setPrenom(resultat.getString(3));
               e.setUsername(resultat.getString(4));
               e.setPassword(resultat.getString(5));
                e.setRoles(resultat.getString(6));
                
             
            }
            return e;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }

   

    public List<Etudiant> DisplayAllObject() {

        List<Etudiant> listedeetudiant = new ArrayList<Etudiant>();

        String requete = "select id,nom,prenom,username,email,naissance from User where roles='Etudiant' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Etudiant a = new Etudiant();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                
                listedeetudiant.add(a);
            }
            return listedeetudiant;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
    }
    
    public List<Etudiant> DisplayDemandeInscrip() {

        List<Etudiant> listedeetudiant = new ArrayList<Etudiant>();

        String requete = "select id,nom,prenom,username,email,naissance from User where roles='Etudiant' and locked=0 ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Etudiant a = new Etudiant();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                
                listedeetudiant.add(a);
            }
            return listedeetudiant;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
    }
    
}
