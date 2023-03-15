package task4.correct_dependency;

public class AdvancedLogin implements ILogger {
    @Override
    public boolean authenticate(User user) {
        //some other logic
        return true;
    }
}
