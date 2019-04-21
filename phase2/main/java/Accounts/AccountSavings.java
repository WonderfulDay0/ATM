package Accounts;

import bankmain.DateDifference;

import java.io.Serializable;
import java.util.Date;

public class AccountSavings extends Account implements Serializable {
    private static final long serialVersionUID = 94L;

    private final double interest;
    private Date lastInterestDate;

    /**
     * Create a new Savings account with given interest.
     * @param inter
     */
    public AccountSavings(double inter, int lowestValue){
        super("2", lowestValue);
        this.interest = inter;
        lastInterestDate = DateDifference.createDate();
    }

    @Override
    /**
     * Adds the "bal" amount to the balance in Savings if possible.
     */
    public void addBalance(double bal){
        super.addBalance(bal);
    }

    /**
     * Updates the interest given the amount of months that have passed since interest was last updated.
     * @param monthsPassed
     */
    public void updateInter(int monthsPassed){
        super.addBalance(super.getBalance()*Math.pow(1 + interest/12, monthsPassed) - super.getBalance());
    }

    /**
     * @return the date when interest was last updated
     */
    public Date getLastInterestDate(){
        return this.lastInterestDate;
    }

    /**
     * Sets the date when interest was last updated to d.
     * @param d
     */
    public void setLastInterestDate(Date d){
        this.lastInterestDate = d;
    }

}

