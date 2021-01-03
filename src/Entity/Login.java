
package Entity;

import static Entity.Connecting.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login {
    
    public static String USERNAME;
    Statement stmt = null;
    ResultSet rs = null;
    public boolean LoginAdmin(String username,String password){
        return username.equals("admin") && password.equals("admin");
    }
    public boolean LoginUser(String username,String password){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                    String name1 = rs.getString(1);  
                    String name2 = rs.getString(2);
                    if(username.equals(name1) && password.equals(name2)) {
                        USERNAME = name1;
                        return true;
                    }
                } 
            } catch (SQLException ex) {}
        return false;
    }
}
