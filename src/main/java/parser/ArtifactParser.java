package parser;

import data.DataUtils;
import main.ArtifactContext;
import model.Artifact;


public abstract class ArtifactParser {

    ArtifactContext<Artifact> context;

    public ArtifactParser(ArtifactContext<Artifact> context) {
        this.context = context;
    }

    public String getArtifactFileName() {
        return DataUtils.getFileAbsolutePathFromFolder(context.getArtifactsFolder());
    }

    public abstract Artifact parseArtifactFromFile(String artifactFileAbsolutePath);

}
