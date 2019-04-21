package Accounts;

import java.io.Serializable;

public class AccountCreditCard extends Account implements Serializable {
    private static final long serialVersionUID = 91L;

    /**
     * Creates a new Credit Account.
     */
    public AccountCreditCard(int lowestValue) {
        super("3", lowestValue);
    }

    @Override
    /**
     * Adds the "bal" amount to the balance in Credit if possible.
     */
    public void addBalance(double bal) {
        if (bal >= 0)
            super.addBalance(-bal);
        else
            System.out.println("You cannot withdraw from this Credit Card account!");
    }
}
