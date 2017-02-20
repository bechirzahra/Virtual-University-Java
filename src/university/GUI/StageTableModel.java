/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.dao.classes.StageDAO;
import university.entities.Cours;
import university.entities.Stage;

/**
 *
 * @author LENOVO
 */
public class StageTableModel extends AbstractTableModel{
    
   private static final long serialVersionUID = 5540475016914456218L;
       	private String[] nomColonnes = new String[]{"Id","NomEntreprise","Domaine","Duree","Date","Description"};

        private List<String[]> tableValues= new ArrayList<String[]>() ;
         
    
    
    @Override
    public int getRowCount() {
return tableValues.size();
    }

    public StageTableModel() {
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
    public String getColumnName(int column){
        return nomColonnes[column];
    }


public  void setData(List<Stage> stage) {
  
    tableValues=new ArrayList<String[]>();
    for(Stage s : stage) {
     tableValues.add(new String[]{
         
     ""+s.getIdStage(),
     s.getNomEntreprise(),
     s.getDomaine()+"",
     s.getDuree()+"",
     s.getDate()+"",
     s.getDescription()
     });
    }

    // le refresh auto
    fireTableChanged(null);
}
    
    
}
