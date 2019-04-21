package GUI.Menus;

import Accounts.Account;
import Managers.ATMManager;
import Managers.TransactionManager;
import Managers.UserManager;
import Transactions.Transaction;
import bankmain.ATM;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUserAccountsInfo extends TemplateInterface {
    private JButton backButton;
    private JList<Account> accountJList;
    private ATM model;
    private String currentUser;

    private JLabel lblAccount;
    private JLabel lblDateCreated;
    private JLabel lblType;
    private JLabel lblAmount;

    public JLabel getLblAccount() {
        return lblAccount;
    }

    public JLabel getLblDateCreated() {
        return lblDateCreated;
    }

    public JLabel getLblType() {
        return lblType;
    }

    public JLabel getLblAmount() {
        return lblAmount;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JList<Account> getAccountJList() {
        return accountJList;
    }

    private JList createAccountList(){
        JList accountList = new JList();
        accountList.setBackground(new Color(240, 255, 240));
        accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountList.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 25));
        accountList.setModel(new AbstractListModel() {
            List<Account> list = new ArrayList<>(model.getUserManager().getUser(currentUser).getAccountMap().values());
            public int getSize() {
                return list.size();
            }
            public Object getElementAt(int index) {
                //TODO change this here to get what you want printed
                return list.get(index);
            }
        });
        System.out.println(accountList.getModel().getElementAt(0));
        accountList.setBounds(39, 250, 251, 260);

        return accountList;
    }

    public EmployeeUserAccountsInfo(ATM model, String currentUser){
        this.model = model;
        this.currentUser = currentUser;
        initialize();
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ATMManager am = new ATMManager();
                    UserManager um = new UserManager();
                    TransactionManager tm = new TransactionManager(um.getUserMap());
                    ATM atm = new ATM(am, um, tm);

                    EmployeeUserAccountsInfo frame = new EmployeeUserAccountsInfo(atm, "m");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("User Account Information");

        backButton = createGoBackButton(30, 140);
        addToContent(backButton);

        JLabel lblUserAccounts = new JLabel("User's Accounts");
        lblUserAccounts.setBounds(50, 180, 200, 50);
        lblUserAccounts.setForeground(new Color(47, 79, 79));
        lblUserAccounts.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        addToContent(lblUserAccounts);

        accountJList = createAccountList();
        Account firstAcc = accountJList.getModel().getElementAt(0);

        JScrollPane scrollPane = new JScrollPane(accountJList);
        scrollPane.setSize(260, 400);
        scrollPane.setLocation(20, 230);
        scrollPane.setViewportView(accountJList);
        addToContent(scrollPane);

        lblAccount = new JLabel("Account: " + firstAcc.getAccountID());
        lblAccount.setBounds(320, 230, 400, 50);
        addToContent(lblAccount);
        lblAccount.setForeground(new Color(47, 79, 79));
        lblAccount.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));

        lblDateCreated = new JLabel("Date Created: " + firstAcc.printCreationDate());
        lblDateCreated.setForeground(new Color(47, 79, 79));
        lblDateCreated.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        lblDateCreated.setBounds(320, 350, 400, 50);
        addToContent(lblDateCreated);

        lblType = new JLabel("Type: " + firstAcc.getType());
        lblType.setForeground(new Color(47, 79, 79));
        lblType.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        lblType.setBounds(320, 290, 400, 50);
        addToContent(lblType);

        lblAmount = new JLabel("Amount: $" + String.format("%.2f",firstAcc.getBalance()));
        lblAmount.setForeground(new Color(47, 79, 79));
        lblAmount.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        lblAmount.setBounds(320, 410, 400, 50);
        addToContent(lblAmount);

    }
}
