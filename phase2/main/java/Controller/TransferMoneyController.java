package Controller;

import Accounts.Account;
import GUI.Menus.MainMenu;
import GUI.Menus.TransactionMenu;
import GUI.Menus.TransferMoney;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.TransactionCompleted;
import GUI.Prompts.TransactionFailed;
import Transactions.TransactionToSelf;
import bankmain.ATM;

public class TransferMoneyController {
    private ATM model;
    private TransferMoney view;

    public TransferMoneyController(ATM atm, TransferMoney frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBack_button().addActionListener(e -> goBack());
        view.getEnter_button().addActionListener(e -> transferMoney());
    }

    private void goBack() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void transferMoney() {
        Account accFrom = view.getAccountFrom();
        Account accTo = view.getAccountTo();

        String strAmount = view.getAmount_field().getText().trim();
        double amount;

        if (!strAmount.matches("[0-9]*\\.?[0-9]*")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        } else {
            amount = Double.valueOf(strAmount);
        }

        TransactionToSelf t = new TransactionToSelf(accFrom.getAccountID(), model.getCurrentUser(), accTo.getAccountID(), amount);
        System.out.println(t);

        if (model.getTransactionManager().transact(t)) {
            accTo.addBalance(amount);
            //transaction completed
            MainMenu mm = new MainMenu(model);
            MainMenuController mmc = new MainMenuController(model, mm);
            mmc.initController();
            mm.setVisible(true);
            mm.setLocationRelativeTo(view);
            view.dispose();
            System.out.println(accFrom.getBalance());
            TransactionCompleted tc = new TransactionCompleted();
            tc.setVisible(true);
            tc.setLocationRelativeTo(view);
        } else {
            //prompt transaction failed, stay in same frame
            TransactionFailed tf = new TransactionFailed();
            tf.setVisible(true);
            tf.setLocationRelativeTo(view);
        }
    }
}
