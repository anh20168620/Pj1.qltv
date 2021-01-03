
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connecting {
	public static Connection conn = null;
	private static final String url       = "jdbc:mysql://localhost:3306/qltv";
    private static final String user      = "root";
    private static final String password  = "159159159anh";
	
    public static Connection connecting(){
    	
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Ket noi database thanh cong");
        } catch (SQLException ex) {
            System.out.println("Ket noi database that bai");
        }
        
        return conn;
    }
    public void Connected(){
        conn = connecting();
        
    }
    public void Close() throws SQLException{
        if(conn != null) conn.close();
        System.out.println("close database");
    }
}
