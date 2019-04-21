package Factories;

import java.io.Serializable;
import Users.*;

public class UserFactory implements Serializable {
    private static final long serialVersionUID = 112324L;

    /**
     * Creates a new user.
     * @return the created user
     */
    public User createUser(String pass){
        return new User(pass);
    }
}
