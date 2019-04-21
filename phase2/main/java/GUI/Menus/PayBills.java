package GUI.Menus;

import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class PayBills extends TemplateInterface {

    private ATM model;
    private JTextField institution_field;
    private JTextField amountField;
    private JButton enter_button;
    private JButton back_button;
    private JComboBox<Account> account_box;

    /**
     * Create the frame.
     */
    public PayBills(ATM model){
        this.model = model;
        initialize(model);
        setVisible(true);
    }

    public JTextField getInstitution_field(){
        return institution_field;
    }

    public JTextField getAmountField(){
        return amountField;
    }

    public JButton getEnter_button(){
        return enter_button;
    }

    public JButton getBack_button(){
        return back_button;
    }

    public Account getSelectedAccount(){
        return account_box.getItemAt(account_box.getSelectedIndex());
    }

    private JTextField createInstField(){
        JTextField institution_field = new JTextField();
        institution_field.setBounds(350, 240, 280, 50);
        institution_field.setColumns(10);
        return institution_field;
    }

    private JTextField createAmountField(){
        JTextField amountField = new JTextField();
        amountField.setColumns(10);
        amountField.setBounds(350, 310, 280, 50);
        return amountField;
    }

    private JButton createEnterButton(){
        JButton enter_button = new JButton("Enter");
        enter_button.setForeground(Color.WHITE);
        enter_button.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        enter_button.setBackground(new Color(47, 79, 79));
        enter_button.setBounds(130, 468, 500, 50);
        return enter_button;
    }

    public void initialize(ATM model) {
        setTitle("Pay Bills");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        addToContent(createJLabel("Institution", 130, 240, 35, 205, 50));

        institution_field = createInstField();
        addToContent(institution_field);

        Account[] accountArray = model.getUserManager().getUser(model.getCurrentUser()).getAccountArray();
        account_box = new JComboBox<>(accountArray);
        account_box.setForeground(new Color(47, 79, 79));
        account_box.setBounds(350, 380, 280, 50);
        addToContent(account_box);

        addToContent(createJLabel("Account", 130, 380, 35, 205, 50));

        addToContent(createJLabel("Amount", 130, 310, 35, 205, 50));

        amountField = createAmountField();
        addToContent(amountField);

        enter_button = createEnterButton();
        addToContent(enter_button);

        back_button = createGoBackButton(25, 135);
        addToContent(back_button);
    }
}
