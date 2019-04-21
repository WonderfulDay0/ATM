package GUI.Menus;

import bankmain.ATM;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

public class AddAccount extends TemplateInterface {
    private ATM model;

    private JLabel accountType;
    private JLabel accountLabel;
    private JLabel joint;

    private JTextField userToField;
    private JButton goBackButton;
    private JButton enterButton;
    private JComboBox<String> accountBox;
    private JCheckBox checkBox;

    public AddAccount(ATM model) {
        this.model = model;
        initialize();
        setVisible(true);
    }

    public JTextField getUserToField() {
        return userToField;
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public String getAccountTypeSelected() {
        return String.valueOf(accountBox.getSelectedIndex());
    }

    private JButton createJButton(String title, int x, int y) {
        JButton butt = new JButton(title);
        butt.setBounds(x, y, 500, 50);
        butt.setBackground(new Color(47, 79, 79));
        butt.setForeground(Color.WHITE);
        butt.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));

        return butt;
    }

    private JLabel createJLabel(String name, int x, int y, int width, int height) {
        JLabel space = new JLabel(name);
        space.setBounds(x, y, width, height);
        space.setForeground(new Color(47, 79, 79));
        space.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));

        return space;
    }


    public void initialize() {
        setTitle("Add New Account");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        accountType = createJLabel("Select your account type", 185,190, 500, 50 );
        accountType.setForeground(new Color(60, 179, 113));
        addToContent(accountType);

        enterButton = createJButton("Enter", 130, 420);
        addToContent(enterButton);

        goBackButton = createGoBackButton(25, 135);
        addToContent(goBackButton);

        accountLabel = createJLabel("Account", 130, 280, 205, 50);
        addToContent(accountLabel);

        joint = createJLabel("Joint", 130, 350, 100, 50);
        addToContent(joint);

        String[] s = {"Chequing", "Savings", "Credit", "Line of Credit", "Tiered Rate"};
        accountBox = new JComboBox<>(s);
        accountBox.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 25));
        accountBox.setForeground(new Color(47, 79, 79));
        accountBox.setBounds(350, 280, 280, 50);
        addToContent(accountBox);

        userToField = new JTextField();
        userToField.setEnabled(false);
        userToField.setColumns(10);
        userToField.setBounds(350, 350, 280, 50);
        addToContent(userToField);

        checkBox = new JCheckBox("");
        checkBox.setBackground(new Color(255, 255, 255));
        checkBox.setBounds(243, 360, 29, 31);
        addToContent(checkBox);
    }
}
