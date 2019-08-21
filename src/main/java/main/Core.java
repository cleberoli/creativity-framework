package main;


import jade.Boot;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import data.DatasetAgent;
import judge.ArtifactJudge;
import judge.JudgeAgent;
import parser.ArtifactParser;
import parser.DatasetParser;


public class Core {

    private ArtifactContext context;
    private DatasetParser datasetParser;
    private ArtifactParser artifactParser;
    private ArtifactJudge artifactJudge;
    private DatasetAgent datasetAgent;
    private JudgeAgent judgeAgent;


    public Core(ArtifactContext context, DatasetParser datasetParser, ArtifactParser artifactParser,
                ArtifactJudge artifactJudge, DatasetAgent datasetAgent, JudgeAgent judgeAgent) {
        this.context = context;
        this.datasetParser = datasetParser;
        this.artifactParser = artifactParser;
        this.artifactJudge = artifactJudge;
        this.datasetAgent = datasetAgent;
        this.judgeAgent = judgeAgent;
    }

    public void run() {
        System.out.println("Creativity Framework");
        Boot.main(new String[]{""});

        setAgentInContainer(datasetAgent, "DatasetAgent", "CreativityFramework");
        setAgentInContainer(judgeAgent, "JudgeAgent", "CreativityFramework");
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


    public ArtifactContext getContext() {
        return context;
    }

    public void setContext(ArtifactContext context) {
        this.context = context;
    }

    public DatasetParser getDatasetParser() {
        return datasetParser;
    }

    public void setDatasetParser(DatasetParser datasetParser) {
        this.datasetParser = datasetParser;
    }

    public ArtifactParser getArtifactParser() {
        return artifactParser;
    }

    public void setArtifactParser(ArtifactParser artifactParser) {
        this.artifactParser = artifactParser;
    }

    public ArtifactJudge getArtifactJudge() {
        return artifactJudge;
    }

    public void setArtifactJudge(ArtifactJudge artifactJudge) {
        this.artifactJudge = artifactJudge;
    }

    public DatasetAgent getDatasetAgent() {
        return datasetAgent;
    }

    public void setDatasetAgent(DatasetAgent datasetAgent) {
        this.datasetAgent = datasetAgent;
    }

    public JudgeAgent getJudgeAgent() {
        return judgeAgent;
    }

    public void setJudgeAgent(JudgeAgent judgeAgent) {
        this.judgeAgent = judgeAgent;
    }

}