package Accounts;

import java.io.Serializable;

public class AccountLineOfCredit extends Account implements Serializable {
    private static final long serialVersionUID = 93L;

    /**
     * Creates a new Line of Credit Account.
     */
    public AccountLineOfCredit(int lowestValue) {
        super("4", lowestValue);
    }

    @Override
    /**
     * Adds the "bal" amount to the balance in Line of Credit if possible.
     */
    public void addBalance(double bal) {
        super.addBalance(-bal);
    }
}

