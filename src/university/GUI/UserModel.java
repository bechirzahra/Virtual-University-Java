
package university.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.entities.User;

public class UserModel extends AbstractTableModel{
    
	private static final long serialVersionUID = 5540475016914456218L;
	//private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
       	private String[] nomColonnes = new String[]{"ID","Nom","Prenom","Login","Email","Naissance","Profession"};

        private List<String[]> tableValues= new ArrayList<String[]>() ;
         
    
    
    @Override
    public int getRowCount() {
return tableValues.size();
    }

    public UserModel() {
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


public  void setData(List<User> user) {
  
    tableValues=new ArrayList<String[]>();
    for(User u : user) {
     tableValues.add(new String[]{
         
     ""+u.getId(),
     u.getNom(),
     u.getPrenom()+"",
     u.getUsername()+"",
     u.getEmail()+"",
     u.getNaissance().toString(),
     u.getRoles()+""
     
     });
    }

    // le refresh auto
    fireTableChanged(null);
}
    
    
    
}
