package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        //        ShakespeareQuoter bean = context.getBean(ShakespeareQuoter.class);
        //        bean.sayQuote();
    }
}
