package agents;

import java.net.InetAddress;
import java.net.UnknownHostException;

import data.Data;
import enums.Performative;
import jms.JMSQueue;
import models.ACLMessage;
import models.AID;
import models.Agent;
import models.AgentCenter;
import models.AgentType;

public class CollectorAgent extends Agent {

	@Override
	public void handleMessage(ACLMessage message) {
		if(message.getPerformative() == Performative.REQUEST) {
			AID reciever = new AID();
			reciever.setName("pong1");
			System.out.println("Pripremam se da posaljem poruku pongu!");
			AgentType type = Data.getAgentTypes().get("pong");
			reciever.setType(type);
			AgentCenter host = findHost();
			if(host == null) {
				System.out.println("doslo je do greske");
				return;
			}
			reciever.setHost(host);
			ACLMessage msg = new ACLMessage();
			msg.setPerformative(Performative.REQUEST);
			AID[] receivers = {reciever};
			msg.setRecivers(receivers);
			msg.setSender(this.getId());
			msg.setContent(message.getContent());
			new JMSQueue(msg);
			
			
		}else if(message.getPerformative() == Performative.INFORM) {
			System.out.println("Pong vratio odgovor");
		}
	}
	private AgentCenter findHost() {
		String currentIp = null;
		try {
			currentIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		for(AgentCenter center : Data.getAgentCenters()) {
			if(center.getAddress().equals(currentIp)) {
				return center;
			}
		}
		return null;
	}
}
