
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class UpdateInformation {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public void Update(String password,String name,String phone,String email,String cmnd,String username){
        String Update = "update rguser set password = ?, name = ?,phone = ?,email = ?,cmnd = ? where username = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username = '"+username+"'");
            while(rs.next()){
                    int conlai = rs.getInt(3) - 1;
                    System.out.println(""+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setString(1,password);
                    ptmt.setString(2, name);
                    ptmt.setString(3, phone);
                    ptmt.setString(4, email);
                    ptmt.setString(5, cmnd);
                    ptmt.setString(6, username);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "update thành công");
                    }
                    ptmt.close();
            }
        
        } catch (SQLException ex) {
            System.out.println("fail update");
        }
    }
    public String getPassword(String username){
        String password = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        password = rs.getString(2);
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
        return password;
    }
    public String getName(String username){
        String name = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        name = rs.getString(3);
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
        return name;
    }
    public String getPhone(String username){
        String phone = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        phone = rs.getString(4);
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
        return phone;
    }
    public String getEmail(String username){
        String email = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        email = rs.getString(5);
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
        return email;
    }
    public String getCmnd(String username){
        System.out.println(""+username);
        String cmnd = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username like '"+username+"'");
            while(rs.next()){
                    if(rs.getString(1).equals(username))
                        cmnd = rs.getString(6);
                }
        } catch (SQLException ex) {
            System.out.println("cant load");
        }
        return cmnd;
    }
}
