package homework.module1.implementation;

import homework.module1.Interfaces.Quest;

public class FightQuest implements Quest {
    public FightQuest() {
    }

    @Override
    public String description() {
        return "Kill Pontific Salivan";
    }
}
