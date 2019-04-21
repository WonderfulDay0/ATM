package bankmain;

import InputOutput.Output;
import Managers.*;
import Transactions.*;

import java.io.Serializable;

public class ATM implements Serializable {
    private static final long serialVersionUID = 123411L;

    //default: [5, 10, 20, 50, 100]
    private int[] bills = new int[5];
    private String currentUser;

    private ATMManager atmManager;
    private UserManager userManager;
    private TransactionManager transactionManager;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String current){
        currentUser = current;
    }

    public ATM(ATMManager am, UserManager um, TransactionManager tm) {
        atmManager = am;
        userManager = um;
        transactionManager = tm;

        //Setting initial number of bills
        for (int i = 0; i < bills.length; i++) {
            bills[i] = 500;
        }
    }

    public TransactionManager getTransactionManager(){
        return transactionManager;
    }

    public UserManager getUserManager(){
        return userManager;
    }


    public int[] getBills() {
        return bills;
    }

    public void addBillsAtIndex(int i, int val) {
        //Adds *val* bills to the bill type at index i
        bills[i] += val;
    }

    public void checkBills() {
        if (bills[0] < 20)
            Output.write("5", "Alerts.txt", true);
        if (bills[1] < 20)
            Output.write("10", "Alerts.txt", true);
        if (bills[2] < 20)
            Output.write("20", "Alerts.txt", true);
        if (bills[3] < 20)
            Output.write("50", "Alerts.txt", true);
        if (bills[4] < 20)
            Output.write("100", "Alerts.txt", true);

        atmManager.checkAlerts(this);
    }

    public boolean verifyLogin(String username, String password){
        if (userManager.checkUserByID(username)) {
            if (userManager.getUser(username).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password){
        if (userManager.getUser(username) == null) {
            userManager.createUser(username, password);
            return true;
        } else {
            return false;
        }
    }

    public void createAccount(String type, String userID){
        userManager.createAccount(type, userID);
    }

    public boolean changePassword(String username, String newPassword, String confirmPassword){
        if (newPassword.equals(confirmPassword)){
            userManager.resetPassword(username, newPassword);
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyPassword(String confirmPass){
        return userManager.getUser(currentUser).getPassword().equals(confirmPass);
    }

    public void depositCheque(String IDUserto, String accountTo, double amount){
        TransactionDeposit t = new TransactionDeposit(accountTo, amount);
        transactionManager.deposit(IDUserto, t);
    }

    public void depositBills(){}

    public void payBill(String accountFrom, String recipient, double amout){

    }


    public String[] getUserList(){
        return userManager.getUsers();
    }

    public void run() {
    }
}