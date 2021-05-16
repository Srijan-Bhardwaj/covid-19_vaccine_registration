// package vaccine.registration;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CitizenRegistration{
	private JFrame j;
	private JPanel form;
	private String dates[]
        = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
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
	private String states[]
		= {	"Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttarakhand",
                "Uttar Pradesh",
                "West Bengal",
                "Andaman and Nicobar Islands",
                "Chandigarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Lakshadweep",
				"Puducherry"};
				
	private JTextField name;
	private JTextField aadhar;
	private JRadioButton rb1,rb2,rb3;
	private JComboBox dd,mm,yy;
	private JTextField mobileno;
	private JTextField cityname;
	private JComboBox statename;
	private JTextArea add;
	private JButton sub,reset;
	CitizenRegistration(){
		j = new JFrame("Citizen Registration"); 
		j.getContentPane().setBackground(new Color(135,206,250));
		j.setSize(1000,700);
		j.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j.setLayout(new BorderLayout(0,50));
		
		JLabel header = new JLabel("Registration Form",JLabel.CENTER);
		header.setFont(new Font("Arial", Font.PLAIN, 25));
		// header.setLocation(0,0);
		// header.setSize(100,30);
		j.add(header,BorderLayout.NORTH);
		
		form = new JPanel();
		form.setSize(500,500);
		form.setBackground(new Color(135,206,250));
		form.setLayout(null);
		form.setVisible(true);
		j.add(form,BorderLayout.CENTER);
		
		int x,y,w,h;
		x=450;y=90;w=0;h=0;
		
		JLabel assumption1 = new JLabel("**Fields marked with asterisk(*) are mandatory");
		assumption1.setFont(new Font("Verdana", Font.PLAIN, 12));
		assumption1.setForeground(Color.red);
		assumption1.setBounds(x+10,y-90,w+500,h+25);
		form.add(assumption1);
		
		JLabel assumption2 = new JLabel("**Vaccination is only applicable for citizens above 18 years and below 45 years");
		assumption2.setFont(new Font("Verdana", Font.PLAIN, 12));
		assumption2.setForeground(Color.red);
		assumption2.setBounds(x+10,y-50,w+500,h+25);
		form.add(assumption2);
		
		JLabel assumption3 = new JLabel("**After 1 hour of registration, date of vaccination will be assigned and registration will get completed in 1 day");
		assumption3.setFont(new Font("Verdana", Font.PLAIN, 12));
		assumption3.setForeground(Color.red);
		assumption3.setBounds(x+10,y-70,w+1000,h+25);
		form.add(assumption3);
		
		JLabel fullName = new JLabel("Full Name* :");
		fullName.setFont(new Font("Verdana", Font.PLAIN, 16));
		fullName.setBounds(x+10,y+0,w+150,h+25);
		form.add(fullName);
		
		name = new JTextField("");
		name.setBounds(x+200,y+0,w+300,h+25);
		name.setToolTipText("enter your full name");
		form.add(name);
		
		JLabel aadharNumber = new JLabel("Aadhar Number* :");
		aadharNumber.setFont(new Font("Verdana", Font.PLAIN, 16));
		aadharNumber.setBounds(x+10,y+35,w+150,h+25);
		form.add(aadharNumber);
		
		aadhar = new JTextField("");
		aadhar.setBounds(x+200,y+35,w+300,h+25);
		aadhar.setToolTipText("enter your 12 digit aadhar number ");
		form.add(aadhar);
		
		JLabel sex = new JLabel("Sex* :");
		sex.setFont(new Font("Verdana", Font.PLAIN, 16));
		sex.setBounds(x+10,y+70,w+150,h+25);
		form.add(sex);
		
		ButtonGroup bg = new ButtonGroup();
		rb1 = new JRadioButton("male");
		rb1.setBounds(x+200,y+70,w+100,h+25);
		rb1.setSelected(true);
		bg.add(rb1);
		rb1.setBackground(new Color(135,206,250));
		form.add(rb1);
		rb2 = new JRadioButton("female");
		rb2.setBounds(x+300,y+70,w+100,h+25);
		rb2.setBackground(new Color(135,206,250));
		bg.add(rb2);
		form.add(rb2);
		rb3 = new JRadioButton("other");
		rb3.setBounds(x+400,y+70,w+100,h+25);
		rb3.setBackground(new Color(135,206,250));
		bg.add(rb3);
		form.add(rb3);
		
		
		JLabel dob = new JLabel("DOB* :");
		dob.setFont(new Font("Verdana", Font.PLAIN, 16));
		dob.setBounds(x+10,y+105,w+150,h+25);
		form.add(dob);
		
		dd = new JComboBox(dates);
		dd.setBounds(x+200,y+105,w+100,h+25);
		form.add(dd);
		
		mm = new JComboBox(months);
		mm.setBounds(x+300,y+105,w+100,h+25);
		form.add(mm);
		
		yy = new JComboBox(years);
		yy.setBounds(x+400,y+105,w+100,h+25);
		form.add(yy);
		
		JLabel mobile = new JLabel("Mobile no.* :");
		mobile.setFont(new Font("Verdana", Font.PLAIN, 16));
		mobile.setBounds(x+10,y+140,w+150,h+25);
		form.add(mobile);
		
		mobileno = new JTextField("");
		mobileno.setBounds(x+200,y+140,w+300,h+25);
		mobileno.setToolTipText("enter your mobile number");
		form.add(mobileno);
		
		JLabel city = new JLabel("City* :");
		city.setFont(new Font("Verdana", Font.PLAIN, 16));
		city.setBounds(x+10,y+175,w+150,h+25);
		form.add(city);
		
		cityname = new JTextField("");
		cityname.setBounds(x+200,y+175,w+300,h+25);
		cityname.setToolTipText("enter city name");
		form.add(cityname);
		
		JLabel state = new JLabel("State* :");
		state.setFont(new Font("Verdana", Font.PLAIN, 16));
		state.setBounds(x+10,y+205,w+150,h+25);
		form.add(state);
		
		statename = new JComboBox(states);
		statename.setBounds(x+200,y+205,w+300,h+25);
		form.add(statename);
		
		JLabel address = new JLabel("Address* :");
		address.setFont(new Font("Verdana", Font.PLAIN, 16));
		address.setBounds(x+10,y+240,w+150,h+25);
		form.add(address);
		
		add = new JTextArea("",50,10);
		JScrollPane scroll = new JScrollPane(add);
		scroll.setBounds(x+200,y+240,w+300,h+100);
		form.add(scroll);
		
		JPanel submission = new JPanel();
		submission.setBackground(new Color(135,206,250));
		sub = new JButton("Submit");
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				validate();
				JOptionPane.showMessageDialog(j,"Registered successfully!");
				reset();
				}
				catch(SQLException s){
					JOptionPane.showMessageDialog(j,"You are already registered!");
					reset();
				}catch(Exception x){
					JOptionPane.showMessageDialog(j,x.getMessage());  
				}
				resetColors();
			}
		});
		submission.add(sub);
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reset();
				resetColors();
			}
		});
		submission.add(reset);
		submission.setVisible(true);
		j.add(submission,BorderLayout.SOUTH);
		
		j.setVisible(true);   //it must be at the end so that content gets loaded before displaying frame
	}
	
	private void reset(){
		name.setText("");
		aadhar.setText("");
		rb1.setSelected(true);
		dd.setSelectedIndex(0);
		mm.setSelectedIndex(0);
		yy.setSelectedIndex(0);
		mobileno.setText("");
		cityname.setText("");
		statename.setSelectedIndex(0);
		add.setText("");
	}
	
	private void resetColors(){
		name.setBackground(Color.white);
		aadhar.setBackground(Color.white);
		mobileno.setBackground(Color.white);
		cityname.setBackground(Color.white);
		add.setBackground(Color.white);
	}
	
	private void validate() throws Exception{
		if(name.getText().length()==0){
			name.setBackground(new Color(220,20,60));
			throw new Exception("Please enter your name!");
		}
		if(aadhar.getText().length()!=12){
			aadhar.setBackground(new Color(220,20,60));
			throw new Exception("Please enter valid aadhar number!");
		}
		else{
			String adhar = aadhar.getText();
			for(int i=0;i<adhar.length();i++){
				if(adhar.charAt(i)<48 || adhar.charAt(i)>57){
					aadhar.setBackground(Color.red);
					throw new Exception("Please enter valid aadhar number!");
				}
			}
		}
		if(!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected()){
			throw new Exception("Please enter your gender!");
		}
		if(mobileno.getText().length()!=10)
		{
			mobileno.setBackground(Color.red);
			throw new Exception("Please enter valid mobile number!");
		}
		else{
			String mobi = mobileno.getText();
			for(int i=0;i<mobi.length();i++){
				if(mobi.charAt(i)<48 || mobi.charAt(i)>57){
					mobileno.setBackground(Color.red);
					throw new Exception("Please enter valid mobile number!");
				}
			}
		}
		if(cityname.getText().length()==0){
			cityname.setBackground(Color.red);
			throw new Exception("Please enter city name!");
		}
		if(add.getText().length()==0){
			add.setBackground(Color.red);
			throw new Exception("Please enter residential address");
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/zcTnIlzUjT","zcTnIlzUjT","aZ9ASDnTDr");
		
		PreparedStatement pstmt = con.prepareStatement("insert into citizens values(?,?,?,?,?,?,?,?,?);");
		PreparedStatement pstmt2 = con.prepareStatement("insert into registrationStatus values(?,?,\"In Process\");");
		
		pstmt.setString(1,name.getText());
		pstmt.setString(2,aadhar.getText());
		if(rb1.isSelected()) pstmt.setString(3,"male");
		if(rb2.isSelected()) pstmt.setString(3,"female");
		if(rb3.isSelected()) pstmt.setString(3,"other");
		String dob = (String)yy.getSelectedItem()+"-"+(mm.getSelectedIndex()+1)+"-"+(String)dd.getSelectedItem();
		pstmt.setDate(4,java.sql.Date.valueOf(dob));
		pstmt.setLong(5,Long.parseLong(mobileno.getText()));
		pstmt.setString(6,cityname.getText());
		pstmt.setString(7,(String)statename.getSelectedItem());
		pstmt.setString(8,add.getText());
		pstmt.setTimestamp(9,new Timestamp(new java.util.Date().getTime()));
		
		pstmt2.setString(1,aadhar.getText());
		pstmt2.setDate(2,java.sql.Date.valueOf(dob));
		int r = pstmt.executeUpdate();
		int i = pstmt2.executeUpdate();
		// System.out.println(r+" record inserted");
		con.close();
	}
}
