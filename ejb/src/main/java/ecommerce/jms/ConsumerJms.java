package ecommerce.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup",
	            propertyValue = "ecommerce/Myqueue"),
	    @ActivationConfigProperty(propertyName = "destinationType",
	            propertyValue = "javax.jms.Queue")
	})
public class ConsumerJms implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			try {
				TextMessage msg = (TextMessage) message;
				
				System.out.println("===============");
				System.out.println("===============");
				
				if(msg.getText().equals("cabulosa")) {
					throw new Exception();
				}
				
				System.out.println(msg.getText());
				
				System.out.println("===============");
				System.out.println("===============");
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	

}
