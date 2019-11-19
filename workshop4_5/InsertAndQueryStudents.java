import java.sql.*;

public class InsertAndQueryStudents {
    public void insertStudents(String firstname, String lastname, int ID, String course) {
        Connection con = null;
        Statement stmt = null;

        try {
            // 2. Get connection and statements objects
            con = DriverManager.getConnection(ConnectionValues.URL, ConnectionValues.USER_NAME, ConnectionValues.PASS_WORD);
            stmt = con.createStatement();

            // 3. Execute JDBC commands
            stmt.executeUpdate("insert into Students " + "VALUES ('"+ ID + "', '"+ firstname + "', '"+ lastname + "','"+ course + "')");
            System.out.println(stmt);

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

    public String queryStudents() {
        Connection con = null;
        Statement stmt = null;
        String studentInfo = "";

        try {
            con = DriverManager.getConnection(ConnectionValues.URL, ConnectionValues.USER_NAME, ConnectionValues.PASS_WORD);
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * FROM Students");

            System.out.println("Students information:");
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("LASTNAME");
                String course = rs.getString("COURSE");
                System.out.println(ID + " \t  " + firstname + " \t  " + lastname + " \t  " + course);
                studentInfo += ("{ ID: " + ID + " \n Name: " + lastname + ", " + firstname + " \n Course: " + course + " }\n\n");
            }

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
        return studentInfo + "<---End of File--->\n\n";
    }
}