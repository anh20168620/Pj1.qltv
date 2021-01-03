
package Entity;

import static Entity.Connecting.conn;
import static GUI.LoginForm.USERNAME;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class UserRegisterBook {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public boolean check1(String namebook){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from registerbook");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    String name2 = rs.getString(2);
                    if(USERNAME.equals(name1) && namebook.equals(name2)) {
                        JOptionPane.showMessageDialog(null, "bạn đã đăng kí,không thể đăng kí thêm");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("check");
        }
        return true;
    }
    public boolean check2(String namebook){
        int i = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from borrowbook");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    String name2 = rs.getString(2);
                    if(USERNAME.equals(name1) && namebook.equals(name2)) {
                        i++;
                    }
            }
            if(i == 0){
                JOptionPane.showMessageDialog(null, "bạn chưa đăng kí,không thể hủy đăng kí");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("check");
        }
        return true;
    }
    public boolean checkbook(){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser");
            while (rs.next()) {
                    String name1 = rs.getString(1);
                    int numberbook = rs.getInt(7);
                    if(USERNAME.equals(name1) && numberbook == 0 ) {
                        JOptionPane.showMessageDialog(null, "bạn chỉ có thể mượn tối đa 5 cuốn");
                        return false;
                    }
            }
        } catch (SQLException ex) {
            System.out.println("checkbook");
        }
        return true;
    }
    public void sendRegister(String namebook){
        String insert = "insert into registerbook values(?,?)";
        try {
                ptmt = conn.prepareStatement(insert);
                ptmt.setString(1, USERNAME);
                ptmt.setString(2, namebook);
                int kt = ptmt.executeUpdate();
                if(kt != 0){
                    JOptionPane.showMessageDialog(null, "đăng kí thành công");
                }
                ptmt.close();
            } catch (SQLException ex) {
                System.out.println("sendRegister");
            }
    }
    public void updateUser1(){
        String Update = "update rguser set conlai = ? where username = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username = '"+USERNAME+"'");
            while(rs.next()){
                    int conlai = rs.getInt(7) - 1;
                    System.out.println(""+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, conlai);
                    ptmt.setString(2, USERNAME);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        //JOptionPane.showMessageDialog(null, "update thành công");
                    }
                    ptmt.close();
            }
        
        } catch (SQLException ex) {
            System.out.println("updateUser1");
        }
    }
    public void delete(String bookname){
        String delete = "delete from registerbook where username = ? and bookname = ?";
        try {
            ptmt = conn.prepareStatement(delete); 
            ptmt.setString(1,USERNAME);  
            ptmt.setString(2,bookname);
            ptmt.execute();
            JOptionPane.showMessageDialog(null, "bạn đã hủy đăng kí mượn sách");
        } catch (SQLException ex) {
            System.out.println("delete");
        }
    }
    public void updateUser2(){
        String Update = "update rguser set conlai = ? where username = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username = '"+USERNAME+"'");
            while(rs.next()){
                    int conlai = rs.getInt(7) + 1;
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, conlai);
                    ptmt.setString(2, USERNAME);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                    }
                    ptmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("updateUser2");
        }
    }
}
