/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import university.dao.classes.CoursDAO;
import university.dao.classes.EnseignantDAO;
import university.dao.classes.ModuleDAO;
import university.dao.interfaces.IDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import university.dao.classes.ExtraCoursDAO;
import university.entities.Cours;
import university.entities.Enseignant;
import university.entities.Module;
import university.entities.User;

/**
 *
 * @author LENOVO
 */
public class CoursInternaute extends javax.swing.JFrame {

    /**
     * Creates new form CoursResponsable
     */
    CoursModel coursModel = new CoursModel();
    CoursDAO coursDao = new CoursDAO();
    EnseignantDAO ensDao = new EnseignantDAO();
    ModuleDAO moduleDao = new ModuleDAO();
    ExtraCoursDAO exCoursDao = new ExtraCoursDAO();
    // Cours c = new Cours();

    public CoursInternaute() {
        initComponents();
        setSize(818, 630);
        coursModel.setData(exCoursDao.DisplayAllObjectIfValider());
        jTable1.setModel(coursModel);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));
        jTable1.setModel(coursModel);

        //************** Combo Enseignant *************************
        Enseignant ens = new Enseignant();
        ens.setId(0);
        ens.setNom("Tous les");
        ens.setPrenom("Enseignants");
        ensCombo.insertItemAt(ens, 0);
        ensCombo.setSelectedIndex(0);

        for (int i = 0; i < ensDao.DisplayAllObject().size(); i++) {
            ensCombo.addItem(ensDao.DisplayAllObject().get(i));
        }

        //************** Combo Module *************************
        Module module = new Module();
        module.setIdModule(0);
        module.setNomModule("Tous Les Modules");

        moduleCombo.insertItemAt(module, 0);
        moduleCombo.setSelectedIndex(0);

        for (int i = 0; i < moduleDao.DisplayAllObject().size(); i++) {
            moduleCombo.addItem(moduleDao.DisplayAllObject().get(i));

        }

//         jTable1.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    JTable target = (JTable) e.getSource();
//                    int row = target.getSelectedRow();
//                    //     int column = target.getSelectedColumn();
//
////         JOptionPane.showMessageDialog(null, row);
////         JOptionPane.showMessageDialog(null, column);
//                    String nomCours = JOptionPane.showInputDialog("Saissir Le Nouveau Nom Du Cours ! ");
//                    Cours c = (Cours) coursDao.findObjectById(Integer.parseInt((String) jTable1.getModel().getValueAt(row, 0)));
//
//                    c.setNomCours(nomCours);
//
//                    coursDao.updateObject(c);
//                    coursModel.setData(coursDao.DisplayAllObject());
//                    jTable1.setModel(coursModel);
//
//                }
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nameRechercheMultiple = new javax.swing.JTextField();
        ensCombo = new javax.swing.JComboBox();
        moduleCombo = new javax.swing.JComboBox();
        dateCoursBox = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/telecharger.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(90, 550, 170, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 480, 90, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 330, 452, 90);

        nameRechercheMultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRechercheMultipleActionPerformed(evt);
            }
        });
        getContentPane().add(nameRechercheMultiple);
        nameRechercheMultiple.setBounds(120, 220, 90, 20);

        getContentPane().add(ensCombo);
        ensCombo.setBounds(340, 260, 100, 30);

        getContentPane().add(moduleCombo);
        moduleCombo.setBounds(340, 210, 100, 30);

        dateCoursBox.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateCoursBox);
        dateCoursBox.setBounds(540, 220, 120, 20);

        jLabel2.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Recherche:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 180, 90, 17);

        jLabel4.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Par module");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 220, 80, 20);

        jLabel5.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Par enseignant");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 260, 98, 30);

        jLabel6.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Par date");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(470, 220, 60, 15);

        jLabel3.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Par nom");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 220, 70, 20);

        jLabel7.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rapide");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 480, 46, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rechrcher.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 470, 170, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/retour.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 120, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inter.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(820, 600));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        coursModel.setData(coursDao.DisplayAllObjectbyNomRapide(jTextField1.getText()));
        jTable1.setModel(coursModel);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void nameRechercheMultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRechercheMultipleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameRechercheMultipleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        java.sql.Date sqlDate = null;
        java.util.Date utilDate;

        if (dateCoursBox.getDate() != null) {

            utilDate = dateCoursBox.getDate();
            sqlDate = new java.sql.Date(utilDate.getTime());

        }

        User u = (User) ensCombo.getSelectedItem();
        Module m = (Module) moduleCombo.getSelectedItem();

       
            coursModel.setData(exCoursDao.listByAllCriteresEtud(nameRechercheMultiple.getText(), m.getIdModule(), u.getId(), sqlDate));

       
        
        jTable1.setModel(coursModel);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int id = Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)));
        CoursDAO coursDAO = new CoursDAO();
        Cours cours = coursDAO.findObjectById(id);
        try {
            URL url = new URL(cours.getCheminCours());
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showSaveDialog(this);

            if (result == chooser.APPROVE_OPTION) {
                String ext = FilenameUtils.getExtension(url.toString());
                System.out.println(chooser.getSelectedFile().toString());
                File destination = new File(chooser.getSelectedFile().toString()+"\\"+cours.getNomCours()+"."+ext);                
                System.out.println("salut"+destination);
                FileUtils.copyURLToFile(url, destination);
                
            }

            //
          
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new Authentification().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CoursInternaute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoursInternaute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoursInternaute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoursInternaute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoursInternaute().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateCoursBox;
    private javax.swing.JComboBox ensCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox moduleCombo;
    private javax.swing.JTextField nameRechercheMultiple;
    // End of variables declaration//GEN-END:variables
}
