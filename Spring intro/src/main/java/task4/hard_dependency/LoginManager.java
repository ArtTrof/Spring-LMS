package task4.hard_dependency;

public class LoginManager {
    Authenticator authenticator;//трабл коли потрібно підстваити іниший логінер

    public LoginManager(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void login(User user) {
        authenticator.authenticate(user);
    }
}
