package main;

import novelty.Novelty;
import value.Value;


public interface ArtifactContext {

    Novelty getNoveltyModel();
    Value getValueModel();
    String getArtifactsFolder();
    String getEvaluatedArtifactsFolder();

}
