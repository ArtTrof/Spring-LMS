package homework.module1.implementation;

import homework.module1.Interfaces.Quest;

public class NPCQuest implements Quest {
    public NPCQuest() {
    }

    @Override
    public String description() {
        return "Find Bebra and give him saint beans";
    }
}
