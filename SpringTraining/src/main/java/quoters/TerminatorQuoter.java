package quoters;

import framework.MyDeprecated;

import java.util.Arrays;
import java.util.List;

@MyDeprecated(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {
    private List<String> quotes = Arrays.asList("nobody see it");

    @Override
    public void sayQuote() {
        for (String quote : quotes) {
            System.out.println(quote);
        }
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
