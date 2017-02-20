/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Module {
    private int idModule;
    private String nomModule;
    private List<Cours> ListCours = new ArrayList<>();

    public Module() {
    }

    public Module(int idModule, String nomModule) {
        this.idModule = idModule;
        this.nomModule = nomModule;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public List<Cours> getListCours() {
        return ListCours;
    }

    public void setListCours(List<Cours> ListCours) {
        this.ListCours = ListCours;
    }
    
     @Override
    public String toString() {
        return nomModule ;
    }
    
    
    
}
