package GUI.Menus;



import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class EmployeeLogin extends TemplateInterface{

    private JLabel loginLabel;
    private JButton userButton;
    private JButton employeeButton;

    public EmployeeLogin() {
        super();
        initialize();
        setVisible(true);
    }

    public JButton getUserButton() {
        return userButton;
    }

    public JButton getEmployeeButton() {
        return employeeButton;
    }

    private JButton createJButton(String name, int x, int y) {
        JButton butt = new JButton(name);
        butt.setForeground(Color.WHITE);
        butt.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        butt.setBackground(new Color(47, 79, 79));
        butt.setBounds(x, y, 500, 50);

        return butt;
    }

    private void initialize() {
        setTitle("Employee Login");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        loginLabel= new JLabel("How do you want to login?");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(new Color(60, 179, 113));
        loginLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 35));
        loginLabel.setBounds(130, 190, 500, 50);
        addToContent(loginLabel);

        userButton = createJButton("As User", 130, 300);
        addToContent(userButton);

        employeeButton = createButton("As Employee", 130, 420, "Franklin Gothic Medium", 23, 500, 50);
        addToContent(employeeButton);
    }
}
