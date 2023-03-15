package task4.correct_dependency;

public class SimpleLogin implements ILogger {
    @Override
    public boolean authenticate(User user) {
       //some other logic
        return true;
    }
}
