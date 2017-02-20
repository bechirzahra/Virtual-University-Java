/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.dao.interfaces;

import java.util.List;
import university.entities.AncienExamen;

/**
 *
 * @author LENOVO
 */
public interface IDAO <O> {
    void insertObject(O val);

    void updateObject(O val);

    void deleteObject(O val);
    
    O findObjectById(int id);
    
    List<O> DisplayAllObject();
    
    
    
}
