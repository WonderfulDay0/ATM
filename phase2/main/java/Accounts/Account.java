package Accounts;

import bankmain.DateDifference;

import java.io.Serializable;
import java.util.Date;

public abstract class Account implements Serializable {
    private static final long serialVersionUID = 123456L;
    private transient static int uniqueID = 0;
    private final String accountID;
    private double balance;
    private Date creationDate;

    public String getType() {
        return type;
    }

    private String type;
    private int lowestValue;

    /**
     * Creates an account of the type "typeNum" (corresponds to one of the 4 account types).
     * @param typeNum
     */
    public Account(String typeNum, int lowestValue){
        this.balance = 0;
        this.lowestValue = lowestValue;
        this.creationDate = DateDifference.createDate();
        this.accountID = typeNum + ++uniqueID;
        switch(typeNum){
            case "1":
                this.type = "Chequing";
                break;
            case "2":
                this.type = "Savings";
                break;
            case "3":
                this.type = "Credit";
                break;
            case "4":
                this.type = "Line of Credit";
                break;
            case "5":
                this.type = "Tiered Rate";
                break;
            default:
                this.type = "";
                break;
        }
    }

    /**
     * Adds "bal" amount to the original balance.
     * @param bal
     */
    public void addBalance(double bal){
        this.balance += bal;
    }

    /**
     * @return balance of the account
     */
    public double getBalance(){
        return this.balance;
    }

    public void setLowestValue(int lowestValue){
        this.lowestValue = lowestValue;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String printCreationDate(){
        return (creationDate.getMonth()+1) + "/" + creationDate.getDate() + "/" + (creationDate.getYear()+1900);
    }

    public int getLowestValue(){
        return lowestValue;
    }

    /**
     *
     * @param id that is set as the account's unique ID (unique for each account created with the bank)
     */
    public static void setUniqueID(int id) {
        uniqueID = id;
    }

    /**
     * @return the account's unique ID
     */
    public static int getUniqueID() {
        return uniqueID;
    }

    /**
     * @return the account's ID (not the unique ID across the bank)
     */
    public String getAccountID() {
        return this.accountID;
    }

    /**
     * Returns a string representation of the Account.
     * */
    @Override
    public String toString(){
        return String.format("ID: %-8d", Integer.parseInt(accountID)) +
                "|Type: " + String.format("%-20s", type) + String.format("%-10s","|$" + String.format("%.2f",balance));
    }
}
