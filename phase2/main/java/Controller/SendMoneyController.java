package Controller;

import Accounts.Account;
import GUI.Menus.MainMenu;
import GUI.Menus.SendMoney;
import GUI.Menus.TransactionMenu;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.TransactionCompleted;
import GUI.Prompts.TransactionFailed;
import Transactions.TransactionToOther;
import Users.User;
import bankmain.ATM;

public class SendMoneyController {
    private ATM model;
    private SendMoney view;

    public SendMoneyController(ATM atm, SendMoney frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBack_button().addActionListener(e -> goBack());
        view.getEnter_button().addActionListener(e -> sendMoney());
    }

    private void goBack() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void sendMoney() {
        String strUserTo = view.getUserTo_field().getText().trim();
        String strAccTo = view.getAccTo_field().getText().trim();
        String strAmount = view.getAmount_field().getText().trim();

        if (!strUserTo.matches("[a-zA-Z0-9]+") || !strAccTo.matches("[a-zA-Z0-9]+")
                || !strAmount.matches("[0-9]*\\.?[0-9]*")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        }

        Account accFrom = view.getSelectedAccount();
        User userTo = model.getUserManager().getUser(strUserTo);
        Account accTo = (userTo.getAccountMap()).get(strAccTo);


        double amount = Double.valueOf(strAmount);

        TransactionToOther t = new TransactionToOther(accFrom.getAccountID(), model.getCurrentUser(),
                accTo.getAccountID(), view.getUserTo_field().getText(), amount);

        if (model.getTransactionManager().sendMoney(t)) {
            //transaction completed
            TransactionCompleted tc = new TransactionCompleted();
            tc.setVisible(true);
            tc.setLocationRelativeTo(view);
            MainMenu mm = new MainMenu(model);
            MainMenuController mmc = new MainMenuController(model, mm);
            mmc.initController();
            mm.setVisible(true);
            mm.setLocationRelativeTo(view);
            view.dispose();
            System.out.println(accTo.getBalance());
        } else {
            //prompt transaction failed, stay in same frame
            TransactionFailed tf = new TransactionFailed();
            tf.setVisible(true);
            tf.setLocationRelativeTo(view);
        }

    }
}

