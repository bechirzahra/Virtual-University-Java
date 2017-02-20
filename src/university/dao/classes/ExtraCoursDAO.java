/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.dao.classes;

import university.technique.MyConnection;
import university.entities.Cours;
import university.entities.Enseignant;
import university.entities.Module;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author El-Nino
 */
public class ExtraCoursDAO {

    private Connection conn;

    public ExtraCoursDAO() {
        conn = MyConnection.getInstance();

    }

    public List<Cours> DisplayAllObjectbyNom(String ch) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours where nomCours=?";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, ch);
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
         //To change body of generated methods, choose Tools | Templates.

    public List<Cours> DisplayAllObjectbyModule(int idModule) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours where idModule=?";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idModule);
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

    public List<Cours> DisplayAllObjectbyEnseignant(int idEnseignant) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours where idEnseignant=?";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, idEnseignant);
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

    public List<Cours> DisplayAllObjectIfValider() {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours where valider=1";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
             Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            //PreparedStatement ps = conn.prepareStatement(requete);
            // ps.setBoolean(1, valider);
            //ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Cours c = new Cours();
                c.setIdCours(resultat.getInt(1));
                c.setDate(resultat.getDate(2));
                c.setNomCours(resultat.getString(3));
                c.setValider(resultat.getInt(4));

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

    public List<Cours> DisplayAllObjectbyDate(Date date) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours where date=?";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setDate(1, date);
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
         //To change body of 

    public List<Cours> DisplayAllObjectbyNomRapide(String cours) {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from Cours where nomCours LIKE '" + cours + "%'";

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

    public List<Cours> DisplayAllObject() {
        List<Cours> listtests = new ArrayList<Cours>();

        String requete = "select * from cours";

        EnseignantDAO ensDao = new EnseignantDAO();
        ModuleDAO moduleDao = new ModuleDAO();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

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

    public static List<Cours> intersection(List<Cours> list1, List<Cours> list2) {
        List<Cours> list = new ArrayList<Cours>();

        for (Cours t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public List<Cours> listByAllCriteres(String nomCours, int idModule, int idEnseignant, int valider, Date date) {

        List<Cours> resultatRecherche = new ArrayList<Cours>();

        resultatRecherche = DisplayAllObject();

        if (!nomCours.equals("")) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyNom(nomCours));
        }

        if (idModule != 0) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyModule(idModule));
        }

        if (idEnseignant != 0) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyEnseignant(idEnseignant));
        }

        if (valider==1) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectIfValider());
        }

        if (date != null) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyDate(date));

        }
        return resultatRecherche;
    }

    
    public List<Cours> listByAllCriteresEtud(String nomCours, int idModule, int idEnseignant,Date date) {

        List<Cours> resultatRecherche = new ArrayList<Cours>();

        resultatRecherche = DisplayAllObject();

        if (!nomCours.equals("")) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyNom(nomCours));
        }

        if (idModule != 0) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyModule(idModule));
        }

        if (idEnseignant != 0) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyEnseignant(idEnseignant));
        }

        

        if (date != null) {
            resultatRecherche = intersection(resultatRecherche, DisplayAllObjectbyDate(date));

        }
        return resultatRecherche;
    }
}
