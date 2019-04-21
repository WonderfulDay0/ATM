package Transactions;

import java.io.Serializable;

public class TransactionReceived extends Transaction implements Serializable {
    private static final long serialVersionUID = 96L;

    private String accTo;

    /**
     * Creates a new transaction for the user that receives money.
     * @param accFrom
     * @param userFrom
     * @param accTo
     * @param amount
     */
    public TransactionReceived(String accFrom, String userFrom, String accTo, double amount) {
        super(accFrom, userFrom, amount);
        setReversible(false);
        this.accTo = accTo;
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---" + getUserFrom() + "---" + accTo + "---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}

