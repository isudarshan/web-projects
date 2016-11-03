/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bankapp.bankservices;

import java.util.List;
import org.bankapp.domain.Dummy;

/**
 *
 * @author Sudarsan
 */
public interface DummyService {

    void create(Dummy dummy);
    
    List<Dummy> getAll();
    
    void delete(Dummy dummy);
    
    Dummy getDummy(Long id);
    
}
