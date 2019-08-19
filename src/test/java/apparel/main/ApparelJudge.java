package apparel.main;

import main.ArtifactContext;
import main.ArtifactJudge;
import model.Artifact;
import novelty.Novelty;
import value.Value;

public class ApparelJudge implements ArtifactJudge<Artifact> {

    public ApparelJudge() {}

    public String evaluateArtifact(ArtifactContext<Artifact> context, Artifact artifact) {

        StringBuilder result = new StringBuilder();
        Novelty<Artifact> noveltyModel = context.getNoveltyModel();
        Value<Artifact> valueModel = context.getValueModel();
        Double n_a = noveltyModel.getNovelty(artifact);
        Double v_a = valueModel.getValue(artifact);

        result.append("\nnovelty: ").append(n_a);
        result.append("\nvalue: ").append(v_a);
        result.append("\nrdc: ").append(v_a + n_a - p(v_a, n_a));

        return result.toString();
    }

    private double p(Double v_a, Double n_a) {
        Double s = v_a + n_a;
        Double d = Math.abs(v_a - n_a);
        return s * (1 - Math.exp(-1.0 * d));
    }
}
