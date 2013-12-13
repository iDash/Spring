package quoters;

import framework.RunThisMethod;

import javax.annotation.PostConstruct;
import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @RunThisMethod
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
