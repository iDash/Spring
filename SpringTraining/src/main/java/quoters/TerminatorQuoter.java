package quoters;

import java.util.List;

public class TerminatorQuoter implements Quoter {
    private List<String> quotes;

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
