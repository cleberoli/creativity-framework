package apparel.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sun.deploy.util.ArrayUtil;
import model.ArtifactFeature;

public class Type extends ArtifactFeature {

    public static final String SHIRT = "shirt";
    public static final String PANTS = "pants";
    public static final String SHOES = "shoes";

    private static final List<String> FEATURES = Arrays.asList(Type.SHIRT, Type.PANTS, Type.SHOES);


    public Type() {
        feature = this.getRandomFeature();
    }

    public Type(String type) {
        if (FEATURES.contains(type)) {
            feature = type;
        } else {
            feature = "";
        }
    }

    public String getRandomFeature() {
        Random random = new Random();
        return FEATURES.get(random.nextInt(FEATURES.size()));
    }

    public int geNumberRepresentation() {
        return FEATURES.indexOf(feature);
    }

    public String toString() {
        return feature;
    }
}
