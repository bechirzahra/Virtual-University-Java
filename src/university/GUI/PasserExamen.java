/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import university.dao.classes.EtudiantDAO;
import university.dao.classes.NoteDAO;
import university.entities.Etudiant;
import university.entities.Examen;
import university.entities.Note;
import university.entities.QuestionExamen;

/**
 *
 * @author LENOVO
 */
public class PasserExamen extends javax.swing.JFrame {

    static int  numQuest=0;
    int note = 0;
    List<QuestionExamen> listQuest = new ArrayList<>();
      NoteDAO notedao = new NoteDAO();
       Note n = new Note();
         Etudiant etu = new Etudiant();
        EtudiantDAO etuDAO = new EtudiantDAO();

   static Examen exam = new Examen();
    /**
     * Creates new form PasserExamen
     * @param 
     */
    public PasserExamen(Examen e) {
        initComponents();
        setSize(818, 630);

        exam=e;
        listQuest = e.getQuestions();

        jLabel6.setText("");
        jLabel6.setText(listQuest.get(PasserExamen.numQuest).getCorps());
        Choix1.setText(listQuest.get(PasserExamen.numQuest).getChoix1());
        Choix2.setText(listQuest.get(PasserExamen.numQuest).getChoix2());
        Choix3.setText(listQuest.get(PasserExamen.numQuest).getChoix3());

       Choix4.setText(listQuest.get(PasserExamen.numQuest).getChoix4());

    //   JOptionPane.showMessageDialog(rootPane, listQuest.get(PasserExamen.numQuest).getChoix4());
       
       jPanel1.removeAll();
       jPanel1.add(new Chrono(e.getDuree(),Color.RED));
       jPanel1.repaint();
       jPanel1.revalidate();
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupeChoix = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Choix4 = new javax.swing.JRadioButton();
        Choix3 = new javax.swing.JRadioButton();
        Choix2 = new javax.swing.JRadioButton();
        Choix1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 620));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profilB_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 120, 130, 40);

        jLabel6.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel2");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 230, 650, 17);

        GroupeChoix.add(Choix4);
        Choix4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choix4ActionPerformed(evt);
            }
        });
        getContentPane().add(Choix4);
        Choix4.setBounds(170, 370, 340, 25);

        GroupeChoix.add(Choix3);
        Choix3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choix3ActionPerformed(evt);
            }
        });
        getContentPane().add(Choix3);
        Choix3.setBounds(170, 340, 340, 25);

        GroupeChoix.add(Choix2);
        Choix2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choix2ActionPerformed(evt);
            }
        });
        getContentPane().add(Choix2);
        Choix2.setBounds(170, 310, 340, 25);

        GroupeChoix.add(Choix1);
        Choix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Choix1ActionPerformed(evt);
            }
        });
        getContentPane().add(Choix1);
        Choix1.setBounds(170, 280, 340, 25);

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 490, 57, 25);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stageB.png"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(470, 120, 160, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/coursB_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(150, 120, 140, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/examenV_1.png"))); // NOI18N
        getContentPane().add(jButton5);
        jButton5.setBounds(310, 120, 130, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/evalautionB_1.png"))); // NOI18N
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(640, 120, 140, 40);

        jPanel1.setOpaque(false);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(650, 180, 100, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/espaceEtudiant.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Choix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choix4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Choix4ActionPerformed

    private void Choix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choix3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Choix3ActionPerformed

    private void Choix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choix2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Choix2ActionPerformed

    private void Choix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Choix1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Choix1ActionPerformed
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//System.out.println(getSelectedButtonText(GroupeChoix)); 

        if (numQuest == listQuest.size() - 1) {
            jButton2.setVisible(false);
          
              if (getSelectedButtonText(GroupeChoix).equals(listQuest.get(PasserExamen.numQuest).getBonneReponse())) {
            //JOptionPane.showMessageDialog(rootPane, "true");
            note = note + listQuest.get(PasserExamen.numQuest).getBarem();
            
        } else {
          //  JOptionPane.showMessageDialog(rootPane, "false");
            note = note + 0;
        } 
 
            
        }  
        
        
        
        
        else {
JOptionPane.showMessageDialog(rootPane, PasserExamen.numQuest);
            if (getSelectedButtonText(GroupeChoix).equals(listQuest.get(PasserExamen.numQuest).getBonneReponse())) {
           // JOptionPane.showMessageDialog(rootPane, "true");
            note = note + listQuest.get(PasserExamen.numQuest).getBarem();
            
        } else {
           // JOptionPane.showMessageDialog(rootPane, "false");
            note = note + 0;
        } 
 
           
                    PasserExamen.numQuest++;
 
        jLabel6.setText("");
        Choix1.setText("");
        Choix2.setText("");
        Choix3.setText("");
        Choix4.setText("");
        
        jLabel6.setText(listQuest.get(PasserExamen.numQuest).getCorps());
        Choix1.setText(listQuest.get(PasserExamen.numQuest).getChoix1());
        Choix2.setText(listQuest.get(PasserExamen.numQuest).getChoix2());
        Choix3.setText(listQuest.get(PasserExamen.numQuest).getChoix3());
        Choix4.setText(listQuest.get(PasserExamen.numQuest).getChoix4());
        //System.out.println(getSelectedButtonText(GroupeChoix));

        
            }
                      System.out.println(note);

        
            
           
        
//                note=note+0;
//      
//       
        n.setNoteE(note);
      
        etu = etuDAO.findObjectById(Authentification.idPersonneAutentfie);
        n.setEtudiant(etu);
       
        n.setExamen(exam);
        notedao.insertObject(n);
        JOptionPane.showMessageDialog(null, "note= "+note);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new EspaceEtudiant().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CoursEtudiant().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ConsulterStage().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new eval().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasserExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasserExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasserExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasserExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
*/
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasserExamen(exam).setVisible(true);
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Choix1;
    private javax.swing.JRadioButton Choix2;
    private javax.swing.JRadioButton Choix3;
    private javax.swing.JRadioButton Choix4;
    private javax.swing.ButtonGroup GroupeChoix;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
