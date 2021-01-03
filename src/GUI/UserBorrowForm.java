/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Entity.Connecting.conn;
import Entity.UserRegisterBook;
import static GUI.LoginForm.USERNAME;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KirrNguyen
 */
public class UserBorrowForm extends javax.swing.JPanel {

    Statement stmt = null;
    Statement stmt2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    DefaultTableModel model;
    public UserBorrowForm() {
        initComponents();
        model = (DefaultTableModel) Table.getModel();
    }
    public void start(){
        Start.setText("");
    } 
    public void View(){
        clearTable();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book");
            int i = 0;
            while (rs.next()) {
                stmt2 = conn.createStatement();
                rs2 = stmt2.executeQuery("select * from registerbook");
                while (rs2.next()) {
                    i = 0;
                    if(USERNAME.equals(rs2.getString(1)) && rs.getString(1).equals(rs2.getString(2))){
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),"Đã Đăng Kí",rs.getString(5), rs.getString(6), rs.getString(7)}); 
                        i++;
                        break;
                    } 
                }
                if(i == 0) model.addRow(new Object[]{rs.getString(1),rs.getString(2), " " , rs.getString(5), rs.getString(6), rs.getString(7)}); 
            }	
        }catch(Exception ex){}
    }
    public void View2(){
        clearTable();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                stmt2 = conn.createStatement();
                rs2 = stmt2.executeQuery("select * from registerbook");
                while (rs2.next()) {
                    if(USERNAME.equals(rs2.getString(1)) && rs.getString(1).equals(rs2.getString(2))){
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),"Đã Đăng Kí",rs.getString(5), rs.getString(6), rs.getString(7)}); 
                        
                    } 
                }
            }
        } catch (SQLException ex) {}
    }
    public void clearTable(){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Start = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sách", "Tên Tác Giả", "Trạng thái", "NXB", "Năm Xuất Bản", "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
        }

        Start.setText("jLabel1");

        jButton1.setText("Đăng Kí Mượn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Trở Về");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Hủy Đăng Kí");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Danh Sách Đăng Kí");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Tất Cả Danh Sách");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Start)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Start)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            MainForm.PanelMain.removeAll();
        }catch(Exception ex){}
        UserForm userform = new UserForm();
        userform.setBounds(5, 5, 780, 480);
        MainForm.PanelMain.add(userform);
        MainForm.PanelMain.repaint();
        userform.start();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Searching();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{   
            int index  = Table.getSelectedRow();
            String bookname = (String) Table.getValueAt(index, 0);
            UserRegisterBook userregister = new UserRegisterBook();
            if(userregister.check1(bookname)){   
                if(userregister.checkbook()){
                    userregister.sendRegister(bookname);
                    userregister.updateUser1();
                    View();
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Chọn 1 cuốn sách");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{    
            int index  = Table.getSelectedRow();
            String bookname = (String) Table.getValueAt(index, 0);
            UserRegisterBook userregister = new UserRegisterBook();
            if(userregister.check2(bookname)){
                userregister.delete(bookname);
                userregister.updateUser2();
            }
            View();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Chọn 1 cuốn sách");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        View2();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        View();
    }//GEN-LAST:event_jButton7ActionPerformed
    public void Searching(){
        clearTable(); 
        String text = SearchText.getText();
        int i = 0;
        if(text.equals("")){
            SearchText.setText("");
            View();
        }else{
            String search[] = {"bookname","writer","nxb","namxb", "theloai"};
            try {
                for(String s : search){
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from book where "+s+" like '"+text+"'");
                    while(rs.next()){
                            stmt2 = conn.createStatement();
                            rs2 = stmt2.executeQuery("select * from registerbook");
                            while (rs2.next()) {
                                i = 0;
                                if(USERNAME.equals(rs2.getString(1)) && rs.getString(1).equals(rs2.getString(2))){
                                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),"Đã Đăng Kí",rs.getString(5), rs.getString(6), rs.getString(7)}); 
                                    i++;
                                    break;
                                } 
                            }
                            if(i == 0) model.addRow(new Object[]{rs.getString(1),rs.getString(2)}); 
                        }
                    }
                SearchText.setText("");
            } catch (SQLException ex) {
                System.out.println("cant load");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchText;
    private javax.swing.JLabel Start;
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
