/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessagerieInstantannee;

import java.util.Timer;
import university.dao.classes.MessagerieDAO;
import university.entities.Messagerie;
import university.entities.User;



/**
 *
 * @author Safa
 */
public class SendAndRecieveMessages extends javax.swing.JFrame {
    
     User userEmetteur = new User(1);
    User userRecepteur = new User(2);
    MessagerieDAO messagerieDAO = new MessagerieDAO();
    
    Timer time = new Timer(); 
    ScheduledTask st = new ScheduledTask(); 

    Messagerie messagerie = new Messagerie();

    /**
     * Creates new form SendAndRecieveMessages1
     */
    public SendAndRecieveMessages() {
        initComponents();
        time.schedule(st, 0, 5000); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sendEmetteur = new javax.swing.JButton();
        sendRecepteur = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMsgEmetteur = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgTextRecepteur = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        chatAreaEmetteur = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        chatAreaRecepteur = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Emetteur");

        jLabel2.setText("Recepteur");

        sendEmetteur.setText("Send");
        sendEmetteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmetteurActionPerformed(evt);
            }
        });

        sendRecepteur.setText("Send");
        sendRecepteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRecepteurActionPerformed(evt);
            }
        });

        textMsgEmetteur.setColumns(20);
        textMsgEmetteur.setRows(5);
        jScrollPane1.setViewportView(textMsgEmetteur);

        msgTextRecepteur.setColumns(20);
        msgTextRecepteur.setRows(5);
        jScrollPane2.setViewportView(msgTextRecepteur);

        chatAreaEmetteur.setColumns(20);
        chatAreaEmetteur.setRows(5);
        jScrollPane3.setViewportView(chatAreaEmetteur);

        chatAreaRecepteur.setColumns(20);
        chatAreaRecepteur.setRows(5);
        jScrollPane4.setViewportView(chatAreaRecepteur);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(sendEmetteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendRecepteur)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendEmetteur)
                    .addComponent(sendRecepteur))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendEmetteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmetteurActionPerformed
        // TODO add your handling code here:
          messagerie.setUserEmeteur(userEmetteur);
        messagerie.setUserRecepteur(userRecepteur);

        messagerie.setContenu(textMsgEmetteur.getText());
        messagerie.setVue(false);
        messagerieDAO.insertObject(messagerie);
        
        textMsgEmetteur.setText("");
    }//GEN-LAST:event_sendEmetteurActionPerformed

    private void sendRecepteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRecepteurActionPerformed
        // TODO add your handling code here:
          messagerie.setUserEmeteur(userRecepteur);
        messagerie.setUserRecepteur(userEmetteur);

        messagerie.setContenu(msgTextRecepteur.getText());
                        messagerie.setVue(false);

        messagerieDAO.insertObject(messagerie);

        msgTextRecepteur.setText(""); 
    }//GEN-LAST:event_sendRecepteurActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendAndRecieveMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendAndRecieveMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendAndRecieveMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendAndRecieveMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendAndRecieveMessages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea chatAreaEmetteur;
    public static javax.swing.JTextArea chatAreaRecepteur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea msgTextRecepteur;
    private javax.swing.JButton sendEmetteur;
    private javax.swing.JButton sendRecepteur;
    private javax.swing.JTextArea textMsgEmetteur;
    // End of variables declaration//GEN-END:variables
}
