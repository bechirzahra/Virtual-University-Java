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
import university.entities.ChefEntreprise;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class ChefEntrepriseDAO implements IDAO<ChefEntreprise> {
     
    private Connection connection;

    public ChefEntrepriseDAO() {
        connection = MyConnection.getInstance();
    }

    public void insertObject(ChefEntreprise chef) {
       String requete = "insert into User (nom,prenom,username,password,roles) values (?,?,?,?,'ChefEntreprise')";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, chef.getNom());
            ps.setString(2, chef.getPrenom());
            ps.setString(3, chef.getUsername());
            ps.setString(4, chef.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChefEntrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public void updateObject (ChefEntreprise chef) {
       String requete = "update User set username = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, chef.getUsername());
            ps.setInt(2, chef.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }  
    }

    public void deleteObject (ChefEntreprise chef) {
    String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, chef.getId());
            ps.executeUpdate();
            System.out.println("User supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        } 
    }

    public ChefEntreprise findObjectById(int id) {
        ChefEntreprise chef = new ChefEntreprise();
        String requete = "select id,nom,prenom,username,password from User where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                chef.setId(resultat.getInt(1));
                chef.setNom(resultat.getString(2));
                chef.setPrenom(resultat.getString(3));
                chef.setUsername(resultat.getString(4));
                chef.setPassword(resultat.getString(5));
                
             
            }
            return chef;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }

   

    public List<ChefEntreprise> DisplayAllObject() {

        List<ChefEntreprise> listedechefentreprise = new ArrayList<ChefEntreprise>();

        String requete = "select (id,nom,prenom,roles) from User where roles='ChefEntreprise' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                ChefEntreprise a = new ChefEntreprise();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setRoles(resultat.getString(4));
                
                listedechefentreprise.add(a);
            }
            return listedechefentreprise;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
    }

    
    
}
