
package pos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DataBaseConnection {

    //Connection conn = null;
    public static Connection connectTODB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nextgenpos","root","");
          //  JOptionPane.showMessageDialog(null, "Connection Establishment");
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection Establishment Failed");
            return null;
        }
        
        
    }
    
}
