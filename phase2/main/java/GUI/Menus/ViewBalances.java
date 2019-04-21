package GUI.Menus;

import Accounts.Account;
import bankmain.ATM;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class ViewBalances extends TemplateInterface {

    private ATM model;
    private JButton goBackButton;

    /**
     * Create the application.
     */
    public ViewBalances(ATM model) {
        this.model = model;
        initialize();
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    private JLabel createLoginLabel() {
        JLabel login_label = new JLabel("Here are your balances:");
        login_label.setHorizontalAlignment(SwingConstants.CENTER);
        login_label.setForeground(new Color(60, 179, 113));
        login_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        login_label.setBounds(180, 191, 425, 50);
        return login_label;
    }

    private JLabel createNetTotalLabel() {
        JLabel netTotal_label = new JLabel("Net Total: $" +
                String.format("%.2f", model.getUserManager().getUserMap().get(model.getCurrentUser()).calcNetTotal()));
        netTotal_label.setHorizontalAlignment(SwingConstants.LEADING);
        netTotal_label.setForeground(new Color(60, 179, 113));
        netTotal_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        netTotal_label.setBounds(180, 590, 425, 50);

        return netTotal_label;
    }

    private JList createAccountList(){
        JList account_list = new JList();
        account_list.setEnabled(false);
        account_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        account_list.setModel(new AbstractListModel() {
            List<Account> list = new ArrayList<>(model.getUserManager().getUser(model.getCurrentUser()).getAccountMap().values());

            public int getSize() {
                return list.size();
            }

            public Object getElementAt(int index) {
                //TODO change this here to get what you want printed
                return list.get(index);
            }
        });
        account_list.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 25));
        account_list.setVisibleRowCount(10);
        account_list.setBounds(170, 260, 800, 500);

        return account_list;
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel login_label = createLoginLabel();
        addToContent(login_label);

        JLabel netTotal_label = createNetTotalLabel();
        addToContent(netTotal_label);

        goBackButton = createGoBackButton(25, 135);
        addToContent(goBackButton);

        JList account_list = createAccountList();
        addToContent(account_list);
    }
}
