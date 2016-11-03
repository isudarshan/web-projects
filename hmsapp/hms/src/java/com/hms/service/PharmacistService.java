/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.service;

import com.hms.domain.sub.Pharmacist;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface PharmacistService {

    void create(Pharmacist pharmacist);

    List<Pharmacist> getrAll();

    Pharmacist getByName(String pharmacistName);


}
