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
import university.entities.Etudiant;
import university.entities.Evaluation;
import university.entities.Examen;
import university.entities.Note;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class NoteDAO implements IDAO<Note>{
    
    private Connection connection;

    public NoteDAO() {
        connection = MyConnection.getInstance();
    }
    
    public void insertObject(Note n) {
        String requete = "insert into note (idEtudiant,idExamen,noteE) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, n.getEtudiant().getId());
            ps.setInt(2, n.getExamen().getIdExamen());
            ps.setInt(3, n.getNoteE());          
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void updateObject(Note n) {
String requete = "update note set noteE =? where idExamen =? and idEtudiant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, n.getNoteE());
            
            ps.setInt(2, n.getExamen().getIdExamen());
            ps.setInt(3, n.getEtudiant().getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }       }

    @Override
    public void deleteObject(Note n) {
String requete = "delete from note where idEtudiant = ? and idExamen=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, n.getEtudiant().getId());
            ps.setInt(2, n.getExamen().getIdExamen());
            ps.executeUpdate();
            System.out.println("note supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }    
    
    @Override
    public Note findObjectById(int id) {
    Note note = new Note();
        String requete = "select * from note where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                note.getEtudiant().setId(resultat.getInt(1));
                note.getExamen().setIdExamen(resultat.getInt(2));
                note.setNoteE(resultat.getInt(3));                
           }
            return note;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du note " + ex.getMessage());
            return null;
        }     }

    @Override
    public List<Note> DisplayAllObject() {
List<Note> listenote = new ArrayList<Note>();

        String requete = "select * from note";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Note note = new Note();
                note.getEtudiant().setId(resultat.getInt(1));
                note.getExamen().setIdExamen(resultat.getInt(2));
                note.setNoteE(resultat.getInt(3));                
                
                listenote.add(note);
            }
            return listenote;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notes " + ex.getMessage());
            return null;
        }        }
    
    public List<Note> DisplayAllObjectplus10() {
        EtudiantDAO et =new EtudiantDAO();
        ExamenDAO exa = new ExamenDAO();
      //  Note n = new Note ();
List<Note> listenote = new ArrayList<Note>();

        String requete = "select * from note where noteE > 10";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Note n = new Note();
               // note.getEtudiant().setId(resultat.getInt(1));
                //note.getExamen().setIdExamen(resultat.getInt(2));
                n.setNoteE(resultat.getInt(3)); 
                  Etudiant etudiant= et.findObjectById(resultat.getInt(1));
                n.setEtudiant(etudiant);
                Examen examen =exa.findObjectById(resultat.getInt(2));
                n.setExamen(examen);
                
                        
                
                
                listenote.add(n);
            }
            return listenote;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notes " + ex.getMessage());
            return null;
        }        }
    
    
    public List<Note> DisplayAllObjectmoins10() {
        EtudiantDAO et =new EtudiantDAO();
        ExamenDAO exa = new ExamenDAO();
      //  Note n = new Note ();
List<Note> listenote = new ArrayList<Note>();

        String requete = "select * from note where noteE < 10";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Note n = new Note();
               // note.getEtudiant().setId(resultat.getInt(1));
                //note.getExamen().setIdExamen(resultat.getInt(2));
                n.setNoteE(resultat.getInt(3)); 
                  Etudiant etudiant= et.findObjectById(resultat.getInt(1));
                n.setEtudiant(etudiant);
                Examen examen =exa.findObjectById(resultat.getInt(2));
                n.setExamen(examen);
                
                        
                
                
                listenote.add(n);
            }
            return listenote;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des notes " + ex.getMessage());
            return null;
        }        }
}
