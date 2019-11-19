package SerializeStudent;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

public class WriteStudent {

    /*public static void writeStd(ArrayList<StudentSerializable> students) {

        try {
            FileOutputStream fos = new FileOutputStream("testFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(students);

            oos.flush();
            fos.close();

            System.out.println("<---WRITE STUDENT INFORMATION-->");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("\n" + students.get(i).toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }*/

     public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean outerFlag = true;

        ArrayList<StudentSerializable> students = new ArrayList<StudentSerializable>();

        while (outerFlag) {
            StudentSerializable student = new StudentSerializable();

            System.out.println("<---STUDENT INFORMATION BEFORE--->");
            System.out.println(student.toString() + "\n");

            System.out.println("Please enter new student information." + "\n");

            System.out.println("Enter Student ID: ");
            student.setID(sc.nextInt());

            System.out.println("Enter First Name: ");
            student.setFirstName(sc.next());

            System.out.println("Enter Last Name: ");
            student.setLastName(sc.next());

            System.out.println("Enter Courses: (type 'exit' or 'Exit' then press Return/Enter key to finish adding courses)");
            boolean innerFlag = true;

            while (innerFlag) {
                String course = sc.next();

                if (!course.equals("exit") && !course.equals("Exit")) {
                    student.addCourse(course);
                    //studentWrite.getCourses().add(course);
                } else {
                    innerFlag = false;
                    System.out.println("\n");
                }
            }
            students.add(student);

            System.out.println("<---STUDENT INFORMATION AFTER--->");
            System.out.println(student.toString() + "\n");

            System.out.println("Add another Student? (yes/no)");
            String choice = sc.next();

            if (choice.equals("no")) {
                outerFlag = false;
            }
        }
         try {
             FileOutputStream fos = new FileOutputStream("testFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos);

             oos.writeObject(students);

             oos.flush();
             fos.close();

             System.out.println("<---WRITE STUDENT INFORMATION-->");
             for (int i = 0; i < students.size(); i++) {
                 System.out.println("\n" + students.get(i).toString());
             }
         } catch (Throwable e) {
             System.err.println(e);
         }
    }
}
