package agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import data.Data;
import enums.Performative;
import jms.JMSQueue;
import models.ACLMessage;
import models.AID;
import models.Agent;
import ws.WSEndPoint;

public class MasterAgent extends Agent{
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void handleMessage(ACLMessage message) {
		if (message.getPerformative() == Performative.INFORM) {
			try {
				Context context = new InitialContext();
				WSEndPoint ws = (WSEndPoint) context.lookup(WSEndPoint.LOOKUP);
				ws.echoTextMessage(message.getContent());
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

}
