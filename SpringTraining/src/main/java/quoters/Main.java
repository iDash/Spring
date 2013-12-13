package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TalkingRobot talkingRobot = context.getBean(TalkingRobot.class);
        talkingRobot.talk();
    }
}
