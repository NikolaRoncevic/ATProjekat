package data;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import agents.PingAgent;
import models.AID;
import models.Agent;
import models.AgentCenter;
import models.AgentType;

@Startup
@Singleton
public class Data {

	private static ArrayList<AgentType> agentTypes = new ArrayList<>();
	private static ArrayList<AgentCenter> agentCenters = new ArrayList<>();
	private static ArrayList<Agent> agents = new ArrayList<>();

	static {
		AgentType type1 = new AgentType("pong", "pong");
		AgentType type2 = new AgentType("ping", "ping");
		AgentType type3 = new AgentType("collector", "collector");
		AgentType type4 = new AgentType("predictor", "predictor");
		AgentType type5 = new AgentType("master", "master");
		agentTypes.add(type1);
		agentTypes.add(type2);
		agentTypes.add(type3);
		agentTypes.add(type4);
		agentTypes.add(type5);
	}

	public static ArrayList<AgentType> getAgentTypes() {
		return agentTypes;
	}

	public static void setAgentTypes(ArrayList<AgentType> agentTypes) {
		Data.agentTypes = agentTypes;
	}

	public static ArrayList<AgentCenter> getAgentCenters() {
		return agentCenters;
	}

	public static void setAgentCenters(ArrayList<AgentCenter> agentCenters) {
		Data.agentCenters = agentCenters;
	}

	public static ArrayList<Agent> getAgents() {
		return agents;
	}

	public static void setAgents(ArrayList<Agent> agents) {
		Data.agents = agents;
	}

	

}
