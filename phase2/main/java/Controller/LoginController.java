package Controller;

import GUI.Menus.EmployeeLogin;
import GUI.Menus.Login;
import GUI.Menus.Welcome;
import GUI.Menus.MainMenu;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.WrongPassword;
import bankmain.ATM;


public class LoginController {
    private ATM model;
    private Login view;

    public LoginController(ATM atm, Login frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> goBack());
        view.getEnterButton().addActionListener(e -> login());
    }

    private void goBack() {
        Welcome window = new Welcome();
        WelcomeController wc = new WelcomeController(model, window);
        wc.initController();
        window.setVisible(true);
        window.setLocationRelativeTo(view);
        view.dispose();
    }

    private void login() {
        String username = view.getUsername_field().getText().trim();

        if (!username.matches("[a-zA-Z0-9@]+")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        }
        model.setCurrentUser(username);
        if (model.getUserManager().getUserMap().get(username) == null) {
            WrongPassword wp = new WrongPassword();
            wp.setVisible(true);
            wp.setLocationRelativeTo(view);
        } else {
            if (username.charAt(0) == '@') {
                EmployeeLogin emp = new EmployeeLogin();
                EmployeeLoginController empC = new EmployeeLoginController(model, emp);
                empC.initController();
                emp.setVisible(true);
                emp.setLocationRelativeTo(view);
                view.dispose();
            } else {
                createMainMenuFrame(username);
            }
        }
    }

    private void createMainMenuFrame(String username) {
        //this is deprecated for security we can choose to fix it
        String password = view.getPassword_field().getText().trim();
        if (!password.matches("[a-zA-Z0-9]+")) {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            return;
        }

        model.setCurrentUser(username);
        MainMenu mainMenu = new MainMenu(model);
        MainMenuController mc = new MainMenuController(model, mainMenu);
        mc.initController();
        mainMenu.setVisible(true);
        mainMenu.setLocationRelativeTo(view);
        view.dispose();
    }
}