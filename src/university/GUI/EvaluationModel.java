/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.entities.Evaluation;

/**
 *
 * @author LENOVO
 */
public class EvaluationModel extends AbstractTableModel {

    private static final long serialVersionUID = 5540475016914456218L;
    //private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
    private String[] nomColonnes = new String[]{"IDEtudiant", "IDCours", "nomcours", "commentaire"};

    private List<String[]> tableValues = new ArrayList<String[]>();

    @Override
    public int getRowCount() {
        return tableValues.size();
    }

    public EvaluationModel() {
    }

    @Override
    public int getColumnCount() {
        return nomColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tableValues.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomColonnes[column];
    }

    public void setData(List<Evaluation> evaluations) {

        tableValues = new ArrayList<String[]>();
        for (Evaluation c : evaluations) {
            tableValues.add(new String[]{
                "" + c.getEtudiant().getId(),
                "" + c.getCours().getIdCours(),
                c.getCours().getNomCours(),
                c.getCommentaire() + "",});
        }

        // le refresh auto
        fireTableChanged(null);
    }

}
