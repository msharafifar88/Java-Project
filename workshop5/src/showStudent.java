import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class showStudent {
    public static void show( JPanel pane) {

        pane.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        JTextArea txtArea = new JTextArea();

        JButton back = new JButton("Back");
        back.setBounds(300, 300, 100, 50);

        try {
            ArrayList<Student> Nejat = new ArrayList<Student> (  );
            Nejat = getStudent.loader ( Nejat );
            Student std = new Student ();
            for(int i=0;i<Nejat.size ();i++){
                std = Nejat.get ( i );

                    txtArea.append( std.toString()  );

            }

        } catch(Throwable e){
            System.err.println(e);
        }

        txtArea.setMinimumSize(new Dimension(350, 350));
        txtArea.setFont(txtArea.getFont().deriveFont(10.0f));

        JScrollPane scroll = new JScrollPane(txtArea);
        scroll.setPreferredSize(new Dimension(500,500));

        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(scroll, gbc);
        gbc.gridy++;
        pane.add(back, gbc);

        back.addActionListener(e ->{
            Menu.displayMenu(pane);
        });

        pane.validate();
        pane.repaint();

    }
}
