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
import university.entities.Enseignant;
import university.technique.MyConnection;

/**
 *
 * @author Safa
 */
public class EnseignantDAO implements IDAO<Enseignant>{
    private Connection conn;
    
    public EnseignantDAO() {
        conn = MyConnection.getInstance();
            }

    public void insertObject(Enseignant a) {
        String requete = "insert into User (nom,prenom,username,password,roles) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, a.getNom());
            ps.setString(2, a.getPrenom());
            ps.setString(3, a.getUsername());
            ps.setString(4, a.getPassword());
            ps.setString(5, a.getRoles());


            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public void updateObject(Enseignant a) {
        String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("User supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
        
    

    public void deleteObject(Enseignant a) {
       String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("Enseignant supprimé");
        } catch (SQLException ex) {
           
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    //To change body of generated methods, choose Tools | Templates.


    public Enseignant findObjectById(int id) {
        Enseignant r = new Enseignant();
        String requete = "select id,nom,prenom from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                r.setId(resultat.getInt(1));
               r.setNom(resultat.getString(2));
               r.setPrenom(resultat.getString(3));
               // r.setUsername(resultat.getString(4));
                //r.setPassword(resultat.getString(5));
                //r.setRoles(resultat.getString(6));
                
             
            }
            return r;

        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }
    }

    public List<Enseignant> DisplayAllObject() {
          
         List<Enseignant>listEnseignant = new ArrayList<Enseignant>();

        String requete = "select id,nom,prenom,roles from User where roles ='Enseignant' ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Enseignant a = new Enseignant();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setRoles(resultat.getString(4));
                
                listEnseignant.add(a);
            }
            return listEnseignant;
        } catch (SQLException ex) {
            
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        } 
    }
    
}
