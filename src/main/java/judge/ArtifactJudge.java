package judge;

import main.ArtifactContext;
import model.Artifact;

public abstract class ArtifactJudge {

    ArtifactContext<Artifact> context;


    public ArtifactJudge(ArtifactContext<Artifact> context) {
        this.context = context;
    }

    public abstract double getNovelty(Artifact artifact);

    public abstract double getValue(Artifact artifact);

    public abstract String evaluateArtifact(Artifact artifact);

    public double getCreativity(Artifact artifact) {
        Double n_a = getNovelty(artifact);
        Double v_a = getValue(artifact);

        return v_a + n_a - p(v_a, n_a);
    }

    public ArtifactContext<Artifact> getContext() {
        return context;
    }

    public void setContext(ArtifactContext<Artifact> context) {
        this.context = context;
    }

    private double p(Double v_a, Double n_a) {
        Double s = v_a + n_a;
        Double d = Math.abs(v_a - n_a);
        return s * (1 - Math.exp(-1.0 * d));
    }

}
