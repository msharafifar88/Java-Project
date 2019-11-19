
import java.util.ArrayList;
import java.util.Scanner;
public class AddStudent {

    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student> (  );
        array = getStudent.loader ( array );
        try {
            System.out.println ( "------->JAC 444 Workshop 3<--------" );
            System.out.println ( "------------->Task 1 <-------------" );
            int option = 0;
            int stdID = 0;
            String firstName = null;
            String lastName = null;
            String[] courses = null;
            boolean error = false;
            boolean flag = true;
            while ( option != 3 && flag) {
                try {
                        System.out.println ( "\n1. Add Student" );
                        System.out.println ( "2. Show Data" );
                        System.out.println ( "3. Exit\n" );
                        System.out.print ( "Enter the Number : " );
                        Scanner in = new Scanner ( System.in );
                        option = in.nextInt ( );
                    if(option >0 ) {
                        switch (option) {
                            case 1:
                                System.out.println ( "\nEnter Student Account Details" );
                                System.out.println ( "---------------------" );
                                Boolean errorid = true;
                                do {

                                try {
                                    System.out.print ( "Student ID : " );
                                    String sid = in.next ();

                                    stdID = Integer.parseInt ( sid );
                                    if (stdID <0 ){
                                        throw new Exception ( "Invalid student ID! ID Should be positive and not have Character" );
                                    }
                                    errorid = false;

                                } catch ( Exception l ) {

                                    System.out.println ( "Invalid student ID!" );
                                }
                                } while (errorid);
                                 do {
                                System.out.print ( "First Name : " );
                                firstName = in.next ( );
                                if ( firstName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "First Name should be atleast 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                } while ( error == true );
                                 do {
                                System.out.print ( "Last Name : " );
                                lastName = in.next ( );
                                if ( lastName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "Last Name should be atleast 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                  }
                                 while ( error == true );
                                System.out.print ( "**** NOTE **** \n separate courses by ' , ' \n" );
                                System.out.print ( "courses : " );
                                String oneline = in.next ( );
                                String[] Tempcourses = oneline.split ( "," );
                                courses = Tempcourses;

                                if ( lastName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "courses should be atleast 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                Student account = new Student ( stdID, firstName, lastName, courses );
                                array.add(account);
                                putStudent.saver ( array );
                                break;
                            case 2:

                                getStudent.read ( );
                                break;
                            case 3:
                                System.out.println ( "\nThank You!\n" );
                                flag = false;
                                break;
                            default:
                                System.out.println ( "NOT VALID OPTION" );
                                break;
                        }
                    }
                } catch ( Exception e ) {
                    System.out.println ( "Please Enter Valid Number From Given Options!\n" );
                }
            }
        } catch ( Exception e ) {
            System.out.println ( e );
        }
    }
}
