/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;

import com.lms.domain.sub.Remarks;

/**
 *
 * @author Sudarsan
 */
public interface RemarksService extends Service {

    void create(Remarks remarks);
    
}
