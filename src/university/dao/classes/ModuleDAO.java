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
import university.dao.interfaces.IDAO;
import university.entities.Module;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class ModuleDAO implements IDAO<Module>{
    
    private Connection conn;
    
     public ModuleDAO() {
        conn = MyConnection.getInstance();

    }

    @Override
    public void insertObject(Module m) {
 String requete = "insert into module (nomModule) values (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1,m.getNomModule());        
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       }

    @Override
    public void updateObject(Module m) {
        String requete = "update module set nomModule=? where idModule=?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, m.getNomModule());
            ps.setInt(2, m.getIdModule());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }

    @Override
    public void deleteObject(Module m) {
String requete = "delete from module where idModule = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, m.getIdModule());
            ps.executeUpdate();
            System.out.println("module supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }

    @Override
    public Module findObjectById(int id) {
Module module = new Module();
        String requete = "select * from module where idModule = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                module.setIdModule(resultat.getInt(1));
                module.setNomModule(resultat.getString(2));
            }
            return module;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du module " + ex.getMessage());
            return null;
        }    }

    @Override
    public List<Module> DisplayAllObject() {
List<Module> listemodule = new ArrayList<Module>();

        String requete = "select * from module";
        try {
            Statement statement = conn
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Module module = new Module();
                module.setIdModule(resultat.getInt(1));
                module.setNomModule(resultat.getString(2));

                listemodule.add(module);
            }
            return listemodule;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }    }
    
    
}
