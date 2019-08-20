package apparel.main;

import main.ArtifactContext;
import judge.ArtifactJudge;
import model.Artifact;
import novelty.Novelty;
import value.Value;

public class ApparelJudge extends ArtifactJudge {

    public ApparelJudge(ArtifactContext<Artifact> context) {
        super(context);
    }

    public double getNovelty(Artifact artifact) {
        Novelty<Artifact> noveltyModel = this.getContext().getNoveltyModel();
        return noveltyModel.getNovelty(artifact);
    }

    public double getValue(Artifact artifact) {
        Value<Artifact> valueModel = this.getContext().getValueModel();
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
