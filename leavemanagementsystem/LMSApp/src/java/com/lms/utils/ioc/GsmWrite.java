/**
 * 
 */
package com.lms.utils.ioc;

import com.harshadura.gsm.smsdura.GsmModem;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

/**
 * @author Sudarsan
 * 
 */
public class GsmWrite {

	private static Logger LOG = Logger.getLogger(GsmWrite.class);

	private static String port = "COM5"; // Modem Port.
	private static int bitRate = 115200; // this is also optional.

	// private static String modemName = "ZTE"; //this is optional.
	// private static String modemPin = "0000"; //Pin code if any have assigned
	// to the modem.
	private static String SMSC = "+919848001104"; // Message Center Number ex.
													// IDEA

	public void write(String mobileNumber, String messageText) {

		GsmModem gsmModem = new GsmModem();
		GsmModem.configModem(port, bitRate, null, null, SMSC);
		try {
			gsmModem.Sender(mobileNumber, messageText);

		} catch (Exception exception) {
			LOG.warn("GsmWrite", exception);
		}

	}


    public void doIt(String mobileNumber, String message) throws Exception
	{
        
        //InputStream inputStream = new FileInputStream(new File("classpath:mobile.properties"));
        InputStream inputStream = getClass().getResourceAsStream("mobile.properties");
        //System.out.println("Input Stream"+inputStream.available());
        Properties properties = new Properties();
        properties.load(inputStream);
        
        OutboundNotification outboundNotification = new OutboundNotification();
		System.out.println("Example: Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		SerialModemGateway gateway = new SerialModemGateway("modem.com5", properties.getProperty("port"), 115200, "Huawei", "");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		// Explicit SMSC address set is required for some modems.
		// Below is for VODAFONE GREECE - be sure to set your own!
		gateway.setSmscNumber(properties.getProperty("smsc"));
		Service.getInstance().setOutboundMessageNotification(outboundNotification);
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();
		System.out.println();
		System.out.println("Modem Information:");
		System.out.println("  Manufacturer: " + gateway.getManufacturer());
		System.out.println("  Model: " + gateway.getModel());
		System.out.println("  Serial No: " + gateway.getSerialNo());
		System.out.println("  SIM IMSI: " + gateway.getImsi());
		System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
	System.out.println();
		// Send a message synchronously.
		OutboundMessage msg = new OutboundMessage(mobileNumber, message);
		Service.getInstance().sendMessage(msg);
		System.out.println(msg);
		// Or, send out a WAP SI message.
		//OutboundWapSIMessage wapMsg = new OutboundWapSIMessage("306974000000",  new URL("http://www.smslib.org/"), "Visit SMSLib now!");
		//Service.getInstance().sendMessage(wapMsg);
		//System.out.println(wapMsg);
		// You can also queue some asynchronous messages to see how the callbacks
		// are called...
		//msg = new OutboundMessage("309999999999", "Wrong number!");
		//srv.queueMessage(msg, gateway.getGatewayId());
		//msg = new OutboundMessage("308888888888", "Wrong number!");
		//srv.queueMessage(msg, gateway.getGatewayId());
		//System.out.println("Now Sleeping - Hit <enter> to terminate.");
		//System.in.read();

        //Thread.sleep(500);
		Service.getInstance().stopService();
        //gateway.stopGateway();
	}

	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}
}
