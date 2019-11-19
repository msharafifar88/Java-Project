import java.io.Serializable;
import java.util.Arrays;
public class Student implements Serializable {
private int stdID;
private String FirstName;
private String LastName;
private String[] Courses;

public Student(){
    this.stdID =0;
    this.FirstName ="";
    this.LastName = "";
    this.Courses = null;
}
    public Student( int stdID, String firstName, String lastName, String[] courses) {
        if( stdID >0 && firstName != null && lastName != null && courses != null){
            this.setStdID ( stdID );
            this.setFirstName ( firstName );
            this.setLastName ( lastName );
            setCourses(courses);
        }
    }
    public int getStdID() {
        return stdID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCourses () {
       return Arrays.toString ( Courses );
    }

    public void setStdID( int stdID) {
        this.stdID = stdID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCourses( String[] Courses) {
        this.Courses = Courses;
    }

    @Override
    public String toString() {
        return ("Student ID" +getStdID() +
                "\nFirstName= " + getFirstName() +
                "\nLastName= " + getLastName() +
                "\nCourses= " +getCourses());
    }
}


