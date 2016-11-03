/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;

import com.lms.domain.sub.Bal;

/**
 *
 * @author Sudarsan
 */
public interface BalService extends Service {


    void create(Bal bal);

    Bal findByEmployeeId(String employeeId);
}
