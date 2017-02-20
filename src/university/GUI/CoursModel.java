
package university.GUI;

import university.entities.Cours;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CoursModel extends AbstractTableModel{
    
	private static final long serialVersionUID = 5540475016914456218L;
	//private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
       	private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Date"};

        private List<String[]> tableValues= new ArrayList<String[]>() ;
         
    
    
    @Override
    public int getRowCount() {
return tableValues.size();
    }

    public CoursModel() {
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


public  void setData(List<Cours> courses) {
  
    tableValues=new ArrayList<String[]>();
    for(Cours c : courses) {
     tableValues.add(new String[]{
         
     ""+c.getIdCours(),
     c.getNomCours(),
     c.getEnseignant().getNom()+"",
     c.getModule().getNomModule()+"",
     //c.getValider()+"",
   //  c.getResponsableModule().getId()+"",
     c.getDate()+""
     
     });
    }

    // le refresh auto
    fireTableChanged(null);
}
    
    
    
}
