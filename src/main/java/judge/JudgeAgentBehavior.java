package judge;

import data.DataUtils;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public abstract class JudgeAgentBehavior extends TickerBehaviour {

    private ArtifactJudge judge;
    private Double threshold;


    public JudgeAgentBehavior(Agent agent, Long period, ArtifactJudge judge, Double threshold) {
        super(agent, period);
        this.judge = judge;
        this.threshold = threshold;
    }

    @Override
    protected void onTick() {
        String originFolder = judge.getContext().getArtifactsFolder();
        String updateFolder = originFolder  + "\\update";
        String ignoreFolder = originFolder + "\\ignore";

        DataUtils.createFolder(updateFolder);
        DataUtils.createFolder(ignoreFolder);

        String fileName = DataUtils.getFileAbsolutePathFromFolder(originFolder);

        if (fileName.endsWith(".json")) {
            Double creativity = evaluateArtifact(fileName);
            String simpleFileName = DataUtils.getFileNameFromFileAbsolutePath(fileName);

            if (creativity >= threshold) {
                DataUtils.moveFile(simpleFileName, originFolder, updateFolder);
            } else {
                DataUtils.moveFile(simpleFileName, originFolder, ignoreFolder);
            }
        }
    }

    public abstract Double evaluateArtifact(String fileName);


    public ArtifactJudge getJudge() {
        return judge;
    }

    public void setJudge(ArtifactJudge judge) {
        this.judge = judge;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

}
