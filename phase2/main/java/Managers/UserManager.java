package Managers;

import java.io.Serializable;
import java.util.*;

import Factories.AccountFactory;
import Factories.UserFactory;
import Users.User;
import Accounts.Account;

public class UserManager implements Serializable {
    private static final long serialVersionUID = 24L;

    private UserFactory userFactory;
    private Map<String, User> userMap;

    private AccountFactory accountFactory;

    public UserManager(){
        userMap = new TreeMap<>();
        accountFactory = new AccountFactory();
        userFactory = new UserFactory();
    }

    public User getUser(String username){
        return this.userMap.get(username);
    }

    public Map<String, User>  getUserMap(){
        return userMap;
    }

    public void createUser(String userID, String pass){
        //Creates the user and put it into the map.
        User new_user = userFactory.createUser(pass);
        userMap.put(userID, new_user);

        //Assigning the primary account as creating the user
        Account new_account = accountFactory.createAccount("1");
        new_user.getAccountMap().put(new_account.getAccountID(), new_account);
    }

    public void createAccount(String type, String userID){
        //Create a new account and store that into the users account list(map)
        Account new_account = accountFactory.createAccount(type);
        userMap.get(userID).getAccountMap().put(new_account.getAccountID(), new_account);
    }

    public void createAccount(String type, String userID1, String userID2) {
        //Creates a new joint account and stores it in each respective user's account maps
        Account new_account = accountFactory.createAccount(type);
        userMap.get(userID1).getAccountMap().put(new_account.getAccountID(), new_account);
        userMap.get(userID2).getAccountMap().put(new_account.getAccountID(), new_account);
    }

    public void deleteAccount(String userID, String accID){
        userMap.get(userID).getAccountMap().remove(accID);
    }

    public boolean checkUserByID(String userID){
        return userMap.containsKey(userID);
    }

    public void resetPassword(String userID, String new_pw){
        userMap.get(userID).setPassword(new_pw);
    }

    public boolean userMapIsEmpty() {
        return userMap.isEmpty();
    }

    public String[] getUsers(){
        return userMap.keySet().toArray(new String[userMap.size()]);
    }

}
