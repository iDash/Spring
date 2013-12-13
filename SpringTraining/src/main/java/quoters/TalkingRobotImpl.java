package quoters;

import framework.Benchmark;

import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @Benchmark
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
