
package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import static Entity.Connecting.conn;

public class RegisterUser {
//	Connection conn = Connecting.connecting();
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ptmt = null;

	public void Register(String username, String password, String name, String phone, String email, String cmnd) {
		String insert = "insert into user values(?,?,?,?,?,?,?,?)";
		try {
			ptmt = conn.prepareStatement(insert);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ptmt.setString(3, name);
			ptmt.setString(4, phone);
			ptmt.setString(5, email);
			ptmt.setString(6, cmnd);
			ptmt.setInt(7, 5);
			ptmt.setString(8, "chưa là thành viên");
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				JOptionPane.showMessageDialog(null, "đã gửi đăng kí");
			} else
				System.out.println("them khong thanh cong");
			ptmt.close();
		} catch (SQLException ex) {
		}
	}

	public void sendRegister(String username, String password, String name, String phone, String email, String cmnd) {
		if (username.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập username");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập password");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập Họ và Tên");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập Số Điện Thoại");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập Email");
		else if (password.equals(""))
			JOptionPane.showMessageDialog(null, "Nhập Số cmnd");
		else if (!check(username)) {
		} else {
			Register(username, password, name, phone, email, cmnd);
		}
	}

	public boolean check(String username) {

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from rguser");
			while (rs.next()) {
				String name1 = rs.getString(1);
				if (username.equals(name1)) {
					JOptionPane.showMessageDialog(null, "Tên đã tồn tại");
					return false;
				}
			}
		} catch (SQLException ex) {
			System.out.println("fail");
		}
		return true;
	}
}
