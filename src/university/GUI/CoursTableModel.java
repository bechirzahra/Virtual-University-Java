/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.dao.classes.CoursDAO;
import university.entities.Cours;

/**
 *
 * @author LENOVO
 */
public class CoursTableModel extends AbstractTableModel {
    
    String[] column = {"id","date","nom","idmodule","NomEnseignant"};
    List<Cours> cours;

    public CoursTableModel(){
        CoursDAO dao =new CoursDAO();
        cours = dao.DisplayAllObject();
    }
    
    public String getColumnName(int col){
        return column[col];
    }
    
    @Override
    public int getRowCount() {
        return cours.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex){
            case 0:
                return cours.get(rowIndex).getIdCours();
            case 1:      
                return cours.get(rowIndex).getDate();
            case 2:      
                return cours.get(rowIndex).getNomCours();
            case 3:      
              return cours.get(rowIndex).getModule().getNomModule();
            case 4:      
                return cours.get(rowIndex).getEnseignant().getNom();
                
            default:
                return null;
        }    }

    void setData(List DisplayAllObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
