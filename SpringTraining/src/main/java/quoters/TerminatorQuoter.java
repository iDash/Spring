package quoters;

import java.util.Arrays;
import java.util.List;

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
