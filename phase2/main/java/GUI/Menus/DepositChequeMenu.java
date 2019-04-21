package GUI.Menus;

import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class DepositChequeMenu extends TemplateInterface {

    private ATM model;
    private JPanel contentPane;
    private JTextField txtEnterCheckAmount;
    private JComboBox<Account> accountBox;
    private JButton backButton;
    private JButton enterButton;

    public JTextField getTxtEnterCheckAmount(){
        return txtEnterCheckAmount;
    }

    public JComboBox<Account> getAccountJComboBox() {
        return accountBox;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public DepositChequeMenu(ATM model) {
        this.model = model;
        initialize(model);
        setVisible(true);
    }

    public void initialize(ATM model) {
        setTitle("Deposit Cheque Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

        JLabel amount_label = createJLabel("Amount", 130 ,240, 35, 205, 50);
        addToContent(amount_label);

        txtEnterCheckAmount = new JTextField();
        txtEnterCheckAmount.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        txtEnterCheckAmount.setText("00.00");
        txtEnterCheckAmount.setBounds(350, 240, 280, 50);
        txtEnterCheckAmount.setColumns(10);
        addToContent(txtEnterCheckAmount);

        JLabel account_label =  createJLabel("Account", 130, 330, 35, 205, 50);
        addToContent(account_label);

        Account[] accountArray = model.getUserManager().getUser(model.getCurrentUser()).getAccountArray();
        accountBox = new JComboBox(accountArray);
        accountBox.setForeground(new Color(47, 79, 79));
        accountBox.setBounds(350, 330, 280, 50);
        addToContent(accountBox);

        enterButton =  createButton("Enter", 130, 420, "Frankkin Gothic Medium", 23,
                500, 50);
        addToContent(enterButton);
    }
}
