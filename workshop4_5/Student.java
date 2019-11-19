import java.io.Serializable;
import java.util.ArrayList;

/* This class creates a student */
public class Student /*implements Serializable*/ {
    /* student's ID, student's first name, student's last name, student's courses */
    private int ID;
    private String firstName;
    private String lastName;
    //private ArrayList<String> courses;
    private String course;

    /* Constructor ... */
    public Student() {
        this.ID = 0;
        this.firstName = "";
        this.lastName = "";
        //this.courses = new ArrayList<String>();
        this.course = "";
    }

    /* Constructor takes in an Integer, 3 Strings */
    public Student(int stdID, String firstName, String lastName, String course) {
        if (stdID > 0 && firstName != null && lastName != null && course != null) {
            this.ID = stdID;
            this.firstName = firstName;
            this.lastName = lastName;
            //this.courses = new ArrayList<String>(courses);
            this.course = course;
        }
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() { return course; }

    public void setID(int stdID) {
        if (stdID > 0) {
            this.ID = stdID;
        }
    }

    public void setFirstName(String firstName) {
        if (!firstName.equals("")) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (!lastName.equals("")) {
            this.lastName = lastName;
        }
    }

    public  void setCourse(String course) {
        if (!course.equals("")) {
            this.course = course;
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + getID()
                + "\nFirst Name: " + getFirstName()
                + "\nLast Name: " + getLastName()
                + "\nCourse: " + getCourse();
    }
}
