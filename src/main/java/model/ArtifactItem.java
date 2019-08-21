package model;

public abstract class ArtifactItem {

    protected ArtifactFeature feature;
    protected ArtifactValue value;


    public abstract String toString();

    public ArtifactFeature getFeature() {
        return feature;
    }

    public void setFeature(ArtifactFeature feature) {
        this.feature = feature;
    }

    public ArtifactValue getValue() {
        return value;
    }

    public void setValue(ArtifactValue value) {
        this.value = value;
    }

}