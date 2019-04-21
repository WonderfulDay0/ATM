package GUI.Menus;


import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

public class UserAndAccountSettings extends TemplateInterface {
    private JButton goBackButton;
    private JButton changePasswordButton;
    private JButton addNewAccountButton;

    public UserAndAccountSettings() {
        super();
        initialize();
        setVisible(true);
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getChangePasswordButton() {
        return changePasswordButton;
    }

    public JButton getAddNewAccountButton() {
        return addNewAccountButton;
    }

    private JLabel createSettingsLabel(){
        JLabel settings_label = new JLabel("Change Settings");
        settings_label.setForeground(new Color(60, 179, 113));
        settings_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        settings_label.setHorizontalAlignment(SwingConstants.CENTER);
        settings_label.setBounds(230, 190, 300, 50);

        return settings_label;
    }

    private void initialize() {
        setTitle("User Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        goBackButton = createGoBackButton(25, 135);
        addToContent(goBackButton);

        changePasswordButton = createButton("Change Password", 130, 420, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(changePasswordButton);

        addNewAccountButton = createButton("Add a new Account", 130, 300, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(addNewAccountButton);

        JLabel settings_label = createSettingsLabel();
        addToContent(settings_label);
    }
}
