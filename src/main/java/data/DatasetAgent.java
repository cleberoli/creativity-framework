package data;

import jade.core.Agent;

import main.ArtifactContext;
import parser.ArtifactParser;
import parser.DatasetParser;


public class DatasetAgent extends Agent {

    private DatasetParser datasetParser;
    private ArtifactParser artifactParser;
    private ArtifactContext context;


    public DatasetAgent(DatasetParser datasetParser, ArtifactParser artifactParser, ArtifactContext context) {
        this.datasetParser = datasetParser;
        this.artifactParser = artifactParser;
        this.context = context;
    }

    protected void setup() {
        super.setup();
        addBehaviour(new DatasetAgentBehavior(this, 2000L, datasetParser, artifactParser, context));
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

    public ArtifactContext getContext() {
        return context;
    }

    public void setContext(ArtifactContext context) {
        this.context = context;
    }

}