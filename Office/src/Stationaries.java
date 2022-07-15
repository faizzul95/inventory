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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import com.toedter.calendar.JDateChooser;

public class Stationaries extends JFrame {

	private JPanel contentPane;
	private JTextField textPrice;
	private JTextField textQty;
	private JTextField textCode;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stationaries frame = new Stationaries();
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
	public Stationaries() {
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
        setTitle("OiS | Stationaries Management");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
        getContentPane().setBackground(SystemColor.textHighlight);
        JTable table = new JTable(); 
        
        try{
	    	 File file = new File("db/stationary.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }	
        	BufferedReader br = new BufferedReader(new FileReader(file));
	        // create a table model and set a Column Identifiers to this model 
	        String[] columns = { "Code","Item Name","Category","Date Purchased","Quantity","Price (RM)","Status" };
//	        DefaultTableModel model = new DefaultTableModel();
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

	        model.fireTableDataChanged();
	        // set the model to the table
	        table.setModel(model);
	        
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
	        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "STATIONARY DETAIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	        panel.setBounds(600, 56, 272, 292);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Code :");
	        lblNewLabel.setBounds(10, 37, 73, 14);
	        panel.add(lblNewLabel);
	        
	        textPrice = new JTextField();
	        textPrice.setBounds(93, 198, 169, 20);
	        panel.add(textPrice);
	        textPrice.setColumns(10);
	        
	        textQty = new JTextField();
	        textQty.setBounds(93, 168, 169, 20);
	        panel.add(textQty);
	        textQty.setColumns(10);
	        JTextField textItemname = new JTextField();
	        textItemname.setBounds(93, 68, 169, 25);
	        panel.add(textItemname);
	        
	        JLabel lblName = new JLabel("Item Name :");
	        lblName.setBounds(10, 70, 73, 14);
	        panel.add(lblName);
	        
	        JLabel lblCategory = new JLabel("Category :");
	        lblCategory.setBounds(10, 103, 73, 14);
	        panel.add(lblCategory);
	        
	        JLabel lblDate = new JLabel("Date");
	        lblDate.setBounds(10, 128, 61, 14);
	        panel.add(lblDate);
	        
	        JLabel lblQty = new JLabel("Quantity  :");
	        lblQty.setBounds(10, 168, 73, 14);
	        panel.add(lblQty);
	        
	        JLabel lbl = new JLabel("Price (RM)  :");
	        lbl.setBounds(10, 198, 73, 14);
	        panel.add(lbl);
	        
	        JLabel lblStatus = new JLabel("Status  :");
	        lblStatus.setBounds(10, 227, 73, 14);
	        panel.add(lblStatus);
	        
	        JComboBox textStatus = new JComboBox();
	        textStatus.setModel(new DefaultComboBoxModel(new String[] {"- Select -", "Stored", "In Use", "Disposed"}));
	        textStatus.setBounds(93, 227, 169, 20);
	        panel.add(textStatus);
	        
	        JComboBox textCategory = new JComboBox();
	        textCategory.setModel(new DefaultComboBoxModel(new String[] {"- Select -", "Writing Instruments", "Packing & Adhesives", "Desktop Stationary", "Filing Products"}));
	        textCategory.setBounds(93, 104, 169, 20);
	        panel.add(textCategory);
	        
	        JDateChooser setDatePurchase = new JDateChooser();
	        String pattern  = "dd-MM-yyyy";
	        DateFormat formatter = new SimpleDateFormat(pattern);
	        setDatePurchase.setBounds(93, 135, 169, 20);
	        panel.add(setDatePurchase);
	        
	        JButton btnNewButton = new JButton("RESET");
	        btnNewButton.setForeground(new Color(255, 102, 0));
	        btnNewButton.setBackground(new Color(255, 255, 255));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent re) {
	        		if(re.getActionCommand()==btnNewButton.getActionCommand())
					{
	        			textCode.setText("");
		                textItemname.setText("");
		                textCategory.setSelectedItem("- Select -");
		                setDatePurchase.setDate(null);
		                textQty.setText("");
		                textPrice.setText("");
		                textStatus.setSelectedItem("- Select -");
					}
	        	}
	        });
	        btnNewButton.setBounds(10, 258, 252, 23);
	        panel.add(btnNewButton);
	        
	        textCode = new JTextField();
	        textCode.setBounds(93, 32, 169, 25);
	        panel.add(textCode);
	        
	        JLabel lblPurchased = new JLabel("Purchased :");
	        lblPurchased.setBounds(10, 135, 83, 25);
	        panel.add(lblPurchased);
	        
	    
