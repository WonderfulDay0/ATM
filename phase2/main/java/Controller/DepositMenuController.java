package Controller;

import GUI.Menus.*;
import bankmain.ATM;

public class DepositMenuController {
    private ATM model;
    private DepositMenu view;

    public DepositMenuController(ATM atm, DepositMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> goBack());
        view.getDepositChequeButton().addActionListener(e -> createDepositChequeFrame());
        view.getDepositCashButton().addActionListener(e -> createDepositCashFrame());
    }

    private void goBack() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createDepositChequeFrame() {
        DepositChequeMenu window = new DepositChequeMenu(model);
        DepositChequeMenuController dcmc = new DepositChequeMenuController(model, window);
        dcmc.initController();
        window.setVisible(true);
        window.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createDepositCashFrame() {
        DepositCashMenu window = new DepositCashMenu(model);
        DepositCashMenuController dcmc = new DepositCashMenuController(model, window);
        dcmc.initController();
        window.setVisible(true);
        window.setLocationRelativeTo(view);
        view.dispose();
    }
}
