import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import javax.swing.ImageIcon;
public class Menu {

    public static void main(String[] args) throws IOException {

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Workshop 5");

            frame.setSize(new Dimension(600,600));
            JPanel input = new JPanel(new GridBagLayout());
            //input.setBackground ( Color.white );
            displayMenu(input);

            frame.add(input);
            frame.setVisible(true);
    }
    public static void displayMenu(JPanel input){
        input.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("Registration for Student");
        JLabel title1 = new JLabel("Menu");
        title.setFont(title.getFont ().deriveFont ( 30 ));
        title1.setFont(title1.getFont().deriveFont(15.0f));
        title.getFont( ).deriveFont ( 40 );
        JButton[] menuButtons = {
                new JButton("Add New Student" ),
                new JButton("Display Students"),
                new JButton("Exit")
        };

        menuButtons[0].addActionListener(e -> {
            addStudent.read (input);
        });

        menuButtons[1].addActionListener(e -> {
            showStudent.show ( input );
        });

        menuButtons[2].addActionListener(e -> System.exit(0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets ( -300,0,0,0 );
                input.add(title,gbc);
        gbc.gridy++;
        gbc.insets = new Insets(-50, 0, 0, 300);
        input.add(title1, gbc);
        gbc.gridy++;

        gbc.insets = new Insets(5, 0, 5, 0);
        for(JButton button : menuButtons){
            button.setFont(button.getFont().deriveFont(15.0f));
            button.setPreferredSize(new Dimension(350, 27));
            input.add(button, gbc);
            gbc.gridy++;
        }

        input.validate();
        input.repaint();
    }
}
