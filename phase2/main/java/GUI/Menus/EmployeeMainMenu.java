package GUI.Menus;

import Managers.ATMManager;
import Managers.TransactionManager;
import Managers.UserManager;
import bankmain.ATM;

import javax.swing.*;
import java.awt.EventQueue;

import java.awt.Font;

public class EmployeeMainMenu extends TemplateInterface {
    private JTextField textField;
    private JButton searchButton;
    private JButton setDateButton;
    private JButton backButton;

    public JTextField getTextField() {
        return textField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getSetDateButton() {
        return setDateButton;
    }

    public JButton getBackButton(){
        return backButton;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserManager um = new UserManager();
                    ATMManager atmm = new ATMManager();
                    TransactionManager tm = new TransactionManager(null);
                    ATM at = new ATM(atmm, um, tm);
                    um.createUser("hello", "hello");
                    um.createUser("hello2222", "hello");
                    EmployeeMainMenu window = new EmployeeMainMenu(at);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public EmployeeMainMenu(ATM atm) {
        //todo: Need to create a logout for this menu!
        //frame = new JFrame();
        setTitle("Employee Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel search_label = createJLabel("Enter a username from below", 130, 190, 35,
                500, 50);
        search_label.setHorizontalAlignment(SwingConstants.CENTER);
        ;
        addToContent(search_label);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

        searchButton = createButton("Search", 130, 500, "Franklin Gothic Medium",
                23, 500, 50);
        addToContent(searchButton);

        setDateButton = createButton("Set Date", 130, 570, "Franklin Gothic Medium",
                23, 500, 50);
        addToContent(setDateButton);

        textField = new JTextField();
        textField.setBounds(130, 260, 500, 50);
        textField.setColumns(10);
        addToContent(textField);

        JList list = new JList();
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setEnabled(false);
        list.setSize(500, 150);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 25));
        list.setModel(new AbstractListModel() {
            String[] values = atm.getUserList();

            public int getSize() {
                return values.length;
            }

            public Object getElementAt(int index) {
                return values[index];
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setSize(500, 150);
        scrollPane.setLocation(130, 330);
        scrollPane.setViewportView(list);
        addToContent(scrollPane);
    }
}
