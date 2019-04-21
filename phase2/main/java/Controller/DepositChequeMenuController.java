package Controller;

import Accounts.Account;
import GUI.Menus.DepositChequeMenu;
import GUI.Menus.DepositMenu;
import GUI.Menus.MainMenu;
import GUI.Prompts.TransactionCompleted;
import GUI.Prompts.TransactionFailed;
import bankmain.ATM;

public class DepositChequeMenuController {
    private ATM model;
    private DepositChequeMenu view;

    public DepositChequeMenuController(ATM atm, DepositChequeMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> goBack());
        view.getEnterButton().addActionListener(e -> deposit());
    }

    private void goBack() {
        DepositMenu dm = new DepositMenu();
        DepositMenuController dmc = new DepositMenuController(model, dm);
        dmc.initController();
        dm.setVisible(true);
        dm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void deposit() {
        String strAmount = view.getTxtEnterCheckAmount().getText().trim();

        if (strAmount.matches("[0-9]*\\.?[0-9]*")) {
            double amount = Double.valueOf(strAmount);
            Account account = (Account) view.getAccountJComboBox().getSelectedItem();
            model.depositCheque(model.getCurrentUser(), account.getAccountID(), amount);

            MainMenu mm = new MainMenu(model);
            MainMenuController mmc = new MainMenuController(model, mm);
            mmc.initController();
            mm.setVisible(true);
            mm.setLocationRelativeTo(view);
            view.dispose();

            TransactionCompleted tc = new TransactionCompleted();
            tc.setVisible(true);
            tc.setLocationRelativeTo(view);
        } else {
            //TODO is there ever a transaction failed
            TransactionFailed tf = new TransactionFailed();
            tf.setVisible(true);
            tf.setLocationRelativeTo(view);
        }

    }

}
