package Factories;

import java.io.Serializable;
import Accounts.*;

public class AccountFactory implements Serializable {
    private static final long serialVersionUID = 1200003L;

    /**
     * Take a string and checks the string for what type to create.
     * @return an Account of the given type
     */
    public Account createAccount(String type){

        //Instead of checking string types, strings could be 1,2,3,4,5 or even just enums

        if (type.equalsIgnoreCase("1")){
            return new AccountChequing(-100);
        } else if (type.equalsIgnoreCase("2")){
            return new AccountSavings(0.001, 0);
        } else if (type.equalsIgnoreCase("3")){
            return new AccountCreditCard(1000);
        } else if (type.equalsIgnoreCase("4")){
            return new AccountLineOfCredit(1000);
        } else if (type.equalsIgnoreCase("5")){
            return new AccountTieredRate(0, 0.01, 0.015, 0.02);
        }
        return null;
    }
}




