
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ManageRegister {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public boolean CheckAccept(String username){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser");
            while (rs.next()) {
                    String name = rs.getString(1);
                    String trangthai = rs.getString(8);
                    if(username.equals(name) && trangthai.equals("Thành Viên")) {
                        JOptionPane.showMessageDialog(null, "Đã là thành viên");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
    public boolean CheckRemove(String username){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser");
            while (rs.next()) {
                String name = rs.getString(1);
                String trangthai = rs.getString(8);
                if(username.equals(name) && trangthai.equals("chưa là thành viên")) {
                    JOptionPane.showMessageDialog(null, "Chưa là thành viên");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
        return true;
    }
    public void DeleteUser(String del){
        String delete = "delete from rguser where username = ?";
        try {
            ptmt = conn.prepareStatement(delete);
            ptmt.setString(1,del); 
            ptmt.execute();
        } catch (SQLException ex) {}
    }
    public void AcceptUser(String name){
        String Update = "update rguser set trangthai = ? where username = ?";
        try {    
            ptmt = conn.prepareStatement(Update);
            ptmt.setString(1, "Thành Viên");
            ptmt.setString(2, name);
            int kt = ptmt.executeUpdate();
            if(kt != 0){}
            ptmt.close();
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
    public void RemoveUser(String name){
        String Update = "update rguser set trangthai = ? where username = ?";
        try {    
            ptmt = conn.prepareStatement(Update);
            ptmt.setString(1, "chưa là thành viên");
            ptmt.setString(2, name);
            int kt = ptmt.executeUpdate();
            if(kt != 0){}
            ptmt.close();
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
}
