package main;

import data.DatasetAgent;
import jade.Boot;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import judge.ArtifactJudge;
import model.Artifact;
import parser.ArtifactParser;
import parser.DatasetParser;

public class Core {

    ArtifactContext<Artifact> context;
    DatasetParser datasetParser;
    ArtifactParser artifactParser;
    ArtifactJudge artifactJudge;
    DatasetAgent datasetAgent;
    Agent judgeAgent;

    public Core(ArtifactContext<Artifact> context, DatasetParser datasetParser, ArtifactParser artifactParser,
                ArtifactJudge artifactJudge, DatasetAgent datasetAgent, Agent judgeAgent) {
        this.context = context;
        this.datasetParser = datasetParser;
        this.artifactParser = artifactParser;
        this.artifactJudge = artifactJudge;
        this.datasetAgent = datasetAgent;
        this.judgeAgent = judgeAgent;
    }

    private void setAgentInContainer(Agent agent, String agentName, String containerName){
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.CONTAINER_NAME, containerName);

        AgentContainer controllerAgentContainer = runtime.createAgentContainer(profile);

        try {
            AgentController controller;
            controller = controllerAgentContainer.acceptNewAgent(agentName, agent);
            controller.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Creativity Framework");
        Boot.main(new String[]{""});

        setAgentInContainer(datasetAgent, "DatasetAgent", "CreativityFramework");
        setAgentInContainer(judgeAgent, "JudgeAgent", "CreativityFramework");
    }

}
