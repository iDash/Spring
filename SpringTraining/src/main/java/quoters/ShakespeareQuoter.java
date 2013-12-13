package quoters;

public class ShakespeareQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
