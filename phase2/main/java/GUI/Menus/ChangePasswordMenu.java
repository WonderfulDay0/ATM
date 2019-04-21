package GUI.Menus;

import bankmain.ATM;


import javax.swing.*;
import java.awt.Font;
import java.awt.Color;


public class ChangePasswordMenu extends TemplateInterface {

    private JPasswordField oldPasswordField, newPasswordField, confirmPasswordField;
    private JButton back_button, change_pass_button;

    private JLabel createOldPassLabel(){
        JLabel oldPassword_label = new JLabel("Enter Old Password");
        oldPassword_label.setForeground(new Color(47, 79, 79));
        oldPassword_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        oldPassword_label.setBounds(100, 230, 270, 50);
        return oldPassword_label;
    }

    private JTextField createOldPassField(){
        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(370, 230, 300, 50);
        return oldPasswordField;
    }

    private JLabel createNewPassLabel(){
        JLabel newPassword_label = new JLabel("Enter New Password");
        newPassword_label.setForeground(new Color(47, 79, 79));
        newPassword_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        newPassword_label.setBounds(100, 330, 270, 50);
        return newPassword_label;
    }

    private JPasswordField createNewPassField(){
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(370, 330, 300, 50);
        return newPasswordField;
    }

    private JLabel createConfirmLabel(){
        JLabel confirm_label = new JLabel("Confirm Password");
        confirm_label.setForeground(new Color(47, 79, 79));
        confirm_label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 25));
        confirm_label.setBounds(100, 430, 270, 50);
        return confirm_label;
    }

    private JPasswordField createConfirmField(){
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(370, 430, 300, 50);
        return confirmPasswordField;
    }

    private JButton createChangeButton(){
        JButton change_pass_button = new JButton("Change Password");
        change_pass_button.setForeground(Color.WHITE);
        change_pass_button.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 23));
        change_pass_button.setBackground(new Color(47, 79, 79));
        change_pass_button.setBounds(130, 530, 500, 50);
        return change_pass_button;
    }

    public JPasswordField getOldPasswordField(){
        return oldPasswordField;
    }

    public JPasswordField getNewPasswordField(){
        return newPasswordField;
    }

    public JPasswordField getConfirmPasswordField(){
        return confirmPasswordField;
    }

    public JButton getBackButton(){
        return back_button;
    }

    public JButton getChangePassButton(){
        return change_pass_button;
    }

    public ChangePasswordMenu(ATM atm) {
        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        back_button = createGoBackButton(25, 135);
        addToContent(back_button);

        addToContent(createOldPassLabel());

        addToContent(createOldPassField());

        addToContent(createNewPassLabel());

        addToContent(createNewPassField());

        addToContent(createConfirmLabel());

        addToContent(createConfirmField());

        change_pass_button = createChangeButton();
        addToContent(change_pass_button);
    }
}
