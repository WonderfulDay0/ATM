package GUI.Menus;

import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class DepositCashMenu extends TemplateInterface {

    private JTextField txtFiveBills;
    private JTextField txtTenBills;
    private JTextField txtTwentyBills;
    private JTextField txtFiftyBills;
    private JTextField txtHundredBills;

    private JButton backButton;
    private JButton enterButton;
    private JComboBox<Account> comboBox;
    private ATM model;

    public JTextField getTxtFiveBills() {
        return txtFiveBills;
    }

    public JTextField getTxtFiftyBills() {
        return txtFiftyBills;
    }

    public JTextField getTxtHundredBills() {
        return txtHundredBills;
    }

    public JTextField getTxtTenBills() {
        return txtTenBills;
    }

    public JTextField getTxtTwentyBills() {
        return txtTwentyBills;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public Account getSelectedAccount() {
        int index = comboBox.getSelectedIndex();

        if (index != -1)
            return comboBox.getItemAt(comboBox.getSelectedIndex());
        else
            return null;

    }

    private JLabel createJLabel(String name, int x, int y, int width, int height) {
        JLabel label = new JLabel(name);
        label.setForeground(new Color(47, 79, 79));
        label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        label.setBounds(x, y, width, height);

        return label;
    }

    private JTextField createJTextField(int x, int y) {
        JTextField enter = new JTextField();
        enter.setText("0");
        enter.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        enter.setColumns(10);
        enter.setBounds(x, y, 50, 50);

        return enter;
    }

    private JButton createJButton(String name, int x, int y, int width, int height) {
        JButton butt = new JButton(name);
        butt.setForeground(Color.WHITE);
        butt.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        butt.setBackground(new Color(47, 79, 79));
        butt.setBounds(x, y, width, height);

        return butt;
    }

    private void createBillLabelText(){
        JLabel lblFiveDollars = createJLabel("$5", 70, 300, 50, 50);
        addToContent(lblFiveDollars);

        txtFiveBills = createJTextField(120, 300);
        addToContent(txtFiveBills);

        JLabel lblTenDollars = createJLabel("$10", 180, 300, 70, 50);
        addToContent(lblTenDollars);

        txtTenBills = createJTextField(250, 300);
        addToContent(txtTenBills);

        JLabel lblTwentyDollars = createJLabel("$20", 310, 300, 70, 50);
        addToContent(lblTwentyDollars);

        txtTwentyBills = createJTextField(380, 300);
        addToContent(txtTwentyBills);

        JLabel lblFiftyDollars = createJLabel("$50", 440, 300, 70, 50);
        addToContent(lblFiftyDollars);

        txtFiftyBills = createJTextField(510, 300);
        addToContent(txtFiftyBills);

        JLabel lblHundredDollars = createJLabel("$100", 570, 300, 90, 50);
        addToContent(lblHundredDollars);

        txtHundredBills = createJTextField(660, 300);
        addToContent(txtHundredBills);

    }

    private void initialize() {
        setTitle("Deposit Cash Menu");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JLabel setting_label = createJLabel("Enter Information", 230, 190, 300, 50);
        addToContent(setting_label);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

        createBillLabelText();

        JLabel lblAccount = createJLabel("Account", 135, 400, 205, 50);
        addToContent(lblAccount);

        Account[] accountArray = model.getUserManager().getUser(model.getCurrentUser()).getAccountArray();
        comboBox = new JComboBox<>(accountArray);
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setBounds(340, 400, 280, 50);
        addToContent(comboBox);

        enterButton = createJButton("Enter", 130, 500, 500, 50);
        addToContent(enterButton);
    }

    public DepositCashMenu(ATM atm) {
        model = atm;
        initialize();
        setVisible(true);
    }
}
