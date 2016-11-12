package project.service.Implementation;

import project.persistence.entities.User;

/**
 * Created by Torfi on 11/12/2016.
 */
public class SessionService {
    private static final SessionService SessionService = new SessionService();
    private boolean loggedIn;
    private User activeUser;

    private SessionService() {
        loggedIn = false;
        activeUser = null;
    }

    public static SessionService getSessionService() {
        return SessionService;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getActiveUser() {
        return activeUser;
    }
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
