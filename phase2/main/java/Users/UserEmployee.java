package Users;

import Managers.UserManager;

import java.io.Serializable;

public class UserEmployee extends User implements Serializable {
    private static final long serialVersionUID = 911L;

    private UserManager userManager;

    public UserEmployee(String password, UserManager um) {
        super(password);
        userManager = um;
    }

    public void deleteAccount(String userID, String accID) {
        userManager.deleteAccount(userID, accID);
    }

    //Consider a converter class that transforms user object into gui
    public User lookUpUser(String userID) {
        return userManager.getUser(userID);
    }
}