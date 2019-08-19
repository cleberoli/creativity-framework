package apparel.value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apparel.model.Color;
import com.google.gson.Gson;

import data.SynergyGraph;
import model.ArtifactValue;
import value.SynergyValue;


public class ApparelSynergyValue extends SynergyValue {

    public ApparelSynergyValue(String synergyFileDescription) {
        super(ApparelSynergyValue.getSynergyGraphFromFile(synergyFileDescription));
    }

    private static SynergyGraph getSynergyGraphFromFile(String synergyFileDescription) {
        Gson gson = new Gson();
        Map<Color, List<Color>> type = new HashMap<Color, List<Color>>();
        BufferedReader br = null;

        try {
             br = new BufferedReader(new FileReader(synergyFileDescription));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<ArtifactValue, List<ArtifactValue>> valueSynergy = (HashMap<ArtifactValue, List<ArtifactValue>>) gson.fromJson(br, type.getClass());
        return SynergyGraph.getInstance(valueSynergy);
    }

}
