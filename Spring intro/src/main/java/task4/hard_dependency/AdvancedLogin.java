package task4.hard_dependency;

public class AdvancedLogin extends Authenticator{
    @Override
    public boolean authenticate(User user) {
        //some other logic
        return true;
    }
}
