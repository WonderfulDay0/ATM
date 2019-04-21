package GUI.Menus;

import Transactions.Transaction;
import bankmain.ATM;


import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class ViewTransactions extends TemplateInterface {

    private ATM model;

    private JButton goBackButton;
    private JButton undoButton;
    private JList transactionJList;
    private JScrollPane transactionScrollPane;

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JList<Transaction> getTransactionJList() {
        return transactionJList;
    }

    public void updateTransactions(){
        transactionJList.setModel(new AbstractListModel() {
            List<Transaction> list = new ArrayList<>(model.getUserManager().getUser(model.getCurrentUser()).getTransactionMap().values());
            public int getSize() {
                return list.size();
            }
            public Object getElementAt(int index) {
                //TODO change this here to get what you want printed
                return list.get(index);
            }
        });
    }
    /**
     * Create the application.
     */
    public ViewTransactions(ATM model) {
        this.model = model;
        initialize();
    }

    private JLabel createLoginLabel(){
        JLabel login_label = new JLabel("Here are your transactions");
        login_label.setHorizontalAlignment(SwingConstants.CENTER);
        login_label.setForeground(new Color(60, 179, 113));
        login_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        login_label.setBounds(0, 191, 800, 50);
        return login_label;
    }

    private JList createTransactionList(){
        transactionJList = new JList();
        transactionJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateTransactions();
        transactionJList.setLayoutOrientation(JList.VERTICAL);
        transactionJList.setSize(500, 150);
        transactionJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        transactionJList.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 25));
        return transactionJList;
    }

    private JScrollPane createScrollPane(JList transactionL){
        transactionScrollPane = new JScrollPane();
        transactionScrollPane.setSize(500, 280);
        transactionScrollPane.setLocation(150, 280);
        transactionScrollPane.setViewportView(transactionL);
        return transactionScrollPane;
    }
    
    private JButton createUndoButton(){
        undoButton = new JButton("Undo");
        undoButton.setForeground(Color.WHITE);
        undoButton.setFont(new Font("Gadugi", Font.BOLD, 20));
        undoButton.setBackground(new Color(47, 79, 79));
        undoButton.setBounds(590, 580, 160, 40);
        return undoButton;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addToContent(createLoginLabel());

        goBackButton = createGoBackButton(25, 135);
        addToContent(goBackButton);

        transactionJList = createTransactionList();
        transactionScrollPane = createScrollPane(transactionJList);
        addToContent(transactionScrollPane);

        undoButton = createUndoButton();
        addToContent(undoButton);
    }
}
