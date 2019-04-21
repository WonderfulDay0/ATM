package Transactions;

import java.io.Serializable;

public class TransactionToSelf extends Transaction implements Serializable {
    private static final long serialVersionUID = 99L;

    private String accTo;

    /**
     * Creates a new transaction between a user's accounts.
     * @param accFrom
     * @param userFrom
     * @param accTo
     * @param amount
     */
    public TransactionToSelf(String accFrom, String userFrom, String accTo, double amount) {
        super(accFrom, userFrom, amount);
        setReversible(true);
        this.accTo = accTo;
    }

    /**
     *
     * @return the account that the transaction deposits money into
     */
    public String getAccTo(){
        return this.accTo;
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---" + getAccountFrom() + "---" + accTo + "---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}
