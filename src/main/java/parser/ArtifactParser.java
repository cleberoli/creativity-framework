package parser;

import data.DataUtils;
import main.ArtifactContext;
import model.Artifact;


public abstract class ArtifactParser {

    private ArtifactContext context;


    public ArtifactParser(ArtifactContext context) {
        this.context = context;
    }

    public String getArtifactFileName() {
        return DataUtils.getFileAbsolutePathFromFolder(context.getArtifactsFolder());
    }

    public abstract Artifact parseArtifactFromFile(String artifactFileAbsolutePath);


    public ArtifactContext getContext() {
        return context;
    }

    public void setContext(ArtifactContext context) {
        this.context = context;
    }

}