
package Controller;

import GUI.LoginForm;
import GUI.MainForm;

public class RegisterControl {
    public void Back(){
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        LoginForm loginform = new LoginForm();
        loginform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(loginform);
        MainForm.PanelMain.repaint();
        loginform.start();
    }
}
