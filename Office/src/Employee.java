import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import javax.swing.UIManager;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTextField textPassword;
	private JTextField textUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setResizable(false);
		
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setEnabled(false);
        setVisible(true);
        setLocationRelativeTo(null);
		
        setBounds(100, 100, 893, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 // create JFrame and JTable
        setTitle("OiS | Employee Management");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
        getContentPane().setBackground(SystemColor.textHighlight);
        JTable table = new JTable(); 
        
        try{
        	 File file = new File("db/userdb.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }
	       	  
        	BufferedReader br = new BufferedReader(new FileReader(file));
	        // create a table model and set a Column Identifiers to this model 
	        String[] columns = { "Staff ID","Name","Contact No","Department","Username","Password","Role" };
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setColumnIdentifiers(columns);
	        
	     // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
         // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(";");
                model.addRow(dataRow);
            }

	        // set the model to the table
	        table.setModel(model);
	       	table.revalidate();
	       	table.repaint();
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.WHITE);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        // create JButtons
	        JButton btnAdd = new JButton("ADD");
	        btnAdd.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnAdd.setForeground(SystemColor.text);
	        btnAdd.setBackground(new Color(0, 204, 0));
	        JButton btnUpdate = new JButton("UPDATE");
	        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnUpdate.setForeground(SystemColor.text);
	        btnUpdate.setBackground(new Color(0, 204, 204));
	        
	        btnAdd.setBounds(786, 359, 86, 31);
	        btnUpdate.setBounds(696, 359, 80, 31);
	        
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(10, 56, 580, 292);
	        
	        getContentPane().setLayout(null);
	        getContentPane().add(pane);
	    
	        // add JButtons to the jframe
	        getContentPane().add(btnAdd);
	        getContentPane().add(btnUpdate);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(230, 230, 250));
	        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "USER DETAIL", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	        panel.setBounds(600, 56, 272, 292);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Staff ID :");
	        lblNewLabel.setBounds(10, 37, 73, 14);
	        panel.add(lblNewLabel);
	        
	        textPassword = new JTextField();
	        textPassword.setBounds(93, 198, 169, 20);
	        panel.add(textPassword);
	        textPassword.setColumns(10);
	        
	        textUsername = new JTextField();
	        textUsername.setBounds(93, 168, 169, 20);
	        panel.add(textUsername);
	        textUsername.setColumns(10);
	        JTextField textContact = new JTextField();
	        textContact.setBounds(93, 101, 169, 25);
	        panel.add(textContact);
	        JTextField textFname = new JTextField();
	        textFname.setBounds(93, 68, 169, 25);
	        panel.add(textFname);
	        
	        JLabel lblName = new JLabel("Name :");
	        lblName.setBounds(10, 70, 73, 14);
	        panel.add(lblName);
	        
	        JLabel lblContactNo = new JLabel("Contact No :");
	        lblContactNo.setBounds(10, 103, 73, 14);
	        panel.add(lblContactNo);
	        
	        JLabel lblDepartment = new JLabel("Department :");
	        lblDepartment.setBounds(10, 135, 73, 14);
	        panel.add(lblDepartment);
	        
	        JLabel lblUsername = new JLabel("Username  :");
	        lblUsername.setBounds(10, 168, 73, 14);
	        panel.add(lblUsername);
	        
	        JLabel lblPassword = new JLabel("Password :");
	        lblPassword.setBounds(10, 198, 73, 14);
	        panel.add(lblPassword);
	        
	        JLabel lblRole = new JLabel("Role  :");
	        lblRole.setBounds(10, 227, 73, 14);
	        panel.add(lblRole);
	        
	        JLabel textId = new JLabel("- Generate ID -");
	        textId.setBounds(93, 31, 169, 26);
	        panel.add(textId);
	        
	        JComboBox textRole = new JComboBox();
	        textRole.setModel(new DefaultComboBoxModel(new String[] {"- Select -", "Admin", "Staff"}));
	        textRole.setBounds(93, 227, 169, 20);
	        panel.add(textRole);
	        
	        JComboBox textDepartment = new JComboBox();
	        textDepartment.setModel(new DefaultComboBoxModel(new String[] {"- Select -", "Information Technology", "Marketing", "Human Resource Management", "Accounting and Finance"}));
	        textDepartment.setBounds(93, 137, 169, 20);
	        panel.add(textDepartment);
	        
	        JButton btnNewButton = new JButton("RESET");
	        btnNewButton.setForeground(new Color(255, 102, 0));
	        btnNewButton.setBackground(new Color(255, 255, 255));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent re) {
	        		if(re.getActionCommand()==btnNewButton.getActionCommand())
					{
	        			textId.setText("- Generate ID -");
		                textFname.setText("");
		                textContact.setText("");
		                textDepartment.setSelectedItem("- Select -");
		                textUsername.setText("");
		                textPassword.setText("");
		                textRole.setSelectedItem("- Select -");
					}
	        	}
	        });
	        btnNewButton.setBounds(10, 258, 252, 23);
	        panel.add(btnNewButton);
	        
	        JButton btnDelete = new JButton("DELETE");
	        btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnDelete.setForeground(new Color(255, 255, 255));
	        btnDelete.setBackground(new Color(255, 0, 0));
	        btnDelete.setBounds(600, 359, 86, 30);
	        getContentPane().add(btnDelete);
	        
	        JLabel lblNewLabel_1 = new JLabel("INVENTORY MANAGEMENT");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(606, 8, 266, 40);
	        getContentPane().add(lblNewLabel_1);
	        
	        ImageIcon stImg = new ImageIcon(new ImageIcon("image/stationery.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnStationaries = new JButton("STATIONARIES", stImg);
	        btnStationaries.setBackground(new Color(255, 255, 255));
	        btnStationaries.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent st) {
	        		if(st.getActionCommand()==btnStationaries.getActionCommand())
					{
	        			setVisible(false);
	        			Stationaries st1 = new Stationaries();
						st1.setVisible(true);
					}
	        	}
	        });
	        btnStationaries.setBounds(130, 8, 148, 37);
	        getContentPane().add(btnStationaries);
	        
	        ImageIcon empImg = new ImageIcon(new ImageIcon("image/register.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	        JButton btnEmployee = new JButton("EMPLOYEE", empImg);
	        btnEmployee.setForeground(new Color(255, 255, 255));
	        btnEmployee.setBackground(new Color(0, 153, 255));
	        btnEmployee.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	}
	        });
	        btnEmployee.setBounds(10, 8, 123, 37);
	        getContentPane().add(btnEmployee);
	        
	        ImageIcon frImg = new ImageIcon(new ImageIcon("image/furniture.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnFurniture = new JButton("FURNITURE", frImg);
	        btnFurniture.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent fr) {
	        		if(fr.getActionCommand()==btnFurniture.getActionCommand())
					{
	        			setVisible(false);
						Furniture openMenu = new Furniture();
						openMenu.setVisible(true);
					}
	        	}
	        });
	        btnFurniture.setBackground(new Color(255, 255, 255));
	        btnFurniture.setBounds(277, 8, 134, 37);
	        getContentPane().add(btnFurniture);
	        
