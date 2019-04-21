package GUI.Menus;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Register extends TemplateInterface {

    private JTextField username_field;
    private JPasswordField password_field;
    private JPasswordField confirm_field;
    private JButton backButton;
    private JButton enterButton;

    public Register() {
        initialize();
        setVisible(true);
    }

    public JTextField getUsernameField() {
        return username_field;
    }

    public JPasswordField getPasswordField() {
        return password_field;
    }

    public JPasswordField getConfirmField() {
        return confirm_field;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    private JLabel createWelcomeLabel() {
        JLabel welcome_label = new JLabel("Welcome to our bank!");
        welcome_label.setForeground(new Color(60, 179, 113));
        welcome_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_label.setBounds(160, 180, 432, 50);

        return welcome_label;
    }

    private void initialize() {
        setTitle("User Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcome_label = createWelcomeLabel();
        addToContent(welcome_label);

        JLabel username_label = createJLabel("Username", 130, 263, 35, 220, 50);
        addToContent(username_label);

        JLabel password_label = createJLabel("Password", 130, 350, 35, 220, 50);
        addToContent(password_label);

        password_field = new JPasswordField();
        password_field.setBounds(385, 350, 240, 50);
        addToContent(password_field);

        username_field = new JTextField();
        username_field.setBounds(385, 263, 240, 50);
        addToContent(username_field);
        username_field.setColumns(10);

        JLabel confirm_label = createJLabel("Confirm", 130, 423, 35, 220, 50);
        addToContent(confirm_label);

        JLabel c_password_label = createJLabel("Password", 130, 462, 35, 220, 49);
        addToContent(c_password_label);

        confirm_field = new JPasswordField();
        confirm_field.setBounds(385, 447, 240, 49);
        addToContent(confirm_field);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

        enterButton = createButton("Enter", 130, 545, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(enterButton);
    }
}
