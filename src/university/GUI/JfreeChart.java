/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;


import java.awt.BorderLayout;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import university.dao.classes.CoursDAO;
import university.dao.classes.EvaluationDAO;
import university.dao.classes.NoteDAO;
import university.dao.classes.UserDAO;
import university.dao.interfaces.IDAO;
import university.entities.Cours;
import university.entities.Evaluation;
import university.entities.Note;


public class JfreeChart extends javax.swing.JFrame {
    CoursDAO coursDAO = new CoursDAO();
    IDAO coursDao=new CoursDAO();
CoursModel coursModel =new CoursModel();
 EvaluationDAO evaluationdao = new EvaluationDAO();
   
    /**
     * Creates new form JfreeChart
     */
    public JfreeChart() {
        initComponents();
        setSize(818, 630);

 
 
 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 620));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(170, 180, 423, 313);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/statCoursEval.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 540, 180, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/utilisStat.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 540, 170, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NoteStat.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(77, 540, 180, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/retour.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 120, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stat.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 790, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
           
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
           int i=0;
         int j=0;
           List<Cours> listcours =coursDAO.DisplayAllObject();
           for (Cours lis1 : listcours) {
            i++;
           }
           //System.out.println("hhhh");
           List<Evaluation> listevaluation =evaluationdao.DisplayAllObject();
           for (Evaluation listeval : listevaluation) {
            j++;
          }
           try {
           dataset.setValue(i,"","cours");
        
         dataset.setValue(j,"","evaluation");
           
            JFreeChart chart = ChartFactory.createBarChart("Statistiques des evaluations et des cours", "", "", dataset, PlotOrientation.VERTICAL,false,false,false);
           CategoryPlot catPlot = chart.getCategoryPlot();
           ChartPanel ChartPanel = new ChartPanel(chart);
           System.out.println("hhhh");
           jPanel1.removeAll();
           jPanel1.add(ChartPanel,BorderLayout.CENTER);
           jPanel1.validate();
          // jPanel1.revalidate();
           }catch (Exception e) {
               System.out.println(i+"kkk");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       UserDAO u= new UserDAO ();
               
        DefaultPieDataset dataset=new DefaultPieDataset  ();
       try{
        dataset.setValue("Admin",u.nombreUtilisateur("admin"));
       dataset.setValue("Responsables",u.nombreUtilisateur("responsable") );
        dataset.setValue("etudiants",u.nombreUtilisateur("etudiant") );
        dataset.setValue("enseignants",u.nombreUtilisateur("enseignant") );
       
JFreeChart chart= ChartFactory.createPieChart3D("les adherents ", (PieDataset) dataset,true ,true ,false);
ChartPanel ChartPanel = new ChartPanel(chart);

        jPanel1.removeAll();
           jPanel1.add(ChartPanel,BorderLayout.CENTER);
           jPanel1.validate();
          // jPanel1.revalidate();
           }catch (Exception e) {
               //System.out.println(i+"kkk");
           }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        NoteDAO notedao=new NoteDAO();
           int i=0;
         int j=0;
           List<Note> listnote =notedao.DisplayAllObjectmoins10();
           for (Note lis1 : listnote) {
            i++;
           }
           //System.out.println("hhhh");
           List<Note> listevaluation =notedao.DisplayAllObjectplus10();
           for (Note list10 : listevaluation) {
            j++;
          }
           try {
           dataset.setValue(i,"","note inferieur à 10");
        
         dataset.setValue(j,"","note superieur à 10");
           
            JFreeChart chart = ChartFactory.createBarChart("Statistiques des notes ", "", "", dataset, PlotOrientation.VERTICAL,false,false,false);
           CategoryPlot catPlot = chart.getCategoryPlot();
           ChartPanel ChartPanel = new ChartPanel(chart);
           System.out.println("hhhh");
           jPanel1.removeAll();
           jPanel1.add(ChartPanel,BorderLayout.CENTER);
           jPanel1.validate();
          // jPanel1.revalidate();
           }catch (Exception e) {
               System.out.println(i+"kkk");
        }
                                                
                                                  // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         this.setVisible(false);
        new Authentification().setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(JfreeChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfreeChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfreeChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfreeChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfreeChart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
