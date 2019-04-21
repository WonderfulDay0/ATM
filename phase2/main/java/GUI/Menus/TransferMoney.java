package GUI.Menus;

import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class TransferMoney extends TemplateInterface {
    private ATM model;
    private JButton back_button;
    private JButton enter_button;
    private JComboBox<Account> comboBoxFrom;
    private JComboBox<Account> comboBoxTo;
    private JTextField amount_field;

    public JButton getBack_button(){
        return back_button;
    }

    public JButton getEnter_button(){
        return enter_button;
    }

    public Account getAccountFrom(){
        return comboBoxFrom.getItemAt(comboBoxFrom.getSelectedIndex());
    }

    public Account getAccountTo(){
        return comboBoxTo.getItemAt(comboBoxTo.getSelectedIndex());
    }

    public JTextField getAmount_field(){
        return amount_field;
    }

    public TransferMoney(ATM model){
        this.model = model;
        initialize(model);
        setVisible(true);
    }

    private JButton createEnterButton(){
        JButton enter_button = new JButton("Enter");
        enter_button.setForeground(Color.WHITE);
        enter_button.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        enter_button.setBackground(new Color(47, 79, 79));
        enter_button.setBounds(130, 468, 500, 50);
        return enter_button;
    }
    
    private JTextField createAmountField(){
        JTextField amount_field = new JTextField();
        amount_field.setBounds(350, 240, 280, 50);
        amount_field.setColumns(10);
        return amount_field;
    }

    private JLabel createAccountLabel(){
        JLabel account_label = new JLabel("To");
        account_label.setForeground(new Color(47, 79, 79));
        account_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        account_label.setBounds(130, 380, 205, 50);
        return account_label;
    }

    private JLabel createFromLabel(){
        JLabel label_from = new JLabel("From");
        label_from.setForeground(new Color(47, 79, 79));
        label_from.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        label_from.setBounds(130, 311, 205, 50);
        return label_from;
    }

    private JLabel createAmountLabel(){
        JLabel amount_label = new JLabel("Amount");
        amount_label.setForeground(new Color(47, 79, 79));
        amount_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        amount_label.setBounds(130, 240, 205, 50);
        return amount_label;
    }

    public void initialize(ATM model) {
        setTitle("Transfer Money");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        enter_button = createEnterButton();
        addToContent(enter_button);

        back_button = createGoBackButton(25, 135);
        addToContent(back_button);

        amount_field = createAmountField();
        addToContent(amount_field);

        Account[] accountArray = model.getUserManager().getUser(model.getCurrentUser()).getAccountArray();
        comboBoxFrom = new JComboBox<>(accountArray);
        comboBoxFrom.setForeground(new Color(47, 79, 79));
        comboBoxFrom.setBounds(350, 309, 280, 50);
        addToContent(comboBoxFrom);

        addToContent(createAccountLabel());

        addToContent(createFromLabel());

        addToContent(createAmountLabel());

        comboBoxTo = new JComboBox<>(accountArray);
        comboBoxTo.setForeground(new Color(47, 79, 79));
        comboBoxTo.setBounds(350, 380, 280, 50);
        addToContent(comboBoxTo);
    }
}
