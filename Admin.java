// package vaccine.registration; 

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Admin{
	private JDialog d;
	private JFrame f;
	private JTable t;
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	Admin(JFrame j){
		
		d = new JDialog(j,"Admin login",true);
		d.setLayout(null);
		
		JLabel user = new JLabel("User name :");
		user.setFont(new Font("Verdana", Font.PLAIN, 12));
		user.setBounds(20,10,150,25);
		d.add(user);
		
		username = new JTextField("");
		username.setBounds(170,10,200,25);
		username.setToolTipText("enter admin username");
		d.add(username);
		
		JLabel pass = new JLabel("Password :");
		pass.setFont(new Font("Verdana", Font.PLAIN, 12));
		pass.setBounds(20,40,150,25);
		d.add(pass);
		
		password = new JPasswordField("");
		password.setBounds(170,40,200,25);
		password.setToolTipText("enter admin password");
		d.add(password);
		
		login = new JButton("Login");
		login.setBounds(150,125,100,25);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					validate();
					d.dispose();
					registeredCitizens();
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(d,x.getMessage());  
				}
			}
		});
		d.add(login);  //always add item after completing all functionality
		
		d.setLocation(500,300);
		d.setSize(400,200);
		d.setVisible(true);
	}
	
	private void registeredCitizens() throws Exception{
		JFrame f = new JFrame("Admin panel");
		f.setLayout(new BorderLayout(0,20));
		f.getContentPane().setBackground(new Color(135,206,250));
		
		JLabel heading = new JLabel("Citizens registered for vaccination",JLabel.CENTER);
		heading.setFont(new Font("Arial", Font.PLAIN, 24));
		f.add(heading,BorderLayout.NORTH);
		
		JPanel p = new JPanel();
		
		DefaultTableModel table = new DefaultTableModel(){
			public boolean isCellEditable(int row,int column){
			return false;
		}};
		table.addColumn("Name");
		table.addColumn("Aadhar Number");
		table.addColumn("Gender");
		table.addColumn("DOB(yyyy-mm-dd)");
		table.addColumn("Mobile Number");
		table.addColumn("City");
		table.addColumn("State");
		table.addColumn("Address");
		table.addColumn("Time");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/zcTnIlzUjT","zcTnIlzUjT","aZ9ASDnTDr");
		
		PreparedStatement pstmt = con.prepareStatement("select * from citizens order by FullName;");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
		table.insertRow(table.getRowCount(),new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
		}
		con.close();
		
		t = new JTable(table);
		
		JScrollPane sp = new JScrollPane(t);
		f.add(sp,BorderLayout.CENTER);
		
		
//		f.setSize(500,500);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}
	
	private void validate() throws Exception{
		if(!username.getText().equals("admin") || !password.getText().equals("vaccine")) throw new Exception("Wrong credentials!");
	}
}