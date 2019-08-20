package apparel.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apparel.model.Apparel;
import apparel.model.ApparelItem;
import apparel.model.Color;
import apparel.model.Type;
import com.google.gson.Gson;

import data.DataUtils;
import main.ArtifactContext;
import model.Artifact;
import parser.ArtifactParser;


public class ApparelArtifactParser extends ArtifactParser {

    private static ApparelArtifactParser instance = null;

    private ApparelArtifactParser(ArtifactContext<Artifact> context) {
        super(context);
    }

    public static synchronized ApparelArtifactParser getInstance(ArtifactContext<Artifact> context) {
        if (instance == null) {
            instance = new ApparelArtifactParser(context);
        }

        return instance;
    }

    public Artifact parseArtifactFromFile(String artifactFileAbsolutePath) {
        Gson gson = new Gson();
        Map<String, List<ApparelItem>> type = new HashMap<String, List<ApparelItem>>();

        BufferedReader br = DataUtils.getReaderForFile(artifactFileAbsolutePath);
        Map<String, List<Map<String, String>>> artifact = gson.fromJson(br, type.getClass());
        DataUtils.closeReader(br);

        List<ApparelItem> apparelItemList = new ArrayList<ApparelItem>();
        ArrayList<Map<String, String>> apparelItems = (ArrayList) artifact.entrySet().iterator().next().getValue();

        for (Map<String, String> apparelItemMap : apparelItems) {
            HashMap<String, String> apparelItemHashMap = new HashMap<String, String>(apparelItemMap);
            apparelItemList.add(new ApparelItem(new Type(apparelItemHashMap.get("type")), new Color(apparelItemHashMap.get("color"))));
        }

        Apparel apparel = new Apparel(apparelItemList);

        return apparel;
    }

}
