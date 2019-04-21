package GUI.Menus;

import bankmain.ATM;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class MainMenu extends TemplateInterface {
    private JButton viewBalanceButton;
    private JButton viewTransactionsButton;
    private JButton makeTransactionButton;
    private JButton userAndAccountButton;
    private JButton logoutButton;
    private ATM model;

    public JButton getViewBalanceButton() {
        return viewBalanceButton;
    }

    public JButton getViewTransactionsButton() {
        return viewTransactionsButton;
    }

    public JButton getMakeTransactionButton() {
        return makeTransactionButton;
    }

    public JButton getUserAndAccountButton() {
        return userAndAccountButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    private JLabel createHelloLabel(){
        JLabel hello_label = new JLabel("Hello, " + model.getCurrentUser());
        hello_label.setForeground(new Color(60, 179, 113));
        hello_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        hello_label.setHorizontalAlignment(SwingConstants.CENTER);
        hello_label.setBounds(130, 150, 500, 50);

        return hello_label;
    }

    private JButton createButton(String name, int x, int y) {
        JButton tempButton = new JButton(name);
        tempButton.setForeground(Color.WHITE);
        tempButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        tempButton.setBackground(new Color(47, 79, 79));
        tempButton.setBounds(x, y, 500, 50);

        return tempButton;
    }

    public MainMenu(ATM atm) {
        super();
        this.model = atm;
        initialize();
    }

    public void initialize(){
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        JLabel hello_label = createHelloLabel();
        addToContent(hello_label);

        userAndAccountButton = createButton("User and Account Settings", 130, 530);
        addToContent(userAndAccountButton);

        makeTransactionButton = createButton("Make a Transaction", 130, 430);
        addToContent(makeTransactionButton);

        viewTransactionsButton = createButton("View Transactions", 130, 330);
        addToContent(viewTransactionsButton);

        viewBalanceButton = createButton("View Balances", 130, 230);
        addToContent(viewBalanceButton);

        logoutButton = createButton("Log out", 575, 135, "Gadugi", 23, 160, 40);
        addToContent(logoutButton);
    }
}
