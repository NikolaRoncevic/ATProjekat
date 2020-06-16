package agents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import data.Data;
import enums.Performative;
import jms.JMSQueue;
import models.ACLMessage;
import models.AID;
import models.Agent;
import models.AgentCenter;
import models.AgentType;
import util.getLocalHost;

public class CollectorAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	public void handleMessage(ACLMessage message) {
		String teamA = message.getContent().split(" ")[0];
		String teamB = message.getContent().split(" ")[1];
		BufferedReader reader = null;
		if (message.getPerformative() == Performative.REQUEST) {
			InputStream in = getClass().getClassLoader().getResourceAsStream("utakmice.txt");
			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			String content = "";
			try {
				while((line = reader.readLine()) != null) {
					content += line + "\n";
				}
				content = content.substring(0, content.length()-1);
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ArrayList<AID> recievers = new ArrayList<>();
			for(Agent a : Data.getAgents()) {
				if(a.getId().getType().getName().equals("predictor")) {
					recievers.add(a.getId());
				}
			}
			AID[] niz = new AID[recievers.size()];
			for(int i = 0;i<recievers.size();i++) {
				niz[i] = recievers.get(i);
			}
			ACLMessage newMsg = new ACLMessage();
			newMsg.setSender(this.getId());
			newMsg.setContent(content);
			newMsg.setRecivers(niz);
			newMsg.setPerformative(Performative.REQUEST);
			
			new JMSQueue(newMsg);
			
			
			System.out.println(content);
		}
	}

	private AgentCenter findHost() {
		String currentIp = null;
		currentIp = getLocalHost.getIpAddress();
	
		for (AgentCenter center : Data.getAgentCenters()) {
			if (center.getAddress().equals(currentIp)) {
				return center;
			}
		}
		return null;
	}
}
