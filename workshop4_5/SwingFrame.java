import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SwingFrame extends JFrame {
    private final JSplitPane splitPane;
    private final JPanel formPanel, outputPanel, buttonPanel;
    private final JScrollPane scrollPane;
    private final JLabel labelID, labelFN, labelLN, labelCx;
    private final JTextField fieldID, fieldFN, fieldLN, fieldCx;
    private final JTextArea areaOutput; // let the application read the information and show user the output
    private final JButton writeButton, readButton;  // let the user save/view entered information
    ArrayList<Student> studentsWrite = new ArrayList<>();
    //ArrayList<Student> studentsRead = new ArrayList<>();

    public SwingFrame() {
        super("Add Student to Database");

        splitPane = new JSplitPane();

        formPanel = new JPanel();
        buttonPanel = new JPanel();
        labelID = new JLabel("Student ID: ");
        labelFN = new JLabel("First Name: ");
        labelLN = new JLabel("Last Name: ");
        labelCx = new JLabel("Course: ");

        fieldID = new JTextField(20);
        fieldFN = new JTextField(20);
        fieldLN = new JTextField(20);
        fieldCx = new JTextField(20);

        writeButton = new JButton("Add Student");
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String[] courses;
                try {
                    if (fieldID.getText().equals("") || fieldFN.getText().equals("") || fieldLN.getText() == null || fieldCx.getText() == null) {
                        JOptionPane.showMessageDialog(SwingFrame.this, String.format(
                                "Incorrect student information", JOptionPane.PLAIN_MESSAGE));
                        ;
                    } else {
                        Student student = new Student();
                        student.setID(Integer.parseInt(fieldID.getText()));
                        student.setFirstName(fieldFN.getText());
                        student.setLastName(fieldLN.getText());
                        student.setCourse(fieldCx.getText());
                        //courses = textFieldCx.getText().split(",");
                        //student.setCourses(new ArrayList<>(Arrays.asList(courses)));
                        studentsWrite.add(student);
                        System.out.println(student.getID());
                        System.out.println(student.getFirstName());
                        System.out.println(student.getLastName());
                        System.out.println(student.getCourse());
                        InsertAndQueryStudents is = new InsertAndQueryStudents();
                        is.insertStudents(student.getFirstName(), student.getLastName(), student.getID(), student.getCourse());
                        //WriteStudent.writeStd(studentsWrite);
                        fieldID.setText("");
                        fieldFN.setText("");
                        fieldLN.setText("");
                        fieldCx.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingFrame.this, String.format(
                            "Incorrect student information", JOptionPane.PLAIN_MESSAGE));
                }
            }
        });
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Form"));
        formPanel.setLayout(new GridBagLayout());
        buttonPanel.setLayout(new GridLayout());

        outputPanel = new JPanel();
        areaOutput = new JTextArea(100, 100);
        scrollPane = new JScrollPane(areaOutput);
        //scrollPane.setViewportView(areaOutput);

        readButton = new JButton("Print All Students");
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*studentsRead = ReadStudent.readStd();
                for (int i = 0; i < studentsRead.size(); i++) {
                    areaOutput.append((studentsRead.get(i).getID()) + "\n");
                    areaOutput.append(studentsRead.get(i).getFirstName() + "\n");
                    areaOutput.append(studentsRead.get(i).getLastName() + "\n");
                    areaOutput.append(studentsRead.get(i).getCourse() + "\n");
                }*/
                InsertAndQueryStudents is = new InsertAndQueryStudents();
                String stdOut = is.queryStudents();
                areaOutput.append(stdOut);
            }
        });
        outputPanel.setBorder(BorderFactory.createTitledBorder("Students Info Display"));
        outputPanel.setLayout(new GridLayout());

        //setPreferredSize(new Dimension(800, 800));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(500);
        splitPane.setLeftComponent(formPanel);
        splitPane.setRightComponent(outputPanel);
        /*splitPane.add(outputPanel, BorderLayout.EAST);
        splitPane.add(detailsPanel, BorderLayout.WEST);*/

        GridBagConstraints gc = new GridBagConstraints();

        /////// Left Columns ///////////////////////
        /////// First Column ///////////////////////////

        gc.weighty = 0.5;
        gc.weightx = 0.5;
        //gc.anchor = gc.LINE_END;

        gc.gridx = 0;
        gc.gridy = 0;
        formPanel.add(labelID, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        formPanel.add(labelFN, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        formPanel.add(labelLN, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        formPanel.add(labelCx, gc);

        /////// Second Column /////////////////////////

        gc.anchor = gc.LINE_START;

        gc.gridx = 1;
        gc.gridy = 0;
        formPanel.add(fieldID, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        formPanel.add(fieldFN, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        formPanel.add(fieldLN, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        formPanel.add(fieldCx, gc);

        /////// Button Columns ///////////////////////

        buttonPanel.add(writeButton);
        buttonPanel.add(readButton);

        gc.weighty = 2;
        gc.anchor = gc.FIRST_LINE_START;

        gc.gridx = 1;
        gc.gridy = 4;
        formPanel.add(buttonPanel, gc);

        /////// Right Columns ///////////////////////

        outputPanel.add(scrollPane);
    }

    public void createSQLTable() {
        Connection con = null;
        Statement stmt = null;

        String createString = "create table Students " + "( ID int, " + "FIRSTNAME varchar(32), " + "LASTNAME varchar(32), " + "COURSE varchar(16))";

        try {
            // 2. Get connection and statements objects
            con = DriverManager.getConnection(ConnectionValues.URL, ConnectionValues.USER_NAME, ConnectionValues.PASS_WORD);
            stmt = con.createStatement();

            // 3. Execute JDBC commands
            stmt.execute("DROP TABLE IF EXISTS Students");
            stmt.executeUpdate(createString);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());

        } finally {
            try {
                // 4. Close the connection and statement
                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();
            } catch (Exception ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingFrame studentFrame = new SwingFrame();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                studentFrame.setSize(1000, 500);
                studentFrame.setVisible(true);

                studentFrame.createSQLTable();
            }
        });
    }
}
