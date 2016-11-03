/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;

import com.lms.domain.sub.AppUser;

/** 
 *
 * @author Sudarsan
 */
public interface AppUserService extends Service {

    AppUser authenticate(String userName, String password);

    void create(AppUser appUser);

    AppUser findByUserName(String userName);

    void remove(String employeeId);
}
