package Controller;

import Accounts.Account;
import GUI.Menus.*;
import bankmain.ATM;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EmployeeUserAccountsInfoController {

    private ATM model;
    private EmployeeUserAccountsInfo view;

    public EmployeeUserAccountsInfoController(ATM atm, EmployeeUserAccountsInfo frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> goBack());
        System.out.println(view.getAccountJList());
        view.getAccountJList().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateAccountView();
                }
            }
        });
    }

    private void goBack() {
        EmployeeMainMenu em = new EmployeeMainMenu(model);
        EmployeeMainMenuController emc = new EmployeeMainMenuController(model, em);
        emc.initController();
        em.setVisible(true);
        em.setLocationRelativeTo(view);
        view.dispose();
    }

    private void updateAccountView(){
        Account account = view.getAccountJList().getSelectedValue();
        view.getLblAccount().setText("Account: " + account.getAccountID());
        view.getLblDateCreated().setText("Date Created: " + account.printCreationDate());
        view.getLblType().setText("Type: " + account.getType());
        view.getLblAmount().setText("Amount: $" + String.format("%.2f",account.getBalance()));

    }



}
