package GUI.Menus;

import bankmain.ATM;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SetMonthMenu extends TemplateInterface {
    private JButton goBack;
    private JTextField monthTxtField;
    private JButton enterButton;


    public SetMonthMenu() {
        initialize();
        setVisible(true);
    }

    public JButton getGoBack() {
        return goBack;
    }

    public JTextField getMonthTxtField() {
        return monthTxtField;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    private JTextField createJTextField(int x, int y) {
        JTextField tempField = new JTextField();
        tempField.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 23));
        tempField.setColumns(10);
        tempField.setBounds(x, y, 100, 50);

        return tempField;
    }

    public void initialize() {
        setTitle("Set Month(s) Forward");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        goBack = createGoBackButton(25, 135);
        addToContent(goBack);

        JLabel month_label = createJLabel("Month(s) Forward", 150, 300, 35, 350, 50);
        addToContent(month_label);

        monthTxtField = createJTextField(500, 300);
        addToContent(monthTxtField);

        enterButton = createButton("Enter", 130, 510, "Franklin Gothic Medium",
                23, 500, 50);
        addToContent(enterButton);
    }
}
