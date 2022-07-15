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
import java.util.InputMismatchException;
import java.util.Scanner;

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
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class StaffDevices extends JFrame {

	private JPanel contentPane;
	private JTextField textLocation;
	private JTextField textQty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffDevices frame = new StaffDevices();
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
	public StaffDevices() {
		setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setEnabled(false);
        setVisible(true);
        setLocationRelativeTo(null);
		
        setBounds(100, 100, 893, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 // create JFrame and JTable
        setTitle("OiS | Devices Management");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
        getContentPane().setBackground(SystemColor.textHighlight);
        JTable table = new JTable(); 
        
        try{
	    	 File file = new File("db/devices.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }	
        	BufferedReader br = new BufferedReader(new FileReader("db/devices.txt"));
	        // create a table model and set a Column Identifiers to this model 
	        String[] columns = { "Product ID","Manufacturer","Category","Date Purchased","Quantity","Price (RM)","Status" };
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setColumnIdentifiers(columns);
	        
	     // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            
         // set data to jtable model
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(";");
                String statusDB = dataRow[6];
				if(!statusDB.equalsIgnoreCase("disposed")){
	                model.addRow(dataRow);
				}
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
	        
	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(10, 56, 580, 460);
	        
	        getContentPane().setLayout(null);
	        getContentPane().add(pane);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(230, 230, 250));
	        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DEVICES DETAIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	        panel.setBounds(600, 56, 272, 177);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Code :");
	        lblNewLabel.setBounds(10, 37, 73, 14);
	        panel.add(lblNewLabel);
	        
	        JLabel lblName = new JLabel("Item Name :");
	        lblName.setBounds(10, 62, 73, 14);
	        panel.add(lblName);
	        
	        JLabel lblCategory = new JLabel("Category :");
	        lblCategory.setBounds(10, 87, 73, 14);
	        panel.add(lblCategory);
	        
	        JLabel lblQty = new JLabel("Quantity  :");
	        lblQty.setBounds(10, 112, 73, 14);
	        panel.add(lblQty);
	        
	        JLabel lblStatus = new JLabel("Status  :");
	        lblStatus.setBounds(10, 137, 73, 14);
	        panel.add(lblStatus);
	        
	        JLabel lblViewCode = new JLabel("");
	        lblViewCode.setBounds(93, 37, 146, 14);
	        panel.add(lblViewCode);
	        
	        JLabel labelViewItemName = new JLabel("");
	        labelViewItemName.setBounds(93, 62, 146, 14);
	        panel.add(labelViewItemName);
	        
	        JLabel labelCategory = new JLabel("");
	        labelCategory.setBounds(93, 87, 146, 14);
	        panel.add(labelCategory);
	        
	        JLabel labelQty = new JLabel("");
	        labelQty.setBounds(93, 112, 146, 14);
	        panel.add(labelQty);
	        
	        JLabel labelStatus = new JLabel("");
	        labelStatus.setBounds(89, 137, 150, 14);
	        panel.add(labelStatus);
	        String pattern  = "dd-MM-yyyy";
	        DateFormat formatter = new SimpleDateFormat(pattern);
	        
	        JLabel lblNewLabel_1 = new JLabel("INVENTORY MANAGEMENT");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(606, 8, 266, 40);
	        getContentPane().add(lblNewLabel_1);
	        
	        ImageIcon stImg = new ImageIcon(new ImageIcon("image/stationery.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnStationaries = new JButton("STATIONARIES", stImg);
	        btnStationaries.setForeground(Color.BLACK);
	        btnStationaries.setBackground(Color.WHITE);
	        btnStationaries.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent st) {
	        		if(st.getActionCommand()==btnStationaries.getActionCommand())
					{
	        			setVisible(false);
	        			Staffstationary st1 = new Staffstationary();
						st1.setVisible(true);
					}
	        	}
	        });
	        btnStationaries.setBounds(10, 8, 148, 37);
	        getContentPane().add(btnStationaries);
	        
	        ImageIcon empImg = new ImageIcon(new ImageIcon("image/register.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	        
	        ImageIcon frImg = new ImageIcon(new ImageIcon("image/furniture.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnFurniture = new JButton("FURNITURE", frImg);
	        btnFurniture.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent fr) {
	        		if(fr.getActionCommand()==btnFurniture.getActionCommand())
					{
	        			setVisible(false);
	        			Stafffurniture openMenu = new Stafffurniture();
						openMenu.setVisible(true);
					}
	        	}
	        });
	        btnFurniture.setBackground(Color.WHITE);
	        btnFurniture.setBounds(157, 8, 134, 37);
	        getContentPane().add(btnFurniture);
	        
//	        JButton btnDevice = new JButton("DEVICE");
	        ImageIcon deImg = new ImageIcon(new ImageIcon("image/device.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnDevice = new JButton("DEVICE", deImg);
	        btnDevice.setForeground(Color.WHITE);
	        btnDevice.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent de) {
	        		if(de.getActionCommand()==btnDevice.getActionCommand())
					{
	        			setVisible(false);
	        			StaffDevices openMenu = new StaffDevices();
						openMenu.setVisible(true);
					}
	        	}
	        });
	        btnDevice.setBackground(new Color(0, 153, 255));
	        btnDevice.setBounds(289, 8, 123, 37);
	        getContentPane().add(btnDevice);
	        
	        ImageIcon backImg = new ImageIcon(new ImageIcon("image/back.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	        JButton btnBack = new JButton("LOG OUT", backImg);
	        btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnBack.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent back) {
	        			JFrame frame = new JFrame();
						int result = JOptionPane.showConfirmDialog(frame,"Are you sure want to log out ?", "Confirm Message",
					               JOptionPane.YES_NO_OPTION,
					               JOptionPane.QUESTION_MESSAGE);
					            if(result == JOptionPane.YES_OPTION){
					            	setVisible(false);
					    			Login log = new Login();
					    			log.setVisible(true);
						          
					            }
		        	}
	        });
	        btnBack.setBackground(new Color(255, 255, 255));
	        btnBack.setBounds(10, 527, 117, 37);
	        getContentPane().add(btnBack);
	        
	        ImageIcon refreshImg = new ImageIcon(new ImageIcon("image/refresh.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
	        JPanel panelBorrow = new JPanel();
	        panelBorrow.setBorder(new TitledBorder(null, "BORROWER DETAIL", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	        panelBorrow.setBounds(600, 244, 272, 272);
	        contentPane.add(panelBorrow);
	        panelBorrow.setLayout(null);
	        
	        JLabel lblSraffID = new JLabel("Staff ID :");
	        lblSraffID.setBounds(10, 39, 74, 14);
	        panelBorrow.add(lblSraffID);
	        
	        JLabel lblStaffName = new JLabel("Staff Name :");
	        lblStaffName.setBounds(10, 70, 74, 14);
	        panelBorrow.add(lblStaffName);
	        
	        JLabel lblContactNo = new JLabel("Contact No :");
	        lblContactNo.setBounds(10, 101, 74, 14);
	        panelBorrow.add(lblContactNo);
	        
	        JLabel lblDepartment = new JLabel("Department :");
	        lblDepartment.setBounds(10, 136, 74, 14);
	        panelBorrow.add(lblDepartment);
	        
	        JLabel lblDateBorrow = new JLabel("Date Request:");
	        lblDateBorrow.setBounds(10, 172, 88, 14);
	        panelBorrow.add(lblDateBorrow);
	        
	        JLabel labelViewName = new JLabel("");
	        labelViewName.setBounds(94, 70, 150, 14);
	        panelBorrow.add(labelViewName);
	        
	        JLabel labelViewContact = new JLabel("");
	        labelViewContact.setBounds(94, 101, 150, 14);
	        panelBorrow.add(labelViewContact);
	        
	        JLabel lblLocationUse = new JLabel("Location Use :");
	        lblLocationUse.setBounds(10, 207, 88, 14);
	        panelBorrow.add(lblLocationUse);
	        
	        JLabel labelCode = new JLabel("");
	        lblLocationUse.setBounds(10, 207, 88, 14);
	        panelBorrow.add(labelCode);
	        
	        JDateChooser dateBorrow = new JDateChooser();
	        dateBorrow.setBounds(94, 172, 150, 20);
	        panelBorrow.add(dateBorrow);
	        
	        textLocation = new JTextField();
	        textLocation.setBounds(94, 204, 150, 20);
	        panelBorrow.add(textLocation);
	        textLocation.setColumns(10);
	        
	        JComboBox staffIDSelect = new JComboBox();
	        staffIDSelect.setBounds(94, 36, 150, 20);
	        panelBorrow.add(staffIDSelect);
	        
	        JLabel lblViewDepartment = new JLabel("");
	        lblViewDepartment.setBounds(94, 136, 150, 14);
	        panelBorrow.add(lblViewDepartment);
	        
        	DefaultComboBoxModel staffID = new DefaultComboBoxModel();
	        try{
	        	File dbRead = new File("db/userdb.txt");
		        BufferedReader reader = new BufferedReader(new FileReader(dbRead));
		        
		        String code = null;
                String name = null;
                String contact = null;
                String departmnt = null;

//		        staffIDSelect.addItem("- Please Select -");
		        Object[] lines = reader.lines().toArray();
		        for(int i = 0; i < lines.length; i++){
	                String line = lines[i].toString();
	                String[] tokens = line.split(";");
	                 code = tokens[0];
	                 staffIDSelect.addItem(code);   
        
	            }
		        
		        staffIDSelect.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
				        
		    	    	String codeSelect = null;
		            	String nameSelect = null;
		            	String contactSelect = null;
		            	String departmntSelect = null;
		            	
		        		int index = staffIDSelect.getSelectedIndex();
		    	        
		    	        for(int i = 0; i < lines.length; i++){
		               	 	String line = lines[i].toString();
		                    String[] tokens = line.split(";");
		                    if(i == index){
		    	                 codeSelect = tokens[0];
		    	                 nameSelect = tokens[1];
		    	                 contactSelect = tokens[2];
		    	                 departmntSelect = tokens[3]; 
		                    }
		                }
						labelCode.setText(codeSelect);
		    	        labelViewName.setText(nameSelect);
		    	        labelViewContact.setText(contactSelect);
		    	        lblViewDepartment.setText(departmntSelect);
		        	}
		        });
        	  
		        
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        
	        
	        JLabel lblQuantity = new JLabel("Quantity :");
	        lblQuantity.setBounds(10, 235, 88, 26);
	        panelBorrow.add(lblQuantity);
	        
	        textQty = new JTextField();
	        textQty.setColumns(10);
	        textQty.setBounds(94, 238, 150, 20);
	        panelBorrow.add(textQty);
	        
	        JButton btnrReq = new JButton("REQUEST");
	        btnrReq.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
        		String codeItem = lblViewCode.getText();
        		String nameItem = labelViewItemName.getText();
        		String cat = labelCategory.getText();
        		String staffID = labelCode.getText();
        		String nameLend = labelViewName.getText();
        		String contact = labelViewContact.getText();
        		String dpt = lblViewDepartment.getText();
        		String loc = textLocation.getText();
        		String reqQty = textQty.getText();
        		
	        	if((nameLend.equalsIgnoreCase("")) || (codeItem.equalsIgnoreCase(null)) || (nameItem.equalsIgnoreCase(null)) || (cat.equalsIgnoreCase(null)) ||  (reqQty.equalsIgnoreCase("")) || (nameLend.equalsIgnoreCase(null)) || (contact.equalsIgnoreCase(null))|| (loc.equalsIgnoreCase("")))
			        {
		            JOptionPane.showMessageDialog(null,
		                "Please enter all information",
		                "Incorrect",
		                JOptionPane.ERROR_MESSAGE);
		        }else {

		        	 // create an array of objects to set the row data
		        	Object[] row = new Object[1500];
			        
		        	int i = table.getSelectedRow();
		        	if(i>=0){
		        		try{ 

		            	int qty = Integer.parseInt(reqQty);
		            		
			        	row[4] = labelQty.getText();
			        	String crrtQty = (String) row[4];
			        	String ldQty = textQty.getText();
			        	
			        	int lendQty = Integer.parseInt(ldQty);
		        		int currentQty = Integer.parseInt(crrtQty);
		        		int minus = currentQty - lendQty;
		        		String newquantity = new Integer(minus).toString(); 
		        		
		        		if(lendQty < 0 || lendQty == 0 ){
		        			JOptionPane.showMessageDialog(null,
					                "Cannot be negative number or zero",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE);
		        			
		        		}else if(lendQty > currentQty) {
		        			JOptionPane.showMessageDialog(null,
					                "Item not enough",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE); 
		        		}else{
		        			String dateReg = formatter.format(dateBorrow.getDate());
				        	LendReg request = new LendReg( staffID,  nameLend,  contact , dpt, codeItem,  nameItem,  cat,  dateReg,  loc,  qty);        	
				        	
				        	request.lendReg();
				        	request.updateQtyDevices();
				        	
			        		 if(minus == 0){
			        			String status = "In Use";
			        			model.setValueAt(status, i, 6);
			        		 }
				        	
				        	model.setValueAt(newquantity, i, 4);
				    		table.setModel(model);
				    		labelQty.setText(newquantity);
		        		}
					}catch(NullPointerException npe) {  
						 JOptionPane.showMessageDialog(null,
				                "All field are required, Please enter all information",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE); }
	        		catch (InputMismatchException im) {
						 JOptionPane.showMessageDialog(null,
					                "Try again. (Incorrect input for quantity)",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE); }
					 catch (NumberFormatException NF ){  
						 JOptionPane.showMessageDialog(null,
					                "Wrong input for quantity.",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE); }
					 catch(Exception ex)  {   System.out.println("problem: " +ex.getMessage());  }
		        	}else	{
				        	JOptionPane.showMessageDialog(null,
					                "Please select Device first !",
					                "Incorrect",
					                JOptionPane.ERROR_MESSAGE); 
				        	}
		        	
		        }	
	        	}
	        });
	        btnrReq.setForeground(new Color(255, 255, 255));
	        btnrReq.setBackground(new Color(0, 204, 51));
	        btnrReq.setBounds(600, 527, 272, 37);
	        contentPane.add(btnrReq);
	        
	        ImageIcon reqImg = new ImageIcon(new ImageIcon("image/request.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        JButton btnListRequest = new JButton("LIST REQUEST", reqImg);
	        btnListRequest.setForeground(Color.BLACK);
	        btnListRequest.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
					Request openMenu = new Request();
					openMenu.setVisible(true);
					
	        	}
	        });
	        btnListRequest.setBackground(Color.WHITE);
	        btnListRequest.setBounds(408, 8, 148, 37);
	        contentPane.add(btnListRequest);
	        
	        JLabel back = new JLabel("");
	        back.setIcon(new ImageIcon("image/background2.png"));
	        back.setBounds(-323, 8, 1210, 599);
	        getContentPane().add(back);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[1500];
	        
	        // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            int i = table.getSelectedRow();
	            
	            lblViewCode.setText(model.getValueAt(i, 0).toString());
	            labelViewItemName.setText(model.getValueAt(i, 1).toString());
	            labelCategory.setText(model.getValueAt(i, 2).toString());
	            labelQty.setText(model.getValueAt(i, 4).toString());
	            labelStatus.setText(model.getValueAt(i, 6).toString());
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
