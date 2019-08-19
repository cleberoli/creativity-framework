package apparel.model;

import model.Artifact;
import model.ArtifactItem;

import java.util.ArrayList;
import java.util.List;

public class Apparel extends Artifact {

    public Apparel() {
    }

    public Apparel(List<ApparelItem> items) {
        List<ArtifactItem> artifactItems = new ArrayList<ArtifactItem>();

        for (ApparelItem apparelItem : items) {
            artifactItems.add((ArtifactItem) apparelItem);
        }
        this.items = artifactItems;
    }

    public String toString() {
        return this.items.toString();
    }
}