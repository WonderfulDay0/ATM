package Transactions;

import java.io.Serializable;

public class TransactionDeposit extends Transaction implements Serializable {
    private static final long serialVersionUID = 95L;

    private String accTo;

    /**
     * Creates a new transaction for money deposit.
     * @param accTo
     * @param amount
     */
    public TransactionDeposit(String accTo, double amount) {
        super("", "", amount);
        setReversible(false);
        this.accTo = accTo;
    }

    /**
     * @return the account the money is deposited to
     */
    public String getAccTo(){
        return this.accTo;
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---NA---" + getAccTo() + "---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}
