/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.domain.sub.AppUser;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface AppUserService {
 
    void create(AppUser appUser);
    
    List<AppUser> getAll();
    
    AppUser authenticate(String userName, String password);
    
    AppUser forgotPassword(String securityQuestion, String answer, String userName);
    
    AppUser findByUserName(String userName);
    
    
    
    
    
}
