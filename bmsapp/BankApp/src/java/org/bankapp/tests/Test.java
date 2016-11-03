
package org.bankapp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.DummyService;
import org.bankapp.domain.Dummy;
import org.bankapp.utils.BankServiceUtils;

/**
 *
 * @author Sudarsan
 */
public class Test {

    private static final Logger LOG = Logger.getLogger(Test.class);

    public static void main(String args[]) {

        DummyService dummyService = BankServiceUtils.getDummyService();
        try {
            InputStream inputStream = new FileInputStream(new File("G:/Koala.jpg"));
            byte[] imageBytes = new byte[inputStream.available()];
            inputStream.read(imageBytes);

            Dummy dummy = new Dummy();
            dummy.setName("BBB");
            dummy.setPic(imageBytes);
            
            dummyService.create(dummy);
        } catch (FileNotFoundException ex) {
            LOG.warn("", ex);
        } catch (IOException ex) {
            LOG.warn("", ex);
        }
    }
}
