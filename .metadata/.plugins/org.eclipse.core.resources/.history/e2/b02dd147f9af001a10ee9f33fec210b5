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

public class PongAgent extends Agent{

	private static final long serialVersionUID = 1L;

	@Override
	public void handleMessage(ACLMessage message) {
		if(message.getPerformative() == Performative.REQUEST) {
			Agent recieverAgent = Data.getAgents().get("ping1");
			
			AID reciever = recieverAgent.getId();
			//reciever.setName("pong1");
			System.out.println("Pripremam se da posaljem poruku pingu!");
			//AgentType type = Data.getAgentTypes().get("pong");
			//reciever.setType(type);
			//AgentCenter host = findHost();
			//if(host == null) {
			//	System.out.println("doslo je do greske");
			//	return;
			//}
			//reciever.setHost(host);
			ACLMessage msg = new ACLMessage();
			msg.setPerformative(Performative.INFORM);
			AID[] receivers = {reciever};
			msg.setRecivers(receivers);
			msg.setSender(this.getId());
			msg.setContent(message.getContent());
			new JMSQueue(msg);
			
			
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
