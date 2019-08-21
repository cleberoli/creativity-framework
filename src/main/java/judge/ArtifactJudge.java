package judge;

import main.ArtifactContext;
import model.Artifact;


public abstract class ArtifactJudge {

    private ArtifactContext context;


    public ArtifactJudge(ArtifactContext context) {
        this.context = context;
    }

    public abstract Double getNovelty(Artifact artifact);

    public abstract Double getValue(Artifact artifact);

    public abstract String evaluateArtifact(Artifact artifact);

    public Double getCreativity(Artifact artifact) {
        Double n_a = getNovelty(artifact);
        Double v_a = getValue(artifact);

        return v_a + n_a - p(v_a, n_a);
    }

    private Double p(Double v_a, Double n_a) {
        Double s = v_a + n_a;
        Double d = Math.abs(v_a - n_a);
        return s * (1 - Math.exp(-1.0 * d));
    }


    public ArtifactContext getContext() {
        return context;
    }

    public void setContext(ArtifactContext context) {
        this.context = context;
    }

}
