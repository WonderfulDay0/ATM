package Controller;

import Accounts.Account;
import GUI.Menus.MainMenu;
import GUI.Menus.PayBills;
import GUI.Menus.TransactionMenu;
import GUI.Prompts.AccountNotSelected;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.TransactionCompleted;
import GUI.Prompts.TransactionFailed;
import InputOutput.Output;
import Transactions.Transaction;
import Transactions.TransactionToBill;
import bankmain.ATM;

public class PayBillsController {
    private ATM model;
    private PayBills view;

    public PayBillsController(ATM atm, PayBills frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBack_button().addActionListener(e -> goBack());
        view.getEnter_button().addActionListener(e -> payBill());
    }

    private void goBack() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void payBill() {
        String institution = view.getInstitution_field().getText().trim();
        String strAmount = view.getAmountField().getText().trim();
        double amount;

        if (!institution.matches("[a-zA-Z0-9]+") || !strAmount.matches("[0-9]*\\.?[0-9]*")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        } else {
            amount = Double.valueOf(strAmount);
        }


        Account account = view.getSelectedAccount();
        if (account != null) {
            Transaction t = new TransactionToBill(account.getAccountID(), model.getCurrentUser(), institution, amount);
            if (model.getTransactionManager().transact(t)) {
                //transaction completed
                Output.createNewDirectory("UserFiles/" + model.getCurrentUser().substring(1));
                Output.write("" + model.getCurrentUser() + " paid " + amount + " to " + institution+"!", "UserFiles/" + model.getCurrentUser().substring(1) + "/outgoing.txt", true);
                TransactionCompleted tc = new TransactionCompleted();
                tc.setVisible(true);
                tc.setLocationRelativeTo(view);
                MainMenu mm = new MainMenu(model);
                MainMenuController mmc = new MainMenuController(model, mm);
                mmc.initController();
                mm.setVisible(true);
                mm.setLocationRelativeTo(view);
                view.dispose();
            } else {
                //prompt transaction failed, stay in same frame
                TransactionFailed tf = new TransactionFailed();
                tf.setVisible(true);
                tf.setLocationRelativeTo(view);
            }
        } else {
            //prompt account not selected, stay in same frame
            AccountNotSelected window = new AccountNotSelected();
            window.setVisible(true);
            window.setLocationRelativeTo(view);
        }
    }
}


