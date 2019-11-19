import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class putStudent {
    public static void saver( ArrayList<Student> output) {
        try {
            FileOutputStream fis = new FileOutputStream ( "StudentAccount.bin" );
            ObjectOutputStream ois = new ObjectOutputStream ( fis );
            ois.writeObject ( output );
        } catch ( FileNotFoundException e ) {
            System.out.println ( e.getMessage ( ) );
        } catch ( IOException e ) {
            System.out.println ( e.getMessage ( ) );
        } catch (Exception e ) {
            System.out.println ( e.getMessage ( ) );
        }
    };
}
