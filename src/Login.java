import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener { 
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1;
	
	Login(){
		
		l1=new JLabel("Username");
		l1.setBounds(40,30,120,30);
		add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40,80,120,30);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(170,30,150,30);
		add(t1);
		
		t2=new JPasswordField();
		t2.setBounds(170,80,150,30);
		add(t2);
		
		b1=new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(120,150,140,30);
		b1.addActionListener(this);
		add(b1);
		
		setLayout(null);
		setBounds(380,200,400,270);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try
		{
			conn=hotelData.ConnectDB();
			String query="select * from Logininfo where username=? and password=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,t1.getText());
			pst.setString(2,t2.getText());
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
				
				Hotel window = new Hotel();
				window.frame.setVisible(true);
			    this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid username and password");
				this.setVisible(false);
			}
			rs.close();
			pst.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);;
	}

}