//	        ImageIcon imageIcon = new ImageIcon(new ImageIcon("image/delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
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
	        btnStationaries.setForeground(new Color(255, 255, 255));
	        btnStationaries.setBackground(new Color(0, 153, 255));
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
	        btnEmployee.setBackground(new Color(255, 255, 255));
	        btnEmployee.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent emp) {
	        		if(emp.getActionCommand()==btnEmployee.getActionCommand())
					{
	        			setVisible(false);
						Employee openMenu = new Employee();
						openMenu.setVisible(true);
					}
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
	                
	                row[0] = textCode.getText();
	                row[1] = textItemname.getText();
	                
	                if(textCategory.getSelectedIndex()==0){
	                	row[2] = "";
					}else  if(textCategory.getSelectedIndex()==1){
	                	row[2] = "Writing Instruments";
					}else if(textCategory.getSelectedIndex()==2){
						row[2] = "Packing & Adhesives";
					}else if(textCategory.getSelectedIndex()==3){
						row[2] = "Desktop Stationary";
					}else if(textCategory.getSelectedIndex()==4){
						row[2] = "Filing Products";
					}
	                row[4] = textQty.getText();
	                row[5] = textPrice.getText();
	                
	                if(textStatus.getSelectedIndex()==0){
	                	row[6] = "";
					}else if(textStatus.getSelectedIndex()==1){
	                	row[6] = "Stored";
					}else if(textStatus.getSelectedIndex()==2){
						row[6] = "In Use";
					}else if(textStatus.getSelectedIndex()==3){
						row[6] = "Disposed";
					}
	                
	                String code = (String) row[0];
	                String itemname = (String) row[1];
	                String cat = (String) row[2];
	                String quantity = (String) row[4];
	                String priceStored = (String) row[5];
	                String status = (String) row[6];
	            
	               if(i >= 0){
	                	try{
		                	
		                		  
    	                int qty = Integer.parseInt(quantity);
    	                double price = Double.parseDouble(priceStored);

                	    if((code.equalsIgnoreCase("")) || (itemname.equalsIgnoreCase("")) || (cat.equalsIgnoreCase("")) ||  (qty==0) || (price==0.0) || (status.equalsIgnoreCase("")))
				        {
			            JOptionPane.showMessageDialog(null,
			                "Please select stationaries first!",
			                "Incorrect",
			                JOptionPane.ERROR_MESSAGE);
					        }else {
		                		JFrame frame = new JFrame();
		        				int result = JOptionPane.showConfirmDialog(frame,"Are you sure want to delete ?", "Confirm Message",
		        			               JOptionPane.YES_NO_OPTION,
		        			               JOptionPane.QUESTION_MESSAGE);
	        			            if(result == JOptionPane.YES_OPTION){
	    		    	                String id = model.getValueAt(i, 0).toString();
	    		    	                String datePurchase = (String) row[3];
	    		    	            	StationariesReg RegStationaries = new StationariesReg(code,itemname,cat,datePurchase,qty,price,status);
	    				               	RegStationaries.deleteStationary();
	
	    			                    // remove a row from jtable
	    			                    model.removeRow(i);
	        			            }
					        	}
		                	}catch(ArrayIndexOutOfBoundsException execpt){System.out.println("");}
	                		 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  }
					  }
	                else{
	                    JOptionPane.showMessageDialog(null,
				                "Please select stationaries to delete!",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textCode.getText();
	                row[1] = textItemname.getText();
	                
	                if(textCategory.getSelectedIndex()==0){
	                	row[2] = "";
					}else  if(textCategory.getSelectedIndex()==1){
	                	row[2] = "Writing Instruments";
					}else if(textCategory.getSelectedIndex()==2){
						row[2] = "Packing & Adhesives";
					}else if(textCategory.getSelectedIndex()==3){
						row[2] = "Desktop Stationary";
					}else if(textCategory.getSelectedIndex()==4){
						row[2] = "Filing Products";
					}
	                
	                row[4] = textQty.getText();
	                row[5] = textPrice.getText();
	                
	                if(textStatus.getSelectedIndex()==0){
	                	row[6] = "";
					}else if(textStatus.getSelectedIndex()==1){
	                	row[6] = "Stored";
					}else if(textStatus.getSelectedIndex()==2){
						row[6] = "In Use";
					}else if(textStatus.getSelectedIndex()==3){
						row[6] = "Disposed";
					}
	                
	                String code = (String) row[0];
	                String itemname = (String) row[1];
	                String cat = (String) row[2];
	                String quantity = (String) row[4];
	                String priceStored = (String) row[5];
	                String status = (String) row[6];
	                
	                PrintWriter stationaryDB = null;
					try{  

		                int qty = Integer.parseInt(quantity);
		                double price = Double.parseDouble(priceStored);


	                if((code.equalsIgnoreCase("")) || (itemname.equalsIgnoreCase("")) || (cat.equalsIgnoreCase("")) ||  (qty==0) || (price==0.0) || (status.equalsIgnoreCase("")))
				        {
			            JOptionPane.showMessageDialog(null,
			                "Please enter all information",
			                "Incorrect",
			                JOptionPane.ERROR_MESSAGE);
			        }else {
			                row[3] = formatter.format(setDatePurchase.getDate());
			                
			                String datePurchase = (String) row[3];
					     
			               	StationariesReg RegStationaries = new StationariesReg(code,itemname,cat,datePurchase,qty,price,status);
			              
						  	// check code in db
			        		BufferedReader input = new BufferedReader (new FileReader("db/stationary.txt")); 

							boolean codeExist = false;
			        		String data = null;
			                while((data = input.readLine()) != null)
							{
								String[] tokens = data.split(";");
                	        	String codeDB = tokens[0];
								
                	        	if(codeDB.equalsIgnoreCase(textCode.getText()))
				                {
                	        		codeExist = true;
				                } 
							}
							input.close();
							
							if(!codeExist){
							 	RegStationaries.regStationary();
							 	JOptionPane.showMessageDialog(null, "Register Successfully!");

						        // add row to the model
					            model.addRow(row);
				            }else{JOptionPane.showMessageDialog(null,
     				                    "Error ! Code item already registers",
     				                    "Incorrect",
     				                    JOptionPane.ERROR_MESSAGE);
				            }
			         	}
					 }  
					 catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
					 catch(IOException iox)  {   System.out.println(iox.getMessage());  } 
					 catch(NullPointerException npe) {  
						 JOptionPane.showMessageDialog(null,
				                "All field are required, Please enter all information",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE); }
					 catch (NumberFormatException NF ){  
						 JOptionPane.showMessageDialog(null,
					                "Wrong input for quantity or price.",
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
	            
	            textCode.setText(model.getValueAt(i, 0).toString());
	            textItemname.setText(model.getValueAt(i, 1).toString());
	            textCategory.setSelectedItem(model.getValueAt(i, 2).toString());
	            java.util.Date date = null;
				try {
					date = new SimpleDateFormat("dd-MM-yyyy").parse((String)model.getValueAt(i, 3));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            setDatePurchase.setDate(date);

	            textQty.setText(model.getValueAt(i, 4).toString());
	            textPrice.setText(model.getValueAt(i, 5).toString());
	            textStatus.setSelectedItem(model.getValueAt(i, 6).toString());
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                row[0] = textCode.getText();
	                row[1] = textItemname.getText();

	                if(textCategory.getSelectedIndex()==0){
	                	row[2] = "";
					}else if(textCategory.getSelectedIndex()==1){
	                	row[2] = "Writing Instruments";
					}else if(textCategory.getSelectedIndex()==2){
						row[2] = "Packing & Adhesives";
					}else if(textCategory.getSelectedIndex()==3){
						row[2] = "Desktop Stationary";
					}else if(textCategory.getSelectedIndex()==4){
						row[2] = "Filing Products";
					}
	                
	                row[4] = textQty.getText();
	                row[5] = textPrice.getText();
	                
	                if(textStatus.getSelectedIndex()==0){
	                	row[6] = "";
					}else if(textStatus.getSelectedIndex()==1){
	                	row[6] = "Stored";
					}else if(textStatus.getSelectedIndex()==2){
						row[6] = "In Use";
					}else if(textStatus.getSelectedIndex()==3){
						row[6] = "Disposed";
					}
	                
	                String code = (String) row[0];
	                String itemname = (String) row[1];
	                String cat = (String) row[2];
	                String quantity = (String) row[4];
	                String priceStored = (String) row[5];
	                String status = (String) row[6];

	                if(i >= 0){
	                	try{
	                		
	                		int qty = Integer.parseInt(quantity);
	       	                double price = Double.parseDouble(priceStored);
	                		if((code.equalsIgnoreCase("")) || (itemname.equalsIgnoreCase("")) || (cat.equalsIgnoreCase("")) ||  (qty==0) || (price==0.0) || (status.equalsIgnoreCase("")))
					        {
				            JOptionPane.showMessageDialog(null,
				                "All field are required, Please enter all information",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE);
				        }else {
	    	                String id = model.getValueAt(i, 0).toString();
	    	                row[3] = formatter.format(setDatePurchase.getDate());
	    	                
	    	                String datePurchase = (String) row[3];
	    	            	StationariesReg updateStationaries = new StationariesReg(code,itemname,cat,datePurchase,qty,price,status);
	    	            	updateStationaries.UpdateStationary();
			               	
	    	            	String date = (String) row[3];
	    	            	
	    	            	model.setValueAt(code, i, 0);
		                    model.setValueAt(itemname, i, 1);
		                    model.setValueAt(cat, i, 2);
		                    model.setValueAt(date, i, 3);
		                    model.setValueAt(qty, i, 4);
		                    model.setValueAt(price, i, 5);
		                    model.setValueAt(status, i, 6);
			    		    table.setModel(model);

			            }    
	                	}catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	                	 catch(ArrayIndexOutOfBoundsException execpt){System.out.println("");}
						 catch(IOException iox)  {   System.out.println(iox.getMessage());  } 
	                	 catch(NullPointerException npe) {  
							 JOptionPane.showMessageDialog(null,
					                "All field are required, Please enter all information",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE); }
	                	 catch (NumberFormatException NF ){  
							 JOptionPane.showMessageDialog(null,
						                "Wrong input for quantity or price.",
						                "Incorrect",
						                JOptionPane.ERROR_MESSAGE); }
						 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  } 
	                	
			        	}
	                else{
	                    JOptionPane.showMessageDialog(null,
				                "Please select stationaries to update first !",
				                "Error",
				                JOptionPane.ERROR_MESSAGE);
	                }   
			      }
	        });
        	
        }catch (Exception ex) {
        	 ex.printStackTrace();
        }
 
	}
	
	public void updateTable() {
		validate();
	   	repaint();
	}
}
