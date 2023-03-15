package homework.module1;

import homework.module1.Interfaces.Quest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Quest quest = context.getBean("love_quest",Quest.class);
        Knight knight = new Knight(quest, "Biba");
        knight.questToDO();
        knight.setQuest((Quest) context.getBean("fight_quest"));
        knight.questToDO();
        knight.setQuest((Quest) context.getBean("npc_quest"));
        knight.questToDO();
    }
}
