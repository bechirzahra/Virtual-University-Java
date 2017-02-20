/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.dao.classes;

import university.GUI.Authentification;
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
import university.dao.interfaces.IDAO;
import university.entities.AncienExamen;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class AncienExamenDAO {
  
    private Connection connection;

    public AncienExamenDAO() {
        connection = MyConnection.getInstance();
    }

    public void insertObject(AncienExamen a) {
        String requete = "insert into ancienexamen (idAncienExamen,date,idEnseignant,idModule) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getIdAncienExamen());
            ps.setDate(2, (Date) a.getDate());
            ps.setInt(3, Authentification.idPersonneAutentfie); 
            ps.setInt(4, a.getModule().getIdModule()); 
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AncienExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }



    public void deleteObject(AncienExamen a) {
String requete = "delete from ancienexamen where idAncienExamen = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, a.getIdAncienExamen());
            ps.executeUpdate();
            System.out.println("doc supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }

    public AncienExamen findObjectById(int id) {
    AncienExamen a = new AncienExamen();
        String requete = "select * from ancienexamen where idAncienExamen = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                a.setIdAncienExamen(resultat.getInt(1));
                a.setDate(resultat.getDate(2));
                a.getEnseignant().setId(resultat.getInt(3));
            }
            return a;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du correction " + ex.getMessage());
            return null;
        }    }


    public List<AncienExamen> DisplayAllObject() {

        List<AncienExamen> liste = new ArrayList<AncienExamen>();

        String requete = "select * from ancienexamen";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                AncienExamen a = new AncienExamen();
                a.setIdAncienExamen(resultat.getInt(1));
                a.setDate(resultat.getDate(2));
                a.getEnseignant().setId(resultat.getInt(3));

                liste.add(a);
            }
            return liste;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des doc " + ex.getMessage());
            return null;
        }    }

    
    
}
