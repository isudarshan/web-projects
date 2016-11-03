/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.tests;

import com.lms.utils.ioc.AppLmsContext;

import com.lms.utils.ioc.GsmWrite;
import org.apache.log4j.Logger;

/**
 *
 * @author Sudarsan
 */
public class Test {

    private static Logger LOG = Logger.getLogger(Test.class);
    public static void main(String args[]) {

        AppLmsContext.init();
//        AppUser appUser = (AppUser) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER);
//        appUser.setUserName("admin");
//        appUser.setPassword("admin");
//        appUser.setQuestion("What was your childhood nickname?");
//        appUser.setAnswer("siddu");
//        appUser.setUserRole("admin");
//        appUser.setCreatedOn(new java.util.Date());
//        appUser.setCreatedBy(1);
//        appUser.setModifiedOn(new java.util.Date());
//        appUser.setModifiedBy(1);
//
//        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
//        appUserService.create(appUser);
//


        GsmWrite gsmWrite = new GsmWrite();
        try {
            //gsmWrite.write("91967653440", "Hai");
            gsmWrite.doIt("8885578008", "Happy Ugadi from Sudarsan, Sent using SMS Lib API");
        }catch(Exception exception){
            exception.printStackTrace();

        }
        


    }
}
