package GUI.Menus;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Login extends TemplateInterface {
    private JPasswordField password_field;
    private JTextField username_field;
    private JButton backButton;
    private JButton enterButton;

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JPasswordField getPassword_field() {
        return password_field;
    }

    public JTextField getUsername_field() {
        return username_field;
    }

    public Login() {
        super();
        initialize();
        setVisible(true);
    }

    private JButton createJButton(String title, int x, int y) {
        JButton butt = new JButton(title);
        butt.setBounds(x, y, 500, 50);
        butt.setBackground(new Color(47, 79, 79));
        butt.setForeground(Color.WHITE);
        butt.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));

        return butt;
    }

    private void initialize() {
        setResizable(false);
        setTitle("User Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        JLabel welcome_label = createJLabel("Welcome Back!", 168, 190, 35,432, 50);
        welcome_label.setForeground(new Color(60, 179, 113));
        welcome_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_label.setBounds(168, 190, 432, 50);
        addToContent(welcome_label);

        JLabel username_label = createJLabel("Username", 130, 273, 35,220, 50);
        addToContent(username_label);

        JLabel password_label = createJLabel("Password", 130, 361, 35,220, 50);
        addToContent(password_label);

        password_field = new JPasswordField();
        password_field.setBounds(385, 360, 240, 49);
        addToContent(password_field);

        username_field = new JTextField();
        username_field.setBounds(385, 270, 240, 50);
        username_field.setColumns(10);
        addToContent(username_field);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

        enterButton = createJButton("Enter", 130, 461);
        addToContent(enterButton);
    }
}
