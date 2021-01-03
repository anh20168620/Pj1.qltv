
package Controller;

import GUI.MainForm;
import GUI.ManageForm;
import GUI.RegisterForm;
import GUI.UserForm;
import javax.swing.JOptionPane;

    
public class LoginControl {
    public void Admin(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            ManageForm manage = new ManageForm();
            manage.setBounds(5, 5, 780,   480);
            MainForm.PanelMain.add(manage);
            MainForm.PanelMain.repaint();
            manage.start();
    }
    public void User(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
            UserForm userform = new UserForm();            userform.setBounds(5, 5, 780, 480);
            MainForm.PanelMain.add(userform);
            MainForm.PanelMain.repaint();
            userform.start();
    }
    public void None(){
        JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không chính xác");
    }
    public void Register(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        RegisterForm registerform = new RegisterForm();
        registerform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(registerform);
        MainForm.PanelMain.repaint();
        registerform.start();
    }
}
