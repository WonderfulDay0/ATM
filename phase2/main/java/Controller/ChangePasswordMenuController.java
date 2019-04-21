package Controller;

import GUI.Menus.ChangePasswordMenu;
import GUI.Menus.MainMenu;
import GUI.Menus.UserAndAccountSettings;
import GUI.Prompts.*;
import bankmain.ATM;

public class ChangePasswordMenuController {

    private ATM model;
    private ChangePasswordMenu view;

    public ChangePasswordMenuController(ATM atm, ChangePasswordMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> createUserAndAccountSettingsFrame());
        view.getChangePassButton().addActionListener(e -> createChangePassword());
    }

    private void createUserAndAccountSettingsFrame() {
        UserAndAccountSettings uas = new UserAndAccountSettings();
        UserAndAccountSettingsController uasc = new UserAndAccountSettingsController(model, uas);
        uasc.initController();
        uas.setVisible(true);
        uas.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createChangePassword() {
        String oldPass = view.getOldPasswordField().getText().trim();
        String newPass = view.getNewPasswordField().getText().trim();
        String confirmPass = view.getConfirmPasswordField().getText().trim();

        if (model.verifyPassword(oldPass)) {
            if (newPass.matches("[a-zA-Z0-9]+")) {
                if (confirmPass.equals(newPass)) {
                    PasswordChanged pc = new PasswordChanged();
                    pc.setVisible(true);
                    pc.setLocationRelativeTo(view);

                    MainMenu mainMenu = new MainMenu(model);
                    MainMenuController mmc = new MainMenuController(model, mainMenu);
                    mmc.initController();
                    mainMenu.setVisible(true);
                    mainMenu.setLocationRelativeTo(view);
                    view.dispose();
                } else {
                    DifferentPasswords dp = new DifferentPasswords();
                    dp.setVisible(true);
                    dp.setLocationRelativeTo(view);
                }
            } else {
                InvalidInput ii = new InvalidInput();
                ii.setVisible(true);
            }
        } else {
            WrongOldPassword wop = new WrongOldPassword();
            wop.setVisible(true);
            wop.setLocationRelativeTo(view);
        }
    }
}
