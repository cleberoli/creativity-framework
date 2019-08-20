package apparel.main;

import apparel.model.Apparel;
import apparel.parser.ApparelArtifactParser;
import data.DataUtils;
import jade.core.Agent;
import judge.JudgeAgentBehavior;

public class ApparelJudgeAgentBehavior extends JudgeAgentBehavior {

    public ApparelJudgeAgentBehavior(Agent agent, Long period, ApparelJudge judge, Double threshold) {
        super(agent, period, judge, threshold);
    }

    public Double evaluateArtifact(String fileName) {
        System.out.printf("\nEvaluating artifact %s", DataUtils.getFileNameFromFileAbsolutePath(fileName));
        ApparelArtifactParser artifactParser = ApparelArtifactParser.getInstance(getJudge().getContext());
        Apparel apparel1 = (Apparel) artifactParser.parseArtifactFromFile(artifactParser.getArtifactFileName());
        System.out.println(getJudge().evaluateArtifact(apparel1));

        return getJudge().getCreativity(apparel1);
    }

}
