/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessagerieInstantannee;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import university.dao.classes.MessagerieDAO;
import university.entities.Messagerie;
import university.entities.User;




/**
 *
 * @author Chaima
 */
public class ScheduledTask extends TimerTask {

     User user = new User();
    MessagerieDAO messagerieDAO = new MessagerieDAO();
     public static List<Messagerie> messagesEmetteur = new ArrayList<>();
    public static List<Messagerie> messagesRecepteur = new ArrayList<>();

        public static List<Messagerie> conversation = new ArrayList<>();

    
    @Override
    public void run() {
        
       // System.err.println("Salut PI DEV  w hetou 20 alf");
      //  messagesEmetteur= messagerieDAO.DisplayAllObjectByUser(2);
  //  System.err.println(messagesRecepteur.size());
   //messagesRecepteur= messagerieDAO.DisplayAllObjectByUser(1);

   conversation = messagerieDAO.DisplayConversationByBothUsers(1,2);
   
      SendAndRecieveMessages.chatAreaRecepteur.setText("");
      SendAndRecieveMessages.chatAreaEmetteur.setText("");
 
        for (Messagerie mess : ScheduledTask.conversation) {
             SendAndRecieveMessages.chatAreaRecepteur.append("\n" + mess.getContenu() + "\n");
           
        }
 
   
   
   for (Messagerie mess : ScheduledTask.conversation) {
       SendAndRecieveMessages.chatAreaEmetteur.append("\n" + mess.getContenu() + "\n");
           
        }
 

       
       
        
    }
    
    /*
    public static void main(String args[]) throws InterruptedException {
 
		Timer time = new Timer(); 
		ScheduledTask st = new ScheduledTask(); 
		time.schedule(st, 0, 1000); 
               
                
//                time.cancel();

 
	}


*/



}


