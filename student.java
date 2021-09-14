package com.libmanagement;

	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;

	public class student  extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField id;
	    private JTextField firstname;
	    private JTextField lastname;
	    private JTextField email;
	    private JTextField deptname;
	    private JTextField mob;
	    private JTextField BloodGroup;
	    private JButton btnNewButton;
	    private JButton btnNewButton1;
		protected String msg;
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    student frame = new student();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the frame.
	     */

	    public student() {
	       
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("STUDENT RECORD");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 30));
	        lblNewUserRegister.setBounds(390, 30, 325, 50);
	        contentPane.add(lblNewUserRegister);
	        
	        JLabel lblId = new JLabel("ID");
	        lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblId.setBounds(358, 75, 99, 43);
	        contentPane.add(lblId);


	        JLabel lblName = new JLabel("First name");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblName.setBounds(58, 152, 99, 43);
	        contentPane.add(lblName);

	        JLabel lblNewLabel = new JLabel("Last name");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(58, 243, 110, 29);
	        contentPane.add(lblNewLabel);

	        JLabel lblEmailAddress = new JLabel("Email\r\n address");
	        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEmailAddress.setBounds(58, 324, 124, 36);
	        contentPane.add(lblEmailAddress);
	        
	        id = new JTextField();
	        id.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        id.setBounds(400, 75, 228, 50);
	        contentPane.add(id);
	        id.setColumns(10);

	        firstname = new JTextField();
	        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        firstname.setBounds(214, 151, 228, 50);
	        contentPane.add(firstname);
	        firstname.setColumns(10);

	        lastname = new JTextField();
	        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lastname.setBounds(214, 235, 228, 50);
	        contentPane.add(lastname);
	        lastname.setColumns(10);

	        email = new JTextField();

	        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        email.setBounds(214, 320, 228, 50);
	        contentPane.add(email);
	        email.setColumns(10);

	        deptname = new JTextField();
	        deptname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        deptname.setBounds(707, 151, 228, 50);
	        contentPane.add(deptname);
	        deptname.setColumns(10);

	        JLabel lblDeptname = new JLabel("Dept");
	        lblDeptname.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblDeptname.setBounds(542, 159, 99, 29);
	        contentPane.add(lblDeptname);

	        JLabel lblBloodGroup = new JLabel("Blood Group");
	        lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblBloodGroup.setBounds(542, 245, 99, 24);
	        contentPane.add(lblBloodGroup);

	        JLabel lblMobileNumber = new JLabel("Mobile number");
	        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMobileNumber.setBounds(542, 329, 139, 26);
	        contentPane.add(lblMobileNumber);

	        mob = new JTextField();
	        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        mob.setBounds(707, 320, 228, 50);
	        contentPane.add(mob);
	        mob.setColumns(10);

	        BloodGroup = new JTextField();
	        BloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        BloodGroup.setBounds(707, 235, 228, 50);
	        contentPane.add(BloodGroup);

	        btnNewButton = new JButton("Save");
	        
	        btnNewButton.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	                String Id=id.getText();
	            	String firstName = firstname.getText();
	                String lastName = lastname.getText();
	                String emailId = email.getText();
	                String Deptname = deptname.getText();
	                String mobileNumber = mob.getText();
	                
	                int len = mobileNumber.length();
	                String bloodgroup = BloodGroup.getText();

	                String msg = "" + firstName;
	                msg += " \n";
	                
	                if (len != 10) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
	                }

	                try {
	                	String db_url="jdbc:mysql://127.0.0.1:3306/batch5723?characterEncoding=utf8";
	        			Connection con=DriverManager.getConnection(db_url,"root","Environment@365");
	        			
	        			System.out.println("2.Connected with SQL");
	        			
	                    String query = "INSERT INTO student values('"+ Id + "','" + firstName + "','" + lastName + "','" + Deptname + "','" +
	                        bloodgroup + "','" + emailId + "','" + mobileNumber + "')";

	                	Statement stmt=con.createStatement();
	                    int x = stmt.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Welcome, " + msg + "Your account is sucessfully created.");
	                    }
					con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton.setBounds(200, 447, 259, 74);
	        contentPane.add(btnNewButton);
	        

	        btnNewButton1 = new JButton("DELETE");
	        btnNewButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String msg = "" + firstname;
	                msg += " \n";
	        		try {
	        			Class.forName("com.mysql.jdbc.Driver");
	        					String db_url="jdbc:mysql://127.0.0.1:3306/batch5723?characterEncoding=utf8";
	    	        			Connection con=DriverManager.getConnection(db_url,"root","Environment@365");
	        	        Statement stmt = con.createStatement();  
	        	        int i = stmt.executeUpdate("DELETE FROM student WHERE id=" + id.getText() + ""); 
	        	        if (i == 0) {JOptionPane.showMessageDialog(btnNewButton, " alredy DELETED");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            " Student RECORD sucessfully DLETED.");
	                     } 
	        	        stmt.close();  
	        	        con.close();  
	        	        Referesh(); //Calling Referesh() method  
	        	    } catch (SQLException | ClassNotFoundException e1) {  
	        	        JOptionPane.showMessageDialog(null, e1);  
	        	    }  
	        	}  
	        		
	        });
	        
	        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton1.setBounds(500, 447, 259, 74);
	        contentPane.add(btnNewButton1);
	        
	    }

		protected void Referesh() {
			// TODO Auto-generated method stub
			
		}
	}


