package Accounts;

import java.io.Serializable;

public class AccountChequing extends Account implements Serializable {
    private static final long serialVersionUID = 9L;

    /**
     * Creates a new Chequing Account.
     */
    public AccountChequing(int lowestValue){
        super("1", lowestValue);
    }

    @Override
    /**
     * Adds the "bal" amount to the balance in Chequing if possible.
     */
    public void addBalance(double bal){
        if (super.getBalance() + bal >= -100)
            super.addBalance(bal);
        else
            System.out.println("You cannot exceed $-100 in this Chequing account!");
    }

}

