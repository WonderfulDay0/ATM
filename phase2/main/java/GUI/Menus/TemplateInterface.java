package GUI.Menus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TemplateInterface extends JFrame {
    private JPanel contentPane;

    public TemplateInterface(){
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(createJLabelTitle());

        JPanel green_panel = createGreenPanel();
        contentPane.add(green_panel);

        JPanel dark_panel = createDarkPanel();
        contentPane.add(dark_panel);
    }

    public void addToContent(JComponent jComponent){
        contentPane.add(jComponent);
    }

    private JLabel createJLabelTitle() {
        JLabel title_label = new JLabel("Dank Bank");
        title_label.setVerticalAlignment(SwingConstants.BOTTOM);
        title_label.setForeground(Color.WHITE);
        title_label.setFont(new Font("Franklin Gothic Heavy", Font.ITALIC, 40));
        title_label.setBounds(25, 27, 800, 46);

        return title_label;
    }

    private JPanel createGreenPanel(){
        JPanel green_panel = new JPanel();
        green_panel.setBounds(0, 0, 800, 100);
        green_panel.setBackground(new Color(60, 179, 113));
        green_panel.setForeground(new Color(60, 179, 113));

        return green_panel;
    }

    private JPanel createDarkPanel(){
        JPanel dark_panel = new JPanel();
        dark_panel.setBounds(0, 10, 800, 100);
        dark_panel.setBackground(new Color(47, 79, 79));

        return dark_panel;
    }

    public JLabel createJLabel(String name, int x, int y, int fontSize, int width, int height) {
        JLabel label = new JLabel(name);
        label.setBackground(new Color(47, 79, 79));
//        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(47, 79, 79));
        label.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, fontSize));
        label.setBounds(x, y, width, height);

        return label;
    }

    public JButton createButton(String name, int x, int y, String fontName, int fontSize, int width, int height) {
        JButton tempButton = new JButton(name);
        tempButton.setForeground(Color.WHITE);
        tempButton.setFont(new Font(fontName, Font.BOLD, fontSize));
        tempButton.setBackground(new Color(47, 79, 79));
        tempButton.setBounds(x, y, width, height);

        return tempButton;
    }

    public JButton createGoBackButton(int x, int y) {
        JButton back = new JButton("Go Back");
        back.setBounds(x, y, 160, 40);
        back.setBackground(new Color(47, 79, 79));
        back.setForeground(new Color(255, 255, 255));
        back.setFont(new Font("Gadugi", Font.BOLD, 20));

        return back;
    }
}
