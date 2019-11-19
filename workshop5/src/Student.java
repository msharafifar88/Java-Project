import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Student implements Serializable {
    private String stdID;
    private String FirstName;
    private String LastName;
    private String[] Courses;

    public Student () {
        this.stdID = "";
        this.FirstName = "";
        this.LastName = "";
        this.Courses = null;
    }

    public Student ( String stdID, String fname, String lname, String[] stdcour ) throws Exception {
        if ( stdID != null && fname != null && lname != null && stdcour != null ) {
            this.stdID = stdID;
            FirstName = fname;
            LastName = lname;
            Courses = stdcour;
        }
        throw new Exception ( "Input IS Empty" );
    }
    public String getStdID () {
        return stdID;
    }

    public String getFirstName () {
        return FirstName;
    }

    public String getLastName () {
        return LastName;
    }

    public String[] getCourses () {
        return Courses;
    }

    public void setStdID ( String stdID ) throws Exception {

        if (  Pattern.matches ( "[0-9]+", stdID ) ) {
            this.stdID = stdID;
        } else {

            throw new Exception ( "Student ID Not Valid" );
        }
    }
    public void setFirstName ( String firstName ) throws Exception {
        if ( firstName.length ( ) > 0 ) {
            FirstName = firstName;
        } else {
            throw new Exception ( "First name can not be Empty" );
        }
    }

    public void setLastName ( String lastName ) throws Exception {
        if ( lastName.length ( ) > 0 ) {
            LastName = lastName;
        } else {
            throw new Exception ( "Last name can not be Empty" );
        }
    }
    public void setCourses ( String[] courses ) throws Exception {

        if(!courses[0].equals ( new String (  ) )){
        Courses = courses;
        }

        else {

            throw new Exception ( "Courses can not be Empty" );}
    }

    @Override
    public String toString() {
        return ("Student ID  =  " +getStdID() +
                "\nFirstName   =  " + getFirstName() +
                "\nLastName   =  " + getLastName() +
                "\nCourses      =  " + Arrays.toString (getCourses())  +"\n\n **************************\n\n");
    }
}


