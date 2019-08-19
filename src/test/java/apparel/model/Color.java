package apparel.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.ArtifactValue;

public class Color extends ArtifactValue {

    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String NAVY = "navy";
    public static final String BLUE = "blue";
    public static final String GRAY = "gray";
    public static final String BROWN = "brown";
    public static final String LILAC = "lilac";

    private static final List<String> VALUES = Arrays.asList(Color.WHITE, Color.BLACK, Color.NAVY, Color.BLUE,
            Color.GRAY, Color.BROWN, Color.LILAC);


    public Color() {
        value = this.getRandomValue();
    }

    public Color(String color) {
        if (VALUES.contains(color)) {
            value = color;
        } else {
            value = "";
        }
    }

    public String getRandomValue() {
        Random random = new Random();
        return VALUES.get(random.nextInt(VALUES.size()));
    }

    public int geNumberRepresentation() {
        return VALUES.indexOf(value);
    }

    public String toString() {
        return value;
    }
}
