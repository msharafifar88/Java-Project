package SerializeStudent;

import java.io.Serializable;
import java.util.ArrayList;

/* This class creates a serializable student */
public class StudentSerializable implements Serializable {
    /* student's ID, student's first name, student's last name, student's courses */
    private int ID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    /* Constructor initializes Student to a safe and empty state */
    public StudentSerializable() {
        this.ID = 0;
        this.firstName = "";
        this.lastName = "";
        this.courses = new ArrayList<String>();
    }

    /* Constructor takes in an Integer, 2 Strings, and an ArrayList */
    public StudentSerializable(int stdID, String firstName, String lastName, ArrayList courses) {
        if (stdID > 0 && firstName != null && lastName != null && courses != null) {
            this.ID = stdID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.courses = new ArrayList<String>(courses);
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

    public ArrayList<String> getCourses() {
        return courses;
    }

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

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + getID()
                + "\nFirst Name: " + getFirstName()
                + "\nLast Name: " + getLastName()
                + "\nCourse: " + getCourses();
    }
}
