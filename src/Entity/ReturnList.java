
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReturnList {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public void delete(String username,String bookname){
        String delete = "delete from borrowbook where username = ? and bookname = ?";
        try {
            ptmt = conn.prepareStatement(delete); 
            ptmt.setString(1,username);  
            ptmt.setString(2,bookname);
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("delete");
        }
    }
    public void update(String bookname){
        String Update = "update book set conlai = ? where bookname = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book where bookname = '"+bookname+"'");
            while(rs.next()){
                if(rs.getString(1).equals(bookname)){
                    int conlai = rs.getInt(4) + 1;
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, conlai);
                    ptmt.setString(2, bookname);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){}
                    ptmt.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("update");
        }
    }
    public void updateUser(String username){
        String Update = "update rguser set conlai = ? where username = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from rguser where username = '"+username+"'");
            while(rs.next()){
                    int conlai = rs.getInt(7) + 1;
                    System.out.println(""+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, conlai);
                    ptmt.setString(2, username);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        //JOptionPane.showMessageDialog(null, "update thành công");
                    }
                    ptmt.close();
            }
        
        } catch (SQLException ex) {
            System.out.println("updateUser");
        }
    }
}