//	        JButton btnDevice = new JButton("DEVICE");
	        ImageIcon deImg = new ImageIcon(new ImageIcon("image/device.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnDevice = new JButton("DEVICE", deImg);
	        btnDevice.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent de) {
	        		if(de.getActionCommand()==btnDevice.getActionCommand())
					{
	        			setVisible(false);
						Devices openMenu = new Devices();
						openMenu.setVisible(true);
					}
	        	}
	        });
	        btnDevice.setBackground(new Color(255, 255, 255));
	        btnDevice.setBounds(409, 8, 123, 37);
	        getContentPane().add(btnDevice);
	        
	        ImageIcon backImg = new ImageIcon(new ImageIcon("image/back.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	        JButton btnBack = new JButton("RETURN", backImg);
	        btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnBack.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent back) {
		        		if(back.getActionCommand()==btnBack.getActionCommand())
						{
		        			setVisible(false);
							AdminMenu openMenu = new AdminMenu();
							openMenu.setVisible(true);
						}
		        	}
	        });
	        btnBack.setBackground(new Color(255, 255, 255));
	        btnBack.setBounds(10, 353, 103, 37);
	        getContentPane().add(btnBack);
	        
	        ImageIcon refreshImg = new ImageIcon(new ImageIcon("image/refresh.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
	        JLabel back = new JLabel("");
	        back.setIcon(new ImageIcon("image/background2.png"));
	        back.setBounds(-323, 0, 1210, 407);
	        getContentPane().add(back);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[1500];
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException {
	            
	            	// i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                row[0] = textId.getText();
	                row[1] = textFname.getText();
	                row[2] = textContact.getText();
	                
	                if(textDepartment.getSelectedIndex()==1){
	                	row[3] = "Information Technology";
					}else if(textDepartment.getSelectedIndex()==2){
						row[3] = "Marketing";
					}else if(textDepartment.getSelectedIndex()==3){
						row[3] = "Human Resource Management";
					}else if(textDepartment.getSelectedIndex()==4){
						row[3] = "Accounting and Finance";
					}
	                
	                
	                row[4] = textUsername.getText();
	                row[5] = textPassword.getText();
	                
	                if(textRole.getSelectedIndex()==1){
	                	row[6] = "Admin";
					}else if(textRole.getSelectedIndex()==2){
						row[6] = "Staff";
					}
	                
	                String stff = (String) row[1];
	                String contact = (String) row[2];
	                String dpt = (String) row[3];
	                String uname = (String) row[4];
	                String pwd = (String) row[5];
	                String role = (String) row[6];

	                if((stff.equalsIgnoreCase("")) || (contact.equalsIgnoreCase("")) || (dpt.equalsIgnoreCase("")) ||  (uname.equalsIgnoreCase("")) || (pwd.equalsIgnoreCase("")) || (role.equalsIgnoreCase("")))
				        {
			            JOptionPane.showMessageDialog(null,
			                "No employee selected, Please select employee to delete.",
			                "Incorrect",
			                JOptionPane.ERROR_MESSAGE);
			        }else {
		                if(i >= 0){
		                    // remove a row from jtable
		                	try{
		                		
		                		JFrame frame = new JFrame();
		        				int result = JOptionPane.showConfirmDialog(frame,"Are you sure want to delete ?", "Confirmation Message",
		        			               JOptionPane.YES_NO_OPTION,
		        			               JOptionPane.QUESTION_MESSAGE);
		        			            if(result == JOptionPane.YES_OPTION){
		        			            	 String id = model.getValueAt(i, 0).toString();
		     		    	                
		     		    	                EmployeeReg regEmployee = new EmployeeReg(id,stff,contact,dpt,uname,pwd,role);
		     					            regEmployee.deleteEmployee();
		     		    	                
		     			                    model.removeRow(i);
		        			            }
			                  
		                	}catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
		                	 catch(ArrayIndexOutOfBoundsException execpt){System.out.println("");}
							 catch(IOException iox)  {   System.out.println(iox.getMessage());  } 
		                	 catch(NullPointerException npe) {  System.out.print("NullPointerException Caught"); }
							 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  }
		               }	
	                
	                else{
	                    System.out.println("Delete Error");
	                }
				  }
	            }
	        });
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[1] = textFname.getText();
	                row[2] = textContact.getText();
	                
	                if(textDepartment.getSelectedIndex()==0){
	                	row[3] = "";
					}else if(textDepartment.getSelectedIndex()==1){
	                	row[3] = "Information Technology";
					}else if(textDepartment.getSelectedIndex()==2){
						row[3] = "Marketing";
					}else if(textDepartment.getSelectedIndex()==3){
						row[3] = "Human Resource Management";
					}else if(textDepartment.getSelectedIndex()==4){
						row[3] = "Accounting and Finance";
					}
	                
	                row[4] = textUsername.getText();
	                row[5] = textPassword.getText();
	                
	                if(textRole.getSelectedIndex()==0){
	                	row[6] = "";
					}else if(textRole.getSelectedIndex()==1){
	                	row[6] = "Admin";
					}else if(textRole.getSelectedIndex()==2){
						row[6] = "Staff";
					} 
	                
	                String stff = (String) row[1];
	                String contact = (String) row[2];
	                String dpt = (String) row[3];
	                String uname = (String) row[4];
	                String pwd = (String) row[5];
	                String role = (String) row[6];
					 
					try{   
					  if((stff.equalsIgnoreCase("")) || (contact.equalsIgnoreCase("")) || (dpt.equalsIgnoreCase("")) ||  (uname.equalsIgnoreCase("")) || (pwd.equalsIgnoreCase("")) || (role.equalsIgnoreCase("")))
				        {
				            JOptionPane.showMessageDialog(null,
				                "Please enter all information",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE);
				        }else {
						 
				        EmployeeReg emp = new EmployeeReg();
				        String staffid = emp.generateID();
				     
				        EmployeeReg regEmployee = new EmployeeReg(staffid,stff,contact,dpt,uname,pwd,role);
			            regEmployee.regEmployee();
			            
			            row[0] = staffid;
					 	 
				        // add row to the model
			            model.addRow(row);
					 	 
					 	JOptionPane.showMessageDialog(null, "Register Successfully!");
				       }
						 
					 }  
					 catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
					 catch(IOException iox)  {   System.out.println(iox.getMessage());  } 
					 catch(NullPointerException npe) {  
						 JOptionPane.showMessageDialog(null,
				                "Please enter all information",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE); }
					 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  }
	             	            }
	        });
	        
	        // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textId.setText(model.getValueAt(i, 0).toString());
	            textFname.setText(model.getValueAt(i, 1).toString());
	            textContact.setText(model.getValueAt(i, 2).toString());
	            textDepartment.setSelectedItem(model.getValueAt(i, 3).toString());
	            textUsername.setText(model.getValueAt(i, 4).toString());
	            textPassword.setText(model.getValueAt(i, 5).toString());
	            textRole.setSelectedItem(model.getValueAt(i, 6).toString());
	            
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                row[0] = textId.getText();
	                row[1] = textFname.getText();
	                row[2] = textContact.getText();
	                
	                if(textDepartment.getSelectedIndex()==0){
	                	row[3] = "";
					}else if(textDepartment.getSelectedIndex()==1){
	                	row[3] = "Information Technology";
					}else if(textDepartment.getSelectedIndex()==2){
						row[3] = "Marketing";
					}else if(textDepartment.getSelectedIndex()==3){
						row[3] = "Human Resource Management";
					}else if(textDepartment.getSelectedIndex()==4){
						row[3] = "Accounting and Finance";
					}
	                
	                row[4] = textUsername.getText();
	                row[5] = textPassword.getText();
	                
	                if(textRole.getSelectedIndex()==0){
	                	row[6] = "";
					}else if(textRole.getSelectedIndex()==1){
						row[6] = "Admin";
					}else if(textRole.getSelectedIndex()==2){
						row[6] = "Staff";
					}
	                
	                String stff = (String) row[1];
	                String contact = (String) row[2];
	                String dpt = (String) row[3];
	                String uname = (String) row[4];
	                String pwd = (String) row[5];
	                String role = (String) row[6];

	                	try{
	                	String stffid = (String) row[0];
	    	           
    	                if((stff.equalsIgnoreCase("")))
    				        {
    			            JOptionPane.showMessageDialog(null,
    			                "Please select employee to update",
    			                "Incorrect",
    			                JOptionPane.ERROR_MESSAGE);
    			        }else if((stff.equalsIgnoreCase("")) || (contact.equalsIgnoreCase("")) || (dpt.equalsIgnoreCase("")) ||  (uname.equalsIgnoreCase("")) || (pwd.equalsIgnoreCase("")) || (role.equalsIgnoreCase("")))
     				       {
    			        	JOptionPane.showMessageDialog(null,
        			                "Please enter all information",
        			                "Incorrect",
        			                JOptionPane.ERROR_MESSAGE);
    			        }else {
    			        	String id = model.getValueAt(i, 0).toString();
 	    	                
					        EmployeeReg regEmployee = new EmployeeReg(id,stff,contact,dpt,uname,pwd,role);
				            regEmployee.UpdateDB();
	    	                
			            	JOptionPane.showMessageDialog(null, "Update Successfully!");
  
		                   model.setValueAt(id, i, 0);
		                   model.setValueAt(stff, i, 1);
		                   model.setValueAt(contact, i, 2);
		                   model.setValueAt(dpt, i, 3);
		                   model.setValueAt(uname, i, 4);
		                   model.setValueAt(pwd, i, 5);
		                   model.setValueAt(role, i, 6);
			    		   table.setModel(model);
    		              } 
	                	}catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	                	 catch(ArrayIndexOutOfBoundsException execpt){System.out.println("");}
						 catch(IOException iox)  {   System.out.println(iox.getMessage());  } 
						 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  } 
	                	
			        	}
	        });
        	
        }catch (Exception ex) {
        	 ex.printStackTrace();
        }
	}
	
	
}
