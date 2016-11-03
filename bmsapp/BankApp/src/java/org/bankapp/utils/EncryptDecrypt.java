/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.utils;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Shashank
 *
 * EncryptDecrypt is a singleTon class
 *
 * Use getInstance method to get its object
 *
 * It has two functions -------------------
 *
 * <b>encrypt(String) and returns an ArrayList</b>
 *
 * Send the string u want to encrypt as the parameter
 *
 * the returned list has two values in it .. First value i.e , 0<sup>th</sup>
 * value is the Encrypted text of the String parameter u sent Second Value i.e,
 * 1<sup>st</sup> value is the secretKey returns " byte[] "(byte array) ..
 * --------------------------------------------------------------
 *
 * <b>decrypt(String, byte[]) and returns the decrypted string</b>
 *
 * It takes the encrypted String as well the secretKey(byte[]) and returns the
 * decrypted String you require
 *
 * ------------------------------------------------------------------
 */
public class EncryptDecrypt {

//    private Connection connection = null;
//    ConnectionJDBC jDBC = new ConnectionJDBC();
    
    
    
    private EncryptDecrypt() {
    }

    public static List encrypt(String message) {

        List list = new ArrayList();

        try {

            KeyGenerator generator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = generator.generateKey();

            Cipher enCipher = Cipher.getInstance("AES");
            enCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] messageBytes = message.getBytes();
            messageBytes = enCipher.doFinal(messageBytes);

            byte[] encBytes = BASE64EncoderStream.encode(messageBytes);
            String encString = new String(encBytes);
            byte[] secretKeyByte = secretKey.getEncoded();

            list.add(encString);
            list.add(secretKeyByte);
            return list;

//            PreparedStatement ps = connection.prepareStatement("INSERT INTO ENCTEST VALUES(?,?,?)");
//            ps.setInt(1, id);
//            ps.setString(2, encString);
//            ps.setBytes(3, secretKeyByte);
//
//            ps.executeUpdate();
//            ps.close();
//            connection.close();

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static String decrypt(String encMessage, byte[] secretKeyB) {

        String decString = "";
        try {

//            connection = jDBC.getConnection();
//            int Id;
//            String encMessage = "";
//            byte[] key = null;
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ENCTEST WHERE ID = ?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Id = resultSet.getInt(1);
//                encMessage = resultSet.getString(2);
//                key = resultSet.getBytes(3);
//            }
            SecretKey secretKey = new SecretKeySpec(secretKeyB, "AES");
            Cipher deChipher = Cipher.getInstance("AES");
            deChipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decBytes = encMessage.getBytes();

            decBytes = BASE64DecoderStream.decode(decBytes);
            decBytes = deChipher.doFinal(decBytes);
            decString = new String(decBytes);
//            resultSet.close();
//            connection.close();

            return decString;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        }
        return decString;

    }
}
