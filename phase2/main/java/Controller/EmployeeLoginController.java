package Controller;

import GUI.Menus.EmployeeLogin;
import GUI.Menus.EmployeeMainMenu;
import GUI.Menus.MainMenu;
import bankmain.ATM;

public class EmployeeLoginController {
    private ATM model;
    private EmployeeLogin view;

    public EmployeeLoginController(ATM atm, EmployeeLogin frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getUserButton().addActionListener(e -> signInAsUser());
        view.getEmployeeButton().addActionListener(e -> signInAsEmployee());
    }

    private void signInAsUser() {
        MainMenu mm = new MainMenu(model);
        MainMenuController mmc = new MainMenuController(model, mm);
        mmc.initController();
        mm.setVisible(true);
        mm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void signInAsEmployee() {
        EmployeeMainMenu em = new EmployeeMainMenu(model);
        EmployeeMainMenuController emc = new EmployeeMainMenuController(model, em);
        emc.initController();
        em.setVisible(true);
        em.setLocationRelativeTo(view);
        view.dispose();
    }
}
