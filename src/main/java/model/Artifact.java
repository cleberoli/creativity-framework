package model;

import java.util.List;

public abstract class Artifact {

    protected List<ArtifactItem> items;


    public abstract String toString();


    public List<ArtifactItem> getItems() {
        return items;
    }

    public void setItems(List<ArtifactItem> items) {
        this.items = items;
    }

}