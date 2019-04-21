package GUI.Menus;
import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class SendMoney extends TemplateInterface {

    private ATM model;
    private JTextField amount_field;
    private JTextField userTo_field;
    private JTextField accTo_field;
    private JButton enter_button;
    private JButton back_button;
    private JComboBox<Account> comboBox;

    public JTextField getAmount_field(){
        return amount_field;
    }

    public JTextField getUserTo_field(){
        return userTo_field;
    }

    public JTextField getAccTo_field(){
        return accTo_field;
    }

    public JButton getEnter_button(){
        return enter_button;
    }

    public JButton getBack_button(){
        return back_button;
    }

    public Account getSelectedAccount(){
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

    public SendMoney(ATM model){
        this.model = model;
        initialize(model);
        setVisible(true);
    }

    private JLabel createJLabel(String name, int x, int y, int width, int height) {
        JLabel space = new JLabel(name);
        space.setBounds(x, y, width, height);
        space.setForeground(new Color(47, 79, 79));
        space.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));

        return space;
    }

    private JTextField createJTextField(int x, int y) {
        JTextField txtField = new JTextField();
        txtField.setColumns(10);
        txtField.setBounds(x, y, 280, 50);

        return txtField;
    }

    private void initialize(ATM model){
        setTitle("Send Money");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        JLabel amount_label = createJLabel("Amount", 130, 240, 205, 50);
        addToContent(amount_label);

        enter_button = new JButton("Enter");
        enter_button.setForeground(Color.WHITE);
        enter_button.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        enter_button.setBackground(new Color(47, 79, 79));
        enter_button.setBounds(130, 530, 500, 50);
        addToContent(enter_button);

        back_button = createGoBackButton(25, 135);
        addToContent(back_button);

        amount_field = createJTextField(350, 240);
        addToContent(amount_field);

        Account[] accountArray = model.getUserManager().getUser(model.getCurrentUser()).getAccountArray();
        comboBox = new JComboBox<>(accountArray);
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setBounds(350, 310, 280, 50);
        addToContent(comboBox);

        JLabel account_label = createJLabel("Account", 130, 310, 205, 50);
        addToContent(account_label);

        JLabel recipient_label = createJLabel("Recipient", 130, 380, 205, 50);
        addToContent(recipient_label);

        userTo_field = createJTextField(350, 380);
        addToContent(userTo_field);

        JLabel lblAccount = createJLabel("Account #", 130, 450, 205, 50);
        addToContent(lblAccount);

        accTo_field = createJTextField(350, 450);
        addToContent(accTo_field);
    }
}