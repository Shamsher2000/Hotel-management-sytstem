import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel {

	JFrame frame;
	private JTable table;
	private JTextField jtxtCustomerRef;
	private JTextField jtxtFirstname;
	private JTextField jtxtSurname;
	private JTextField jtxtAddress;
	private JTextField jtxtPostCode;
	private JTextField jtxtMobile;
	private JTextField jtxtEmail;
	private JLabel PostCode;
	private JTextField jtxtTax;
	private JTextField jtxtSubtotal;
	private JTextField jtxtTotal;
	private JTextField jtxtNationality;
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	DefaultTableModel model=new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	public void updateTable()
	{
		conn=hotelData.ConnectDB();
		
		if(conn!=null)
		{
			String sql="Select CusRef,Firstname,Surname,Address,PostCode,Mobile,Email,Gender,Nationality,ProofofID,DOB,InDate,OutDate,Meal,RoomType,RoomNo,RoomExt from hoteldb";
		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			Object[] columnData=new Object[17];
			
			while(rs.next())
			{
				columnData[0]=rs.getString("CusRef");
				columnData[1]=rs.getString("Firstname");
				columnData[2]=rs.getString("Surname");
				columnData[3]=rs.getString("Address");
				columnData[4]=rs.getString("PostCode");
				columnData[5]=rs.getString("Mobile");
				columnData[6]=rs.getString("Email");
				columnData[7]=rs.getString("Gender");
				columnData[8]=rs.getString("Nationality");
				columnData[9]=rs.getString("ProofofID");
				columnData[10]=rs.getString("DOB");
				columnData[11]=rs.getString("InDate");
				columnData[12]=rs.getString("OutDate");
				columnData[13]=rs.getString("Meal");
				columnData[14]=rs.getString("RoomType");
				columnData[15]=rs.getString("RoomNo");
				columnData[16]=rs.getString("RoomExt");
				
				model.addRow(columnData);
			}
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Connection error");
		}
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel window = new Hotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hotel() {
		initialize();
		
		Object col[]= {"CusRef","Firstname","Surname","Address","PostCode","Mobile","Email","Gender","Nationality","ProofofID","DOB","InDate","OutDate","Meal","RoomType","RoomNo","RoomExt"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
		conn=hotelData.ConnectDB();
		
		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1470, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 290, 621);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel CustomerRef = new JLabel("CustomerRef.");
		CustomerRef.setFont(new Font("Tahoma", Font.BOLD, 18));
		CustomerRef.setBounds(10, 11, 123, 32);
		panel.add(CustomerRef);
		
		jtxtCustomerRef = new JTextField();
		jtxtCustomerRef.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtCustomerRef.setBounds(141, 17, 141, 23);
		panel.add(jtxtCustomerRef);
		jtxtCustomerRef.setColumns(10);
		
		JLabel Firstname = new JLabel("Firstname");
		Firstname.setFont(new Font("Tahoma", Font.BOLD, 18));
		Firstname.setBounds(10, 60, 123, 20);
		panel.add(Firstname);
		
		JLabel Surname = new JLabel("Surname");
		Surname.setFont(new Font("Tahoma", Font.BOLD, 18));
		Surname.setBounds(10, 91, 123, 29);
		panel.add(Surname);
		
		jtxtFirstname = new JTextField();
		jtxtFirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtFirstname.setColumns(10);
		jtxtFirstname.setBounds(141, 63, 141, 23);
		panel.add(jtxtFirstname);
		
		jtxtSurname = new JTextField();
		jtxtSurname.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtSurname.setColumns(10);
		jtxtSurname.setBounds(141, 100, 141, 23);
		panel.add(jtxtSurname);
		
		PostCode = new JLabel("Post Code");
		PostCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		PostCode.setBounds(10, 169, 123, 38);
		panel.add(PostCode);
		
		JLabel Address = new JLabel("Address");
		Address.setFont(new Font("Tahoma", Font.BOLD, 18));
		Address.setBounds(10, 131, 123, 38);
		panel.add(Address);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Tahoma", Font.BOLD, 18));
		Email.setBounds(10, 242, 123, 38);
		panel.add(Email);
		
		JLabel Mobile = new JLabel("Mobile");
		Mobile.setFont(new Font("Tahoma", Font.BOLD, 18));
		Mobile.setBounds(10, 205, 123, 38);
		panel.add(Mobile);
		
		JLabel Nationality = new JLabel("Nationality");
		Nationality.setFont(new Font("Tahoma", Font.BOLD, 18));
		Nationality.setBounds(10, 311, 123, 32);
		panel.add(Nationality);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setFont(new Font("Tahoma", Font.BOLD, 18));
		Gender.setBounds(10, 276, 123, 38);
		panel.add(Gender);
		
		JLabel DateofBirth = new JLabel("Date of Birth");
		DateofBirth.setFont(new Font("Tahoma", Font.BOLD, 18));
		DateofBirth.setBounds(10, 381, 123, 38);
		panel.add(DateofBirth);
		
		JLabel ProofofID = new JLabel("Proof of ID");
		ProofofID.setFont(new Font("Tahoma", Font.BOLD, 18));
		ProofofID.setBounds(10, 345, 123, 38);
		panel.add(ProofofID);
		
		JLabel OutDate = new JLabel("Out Date");
		OutDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		OutDate.setBounds(10, 451, 123, 38);
		panel.add(OutDate);
		
		JLabel InDate = new JLabel("In Date");
		InDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		InDate.setBounds(10, 414, 123, 38);
		panel.add(InDate);
		
		JLabel RoomType = new JLabel("Room Type");
		RoomType.setFont(new Font("Tahoma", Font.BOLD, 18));
		RoomType.setBounds(10, 522, 123, 38);
		panel.add(RoomType);
		
		JLabel Meal = new JLabel("Meal");
		Meal.setFont(new Font("Tahoma", Font.BOLD, 18));
		Meal.setBounds(10, 489, 123, 32);
		panel.add(Meal);
		
		JLabel lblNewLabel_2_7 = new JLabel("Room No.");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_7.setBounds(10, 640, 123, 38);
		panel.add(lblNewLabel_2_7);
		
		jtxtAddress = new JTextField();
		jtxtAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtAddress.setColumns(10);
		jtxtAddress.setBounds(141, 140, 141, 23);
		panel.add(jtxtAddress);
		
		jtxtPostCode = new JTextField();
		jtxtPostCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtPostCode.setColumns(10);
		jtxtPostCode.setBounds(141, 178, 141, 23);
		panel.add(jtxtPostCode);
		
		jtxtMobile = new JTextField();
		jtxtMobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtMobile.setColumns(10);
		jtxtMobile.setBounds(141, 214, 141, 23);
		panel.add(jtxtMobile);
		
		jtxtEmail = new JTextField();
		jtxtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtEmail.setColumns(10);
		jtxtEmail.setBounds(141, 251, 141, 23);
		panel.add(jtxtEmail);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 644, 141, 29);
		panel.add(comboBox);
		
		JComboBox cboRoomType = new JComboBox();
		cboRoomType.setModel(new DefaultComboBoxModel(new String[] {"Select Room Type", "Single", "Double", "Family"}));
		cboRoomType.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboRoomType.setBounds(141, 533, 141, 23);
		panel.add(cboRoomType);
		
		JLabel RoomNo = new JLabel("Room No.");
		RoomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		RoomNo.setBounds(10, 552, 123, 38);
		panel.add(RoomNo);
		
		JLabel RoomExtno = new JLabel("Room Extno.");
		RoomExtno.setFont(new Font("Tahoma", Font.BOLD, 18));
		RoomExtno.setBounds(10, 583, 123, 38);
		panel.add(RoomExtno);
		
		JComboBox cboRoomNo = new JComboBox();
		cboRoomNo.setModel(new DefaultComboBoxModel(new String[] {"Select Room No", "001", "002", "003", "004", "005", "006"}));
		cboRoomNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboRoomNo.setBounds(141, 563, 141, 23);
		panel.add(cboRoomNo);
		
		JComboBox cboRoomExtno = new JComboBox();
		cboRoomExtno.setModel(new DefaultComboBoxModel(new String[] {"Select Room Ext No", "1001", "1002", "1003", "1004", "1005", "1006"}));
		cboRoomExtno.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboRoomExtno.setBounds(141, 594, 141, 23);
		panel.add(cboRoomExtno);
		
		JComboBox cboMeal = new JComboBox();
		cboMeal.setModel(new DefaultComboBoxModel(new String[] {"Select Meal", "Breakfast", "Lunch", "Dinner"}));
		cboMeal.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboMeal.setBounds(141, 497, 141, 23);
		panel.add(cboMeal);
		
		JComboBox cboGender = new JComboBox();
		cboGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female", "Other"}));
		cboGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboGender.setBounds(141, 287, 141, 23);
		panel.add(cboGender);
		
		JComboBox cboProofofID = new JComboBox();
		cboProofofID.setModel(new DefaultComboBoxModel(new String[] {"Select Proof of ID", "Student ID", "Aadhar Card", "Pan Card", "Passport", "Driving Licence"}));
		cboProofofID.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboProofofID.setBounds(141, 356, 141, 23);
		panel.add(cboProofofID);
		
		JDateChooser jDateChooser1 = new JDateChooser();
		jDateChooser1.setBounds(141, 390, 141, 23);
		panel.add(jDateChooser1);
		
		JDateChooser jDateChooser3 = new JDateChooser();
		jDateChooser3.setBounds(141, 463, 141, 23);
		jDateChooser3.setDateFormatString("dd-MM-yyyy");
		panel.add(jDateChooser3);
		
		JDateChooser jDateChooser2 = new JDateChooser();
		jDateChooser2.setBounds(141, 424, 141, 23);
		panel.add(jDateChooser2);
		
		jtxtNationality = new JTextField();
		jtxtNationality.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtNationality.setColumns(10);
		jtxtNationality.setBounds(141, 320, 141, 23);
		panel.add(jtxtNationality);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(310, 11, 963, 508);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 943, 486);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CustomerRef.", "Firstname", "Surname", "Address", "Post Code", "Mobile", "Email", "Gender", "Nationality", "Proof of ID", "Date of Birth", "In Date", "Out Date","Meal", "Room Type", "Room No.", "Room Ext. No."
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(310, 530, 962, 102);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Tax = new JLabel("Tax");
		Tax.setBounds(10, 0, 76, 38);
		Tax.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(Tax);
		
		JLabel Subtotal = new JLabel("Subtotal");
		Subtotal.setBounds(10, 33, 76, 38);
		Subtotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(Subtotal);
		
		JLabel Total = new JLabel("Total");
		Total.setBounds(10, 69, 76, 23);
		Total.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(Total);
		
		jtxtTax = new JTextField();
		jtxtTax.setBounds(96, 9, 141, 23);
		jtxtTax.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtTax.setColumns(10);
		panel_2.add(jtxtTax);
		
		jtxtSubtotal = new JTextField();
		jtxtSubtotal.setBounds(96, 42, 141, 23);
		jtxtSubtotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtSubtotal.setColumns(10);
		panel_2.add(jtxtSubtotal);
		
		jtxtTotal = new JTextField();
		jtxtTotal.setBounds(96, 70, 141, 23);
		jtxtTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		jtxtTotal.setColumns(10);
		panel_2.add(jtxtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double SingleRoom=1000;
				double DoubleRoom=2500;
				double FamilyRoom=5000;
				double oneMeal=50;
				double twoMeal=100;
				double threeMeal=200;
				
				try
				{
					if(cboMeal.getSelectedItem().equals("Breakfast")&&cboRoomType.getSelectedItem().equals("Single"))
					{
						double q=(SingleRoom + oneMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("Breakfast")&&cboRoomType.getSelectedItem().equals("Double"))
					{
						double q=(DoubleRoom + oneMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("Breakfast")&&cboRoomType.getSelectedItem().equals("Family"))
					{
						double q=(FamilyRoom + oneMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					
					else if(cboMeal.getSelectedItem().equals("Lunch")&&cboRoomType.getSelectedItem().equals("Single"))
					{
						double q=(SingleRoom + twoMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("Lunch")&&cboRoomType.getSelectedItem().equals("Double"))
					{
						double q=(DoubleRoom + twoMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("lunch")&&cboRoomType.getSelectedItem().equals("Family"))
					{
						double q=(FamilyRoom + twoMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					
					else if(cboMeal.getSelectedItem().equals("Dinner")&&cboRoomType.getSelectedItem().equals("Single"))
					{
						double q=(SingleRoom + threeMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("Dinner")&&cboRoomType.getSelectedItem().equals("Double"))
					{
						double q=(DoubleRoom + threeMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
					else if(cboMeal.getSelectedItem().equals("Dinner")&&cboRoomType.getSelectedItem().equals("Family"))
					{
						double q=(FamilyRoom + threeMeal);
						double i=(q*12)/100;
						String tax=String.format("Rs. %.2f",i);
						jtxtTax.setText(tax);
						
						String subTotal=String.format("Rs. %.2f",q);
						jtxtSubtotal.setText(subTotal);
						
						String Total=String.format("Rs. %.2f",q+i);
						jtxtTotal.setText(Total);							
					}
				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, ev);
				}
				
			}
		});
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnTotal.setBounds(247, 9, 104, 91);
		panel_2.add(btnTotal);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql="INSERT INTO hoteldb(CusRef,Firstname,Surname,Address,PostCode,Mobile,Email,Gender,Nationality,"
						+ "ProofofID,DOB,InDate,OutDate,Meal,RoomType,RoomNo,RoomExt)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				try
				{
					pst=conn.prepareStatement(sql);
					pst.setString(1, jtxtCustomerRef.getText());
					pst.setString(2, jtxtFirstname.getText());
					pst.setString(3, jtxtSurname.getText());
					pst.setString(4, jtxtAddress.getText());
					pst.setString(5, jtxtPostCode.getText());
					pst.setString(6, jtxtMobile.getText());
					pst.setString(7, jtxtEmail.getText());
					pst.setString(8, (String) cboGender.getSelectedItem());
					pst.setString(9, jtxtNationality.getText());
					pst.setString(10, (String) cboProofofID.getSelectedItem());
					pst.setString(11, jDateChooser1.getDate().toString());
					pst.setString(12, jDateChooser2.getDate().toString());
					pst.setString(13, jDateChooser3.getDate().toString());
					pst.setString(14, (String) cboMeal.getSelectedItem());
					pst.setString(15, (String) cboRoomType.getSelectedItem());
					pst.setString(16, (String) cboRoomNo.getSelectedItem());
					pst.setString(17, (String) cboRoomExtno.getSelectedItem());
					
					pst.execute();
					rs.close();
					pst.close();
					
				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, ev);
				}
				
				
				updateTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnUpdate.setBounds(361, 9, 122, 91);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel mod=(DefaultTableModel)table.getModel();
				
				if(table.getSelectedRow()==-1)
				{			
						JOptionPane.showMessageDialog(null, "Select row to delete","Hotel System",JOptionPane.OK_OPTION);
				}
				else 
				{
					mod.removeRow(table.getSelectedRow());
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDelete.setBounds(493, 9, 114, 91);
		panel_2.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					jtxtCustomerRef.setText(null);
					jtxtFirstname.setText(null);
					jtxtSurname.setText(null);
					jtxtAddress.setText(null);
					jtxtPostCode.setText(null);
					jtxtMobile.setText(null);
					jtxtEmail.setText(null);
					cboGender.setSelectedIndex(0);
					jtxtNationality.setText(null);
					cboProofofID.setSelectedIndex(0);
					jDateChooser1.setDate(null);
					jDateChooser2.setDate(null);
					jDateChooser3.setDate(null);
					cboMeal.setSelectedIndex(0);
					cboRoomType.setSelectedIndex(0);
					cboRoomNo.setSelectedIndex(0);
					cboRoomExtno.setSelectedIndex(0);
					jtxtTax.setText(null);
					jtxtSubtotal.setText(null);
					jtxtTotal.setText(null);
				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, ev);
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReset.setBounds(617, 9, 104, 91);
		panel_2.add(btnReset);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					table.print();
				}
				catch(java.awt.print.PrinterException ev)
				{
					System.err.format("No Printer Found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPrint.setBounds(731, 9, 104, 91);
		panel_2.add(btnPrint);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Hotel System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnExit.setBounds(845, 9, 104, 91);
		panel_2.add(btnExit);
	}
}

