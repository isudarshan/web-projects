/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.utils;

import org.bankapp.bankservices.BankServices;
import org.bankapp.bankservices.DummyService;
import org.bankapp.bankservices.impl.BankServicesImpl;
import org.bankapp.bankservices.impl.DummyServiceImpl;

/**
 *
 * @author Admin
 */
public class BankServiceUtils {

    public static BankServices getInstance() {
        return BankServicesImpl.getInstance();
    }
    
    public static DummyService getDummyService() {
        return DummyServiceImpl.getDummyService();
    }
}
