package SerializeStudent;

import java.io.*;
import java.util.ArrayList;

public class ReadStudent {

    /*public static ArrayList<StudentSerializable> readStd() {
        ArrayList<StudentSerializable> students = new ArrayList<StudentSerializable>();

        try {
            FileInputStream fis = new FileInputStream("testFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = (ArrayList<StudentSerializable>) ois.readObject();

            fis.close();
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        return students;
    }*/


    public static void main(String[] args) throws IOException {
        ArrayList<StudentSerializable> students = new ArrayList<StudentSerializable>();
        try {
            FileInputStream fis = new FileInputStream("testFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = (ArrayList<StudentSerializable>) ois.readObject();

            fis.close();
        }
        catch (Throwable e) {
            System.err.println(e);
        }
        System.out.println("<---READ STUDENT INFORMATION-->");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("\n" + students.get(i).toString());
        }
    }
}
