package task4.correct_dependency;

public class LoginManager {
    ILogger logger;

    public LoginManager(ILogger logger) {
        this.logger = logger;
    }

    public void login(User user) {
        logger.authenticate(user);
    }
}
