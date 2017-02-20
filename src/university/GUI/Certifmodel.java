/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import university.entities.Certification;
import university.entities.Cours;

/**
 *
 * @author Safa
 */
public class Certifmodel extends AbstractTableModel{
    
	private static final long serialVersionUID = 5540475016914456218L;
	//private String[] nomColonnes = new String[]{"ID","Nom du Cours","Enseignant","Module","Responsable du Module","Date"};
       	private String[] nomColonnes = new String[]{"ID","duree","date d obtention","nomCertif","nom admin"};

        private List<String[]> tableValues= new ArrayList<String[]>() ;
         
    
    
    @Override
    public int getRowCount() {
return tableValues.size();
    }

    public Certifmodel () {
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


public  void setData(List<Certification> certifications) {
  
    tableValues=new ArrayList<String[]>();
    for(Certification c : certifications) {
     tableValues.add(new String[]{
         
     ""+c.getIdCertification(),
     ""+c.getDuree(),
     ""+c.getDateObtention(),
     ""+c.getNomCertif(),
     
     ""+c.getAdmin().getId()
     
     
     });
    }

    // le refresh auto
    fireTableChanged(null);
}}
