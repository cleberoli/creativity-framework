package data;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import main.ArtifactContext;
import model.Artifact;
import parser.ArtifactParser;
import parser.DatasetParser;


public class DatasetAgentBehavior extends TickerBehaviour {

    private DatasetParser datasetParser;
    private ArtifactParser artifactParser;
    private ArtifactContext context;


    public DatasetAgentBehavior(Agent agent, Long period, DatasetParser datasetParser,
                                ArtifactParser artifactParser, ArtifactContext context) {
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