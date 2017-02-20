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
import university.entities.ResponsableModule;
import university.technique.MyConnection;

/**
 *
 * @author Safa
 */
public class ResponsableModuleDAO implements IDAO<ResponsableModule>{
    private Connection conn;
    
    public ResponsableModuleDAO() {
        conn = MyConnection.getInstance();
            }

    public void insertObject(ResponsableModule a) {
        String requete = "insert into User (id,nom,prenom,username,password,roles) values (?,?,?,?,?,'ResponsableModule')";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getNom());
            ps.setString(3, a.getPrenom());
            ps.setString(4, a.getUsername());
            ps.setString(5, a.getPassword());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public void updateObject(ResponsableModule a) {
String requete = "update user set username = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, a.getUsername());
            ps.setInt(2, a.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }   
    }
        
    

    public void deleteObject(ResponsableModule a) {
       String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("ResponsableModule supprimé");
        } catch (SQLException ex) {
           
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    //To change body of generated methods, choose Tools | Templates.


    public ResponsableModule findObjectById(int id) {
        ResponsableModule r = new ResponsableModule();
        String requete = "select (id,nom,prenom,username,password,roles) from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setPrenom(resultat.getString(3));
                r.setUsername(resultat.getString(4));
                r.setPassword(resultat.getString(5));
                r.setRoles(resultat.getString(6));
                
             
            }
            return r;

        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }
    }

    public List<ResponsableModule> DisplayAllObject() {
          
         List<ResponsableModule>listResponsableModule = new ArrayList<ResponsableModule>();

        String requete = "select (id,nom,prenom,roles) from User where roles ='ResponsableModule' ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
               ResponsableModule a = new ResponsableModule();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setRoles(resultat.getString(4));
                
                listResponsableModule.add(a);
            }
            return listResponsableModule;
        } catch (SQLException ex) {
            
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        } 
    }

    

    
}
