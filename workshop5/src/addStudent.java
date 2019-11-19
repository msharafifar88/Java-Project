import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class addStudent {


    public static void read(JPanel pane) {

        pane.removeAll();

        try {
//            FileOutputStream fs = new FileOutputStream("output.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fs);

            JLabel[] stdInfoPrompt = {
                    new JLabel("Student number: "),
                    new JLabel("Student's first name: "),
                    new JLabel("Student's last name: "),
                    new JLabel("Student's course: ")
            };

            ArrayList<JTextField> stdInfoInput = new ArrayList<JTextField>();

            JTextField studentID = new JTextField();
            JTextField studentFname = new JTextField();
            JTextField studentLname = new JTextField();
            JTextField studentCours = new JTextField();
            JTextField Error = new JTextField();

            JButton submit = new JButton("Submit");
            submit.setBounds(300, 300, 100, 50);

            JButton reset = new JButton("Reset");
            reset.setBounds(300, 300, 100, 50);

            JButton back = new JButton("Back");
            back.setBounds(300, 300, 100, 50);


            GridBagConstraints gbc = new GridBagConstraints();

            Student std = new Student();

            gbc.gridx = 0;
            gbc.gridy = 0;

            studentID.setColumns(15);
            studentID.setEditable(true);
            pane.add(stdInfoPrompt[0], gbc);
            gbc.gridx++;
            pane.add(studentID,gbc);
            gbc.gridx=0;
            gbc.gridy++;

            studentFname.setColumns(15);
            studentFname.setEditable(true);
            pane.add(stdInfoPrompt[1], gbc);
            gbc.gridx++;
            pane.add(studentFname,gbc);
            gbc.gridx=0;
            gbc.gridy++;

            studentLname.setColumns(15);
            studentLname.setEditable(true);
            pane.add(stdInfoPrompt[2], gbc);
            gbc.gridx++;
            pane.add(studentLname,gbc);
            gbc.gridx=0;
            gbc.gridy++;

            studentCours.setColumns(15);
            studentCours.setEditable(true);
            pane.add(stdInfoPrompt[3], gbc);
            gbc.gridx++;
            pane.add(studentCours,gbc );
            gbc.gridx=0;
            gbc.gridy++;


            pane.add(back, gbc);

            gbc.gridx++;
            pane.add(reset, gbc);
            gbc.gridx++;
            gbc.gridy++;

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipady = 40;
            gbc.weightx = 0.0;
            gbc.gridwidth = 3;
            gbc.gridx = 0;

            pane.add(submit, gbc);
            gbc.gridy++;

            Error.setColumns ( 40 );
            Error.setEditable(false);
            Error.setBackground ( Color.yellow );
            //gbc.anchor = GridBagConstraints.CENTER;
            Error.setText ( "                                                Error Messages" );
            pane.add(Error,gbc );
            pane.validate();

            back.addActionListener(e -> {
                try {
                   /* oos.flush();
                    fs.close();*/
                }catch (Throwable e1){
                    System.out.println(e1);
                }

                Menu.displayMenu(pane);
            });

            reset.addActionListener(e ->{
                studentID.setText ( "" );
                studentFname.setText ( "" );
                studentLname.setText ( "" );
                studentCours.setText ( "" );
                Error.setText ( "" );

            });

            submit.addActionListener(new ActionListener () {
                                         @Override
                         public void actionPerformed ( ActionEvent e ) {

                             try {
                                ArrayList<Student> Nejat = new ArrayList<Student> (  );
                                 Nejat = getStudent.loader ( Nejat );
                                 Student stdacc = new Student ( );

                                 String stdID =  studentID.getText ( );
                                 String Fname = studentFname.getText ();
                                 String Lname = studentLname.getText ();
                                 String stdcour = studentCours.getText ();
                                 String[] temp = stdcour.split ( "," );

                                 stdacc.setStdID (stdID);
                                 stdacc.setFirstName ( Fname );
                                 stdacc.setLastName ( Lname );
                                 stdacc.setCourses ( temp );

                                 Nejat.add(stdacc);
                                 putStudent.saver ( Nejat );



                                 studentID.setText ("");
                                 studentFname.setText ("");
                                 studentLname.setText ("");
                                 studentCours.setText ("");
                                 Error.setVisible (true );
                                 Error.setVisible (true );
                                 Error.setText ( "                       *******Student ADD *******" );

                             } catch ( Exception e1 ) {
                                 Error.setText (e1.getMessage ());
                                 System.out.println ( e1 );
                             }

                         }
                     });

            pane.validate();
            pane.repaint();
        } catch (Exception e) {

            System.out.println(e.getMessage ());
        }
    }
}
