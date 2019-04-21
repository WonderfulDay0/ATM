package bankmain;
import java.io.*;
import java.util.*;

import Accounts.Account;
import Accounts.AccountSavings;
import Accounts.AccountTieredRate;
import Controller.WelcomeController;
import GUI.Menus.Welcome;
import InputOutput.ReaderText;
import InputOutput.Serialization;
import Managers.*;
import Transactions.Transaction;
import Users.User;


public class Bank implements Serializable {
    private static final long serialVersionUID = 1234L;

    public static void main(String[] args) {
        Serialization serializer = new Serialization();

        ATMManager am = new ATMManager();
        UserManager um = new UserManager();
        TransactionManager tm = new TransactionManager(um.getUserMap());

//        ATM atm = new ATM(am, um, tm);
        ATM atm = (ATM)Serialization.deserializeObject("atm.ser");

        Welcome window = new Welcome();

        WelcomeController wc = new WelcomeController(atm, window);
        wc.initController();

        DateDifference.setYearsAdded(ReaderText.readID("Year.txt"));
        DateDifference.setMonthsAdded(ReaderText.readID("Month.txt"));
        Account.setUniqueID(ReaderText.readID("AccID.txt"));
        Transaction.setUniqueTransactionID(ReaderText.readID("TransID.txt"));

        updateInterestOnStartup(atm.getUserManager());

        if (atm.getUserManager().userMapIsEmpty()) {
            String[] info = ReaderText.readEmployeeInfo("Employees.txt");
            atm.getUserManager().createUser(info[0], info[1]);
        }
    }

    public static void updateInterestOnStartup(UserManager um) {
        int currYear = new Date().getYear() + DateDifference.getYearsAdded();
        int currMonth = new Date().getMonth() + DateDifference.getMonthsAdded();

        for (User user : um.getUserMap().values()) {
            for(Account acc : user.getAccountMap().values()){
                if (acc instanceof AccountSavings){
                    AccountSavings accS = (AccountSavings)acc;
                    Date accDate = accS.getLastInterestDate();

                    int monthDiff = (currYear - accDate.getYear()) * 12 + (currMonth - accDate.getMonth());
                    accS.updateInter(monthDiff);
                    accS.setLastInterestDate(DateDifference.createDate());
                }
                else if(acc instanceof AccountTieredRate){
                    AccountTieredRate atr = (AccountTieredRate)acc;
                    Date accDate = atr.getLastInterestDate();

                    int monthDiff = (currYear - accDate.getYear()) * 12 + (currMonth - accDate.getMonth());
                    atr.updateInter(monthDiff);
                    atr.setLastInterestDate(DateDifference.createDate());
                }
            }
        }
    }
}


