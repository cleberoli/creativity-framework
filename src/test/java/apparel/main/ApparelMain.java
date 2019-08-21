package apparel.main;

import jade.core.Agent;

import apparel.judge.ApparelJudge;
import apparel.judge.ApparelJudgeAgent;
import apparel.parser.ApparelArtifactParser;
import apparel.parser.ApparelDatasetParser;
import data.DatasetAgent;
import judge.ArtifactJudge;
import main.ArtifactContext;
import main.Core;
import parser.ArtifactParser;
import parser.DatasetParser;


public class ApparelMain {

    public static void main(String[] args) {

        ArtifactContext context = new ApparelContext();
        DatasetParser datasetParser = ApparelDatasetParser.getInstance();
        ArtifactParser artifactParser = ApparelArtifactParser.getInstance(context);
        ArtifactJudge artifactJudge = new ApparelJudge(context);
        DatasetAgent datasetAgent = new DatasetAgent(datasetParser, artifactParser, context);
        Agent judgeAgent = new ApparelJudgeAgent((ApparelJudge) artifactJudge);

        Core core = new Core(context, datasetParser, artifactParser, artifactJudge, datasetAgent, judgeAgent);

        core.run();
    }

}