package GUI.Menus;

import javax.swing.*;

import java.awt.*;

public class Welcome extends TemplateInterface {
    private JButton loginButton;
    private JButton registerButton;

    public Welcome() {
        initialize();
        setVisible(true);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    private JLabel createJLabelWelcome() {
        JLabel welcome_label = new JLabel("Welcome to Dank Bank!");
        welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_label.setForeground(new Color(60, 179, 113));
        welcome_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        welcome_label.setBounds(168, 190, 432, 50);

        return welcome_label;
    }

    private void initialize() {
        setTitle("Welcome Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addToContent(createJLabelWelcome());

        loginButton = createButton("Login", 130, 300, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(loginButton);

        registerButton = createButton("Register", 130, 420, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(registerButton);
    }
}