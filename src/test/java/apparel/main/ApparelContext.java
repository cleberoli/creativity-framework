package apparel.main;

import apparel.novelty.ApparelBayesianSurprise;
import apparel.value.ApparelSynergyValue;
import main.ArtifactContext;
import novelty.Novelty;
import value.Value;

public class ApparelContext implements ArtifactContext {

    private static final String datasetFileAbsolutePath = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelDataset.json";
    private static final String synergyFileAbsolutePath = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelSynergy.json";
    private static final String artifactsFolderAbsolutePath = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.artifacts";
    private static final String evaluatedArtifactsFolderAbsolutePath = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.evaluated";

    public Novelty getNoveltyModel() {
        return new ApparelBayesianSurprise(datasetFileAbsolutePath);
    }

    public Value getValueModel() {
        return new ApparelSynergyValue(synergyFileAbsolutePath);
    }

    public String getArtifactsFolder() {
        return artifactsFolderAbsolutePath;
    }

    public String getEvaluatedArtifactsFolder() {
        return evaluatedArtifactsFolderAbsolutePath;
    }

}