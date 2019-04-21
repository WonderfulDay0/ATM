package Controller;

import GUI.Menus.EmployeeLogin;
import GUI.Menus.EmployeeMainMenu;
import GUI.Menus.EmployeeUserAccountsInfo;
import GUI.Menus.SetMonthMenu;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.UserNotFound;
import bankmain.ATM;

public class EmployeeMainMenuController {

    private ATM model;
    private EmployeeMainMenu view;

    public EmployeeMainMenuController(ATM atm, EmployeeMainMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getSearchButton().addActionListener(e -> search());
        view.getSetDateButton().addActionListener(e -> createSetDateFrame());
        view.getBackButton().addActionListener(e -> createEmployeeLoginFrame());
    }

    private void search() {
        String username = view.getTextField().getText().trim();

        if (!username.matches("[a-zA-Z0-9@]+")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            ii.setLocationRelativeTo(view);
            return;
        } else if (!model.getUserManager().getUserMap().containsKey(username)) {
            UserNotFound unf = new UserNotFound();
            unf.setVisible(true);
            unf.setLocationRelativeTo(view);
            return;
        }

        EmployeeUserAccountsInfo em = new EmployeeUserAccountsInfo(model, username);
        EmployeeUserAccountsInfoController emc = new EmployeeUserAccountsInfoController(model, em);
        emc.initController();
        em.setVisible(true);
        em.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createSetDateFrame() {
        SetMonthMenu smm = new SetMonthMenu();
        SetMonthMenuController smmc = new SetMonthMenuController(model, smm);
        smmc.initController();
        smm.setVisible(true);
        smm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createEmployeeLoginFrame(){
        EmployeeLogin el = new EmployeeLogin();
        EmployeeLoginController elc = new EmployeeLoginController(model, el);
        elc.initController();
        el.setVisible(true);
        el.setLocationRelativeTo(view);
        view.dispose();
    }
}
