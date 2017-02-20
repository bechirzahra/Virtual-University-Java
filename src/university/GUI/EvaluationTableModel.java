/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.dao.classes.EvaluationDAO;
import university.entities.Evaluation;

/**
 *
 * @author LENOVO
 */
public class EvaluationTableModel extends AbstractTableModel  {
    String[] column = {"idEtudiant","NomCours","Commentaire","Note"};
    List<Evaluation> evaluation;
    
    public EvaluationTableModel(){
        EvaluationDAO dao =new EvaluationDAO();
        evaluation = dao.DisplayAllObject();
    }
    
    public String getColumnName(int col){
        return column[col];
    }
    
    @Override
    public int getRowCount() {
        return evaluation.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex){
            case 0:
                return evaluation.get(rowIndex).getEtudiant().getId();
            case 1:      
                return evaluation.get(rowIndex).getCours().getNomCours();
            case 2:      
                return evaluation.get(rowIndex).getCommentaire();
            case 3:
                return evaluation.get(rowIndex).getNote();

            default:
                return null;
        }    }
            
    
}
