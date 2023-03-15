package task4.correct_dependency;

public class Authenticator implements ILogger{

    @Override
    public boolean authenticate(User user) {
        //some logic
        return true;
    }
}
