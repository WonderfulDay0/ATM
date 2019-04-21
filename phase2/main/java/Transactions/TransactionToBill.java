package Transactions;

import java.io.Serializable;

public class TransactionToBill extends Transaction implements Serializable {
    private static final long serialVersionUID = 97L;

    private String payeeTo;

    /**
     * Creates a new transaction for a bill.
     * @param accFrom
     * @param userFrom
     * @param payeeTo
     * @param amount
     */
    public TransactionToBill(String accFrom, String userFrom, String payeeTo, double amount) {
        super(accFrom, userFrom, amount);
        setReversible(false);
        this.payeeTo = payeeTo;
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---" + getAccountFrom() + "---" + payeeTo + "---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}
