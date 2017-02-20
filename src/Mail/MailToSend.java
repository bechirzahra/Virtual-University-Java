/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;



/**
 *
 * @author LENOVO
 */
public class MailToSend {
    
    
    public static void sendMessage(String subject, String text, String destinataire, String copyDest) { 
    // 1 -> CrÃ©ation de la session 
    Properties props = new Properties(); 
    props.setProperty("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.starttls.enable","true"); // ********
    props.put("mail.smtp.host","smtp.gmail.com"); // serveur 
    props.put("mail.smtp.port","587"); // port
   
    //properties.setProperty("mail.smtp.host", SMTP_HOST1); 
    //properties.setProperty("mail.smtp.user", LOGIN_SMTP1); 
    //properties.setProperty("mail.from", IMAP_ACCOUNT1); 
    Session session = Session.getInstance(props);
    
      // 2 -> CrÃ©ation du message 
    MimeMessage message = new MimeMessage(session); 
    try { 
        message.setText(text); 
        message.setSubject(subject); 
        message.addRecipients(Message.RecipientType.TO, destinataire); 
        message.addRecipients(Message.RecipientType.CC, copyDest); 
    } catch (MessagingException e) { 
        e.printStackTrace(); 
    } 
    
     // 3 -> Envoi du message 
    Transport transport=null;
    try { 
         transport = session.getTransport("smtp"); 
        transport.connect("ranyahammouda92@gmail.com","Pidev"); 
        transport.sendMessage(message, new Address[] { new InternetAddress(destinataire), 
                                                        new InternetAddress(copyDest) }); 
    } catch (MessagingException e) { 
        e.printStackTrace(); 
    } finally { 
        try { 
            if (transport != null) { 
                transport.close(); 
            } 
        } catch (MessagingException e) { 
            e.printStackTrace(); 
        } 
        
     
    }
    
    }
    
    
}
