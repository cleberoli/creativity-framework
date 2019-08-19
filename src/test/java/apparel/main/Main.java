package apparel.main;

import apparel.model.Apparel;
import apparel.model.ApparelItem;
import apparel.model.Color;
import apparel.model.Type;
import apparel.novelty.ApparelBayesianSurprise;
import apparel.parser.ApparelParser;
import apparel.value.ApparelSynergyValue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.SynergyGraph;
import model.ArtifactValue;
import value.SynergyValue;
import value.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        ApparelSynergyValue value = new ApparelSynergyValue("E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelSynergy.json");

        ApparelItem pants = new ApparelItem(new Type(Type.PANTS), new Color(Color.WHITE));
        ApparelItem shoes = new ApparelItem(new Type(Type.SHOES), new Color(Color.GRAY));
        ApparelItem shirt = new ApparelItem(new Type(Type.SHIRT), new Color(Color.LILAC));

        Apparel apparel = new Apparel(Arrays.asList(pants, shoes, shirt));
        System.out.println(apparel);

        System.out.println(value.getValue(apparel));

        ApparelContext context = new ApparelContext();
        System.out.println(context.getValueModel().getValue(apparel));

        ApparelBayesianSurprise novelty = new ApparelBayesianSurprise("E:\\Documents\\git\\creativity-framework\\src\\test\\apparel.data\\apparelDataset.json");
        System.out.println(novelty.getNovelty(apparel));


        ApparelParser ap = new ApparelParser();
        ap.getInstance(apparel);

        ApparelJudge judge = new ApparelJudge();
        System.out.println(judge.evaluateArtifact(context, apparel));

    }
}
