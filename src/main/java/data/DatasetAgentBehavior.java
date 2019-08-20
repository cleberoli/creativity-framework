package data;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import main.ArtifactContext;
import model.Artifact;
import parser.ArtifactParser;
import parser.DatasetParser;


public class DatasetAgentBehavior extends TickerBehaviour {

    DatasetParser datasetParser;
    ArtifactParser artifactParser;
    ArtifactContext<Artifact> context;

    public DatasetAgentBehavior(Agent agent, Long period, DatasetParser datasetParser,
                                ArtifactParser artifactParser, ArtifactContext<Artifact> context) {
        super(agent, period);
        this.datasetParser = datasetParser;
        this.artifactParser = artifactParser;
        this.context = context;
    }

    @Override
    protected void onTick() {
        String originFolder = context.getArtifactsFolder();
        String destinyFolder = context.getEvaluatedArtifactsFolder();
        String updateFolder = originFolder  + "\\update";

        String fileName = DataUtils.getFileAbsolutePathFromFolder(updateFolder);

        if (fileName.endsWith(".json")) {
            String simpleFileName = DataUtils.getFileNameFromFileAbsolutePath(fileName);
            Artifact artifact = artifactParser.parseArtifactFromFile(fileName);
            Dataset.getInstance().addInstance(datasetParser.getInstance(artifact));
            DataUtils.moveFile(simpleFileName, updateFolder, destinyFolder);
        }
    }

}
