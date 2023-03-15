package homework.module1;

import homework.module1.Interfaces.Quest;

public class Knight {
    private Quest quest;
    private String name;

    public Knight(Quest quest, String name) {
        this.quest = quest;
        this.name = name;
    }

    public Knight() {
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void questToDO(){
        System.out.println("*************");
        System.out.println("now our knight '"+ getName() + "' is gonna do this quest:" + quest.description());
        System.out.println("*************");
    }
}
