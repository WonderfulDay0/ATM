package Controller;

import Accounts.Account;
import GUI.Menus.*;
import InputOutput.Output;
import InputOutput.Serialization;
import Transactions.Transaction;
import bankmain.ATM;
import bankmain.DateDifference;

public class MainMenuController {
    private ATM model;
    private MainMenu view;


    public MainMenuController(ATM atm, MainMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getViewBalanceButton().addActionListener(e -> createViewBalances());
        view.getViewTransactionsButton().addActionListener(e -> createViewTransactions());
        view.getMakeTransactionButton().addActionListener(e -> createMakeATransaction());
        view.getUserAndAccountButton().addActionListener(e -> createUserAndAccountSetting());
        view.getLogoutButton().addActionListener(e -> createLogout());
    }

    private void createViewBalances() {
        ViewBalances vb = new ViewBalances(model);
        ViewBalancesController vbc = new ViewBalancesController(model, vb);
        vbc.initController();
        vb.setVisible(true);
        vb.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createViewTransactions() {
        ViewTransactions vc = new ViewTransactions(model);
        ViewTransactionsController vcc = new ViewTransactionsController(model, vc);
        vcc.initController();
        vc.setVisible(true);
        vc.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createMakeATransaction() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createUserAndAccountSetting() {
        UserAndAccountSettings um = new UserAndAccountSettings();
        UserAndAccountSettingsController usc = new UserAndAccountSettingsController(model, um);
        usc.initController();
        um.setVisible(true);
        um.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createLogout(){
        Serialization.serializeObject(model, "atm.ser");

        Output.write("" + Account.getUniqueID(), "AccID.txt", false);
        Output.write("" + DateDifference.getYearsAdded(), "Year.txt", false);
        Output.write("" + DateDifference.getMonthsAdded(), "Month.txt", false);
        Output.write("" + Transaction.getUniqueTransactionID(), "TransID.txt", false);

        System.exit(0);

    }

}
