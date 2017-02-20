
package university.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.entities.Etudiant;

public class EtudiantModel extends AbstractTableModel{
    
	private static final long serialVersionUID = 5540475016914456218L;
	//private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
       	private String[] nomColonnes = new String[]{"ID","Nom","Prenom","Login","Email","Naissance"};

        private List<String[]> tableValues= new ArrayList<String[]>() ;
         
    
    
    @Override
    public int getRowCount() {
return tableValues.size();
    }

    public EtudiantModel() {
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


public  void setData(List<Etudiant> etudiant) {
  
    tableValues=new ArrayList<String[]>();
    for(Etudiant e : etudiant) {
     tableValues.add(new String[]{
         
     ""+e.getId(),
     e.getNom(),
     e.getPrenom()+"",
     e.getUsername()+"",
     e.getEmail()+"",
     e.getNaissance().toString()
     
     });
    }

    // le refresh auto
    fireTableChanged(null);
}
    
    
    
}
