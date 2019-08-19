package main;

import novelty.Novelty;
import value.Value;

public interface ArtifactContext<T> {

    Novelty<T> getNoveltyModel();
    Value<T> getValueModel();

}
