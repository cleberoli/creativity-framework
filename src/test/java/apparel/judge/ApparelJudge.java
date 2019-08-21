package apparel.judge;

import main.ArtifactContext;
import judge.ArtifactJudge;
import model.Artifact;
import novelty.Novelty;
import value.Value;


public class ApparelJudge extends ArtifactJudge {

    public ApparelJudge(ArtifactContext context) {
        super(context);
    }

    public Double getNovelty(Artifact artifact) {
        Novelty noveltyModel = this.getContext().getNoveltyModel();
        return noveltyModel.getNovelty(artifact);
    }

    public Double getValue(Artifact artifact) {
        Value valueModel = this.getContext().getValueModel();
        return valueModel.getValue(artifact);
    }

    public String evaluateArtifact(Artifact artifact) {
        StringBuilder result = new StringBuilder();

        result.append("\nnovelty: ").append(String.format("%.2f", getNovelty(artifact)));
        result.append("\nvalue: ").append(String.format("%.2f", getValue(artifact)));
        result.append("\nrdc: ").append(String.format("%.2f", getCreativity(artifact)));

        return result.toString();
    }

}