package apparel.model;

import java.util.ArrayList;
import java.util.List;

import model.Artifact;
import model.ArtifactItem;


public class Apparel extends Artifact {

    public Apparel() {
    }

    public Apparel(List<ApparelItem> items) {
        List<ArtifactItem> artifactItems = new ArrayList<ArtifactItem>();

        for (ApparelItem apparelItem : items) {
            artifactItems.add(apparelItem);
        }
        this.items = artifactItems;
    }

    public String toString() {
        return this.items.toString();
    }

}
