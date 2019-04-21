package Controller;

import GUI.Prompts.InvalidInput;
import bankmain.ATM;
import GUI.Menus.EmployeeMainMenu;
import GUI.Menus.SetMonthMenu;
import GUI.Menus.TemplateInterface;
import bankmain.Bank;
import bankmain.DateDifference;

public class SetMonthMenuController {

    private ATM model;
    private SetMonthMenu view;

    public SetMonthMenuController(ATM atm, SetMonthMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getGoBack().addActionListener(e -> goBack());
        view.getEnterButton().addActionListener(e -> setMonth());
    }

    private void goBack() {
        EmployeeMainMenu emm = new EmployeeMainMenu(model);
        EmployeeMainMenuController emmc = new EmployeeMainMenuController(model, emm);
        emmc.initController();
        emm.setVisible(true);
        emm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void setMonth() {
        if (view.getMonthTxtField().getText().matches("^[1-9][0-9]*")) {
            int month = Integer.parseInt(view.getMonthTxtField().getText().trim());
            DateDifference.addDifference(month);
            Bank.updateInterestOnStartup(model.getUserManager());

            EmployeeMainMenu emm = new EmployeeMainMenu(model);
            EmployeeMainMenuController emmc = new EmployeeMainMenuController(model, emm);
            emmc.initController();
            emm.setVisible(true);
            emm.setLocationRelativeTo(view);
            view.dispose();
        } else {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
        }
    }
}
