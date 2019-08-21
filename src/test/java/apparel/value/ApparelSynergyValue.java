package apparel.value;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import apparel.model.Color;
import data.DataUtils;
import data.SynergyGraph;
import model.ArtifactValue;
import value.SynergyValue;


public class ApparelSynergyValue extends SynergyValue {

    public ApparelSynergyValue(String synergyFileAbsolutePath) {
        super(ApparelSynergyValue.getSynergyGraphFromFile(synergyFileAbsolutePath));
    }

    private static SynergyGraph getSynergyGraphFromFile(String synergyFileAbsolutePath) {
        Gson gson = new Gson();
        Map<Color, List<Color>> type = new HashMap<Color, List<Color>>();

        BufferedReader br = DataUtils.getReaderForFile(synergyFileAbsolutePath);
        HashMap<ArtifactValue, List<ArtifactValue>> valueSynergy = (HashMap<ArtifactValue, List<ArtifactValue>>) gson.fromJson(br, type.getClass());
        DataUtils.closeReader(br);

        return SynergyGraph.getInstance(valueSynergy);
    }

}