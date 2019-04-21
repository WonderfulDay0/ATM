package Accounts;

import bankmain.DateDifference;

import java.io.Serializable;
import java.util.Date;

public class AccountTieredRate extends Account implements Serializable {
    private static final long serialVersionUID = 95L;

    private double firstTierInterest;
    private double secondTierInterest;
    private double thirdTierInterest;
    private Date lastInterestDate;

    public AccountTieredRate(int lowestValue, double firstTier, double secondTier, double thirdTier) {
        super("5", lowestValue);
        firstTierInterest = firstTier;
        secondTierInterest = secondTier;
        thirdTierInterest = thirdTier;
        lastInterestDate = DateDifference.createDate();
    }

    public void updateInter(int monthsPassed){

        double balance;
        double generated_money;

        for(int i=0; i<monthsPassed; i++){
            balance = super.getBalance();

            if(balance <= 5000){
                generated_money = balance * firstTierInterest;
            }
            else if(balance <= 15000){
                generated_money = 5000 * firstTierInterest + (balance-5000) * secondTierInterest;
            }
            else{
                generated_money = 5000 * firstTierInterest + 10000 * secondTierInterest +
                        (balance-15000) * thirdTierInterest;
            }
            super.addBalance(generated_money);
        }
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
