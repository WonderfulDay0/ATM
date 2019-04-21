package Transactions;

import bankmain.DateDifference;

import java.io.Serializable;
import java.util.Date;

public abstract class Transaction implements Serializable {
    private static final long serialVersionUID = 143223L;
    private static int uniqueTransactionID = 0;
    private String transactionID;

    private boolean isReversible;
    private String accFrom;
    private String userFrom;
    private double amount;
    private Date date;

    /**
     * Creates a new transaction.
     * @param accFrom
     * @param userFrom
     * @param amount
     */
    Transaction(String accFrom, String userFrom, double amount) {
        this.transactionID = "9" + ++uniqueTransactionID;
        this.accFrom = accFrom;
        this.userFrom = userFrom;
        this.amount = amount;
        this.date = DateDifference.createDate();
    }

    /**
     * Sets the transaction as reversible.
     * @param isReversible
     */
    public void setReversible(boolean isReversible) {
        this.isReversible = isReversible;
    }

    /**
     * @return a boolean representing whether or not the transaction is reversible
     */
    public boolean checkReversible(){
        return this.isReversible;
    }

    /**
     * @return the string that denotes the account money is being sent from
     */
    public String getAccountFrom(){
        return this.accFrom;
    }

    /**
     * @return the username of the user that money is being sent from
     */
    public String getUserFrom(){
        return this.userFrom;
    }

    /**
     * @return the amount of money that is being transacted
     */
    public double getAmount(){
        return this.amount;
    }

    /**
     * Sets a unique ID to the transaction.
     * @param ID
     */
    public static void setUniqueTransactionID(int ID) {
        uniqueTransactionID = ID;
    }

    /**
     * @return the transaction's unique ID
     */
    public static int getUniqueTransactionID() {
        return uniqueTransactionID;
    }

    /**
     * @return the transaction's ID
     */
    public String getID(){return this.transactionID;}

    /**
     * @return the date of the transaction
     */
    public String getDate() {
        return this.date.toString();
    }


}

