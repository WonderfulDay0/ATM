package Transactions;

import java.io.Serializable;

public class TransactionWithdrawal extends Transaction implements Serializable {
    private static final long serialVersionUID = 910L;
    /**
     * Creates a new transaction for withdrawals.
     * @param accFrom
     * @param userFrom
     * @param amount
     */
    public TransactionWithdrawal(String accFrom, String userFrom, double amount) {
        super(accFrom, userFrom, amount);
        setReversible(false);
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---" + getAccountFrom() + "---NA---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}

