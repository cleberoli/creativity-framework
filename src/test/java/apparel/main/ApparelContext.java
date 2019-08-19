package apparel.main;

import apparel.model.Apparel;
import apparel.novelty.ApparelBayesianSurprise;
import apparel.value.ApparelSynergyValue;
import main.ArtifactContext;
import model.Artifact;
import novelty.Novelty;
import value.Value;

public class ApparelContext implements ArtifactContext<Artifact> {

    String datasetFileDescription = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelDataset.json";
    String synergyFileDescription = "E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelSynergy.json";

    public Novelty<Artifact> getNoveltyModel() {
        return new ApparelBayesianSurprise(datasetFileDescription);
    }

    public Value<Artifact> getValueModel() {
        return new ApparelSynergyValue(synergyFileDescription);
    }
}
