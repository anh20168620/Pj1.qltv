
package Entity;

import static Entity.Connecting.conn;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteBook {
    PreparedStatement ptmt = null;
    public void DeleteBook(String del){
        String delete = "delete from book where bookname = ?";
        try {
            ptmt = conn.prepareStatement(delete);
            ptmt.setString(1,del); 
            ptmt.execute();
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
}
