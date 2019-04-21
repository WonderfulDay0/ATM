package Controller;

import GUI.Menus.UserAndAccountSettings;
import GUI.Menus.ChangePasswordMenu;
import GUI.Menus.MainMenu;
import GUI.Menus.AddAccount;
import bankmain.ATM;

public class UserAndAccountSettingsController {
    private ATM model;
    private UserAndAccountSettings view;

    public UserAndAccountSettingsController(ATM atm, UserAndAccountSettings frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getGoBackButton().addActionListener(e -> goBack());
        view.getChangePasswordButton().addActionListener(e -> changePassword());
        view.getAddNewAccountButton().addActionListener(e -> addNewAccount());
    }

    private void goBack() {
        MainMenu mm = new MainMenu(model);
        MainMenuController mmc = new MainMenuController(model, mm);
        mmc.initController();
        mm.setVisible(true);
        mm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void changePassword() {
        ChangePasswordMenu cpm = new ChangePasswordMenu(model);
        ChangePasswordMenuController cpmc = new ChangePasswordMenuController(model, cpm);
        cpmc.initController();
        cpm.setVisible(true);
        cpm.setLocationRelativeTo(view);
        view.dispose();
    }

    private void addNewAccount() {
        AddAccount aa = new AddAccount(model);
        AddAccountController aac = new AddAccountController(model, aa);
        aac.initController();
        aa.setVisible(true);
        aa.setLocationRelativeTo(view);
        view.dispose();
    }


}
