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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import university.GUI.Authentification;
import university.entities.Enseignant;
import university.entities.Examen;
import university.entities.Module;
import university.entities.QuestionExamen;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class ExamenDAO {

    private Connection conn;

    public ExamenDAO() {
        conn = MyConnection.getInstance();

    }

    public void insertObject(Examen e) {

        QuestionExamenDAO questionExamenDAO = new QuestionExamenDAO();
        String requete = "insert into examen (duree,date,idModule,idEnseignant,heure,minute) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, e.getDuree());
            ps.setDate(2, (java.sql.Date) e.getDate());
            ps.setInt(3, e.getModule().getIdModule());
            ps.setInt(4, Authentification.idPersonneAutentfie);
            ps.setInt(5, e.getHeure());
            ps.setInt(6, e.getMinute());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {

                    int idExamen = generatedKeys.getInt(1);

                    for (QuestionExamen ques : e.getQuestions()) {

                        ques.setExamen(findObjectById(idExamen));
                        questionExamenDAO.insertObject(ques);
                    }

                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteObject(Examen e) {
        String requete = "delete from examen where idExamen = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, e.getIdExamen());
            ps.executeUpdate();
            System.out.println("examen supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Examen findObjectById(int id) {
        Examen e = new Examen();
        ModuleDAO moduledao = new ModuleDAO();
        EnseignantDAO ens = new EnseignantDAO();
        QuestionExamenDAO questDao = new QuestionExamenDAO();

        String requete = "select * from examen where idExamen = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                e.setIdExamen(resultat.getInt(1));
                e.setDuree(resultat.getInt(2));
                e.setDate(resultat.getDate(3));

                Module mod = moduledao.findObjectById(resultat.getInt(4));
                e.setModule(mod);

                Enseignant es = ens.findObjectById(resultat.getInt(5));
                e.setEnseignant(es);

                List<QuestionExamen> listquest = questDao.DisplayByIdExamen(resultat.getInt(1));
                e.setQuestions(listquest);
                e.setHeure(resultat.getInt(6));
                e.setMinute(resultat.getInt(7));

            }
            return e;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du examen " + ex.getMessage());
            return null;
        }

    }

    public List<Examen> DisplayAllObject() {
        List<Examen> listtests = new ArrayList<Examen>();

        String requete = "select * from examen";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen e = new Examen();
                e.setIdExamen(resultat.getInt(1));
                e.setDuree(resultat.getInt(2));
                e.setDate(resultat.getDate(3));

                ModuleDAO moduleDao = new ModuleDAO();
                e.setModule(moduleDao.findObjectById(resultat.getInt(4)));
                EnseignantDAO ensDao = new EnseignantDAO();
                e.setEnseignant(ensDao.findObjectById(resultat.getInt(5)));
                e.setHeure(resultat.getInt(6));
                e.setMinute(resultat.getInt(7));

                listtests.add(e);
            }
            return listtests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des examens " + ex.getMessage());
            return null;
        }
    }
    public List<Examen> DisplayAllObjectDate() {
        List<Examen> listtests = new ArrayList<Examen>();

        String requete = "select * from examen ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Examen e = new Examen();
                e.setIdExamen(resultat.getInt(1));
                e.setDuree(resultat.getInt(2));
                e.setDate(resultat.getDate(3));

                ModuleDAO moduleDao = new ModuleDAO();
                e.setModule(moduleDao.findObjectById(resultat.getInt(4)));
                EnseignantDAO ensDao = new EnseignantDAO();
                e.setEnseignant(ensDao.findObjectById(resultat.getInt(5)));
                e.setHeure(resultat.getInt(6));
                e.setMinute(resultat.getInt(7));

                listtests.add(e);
            }
            return listtests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des examens " + ex.getMessage());
            return null;
        }
    }

}
