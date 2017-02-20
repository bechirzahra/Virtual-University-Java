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
import university.entities.Admin;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class AdminDAO implements IDAO<Admin>{
     private Connection connection;

    public AdminDAO() {
        connection = MyConnection.getInstance();
    }
    
     public void insertObject(Admin a) {
       String requete = "insert into User (id,nom,prenom,username,password,roles) values (?,?,?,?,?,'Admin')";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getNom());
            ps.setString(3, a.getPrenom());
            ps.setString(4, a.getUsername());
            ps.setString(5, a.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void updateObject (Admin a) {
       String requete = "update User set username = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, a.getUsername());
            ps.setInt(2, a.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }  
    }

    public void deleteObject (Admin a) {
    String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("User supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        } 
    }

    public Admin findObjectById(int id) {
        Admin a = new Admin();
        String requete = "select id,nom,prenom,username,password,roles from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setPassword(resultat.getString(5));
                a.setRoles(resultat.getString(6));
                
             
            }
            return a;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }

   

    public List<Admin> DisplayAllObject() {

        List<Admin> listedeetudiant = new ArrayList<Admin>();

        String requete = "select (id,nom,prenom,roles) from User where roles='Admin' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Admin a = new Admin();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setRoles(resultat.getString(4));
                
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
