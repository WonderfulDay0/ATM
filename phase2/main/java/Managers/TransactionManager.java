package Managers;

import java.io.Serializable;
import java.util.Map;
import Users.*;
import Transactions.*;
import Accounts.*;

public class TransactionManager implements Serializable {
    private static final long serialVersionUID = 25L;

    private Map<String, User> userMap;

    public TransactionManager(Map<String, User> userMap){
        this.userMap = userMap;
    }

    public boolean transact(Transaction trans){
        //Generate String information
        String IDUserFrom = trans.getUserFrom();
        String IDAccFrom = trans.getAccountFrom();

        //Find the corresponding User and Accounts through the above strings
        User UserFrom = userMap.get(IDUserFrom);
        Account AccFrom = UserFrom.getAccountMap().get(IDAccFrom);

        double amount = trans.getAmount();

        if(withDrawLimitCheck(AccFrom, amount)){
            AccFrom.addBalance(-amount);
            UserFrom.getTransactionMap().put(trans.getID(), trans);
            UserFrom.setLatestTransaction(trans);
            return true;
        }
        return false;
    }

    //This method is for sending money to other user
    public boolean sendMoney(TransactionToOther trans){
        String IDUserFrom = trans.getUserFrom();
        String IDAccFrom = trans.getAccountFrom();

        //Find the corresponding User and Accounts through the above strings
        User UserFrom = userMap.get(IDUserFrom);
        Account AccFrom = UserFrom.getAccountMap().get(IDAccFrom);

        double amount = trans.getAmount();

        if(withDrawLimitCheck(AccFrom, amount)) {
            AccFrom.addBalance(-amount);
            UserFrom.getTransactionMap().put(trans.getID(), trans);
            UserFrom.setLatestTransaction(trans);


            String IDUserTo = trans.getUserTo();
            String IDAccTo = trans.getAccTo();

            User UserTo = userMap.get(IDUserTo);
            Account AccTo = UserTo.getAccountMap().get(IDAccTo);

            AccTo.addBalance(amount);

            TransactionReceived ReceivedTrans = createReceivedTransaction(trans);

            UserTo.getTransactionMap().put(ReceivedTrans.getID(), ReceivedTrans);
            UserTo.setLatestTransaction(ReceivedTrans);
            return true;
        }
        else{
            return false;
        }
    }

    public void deposit(String IDUserTo, TransactionDeposit trans){
        String IDAccTo = trans.getAccTo();

        User UserTo = userMap.get(IDUserTo);
        Account AccTo = UserTo.getAccountMap().get(IDAccTo);

        AccTo.addBalance(trans.getAmount());

        UserTo.getTransactionMap().put(trans.getID(), trans);
        UserTo.setLatestTransaction(trans);
    }

    private TransactionReceived createReceivedTransaction(TransactionToOther trans){
        String IDUserFrom = trans.getUserFrom();
        String IDAccFrom = trans.getAccountFrom();

        String IDAccTo = trans.getAccTo();

        double amount = trans.getAmount();

        return new TransactionReceived(IDAccFrom, IDUserFrom, IDAccTo, amount);
    }

    private boolean withDrawLimitCheck(Account acc, double amount){
        boolean valid_withDraw = true;

        if (acc.getAccountID().charAt(0) == '1'){ //Chequing Account
            if (acc.getBalance() < 0 || acc.getBalance() - amount < acc.getLowestValue()) {
                valid_withDraw = false;
            }
        }
        else if (acc.getAccountID().charAt(0) == '2') {//Savings
            if(acc.getBalance() <= 0 || acc.getBalance() - amount < acc.getLowestValue()){
                valid_withDraw = false;
            }
        }
        else if (acc.getAccountID().charAt(0) == '3'){ //Credit
            valid_withDraw = false;
        }
        else{ //if it's not line of credit but other kind of accounts
            if (acc.getAccountID().charAt(0) != '4'){
                valid_withDraw = false;
            }
        }

        return valid_withDraw;
    }
}
