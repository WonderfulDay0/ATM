package GUI.Menus;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class TransactionMenu extends TemplateInterface {

    private JButton backButton;
    private JButton billButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton sendButton;
    private JButton depositButton;

    public JButton getBackButton(){
        return backButton;
    }

    public JButton getBillButton(){
        return billButton;
    }

    public JButton getWithdrawButton(){
        return withdrawButton;
    }

    public JButton getTransferButton(){
        return transferButton;
    }

    public JButton getSendButton(){
        return sendButton;
    }

    public JButton getDepositButton(){
        return depositButton;
    }

    private JLabel createTransactionLabel(){
        JLabel transaction_label = new JLabel("Choose a Transaction");
        transaction_label.setForeground(new Color(60, 179, 113));
        transaction_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        transaction_label.setHorizontalAlignment(SwingConstants.CENTER);
        transaction_label.setBounds(162, 175, 440, 50);

        return transaction_label;
    }
    public TransactionMenu(){
        initializer();
        setVisible(true);
    }

    /**
     * Create the frame.
     */
    private void initializer() {
        setTitle("Transactions Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel transaction_label = createTransactionLabel();
        addToContent(transaction_label);

        withdrawButton =  createButton("Withdraw Cash", 130, 240, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(withdrawButton);

        transferButton =  createButton("Transfer Money", 130, 316, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(transferButton);

        sendButton =  createButton("Send Money", 130, 389, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(sendButton);

        billButton =  createButton("Pay Bills", 130, 465, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(billButton);

        depositButton = createButton("Deposit", 130, 540, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(depositButton);

        backButton = createGoBackButton(25, 135);
        addToContent(backButton);

    }
}

