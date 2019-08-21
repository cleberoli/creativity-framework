package apparel.judge;

import judge.JudgeAgent;


public class ApparelJudgeAgent extends JudgeAgent {

    private ApparelJudge apparelJudge;


    public ApparelJudgeAgent(ApparelJudge apparelJudge) {
        this.apparelJudge = apparelJudge;
    }

    protected void setup() {
        super.setup();
        addBehaviour(new ApparelJudgeAgentBehavior(this, 2000L, apparelJudge, 1.8));
    }


    public ApparelJudge getApparelJudge() {
        return apparelJudge;
    }

    public void setApparelJudge(ApparelJudge apparelJudge) {
        this.apparelJudge = apparelJudge;
    }

}