package Controller;

import GUI.Menus.Login;
import GUI.Menus.Register;
import GUI.Menus.Welcome;
import bankmain.ATM;

public class WelcomeController {
    private ATM model;
    private Welcome view;


    public WelcomeController(ATM atm, Welcome frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getLoginButton().addActionListener(e -> createLoginFrame());
        view.getRegisterButton().addActionListener(e -> createRegisterFrame());
    }

    private void createLoginFrame() {
        //Login should no longer take in an atm instance
        Login login = new Login();
        LoginController lc = new LoginController(model, login);
        lc.initController();
        login.setVisible(true);
        login.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createRegisterFrame() {
        //Login should no longer take in an atm instance
        Register register = new Register();
        RegisterController rc = new RegisterController(model, register);
        rc.initController();
        register.setVisible(true);
        register.setLocationRelativeTo(view);
        view.dispose();
    }

}