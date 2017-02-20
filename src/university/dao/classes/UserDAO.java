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
import university.dao.interfaces.IDAO;
import university.entities.User;
import university.technique.MyConnection;

/**
 *
 * @author LENOVO
 */
public class UserDAO implements IDAO<User>{

     private Connection conn;
    
    public UserDAO() {
        conn = MyConnection.getInstance();
            }
    
    @Override
    public void insertObject(User a) {
String requete = "insert into User (nom,prenom,username,password,roles,cheminImage,email,sexe,naissance,locked) values (?,?,?,?,?,?,?,?,?,0)";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            
             ps.setString(3, a.getUsername());
            ps.setString(7, a.getEmail());
            ps.setString(4, a.getPassword());
            ps.setString(5, a.getRoles());
            ps.setString(8, a.getSexe());
            ps.setString(1, a.getNom());
            ps.setString(2, a.getPrenom());
            ps.setDate(9, a.getNaissance());
            ps.setString(6, a.getCheminImage());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void updateObject(User a) {
String requete = "update user set nom=?,prenom=?,username=?,password=?,roles=?,cheminImage=?,email=?,sexe=?,naissance=? where id = '"+Authentification.idPersonneAutentfie+"' "; 
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, a.getNom()); 
            ps.setString(2, a.getPrenom());
            ps.setString(3, a.getUsername());
            ps.setString(4, a.getPassword());
            ps.setString(5, a.getRoles());
            ps.setString(6, a.getCheminImage());
            ps.setString(7, a.getEmail());
            ps.setString(8, a.getSexe());
            ps.setDate(9, a.getNaissance());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }
    
        public void updateUservalider(User u) {
String requete = "update user set locked = 1 where id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
           
            ps.setInt(1, u.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }
    

    @Override
    public void deleteObject(User a) {
String requete = "delete from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
            System.out.println("User supprimé");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }

    @Override
    public User findObjectById(int id) {
User r = new User();
        String requete = "select id,username,nom,prenom,password,cheminImage,email,sexe,naissance,roles from User where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                r.setId(resultat.getInt(1));
                r.setUsername(resultat.getString(2));
                r.setNom(resultat.getString(3));
                r.setPrenom(resultat.getString(4));
                r.setPassword(resultat.getString(5));
                r.setCheminImage(resultat.getString(6));
                r.setEmail(resultat.getString(7));
                r.setSexe(resultat.getString(8));
                r.setNaissance(resultat.getDate(9));
                r.setRoles(resultat.getString(10));
                
             
            }
            return r;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    }

    
    public User findObjectByLoginPassword(String login, String password) {
        boolean exist=false;
        User r = new User();
        String requete = "select id,nom,prenom,username,password,naissance,sexe,email,roles,cheminImage,locked from user where username = ? and password= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                r.setId(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setPrenom(resultat.getString(3));
                r.setUsername(resultat.getString(4));
                r.setPassword(resultat.getString(5));
                r.setNaissance(resultat.getDate(6));
                r.setSexe(resultat.getString(7));
                r.setEmail(resultat.getString(8));
                r.setRoles(resultat.getString(9));
                r.setCheminImage(resultat.getString(10));
                r.setLocked(resultat.getInt(11));

                exist=true;
             
            }
            if(exist){
                return r;
            }
    return null;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    }
    
    
    @Override
    public List<User> DisplayAllObject() {
    
        List<User>listUser = new ArrayList<User>();

        String requete = "select id,nom,prenom,username,email,naissance,roles from User  ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                User a = new User();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                a.setRoles(resultat.getString(7));
                
                listUser.add(a);
            }
            return listUser;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
        }
    
    public List<User> DisplayByRoles(String role) {
        
         List<User>listUserByroles = new ArrayList<User>();
        User r = new User();
        String requete = "select id,nom,prenom,username,email,naissance,roles from User where roles ='"+role+"' ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            

            while (resultat.next()) {
               User a = new User();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                a.setRoles(resultat.getString(7));
             
                listUserByroles.add(a);
            }
            return listUserByroles;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }  
   }
    
    public List<User> DisplayDemandeInscrip() {

        List<User> listedemandeUser = new ArrayList<User>();

        String requete = "select id,nom,prenom,username,email,naissance,roles from User where locked=0 ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                User a = new User();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                a.setRoles(resultat.getString(7));
                
                listedemandeUser.add(a);
            }
            return listedemandeUser;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
    }
    
        public static List<User> intersection(List<User> list1, List<User> list2) {
        List<User> list = new ArrayList<User>();

        for (User t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
        
         public List<User> listByAllCriteres(String role, int locked) {

        List<User> resultatRecherche = new ArrayList<User>();

       resultatRecherche = DisplayAllObject();
        
        //resultatRecherche=intersection(DisplayDemandeInscrip(),DisplayByRoles(role));
        
        if(!role.equals("")){
            resultatRecherche = intersection(resultatRecherche,DisplayByRoles(role));
        }
        if(locked==0){
           resultatRecherche = intersection(resultatRecherche,DisplayDemandeInscrip());

        }
       
        return resultatRecherche;

         }
        
        
        
        
         /*      
    
    public List<User> DisplayDemandeInscripRole(String role) {

        List<User> listedemandeUser = new ArrayList<User>();

        String requete = "select id,nom,prenom,username,email,naissance,roles from User where roles='"+role+"' and locked=0 ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                User a = new User();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString(2));
                a.setPrenom(resultat.getString(3));
                a.setUsername(resultat.getString(4));
                a.setEmail(resultat.getString(5));
                a.setNaissance(resultat.getDate(6));
                a.setRoles(resultat.getString(7));

                
                listedemandeUser.add(a);
            }
            return listedemandeUser;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return null;
        }
    }*/
         public int nombreUtilisateur  (String roles){
            int nombre=0;
            
            String requete="SELECT count(*)from user group by roles=?";
            try {
            PreparedStatement ps = conn.prepareStatement(requete);
           ps.setString(1,roles);
           ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()){
                
                
           nombre=resultat.getInt(1) ;}
            System.out.println("");
            
        } catch (SQLException ex) {
            
            System.out.println("erreur  " + ex.getMessage());
        }
         
            return nombre;
            
        }   
         
         
         
         
         public User findByPseudo(String pseudo)
  {

         String requete ="Select * from user where nom=?";
         try
         {
         PreparedStatement
ps=MyConnection.getInstance().prepareStatement(requete);
         ps.setString(1, pseudo);
         ResultSet resultat =ps.executeQuery();
         User user= new User();

         while (resultat.next())
         {

         user.setNom(resultat.getString(2));
         }
         return user;

         }

         catch(SQLException ex)
         {

                System.out.println("erreur lors du chargement"+ex.getMessage());
            }

  return null;

}


        public void AjouterUserfb(User us){
        try {
    String req="INSERT INTO `user`(`nom`,`email`,`password`,) VALUES (?,?,?)";
            PreparedStatement ps =
MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, us.getNom());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPassword());
           //ps.setString(4, us.getEtat());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,
null, ex);
            System.out.println("Erreur de l'ajout "+ex.getMessage());

        }

  }
   
    
}
