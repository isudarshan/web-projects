/**
 * 
 */
package com.lms.domain.sub;

import org.smslib.AGateway;
import org.smslib.ICallNotification;

/**
 * @author Sudarsan
 * 
 */
public class CallNotification implements ICallNotification {

	public void process(AGateway gateway, String callerId) {
		System.out.println(">>> New call detected from Gateway: "
				+ gateway.getGatewayId() + " : " + callerId);
	}
}
