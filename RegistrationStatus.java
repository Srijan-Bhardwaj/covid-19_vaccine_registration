// package vaccine.registration;


import java.text.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegistrationStatus{
	
	private JDialog d;
	private JTextField username;
	private JComboBox dd,mm,yy;
	private JLabel res;
	private JButton login;
	private String dates[]
        = { "01", "02", "03", "04", "05",
            "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
        = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
        = { "1976",	"1977",	"1978",	"1979",	"1980",
			"1981",	"1982",	"1983",	"1984",
			"1985", "1986",	"1987",	"1988",
			"1989",	"1990",	"1991",	"1992",
			"1993",	"1994",
			"1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
			"2003"
			};

	RegistrationStatus(JFrame j){
		d = new JDialog(j,"Login",true);
		d.setLayout(null);
		
		JLabel user = new JLabel("Aadhar number :");
		user.setFont(new Font("Verdana", Font.PLAIN, 12));
		user.setBounds(20,10,150,25);
		d.add(user);
		
		username = new JTextField("");
		username.setBounds(170,10,200,25);
		username.setToolTipText("enter your aadhar number");
		d.add(username);
		
		JLabel pass = new JLabel("Password :");
		pass.setFont(new Font("Verdana", Font.PLAIN, 12));
		pass.setBounds(20,40,150,25);
		d.add(pass);
		
		dd = new JComboBox(dates);
		dd.setBounds(170,40,66,25);
		d.add(dd);
		
		mm = new JComboBox(months);
		mm.setBounds(236,40,66,25);
		d.add(mm);
		
		yy = new JComboBox(years);
		yy.setBounds(302,40,66,25);
		d.add(yy);
		
		res = new JLabel("");
		res.setForeground(new Color(0,100,0));
		res.setBounds(20,100,500,25);
		res.setFont(new Font("Arial", Font.PLAIN, 12));
		d.add(res);
		
		login = new JButton("Login");
		login.setBounds(150,150,100,25);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					validate();
				}
				catch(Exception x){
					res.setText("");
					JOptionPane.showMessageDialog(d,x.getMessage());
				}
			}
		});
		d.add(login);  //always add item after completing all functionality
		
		d.setLocation(500,300);
		d.setSize(400,225);
		d.setVisible(true);
	}
	
	private void validate() throws Exception{
		if(username.getText().length()!=12){
			throw new Exception("Please enter valid aadhar number!");
		}
		else{
			String adhar = username.getText();
			for(int i=0;i<adhar.length();i++){
				if(adhar.charAt(i)<48 || adhar.charAt(i)>57){
					throw new Exception("Please enter valid aadhar number!");
				}
			}
		}
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/zcTnIlzUjT","zcTnIlzUjT","aZ9ASDnTDr");
		
		PreparedStatement pstmt = con.prepareStatement("select * from registrationStatus;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		PreparedStatement pstmt2 = con.prepareStatement("select Time_of_reg from citizens where AadharNumber = ?;");
		PreparedStatement pstmt3 = con.prepareStatement("update registrationStatus set Status = ? where Aadharno = ?;");
		ResultSet rs = pstmt.executeQuery();
		boolean isFound = false;
		while(rs.next()){
			if(rs.getString(1).equals(username.getText())){
				isFound = true;
				String dob = (String)yy.getSelectedItem()+"-"+(new DecimalFormat("00").format(mm.getSelectedIndex()+1))+"-"+(String)dd.getSelectedItem();
				if(rs.getString(2).equals(dob)){
					pstmt2.setString(1,username.getText());
					ResultSet rs2 = pstmt2.executeQuery();
					if(rs2.next()){
					long time = new java.util.Date().getTime();
					if(((time-rs2.getTimestamp(1).getTime())/1000)>3600){pstmt3.setString(1,"Scheduled on Date");pstmt3.setString(2,username.getText());pstmt3.executeUpdate();}
					if(((time-rs2.getTimestamp(1).getTime())/1000)>86400){pstmt3.setString(1,"Completed");pstmt3.setString(2,username.getText());pstmt3.executeUpdate();}
					rs.refreshRow();
					res.setText("Registration status is "+rs.getString(3));
					break;
					}
				}
				else throw new Exception("Date of Birth is not matching!");
			}
		}
		if(!isFound)throw new Exception("either you have entered wrong aadhar number or you have not registered for vaccination!");
		con.close();
	}
}
