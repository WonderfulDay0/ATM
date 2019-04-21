package Transactions;

import java.io.Serializable;

public class TransactionToOther extends Transaction implements Serializable {
    private static final long serialVersionUID = 98L;
    private String accTo;
    private String userTo;

    /**
     * Creates a transaction between two users of the bank.
     * @param accFrom
     * @param userFrom
     * @param accTo
     * @param userTo
     * @param amount
     */
    public TransactionToOther(String accFrom, String userFrom, String accTo, String userTo, double amount) {
        super(accFrom, userFrom, amount);
        setReversible(true);
        this.accTo = accTo;
        this.userTo = userTo;
    }

    /**
     * @return the account the transaction sends money to
     */
    public String getAccTo(){
        return this.accTo;
    }

    /**
     * @return the user the transaction sends money to
     */
    public String getUserTo(){
        return this.userTo;
    }

    @Override
    /**
     * Returns a string representation of the transaction.
     */
    public String toString(){
        return "ID:" + super.getID() + "---" + getAccountFrom() + "---" + getUserTo() + "---" + "$" + String.format("%.2f",getAmount()) + "---"
                + checkReversible() + "---" + super.getDate();
    }
}

