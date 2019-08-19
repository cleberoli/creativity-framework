package main;

public interface ArtifactJudge<T> {

    String evaluateArtifact(ArtifactContext<T> context, T artifact);

}
