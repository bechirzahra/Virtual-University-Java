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
import university.entities.Examen;

/**
 *
 * @author Safa
 */
public class ExamenTableModel extends AbstractTableModel {
     private static final long serialVersionUID = 5540475016914456218L;
    //private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
    private String[] nomColonnes = new String[]{"IDExamen", "duree", "nomModule", "nomEnseignant"};

    private List<String[]> tableValues = new ArrayList<String[]>();

    @Override
    public int getRowCount() {
        return tableValues.size();
    }

    public ExamenTableModel() {
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

    public void setData(List<Examen> examen) {

        tableValues = new ArrayList<String[]>();
        for (Examen e : examen) {
            tableValues.add(new String[]{
                "" + e.getIdExamen(),
                "" + e.getDuree(),
                e.getModule().getNomModule(),
                e.getEnseignant().getNom() + "",});
        }

        // le refresh auto
        fireTableChanged(null);
    }

    
}
