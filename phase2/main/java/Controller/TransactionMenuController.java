package Controller;

import GUI.Menus.*;
import bankmain.ATM;

public class TransactionMenuController {
    private ATM model;
    private TransactionMenu view;

    public TransactionMenuController(ATM atm, TransactionMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController(){
        view.getBillButton().addActionListener(e -> createPayBills());
        view.getBackButton().addActionListener(e -> goBack());
        view.getDepositButton().addActionListener(e -> createDepositMenu());
        view.getSendButton().addActionListener(e -> createSend());
        view.getTransferButton().addActionListener(e -> createTransfer());
        view.getWithdrawButton().addActionListener(e -> createWithdraw());
    }

    private void goBack(){
        MainMenu mm = new MainMenu(model);
        MainMenuController mmc = new MainMenuController(model, mm);
        mmc.initController();
        mm.setVisible(true);
        mm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createPayBills(){
        PayBills pb = new PayBills(model);
        PayBillsController pbc = new PayBillsController(model, pb);
        pbc.initController();
        pb.setVisible(true);
        pb.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createDepositMenu(){
        DepositMenu dm = new DepositMenu();
        DepositMenuController dmc = new DepositMenuController(model, dm);
        dmc.initController();
        dm.setVisible(true);
        dm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createSend(){
        SendMoney sm = new SendMoney(model);
        SendMoneyController smc = new SendMoneyController(model, sm);
        smc.initController();
        sm.setVisible(true);
        sm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createTransfer(){
        TransferMoney tm = new TransferMoney(model);
        TransferMoneyController tmc = new TransferMoneyController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createWithdraw(){
        Withdraw wd = new Withdraw(model);
        WithdrawController wdc = new WithdrawController(model, wd);
        wdc.initController();
        wd.setVisible(true);
        wd.setLocationRelativeTo(view);
        view.dispose();
    }
}


