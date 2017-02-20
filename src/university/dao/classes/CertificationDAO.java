/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import university.entities.Certification;
import university.technique.MyConnection;

/**
 *
 * @author Safa
 */
public class CertificationDAO implements  IDAO <Certification>  {
   
    private Connection conn;
    
     public CertificationDAO (){
        conn = MyConnection.getInstance();
          

    }
    
     public void insertObject(Certification c) {
        String requete = "insert into certification (duree,dateObtention,nomCertif,idAdmin) values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getDuree());
           ps.setDate(2, (Date) c.getDateObtention());
            ps.setString(3,c.getNomCertif());
            ps.setInt(4,Authentification.idPersonneAutentfie);
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
  /*    public void updateObject(Certification c) {
        String requete = "update certification set nomCertif =? where idCertification =?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, c.getNomCours());
            
            ps.setInt(2, c.getIdCertification());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }*/
    
    public void deleteObject(Certification c) {
        String requete = "delete from certification where idCertification = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, c.getIdCertification());
            ps.executeUpdate();
            System.out.println("certif supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    public Certification findById(int idCertification) {
        Certification c = new Certification();
        String requete = "select * from certification where idCertification= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idCertification);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setDateObtention(resultat.getDate(3));
                c.setIdCertification(resultat.getInt(1));
                c.setDuree(resultat.getString(2));
               c.setNomCertif(resultat.getString(4));
              AdminDAO admindao=new AdminDAO();
                c.setAdmin(admindao.findObjectById(resultat.getInt(5)));
                
                
            }
            return c;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du certif " + ex.getMessage());
            return null;
        }
    }
    
    
    public Certification findByNom(String nomCertif) {
        Certification c = new Certification();
        String requete = "select * from Certification where nomCertif= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, nomCertif);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setIdCertification(resultat.getInt(1));
                c.setNomCertif(resultat.getString(2));
                
            }
            return c;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du cours " + ex.getMessage());
            return null;
        }
    }
    
     public List<Certification> DisplayAll() {
        
         List<Certification> listtests = new ArrayList<Certification>();

        String requete = "select * from certification";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Certification c = new Certification();
                c.setIdCertification(resultat.getInt(1));
                c.setNomCertif(resultat.getString(4));
                c.setDuree(resultat.getString(2));
                c.setDateObtention(resultat.getDate(3));
                AdminDAO admindao=new AdminDAO();
                c.setAdmin(admindao.findObjectById(resultat.getInt(5)));
                
                
   
                listtests.add(c);
            }
            return listtests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }
    }

    public void updateObject(Certification val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Certification findObjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Certification> DisplayAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
   
    
}
