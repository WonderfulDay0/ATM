package GUI.Prompts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PromptTemplate extends JFrame {
    private JPanel contentPane;

    public PromptTemplate(){
        setEnabled(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public JLabel createMainLabel(String s1){
        JLabel label1 = new JLabel(s1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(60, 179, 113));
        label1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
        label1.setBounds(0, 50, 425, 50);
        return label1;
    }

    public JLabel createSecondaryLabel(String s2){
        JLabel label2 = new JLabel(s2);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(new Color(0, 0, 0));
        label2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
        label2.setBounds(0, 96, 425, 30);
        return label2;
    }

    public JLabel createTryAgainLabel(){
        JLabel label3 = new JLabel("Please try again!");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
        label3.setForeground(new Color(0, 0, 0));
        label3.setBounds(0, 125, 425, 30);
        return label3;
    }

    public void addToContent(Component comp){
        contentPane.add(comp);
    }
}
