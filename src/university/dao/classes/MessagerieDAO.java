package university.dao.classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import university.dao.classes.UserDAO;
import university.technique.MyConnection;
import university.entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import university.entities.Messagerie;


/**
 *
 * @author Chaima
 */
public class MessagerieDAO {
      private Connection conn;
    public MessagerieDAO (){
        conn = MyConnection.getInstance();
 }
     public void insertObject(Messagerie m) {
 String requete = "insert into messagerie (idUserRecepteur,idUserEmeteur,contenu,vue) values (?,?,?,?)";
 
 
    // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

 
 //java.util.Date utilDate = new java.util.Date();
 
 //dateFormat.format(utilDate.getTime());
    
   // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
          ps.setInt(1, m.getUserEmeteur().getId());
            ps.setInt(2, m.getUserRecepteur().getId());
            ps.setString(3,m.getContenu());
            ps.setBoolean(4, m.isVue());
           // ps.setDate(5, sqlDate );
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessagerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }
     
     
     
     public void messageVu(Messagerie m)
     {
     String  requete = "update messagerie set vue = 1 where  id=?" ;
     
       
            try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            System.out.println("Vu");
        } catch (SQLException ex) {
            System.out.println("non vu" + ex.getMessage());
        }  
          
        
         
     }      


     
       public Messagerie findByUser(int idUserRecepteur)
               
  {
 
         String requete ="Select * from messagerie where idUserRecepteur=?";

      
   UserDAO userDAO = new UserDAO();

         try 
         {
         PreparedStatement ps=MyConnection.getInstance().prepareStatement(requete);
         ps.setInt(1, idUserRecepteur);
         ResultSet resultat =ps.executeQuery();
         Messagerie mess= new Messagerie();
         
         while (resultat.next())
            
         {
        
        mess.setIdMess(resultat.getInt(1));
        mess.setContenu(resultat.getString(2));
      
        
    User emetteur = userDAO.findObjectById(resultat.getInt(3));
                mess.setUserEmeteur(emetteur);
                
                
     User recepteur = userDAO.findObjectById(resultat.getInt(4));
                mess.setUserRecepteur(recepteur);      
        
         }
         return mess;
         
         }
         
        
         catch(SQLException ex)
         {
  
                System.out.println("erreur lors du chargement"+ex.getMessage());
  }
  
  return null;




}
  
       
       
       
       public List DisplayAllObjectByUser(int idUserRecepteur) {

    
    List<Messagerie> lisMessages = new ArrayList<Messagerie>();

    UserDAO userDAO = new UserDAO();
    
        String requete = "Select * from messagerie where idUserRecepteur= "+idUserRecepteur+"";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Messagerie m = new Messagerie();
                
                m.setId(resultat.getInt(1));
                m.setContenu(resultat.getString(4));
                m.setVue(resultat.getBoolean(5));
                
               User Recepteur= userDAO.findObjectById(resultat.getInt(2));
                m.setUserRecepteur(Recepteur);
                
               
                User Emetteur= userDAO.findObjectById(resultat.getInt(3));
                m.setUserRecepteur(Emetteur);
               
                
                lisMessages.add(m);
            }
            return lisMessages;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des examens " + ex.getMessage());
            return null;
        }
    
    
    }
    
      
       
       
        public List DisplayConversationByBothUsers(int idUserRecepteur, int idUSerEmetteur) {

    
    List<Messagerie> lisMessages = new ArrayList<Messagerie>();

    UserDAO userDAO = new UserDAO();
                                                                                                
        String requete = "Select * from messagerie where idUserRecepteur= "+idUserRecepteur+" and idUserEmeteur= "+idUSerEmetteur+"  union ( Select * from messagerie where idUserRecepteur= "+idUSerEmetteur+" and idUserEmeteur= "+idUserRecepteur+") order by (date) ";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Messagerie m = new Messagerie();
                
                m.setId(resultat.getInt(1));
                m.setContenu(resultat.getString(4));
                m.setVue(resultat.getBoolean(5));
                
               User Recepteur= userDAO.findObjectById(resultat.getInt(2));
                m.setUserRecepteur(Recepteur);
                
               
                User Emetteur= userDAO.findObjectById(resultat.getInt(3));
                m.setUserRecepteur(Emetteur);
               
                
                lisMessages.add(m);
            }
            return lisMessages;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des examens " + ex.getMessage());
            return null;
        }
    
    
    }
       
}
