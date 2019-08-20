package apparel.main;

import jade.core.Agent;

public class ApparelJudgeAgent extends Agent {

    ApparelJudge apparelJudge;

    public ApparelJudgeAgent(ApparelJudge apparelJudge) {
        this.apparelJudge = apparelJudge;
    }

    protected void setup() {
        super.setup();
        addBehaviour(new ApparelJudgeAgentBehavior(this, 2000L, apparelJudge, 1.8));
    }

}
