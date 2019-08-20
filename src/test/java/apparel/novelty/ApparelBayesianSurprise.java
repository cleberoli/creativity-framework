package apparel.novelty;

import apparel.model.Apparel;
import apparel.model.ApparelItem;
import apparel.model.Color;
import apparel.model.Type;
import apparel.parser.ApparelDatasetParser;
import com.google.gson.Gson;
import data.DataUtils;
import data.Dataset;
import novelty.BayesianSurprise;
import parser.Parser;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApparelBayesianSurprise extends BayesianSurprise {

    public ApparelBayesianSurprise(String datasetFileAbsolutePath) {
        super(ApparelBayesianSurprise.getDatasetFromFile(datasetFileAbsolutePath), ApparelDatasetParser.getInstance(), 0.1);
    }

    private static Dataset getDatasetFromFile(String datasetFileAbsolutePath) {
        Gson gson = new Gson();
        Parser parser = ApparelDatasetParser.getInstance();
        List<Map<String, List<ApparelItem>>> type = new ArrayList<Map<String, List<ApparelItem>>>();

        BufferedReader br = DataUtils.getReaderForFile(datasetFileAbsolutePath);
        List<Map<String, List<Map<String, String>>>> existingArtifacts = gson.fromJson(br, type.getClass());
        DataUtils.closeReader(br);

        Integer numberOfAttributes = parser.getNumberOfAttributes();
        Dataset dataset = Dataset.getInstance(numberOfAttributes);

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
