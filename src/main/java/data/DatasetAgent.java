package data;

import jade.core.Agent;

import main.ArtifactContext;
import model.Artifact;
import parser.ArtifactParser;
import parser.DatasetParser;


public class DatasetAgent extends Agent {

    DatasetParser datasetParser;
    ArtifactParser artifactParser;
    ArtifactContext<Artifact> context;

    public DatasetAgent(DatasetParser datasetParser, ArtifactParser artifactParser, ArtifactContext<Artifact> context) {
        this.datasetParser = datasetParser;
        this.artifactParser = artifactParser;
        this.context = context;
    }

    protected void setup() {
        super.setup();
        addBehaviour(new DatasetAgentBehavior(this, 2000L, datasetParser, artifactParser, context));
    }

}
