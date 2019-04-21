package Controller;

import GUI.Menus.MainMenu;
import GUI.Menus.Register;
import GUI.Menus.TemplateInterface;
import GUI.Menus.Welcome;
import GUI.Prompts.DifferentPasswords;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.UsernameTaken;
import GUI.Prompts.UsernameTooLong;
import bankmain.ATM;

public class RegisterController {
    private ATM model;
    private Register view;

    public RegisterController(ATM atm, Register frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getEnterButton().addActionListener(e -> register());
        view.getBackButton().addActionListener(e -> goBack());
    }

    private void goBack() {
        Welcome w = new Welcome();
        WelcomeController wc = new WelcomeController(model, w);
        wc.initController();
        w.setVisible(true);
        w.setLocationRelativeTo(view);
        view.dispose();
    }

    private void register() {
        String userName = view.getUsernameField().getText().trim();
        String password1 = view.getPasswordField().getText().trim();
        String password2 = view.getConfirmField().getText().trim();

        if (!password1.matches("[a-zA-Z0-9]+") || !password2.matches("[a-zA-Z0-9]+")
                || !userName.matches("[a-zA-Z0-9]+")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        }
        if (password1.equals(password2)) {
            if (model.register(userName, password1)) {
                model.setCurrentUser(userName);
                MainMenu mainMenu = new MainMenu(model);
                MainMenuController mc = new MainMenuController(model, mainMenu);
                mc.initController();
                mainMenu.setVisible(true);
                mainMenu.setLocationRelativeTo(view);
                view.dispose();
            } else {
                UsernameTaken ut = new UsernameTaken();
                ut.setVisible(true);
                ut.setLocationRelativeTo(view);
            }
        } else if (userName.length() > 10) {
            UsernameTooLong ul = new UsernameTooLong();
            ul.setVisible(true);
            ul.setLocationRelativeTo(view);
        } else {
            DifferentPasswords dp = new DifferentPasswords();
            dp.setVisible(true);
            dp.setLocationRelativeTo(view);
        }

    }
}
