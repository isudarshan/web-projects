/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.utils;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class RandomGenerator {

    public static Long generateClerkId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("8468").append(randValue)
                .append(calendar.get(Calendar.DAY_OF_YEAR));
        Long l = new Long(builder.toString());
        return l;

    }

    public static Long generateUserId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("7427").append(randValue)
                .append(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        Long l = new Long(builder.toString());
        return l;

    }

    public static String generateUserPassword(String name) {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        String pwd = name.substring(0, (name.length() / 2));
        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append(pwd).append(randValue)
                .append(calendar.get(Calendar.YEAR));
        return builder.toString();

    }

    public static Long generateAddressId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("2685").append(randValue)
                .append(calendar.get(Calendar.DAY_OF_WEEK));

        return new Long(builder.toString());
    }

    public static Long generateDetailsId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("7262").append(randValue)
                .append(calendar.get(Calendar.MILLISECOND));
        return new Long(builder.toString());
    }

    public static Long generateAccountId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("7695").append(randValue)
                .append(calendar.get(Calendar.DATE));
        return new Long(builder.toString());
    }
    
    
    

    public static Long generateCustomerId() {
        Random random = new Random(System.currentTimeMillis());
        String randValue = String.valueOf((1 + random.nextInt(2)) * 10000
                + random.nextInt(10000));

        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append("7728").append(randValue)
                .append(calendar.get(Calendar.HOUR_OF_DAY));
        return new Long(builder.toString());

    }
}
