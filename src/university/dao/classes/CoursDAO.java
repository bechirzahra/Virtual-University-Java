


package university.dao.classes;

import java.sql.Connection;
import java.sql.Date;
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
import university.entities.Cours;
import university.entities.Enseignant;
import university.entities.Module;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class CoursDAO implements IDAO<Cours> {
        private Connection conn;
    
     public CoursDAO() {
        conn = MyConnection.getInstance();

    }

    @Override
    public void insertObject(Cours c) {
 String requete = "insert into cours (date,nomCours,idModule,idEnseignant,cheminCours) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setDate(1,  c.getDate());
            ps.setString(2,c.getNomCours());
            ps.setInt(3, c.getModule().getIdModule());
            ps.setInt(4, Authentification.idPersonneAutentfie);  
            ps.setString(5, c.getCheminCours());              
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public void updatecoursvalider(Cours c) {
String requete = "update cours set valider = 1 where idCours =?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
           
            ps.setInt(1, c.getIdCours());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }
    
    @Override
    public void updateObject(Cours c) {
String requete = "update cours set nomCours =? where idCours =?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getNomCours());
            
            ps.setInt(2, c.getIdCours());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }

    @Override
    public void deleteObject(Cours c) {
String requete = "delete from cours where idCours = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, c.getIdCours());
            ps.executeUpdate();
            System.out.println("cours supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }

    @Override
    public Cours findObjectById(int idCours) {
Cours c = new Cours();
        String requete = "select * from cours where idCours = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idCours);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setIdCours(resultat.getInt(1));
                c.setDate(resultat.getDate(2));
                c.setNomCours(resultat.getString(3));
                c.setCheminCours(resultat.getString(8));
                
                
                
            }
            return c;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du cours " + ex.getMessage());
            return null;
        }    }

    @Override
    public List<Cours> DisplayAllObject() {
List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select idCours,date,nomCours,idModule,idEnseignant,valider from cours";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            ModuleDAO moduleDAO = new ModuleDAO();
            EnseignantDAO enseignantDAO = new EnseignantDAO();

            while (resultat.next()) {
                Cours c = new Cours();
                c.setIdCours(resultat.getInt(1));
                c.setDate(resultat.getDate(2));
                c.setNomCours(resultat.getString(3));
                c.setModule(moduleDAO.findObjectById(resultat.getInt(4)));
                c.setEnseignant(enseignantDAO.findObjectById(resultat.getInt(5)));
                c.setValider(resultat.getInt(6));
                listtests.add(c);
            }
            return listtests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }    }
    
    
    public List<Cours> DisplayAllObjectbyNomRapide(String cours) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete="select * from Cours where nomCours LIKE '"+cours+"%'";
        
        
        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Cours c = new Cours();
                c.setIdCours(resultat.getInt(1));
                c.setNomCours(resultat.getString(3));
                c.setDate(resultat.getDate(2));
               
                //**************************************
                
               // int idEnseignant = resultat.getInt(5);
                Enseignant es = ensDao.findObjectById(resultat.getInt(5));
                c.setEnseignant(es);
                
                
               // int idModule = resultat.getInt(4);
                Module module = moduleDao.findObjectById(resultat.getInt(4));
                c.setModule(module);
                
                
                //*************************************
                
                
                listtests.add(c);
            }
            return listtests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }    
        
        }
   
    
    
}
