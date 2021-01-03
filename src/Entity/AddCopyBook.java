
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddCopyBook extends Connecting{
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ptmt = null;
    public void addbook(String name,String number){
        
        String Update = "update book set soluong = ?,conlai = ? where bookname = ?";
        try {    
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book where bookname = '"+name+"'");
            while(rs.next()){
                if(rs.getString(1).equals(name)){
                    int soluong = rs.getInt(3)+Integer.parseInt(number);
                    int conlai = rs.getInt(4)+Integer.parseInt(number);
                    System.out.println(""+soluong+conlai);
                    ptmt = conn.prepareStatement(Update);
                    ptmt.setInt(1, soluong);
                    ptmt.setInt(2, conlai);
                    ptmt.setString(3, name);
                    int kt = ptmt.executeUpdate();
                    if(kt != 0){
                        JOptionPane.showMessageDialog(null, "thêm thành công");
                    }
                    ptmt.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("fail");
        }
    }
}
