package homework.module1.implementation;

import homework.module1.Interfaces.Quest;

public class LoveQuest implements Quest {
    public LoveQuest() {
    }

    @Override
    public String description() {
        return "Marry Baba Galya from 4th podjezd";
    }
}
