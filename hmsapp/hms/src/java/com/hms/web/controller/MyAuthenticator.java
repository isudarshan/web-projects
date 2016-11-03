/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.web.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author cmc
 */
public class MyAuthenticator extends  Authenticator{

    PasswordAuthentication passwordAuthentication = null;

    public MyAuthenticator(String userName, String password){
      passwordAuthentication = new PasswordAuthentication(userName, password);

    }



    public PasswordAuthentication getPasswordAuthentication(){
        return passwordAuthentication;
    }

}
