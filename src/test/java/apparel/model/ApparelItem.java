package apparel.model;

import model.ArtifactItem;

public class ApparelItem extends ArtifactItem {

    public ApparelItem() {
        this.feature = new Type();
        this.value = new Color();
    }

    public ApparelItem(Type type, Color color) {
        this.feature = type;
        this.value = color;
    }

    public String toString() {
        return String.format("%s: %s", this.feature, this.value);
    }

}
