package GUI.Menus;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class DepositMenu extends TemplateInterface {

    private JButton backButton;
    private JButton depositChequeButton;
    private JButton depositCashButton;

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getDepositChequeButton() {
        return depositChequeButton;
    }

    public JButton getDepositCashButton() {
        return depositCashButton;
    }

    private void initialize() {
        setTitle("Deposit Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel settings_label = new JLabel("Cash or Cheque?");
        settings_label.setForeground(new Color(60, 179, 113));
        settings_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        settings_label.setHorizontalAlignment(SwingConstants.CENTER);
        settings_label.setBounds(230, 190, 300, 50);
        addToContent(settings_label);

        depositChequeButton = createButton("Cheque", 130, 300, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(depositChequeButton);

        depositCashButton = createButton("Cash", 130, 420, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(depositCashButton);

        backButton = createGoBackButton(25, 135);

        addToContent(backButton);
    }

    public DepositMenu() {
        initialize();
        setVisible(true);
    }
}
