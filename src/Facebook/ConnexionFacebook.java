/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import com.restfb.types.User;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import university.dao.classes.UserDAO;



/**
 *
 * @author Chaima
 */
public class ConnexionFacebook {
    
     public static User currentUser;
    // les attribus 
    public static String API_KEY = "1004350572910764";
   // static String API_KEY = "1471522786397444";
    //public static String SECRET = "e7d974d763f40021365cd43da84fb040";
     //  public static String SECRET = "cb77000447a93093eeb4e6e05704cd53";
public static String SECRET ="c61f6f0d172971d0ebf7a5a8ced3f9e5";
   
    public static String firstRequest = "https://graph.facebook.com/oauth/authorize?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";
     public static String secondRequest = "https://graph.facebook.com/aouth/acceess_token?"
 
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "client_secret=" + SECRET + "&code=";
    public static String access_token = "CAACEdEose0cBAFPdHGhcQ4Tx1iZCz78bBjuzaEGsG07qKlBjyn9WXfroOdJSqhgmgIBIt3iIgNwZA2629wepmhW2PTb06JZALwEeZBa6Mmkat1oFV9o5n1T8fMLQ8ZArc8geYfcjWhJdCkfNv86GAsknRyjNYJOamk8nZAL8vV3SSt8w1oxjZC6xoafn2P2U3xVMrJErgNpu9s1M3ZAZAvMhTd9ybZBOrFyZAEZD";
    public static boolean firstRequestDone = false;
    public static boolean secondRequestDone = false;
    final JFrame loginFrame = new JFrame();
    public static FacebookClient facebookClient = null;
    private String userName;
    private String userMail;
    public static boolean fbCnxEnd = false;
    /**
     *
     */
    public String  registredUserName;
    
    // notification par email
    Gmail gmail = new Gmail(); 

    

    public void loginFb() {
        NativeInterface.open();
        NativeInterface.initialize();
        final JFrame authFrame = new JFrame();
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        final JWebBrowser webBrowser = new JWebBrowser();
        
        webBrowser.navigate(firstRequest);
        
        
        
        webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
            @Override
            public void locationChanged(WebBrowserNavigationEvent e) {
                super.locationChanged(e);
                // Check if first request was not done
                if (!firstRequestDone) {
                    // Check if you left the location and were redirected to the next
                    // location
                    
                    if (e.getNewResourceLocation().contains("http://www.facebook.com/connect/login_success.html?code=")) {
                        // If it successfully redirects you, get the verification code
                        // and go for a second request
                        String[] splits = e.getNewResourceLocation().split("=");
                        String stage2temp = secondRequest + splits[1];
                        System.out.println("First =" + splits[1]);
                        webBrowser.navigate(stage2temp);
                        firstRequestDone = true;
                    }
                } else {
                    // If secondRequest is not done yet, you perform this and get the
                    // access_token
                    if (!secondRequestDone) {
                        System.out.println(webBrowser.getHTMLContent());
                        // Create reader with the html content
                        StringReader readerSTR = new StringReader(webBrowser.getHTMLContent());
                        // Create a callback for html parser
                        HTMLEditorKit.ParserCallback callback;
                        callback = new HTMLEditorKit.ParserCallback() {
                               @Override
                               public void handleText(char[] data, int pos) {
                                   try {
                                       System.out.println(data);
                                       // because there is only one line with the access_token
                                       // in the html content you can parse it.
                                       String string = new String(data);
                                       String[] temp1 = string.split("&");
                                       String[] temp2 = temp1[0].split("=");
                                       System.out.println("access tocken=" + temp2);
                                       access_token = temp2[1];
                                       new GraphReaderExample(access_token).runEverything();
                                       facebookClient = new DefaultFacebookClient(access_token);
                                      com.restfb.types.User user = facebookClient.fetchObject("me", User.class);
                       //                Page page = facebookClient.fetchObject("cocacola", Page.class);
                                     //  userName = user.getName();
                                     //  userMail = user.getEmail();

                                       authFrame.dispose();
                                       /**
                                        * *****
                                        */
                                       
                                       
                                       
                                       String userName = user.getName();
                                       String userMail = user.getEmail();
                              
                                       // attribution de mot de passe aleatoire de longuer 8 
                                       String password = GenerationDeCode.generate(8);
                                   university.dao.classes.UserDAO userDAO = new university.dao.classes.UserDAO();
                                      university.entities.User us= new university.entities.User();
                                      
                                        
                                      us.setEmail(userMail);
                  
                                       us.setNom(userName);
                                       //us.setEtat("false");
                                       // attribution de mot de passe automatique
                                       us.setPassword(string);
                                     
                                       System.out.println("**************");
                                       System.out.println(us.getNom());
                                       System.out.println(userDAO.findByPseudo(userName).getNom());
                                       
                                 registredUserName = userDAO.findByPseudo(userName).getNom();
                                       
                                       if (us.getNom().equals(registredUserName)) {

                                           
                                           MainFrameAdmin admin=new MainFrameAdmin();
                                           JOptionPane.showMessageDialog(admin, "Bievenue " + registredUserName);

                                       } else {
                              // envoie de l email automatiaue             
                             userDAO.AjouterUserfb(us);
                             gmail.adresse_destination=us.getEmail();
                             gmail.subject="Votre Mot de passe";
                             gmail.contenu="voici votre mot de passe"+us.getPassword()+"changer le";
                             gmail.sendMail();
                                           
                                       }
                                   } catch (Exception ex) {
                                       Logger.getLogger(ConnexionFacebook.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                               }
                           };
                        try {
                            // Call the parse method
                            new ParserDelegator().parse(readerSTR, callback, false);

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        // After everything is done, you can dispose the jframe
                        authFrame.dispose();
                        

                    }
                }
            }
        });

        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        authFrame.add(webBrowserPanel);
        authFrame.setSize(900, 700);
        authFrame.setVisible(true);
        authFrame.setLocationRelativeTo(null);

    }
    
}
