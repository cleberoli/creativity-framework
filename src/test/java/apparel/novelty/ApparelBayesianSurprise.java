package apparel.novelty;

import apparel.model.Apparel;
import apparel.model.ApparelItem;
import apparel.model.Color;
import apparel.model.Type;
import apparel.parser.ApparelParser;
import com.google.gson.Gson;
import data.Dataset;
import data.SynergyGraph;
import model.ArtifactValue;
import novelty.BayesianSurprise;
import novelty.Novelty;
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApparelBayesianSurprise extends BayesianSurprise {

    public ApparelBayesianSurprise(String datasetFileDescription) {
        super(ApparelBayesianSurprise.getDatasetFromFile(datasetFileDescription), new ApparelParser(), 0.1);
    }

    private static Dataset getDatasetFromFile(String datasetFileDescription) {
        Gson gson = new Gson();
        Parser parser = new ApparelParser();
        List<Map<String, List<ApparelItem>>> type = new ArrayList<Map<String, List<ApparelItem>>>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(datasetFileDescription));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Map<String, List<Map<String, String>>>> existingArtifacts = gson.fromJson(br, type.getClass());

        Integer numberOfAttributes = parser.getNumberOfAttributes();
        Dataset dataset = new Dataset(numberOfAttributes);

        List<ApparelItem> apparelItemList = new ArrayList<ApparelItem>();

        for (Map<String, List<Map<String, String>>> artifact : existingArtifacts) {
            ArrayList<Map<String, String>> apparelItems = (ArrayList) artifact.entrySet().iterator().next().getValue();

            for (Map<String, String> apparelItemMap : apparelItems) {
                HashMap<String, String> apparelItemHashMap = new HashMap<String, String>(apparelItemMap);
                apparelItemList.add(new ApparelItem(new Type(apparelItemHashMap.get("type")), new Color(apparelItemHashMap.get("color"))));
            }

            Apparel apparel = new Apparel(apparelItemList);
            dataset.addInstance(parser.getInstance(apparel));
        }

        return dataset;
    }
}
