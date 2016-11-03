/**
 * 
 */
package com.lms.utils.ioc;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.smslib.AGateway.Protocols;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Library;
import org.smslib.Service;
import org.smslib.crypto.AESKey;
import org.smslib.modem.SerialModemGateway;


import com.lms.domain.sub.CallNotification;
import com.lms.domain.sub.GatewayStatusNotification;
import com.lms.domain.sub.InboundNotification;
import com.lms.domain.sub.OrphanedMessageNotification;

/**
 * @author Sudarsan
 * 
 */
public class GsmRead {
	private static Logger LOG = Logger.getLogger(GsmRead.class);

	public void read() throws Exception {

		// Define a list which will hold the read messages.
		List<InboundMessage> msgList;
		// Create the notification callback method for inbound & status report
		// messages.
		InboundNotification inboundNotification = new InboundNotification();
		// Create the notification callback method for inbound voice calls.
		CallNotification callNotification = new CallNotification();
		// Create the notification callback method for gateway statuses.
		GatewayStatusNotification statusNotification = new GatewayStatusNotification();
		OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
		try {
			System.out
					.println("Example: Read messages from a serial gsm modem.");
			LOG.debug(Library.getLibraryDescription());
			LOG.debug("Version: " + Library.getLibraryVersion());
			// Create the Gateway representing the serial GSM modem.
			SerialModemGateway gateway = new SerialModemGateway("modem.com3",
					"COM3", 115200, null, "E1732");
			gateway.getATHandler().setStorageLocations("SM");
			// Set the modem protocol to PDU (alternative is TEXT). PDU is the
			// default, anyway...
			gateway.setProtocol(Protocols.PDU);
			// Do we want the Gateway to be used for Inbound messages?
			gateway.setInbound(true);
			// Do we want the Gateway to be used for Outbound messages?
			gateway.setOutbound(true);

			// Let SMSLib know which is the SIM PIN.
			// gateway.setSimPin("0000");
			// Set up the notification methods.
			Service.getInstance().setInboundMessageNotification(
					inboundNotification);
			Service.getInstance().setCallNotification(callNotification);
			Service.getInstance().setGatewayStatusNotification(
					statusNotification);
			Service.getInstance().setOrphanedMessageNotification(
					orphanedMessageNotification);

			// Add the Gateway to the Service object.
			Service.getInstance().addGateway(gateway);
			// Similarly, you may define as many Gateway objects, representing
			// various GSM modems, add them in the Service object and control
			// all of them.
			// Start! (i.e. connect to all defined Gateways)
			Service.getInstance().startService();

			// Printout some general information about the modem.
			LOG.debug("\n");
			LOG.debug("Modem Information:");
			LOG.debug("  Manufacturer: " + gateway.getManufacturer());
			LOG.debug("  Model: " + gateway.getModel());
			LOG.debug("  Serial No: " + gateway.getSerialNo());
			LOG.debug("  SIM IMSI: " + gateway.getImsi());
			LOG.debug("  Signal Level: " + gateway.getSignalLevel() + " dBm");
			LOG.debug("  Battery Level: " + gateway.getBatteryLevel() + "%");
			LOG.debug("\n");

			// In case you work with encrypted messages, its a good time to
			// declare your keys.
			// Create a new AES Key with a known key value.
			// Register it in KeyManager in order to keep it active. SMSLib will
			// then automatically
			// encrypt / decrypt all messages send to / received from this
			// number.

			Service.getInstance()
					.getKeyManager()
					.registerKey(
							"+919676534400",
							new AESKey(new SecretKeySpec("0011223344556677"
									.getBytes(), "AES")));

			// Read Messages. The reading is done via the Service object and
			// affects all Gateway objects defined. This can also be more
			// directed to a specific
			// Gateway - look the JavaDocs for information on the Service method
			// calls.
			msgList = new ArrayList<InboundMessage>();
			Service.getInstance().readMessages(msgList, MessageClasses.ALL);

			for (InboundMessage msg : msgList) {
				msg.setMemLocation("SM");
				LOG.debug(msg.getMemLocation() + "\t" + msg.getOriginator()
						+ "\t" + msg.getText());
			}
			// Sleep now. Emulate real world situation and give a chance to the
			// notifications
			// methods to be called in the event of message or voice call
			// reception.
			LOG.debug("Now Sleeping - Hit <enter> to stop service.");
			System.in.read();
			System.in.read();
		} catch (Exception e) {
			LOG.warn("GsmRead", e);
		} finally {
			Service.getInstance().stopService();
		}
	}
}
