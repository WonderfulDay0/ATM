package Users;

import Transactions.*;
import Accounts.*;

import java.io.Serializable;
import java.util.*;

import Comparators.IDComparator;

public class User implements Serializable {
    private static final long serialVersionUID = 12400L;

    private String password;
    private Transaction latestTransaction;

    private Map<String, Account> accountMap;
    private Map<String, Transaction> transactionMap;

    /**
     * Creates a new user with the given username and password.
     * @param pass user's password
     */
    public User(String pass){
        this.password = pass;

        accountMap = new TreeMap<>(new IDComparator());
        transactionMap = new TreeMap<>(new IDComparator());
//        accountMap = new TreeMap<>(Comparator.comparing(Integer::parseInt));
//        transactionMap = new TreeMap<>(Comparator.comparing(Integer::parseInt));

    }

    /**
     * @return the user's latest transaction
     */
    public Transaction getLatestTransaction(){
        return this.latestTransaction;
    }

    /**
     * Sets the user's password.
     * @param new_pw new password
     */
    public void setPassword(String new_pw){
        password = new_pw;
    }

    /**
     *
     * @return the user's current password
     */
    public String getPassword() {return this.password;}

    /**
     * Sets the user's latest transaction to the given transaction t.
     * @param t the latest transaction
     */
    public void setLatestTransaction(Transaction t){
        this.latestTransaction = t;
    }

    /**
     * Gets a map of the accounts the user has.
     * @return the map of accounts
     */
    public Map<String, Account> getAccountMap(){
        return accountMap;
    }

    /**
     * @return a map of the user's transactions
     */
    public Map<String, Transaction> getTransactionMap(){ return transactionMap;}

    public Account[] getAccountArray(){
        Account[] accountArray = new Account[accountMap.size()];
        int loop_count = 0;
        for (Map.Entry<String,Account> entry : accountMap.entrySet()){
            accountArray[loop_count] = entry.getValue();
            loop_count++;
        }
        return accountArray;
    }

    public Transaction[] getTransactionArray(){
        Transaction[] transactionArray = new Transaction[transactionMap.size()];
        int loop_count = 0;
        for (Map.Entry<String,Transaction> entry : transactionMap.entrySet()){
            transactionArray[loop_count] = entry.getValue();
            loop_count++;
        }
        return transactionArray;
    }

    public double calcNetTotal(){
        double sum = 0;
        for(Account acc: accountMap.values()){
            if (acc.getAccountID().charAt(0) == '3' || acc.getAccountID().charAt(0) == '4'){
                sum -= acc.getBalance();
            }
            else{
                sum += acc.getBalance();
            }
        }
        return sum;
    }
}
