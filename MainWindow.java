// package vaccine.registration;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow{
	JFrame f;
	MainWindow(){
		f = new JFrame();
		f.getContentPane().setBackground(new Color(144,238,144));
		JPanel button = new JPanel();
		button.setBackground(new Color(144,238,144));
		JLabel l1 = new JLabel("Welcome to COVID-19 vaccine registration window",JLabel.CENTER);
		final JLabel l2 = new JLabel("Developed by Srijan Bhardwaj(19MCA047)",JLabel.CENTER);
		JButton b1 = new JButton("Citizen Registration");
		JButton b2 = new JButton("Registration Status");
		JButton b3 = new JButton("Admin");
		
		l1.setVerticalAlignment(0);
		l1.setFont(new Font("Verdana", Font.PLAIN, 24));
		
		l2.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		f.setTitle("COVID-19 Vaccine Registration");
		f.setLayout(new BorderLayout());
		
		button.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		 c.insets=new Insets(3,20,3,0);
		 
		 c.gridx = 1;
		 c.gridy = 1;
		 c.ipadx = 100;
		 c.ipady = 25;
		 button.add(b1,c);
		 
		 c.gridx = 2;
		 c.gridy = 1;
		 c.ipadx = 100;
		 c.ipady = 25;
		 button.add(b2,c);
		 
		 c.gridx = 3;
		 c.gridy = 1;
		 c.ipadx = 100;
		 c.ipady = 25;
		 button.add(b3,c);
		
		JPanel buttons = new JPanel();
		buttons.setSize(500,100);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		f.add(l1,BorderLayout.NORTH);
		f.add(button,BorderLayout.CENTER);
		f.add(l2,BorderLayout.SOUTH);
		f.setSize(800,800);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		b1.addActionListener((e)-> new CitizenRegistration());  //lambda expression
		b2.addActionListener((e)-> new RegistrationStatus(f));
		b3.addActionListener((e)-> new Admin(f));
	}
	
	public static void main(String[] args){
		try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e) {}
		finally {new MainWindow();}
	}
}