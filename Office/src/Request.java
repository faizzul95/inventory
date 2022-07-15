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

public class Request extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request frame = new Request();
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
	public Request() {
		setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setEnabled(false);
        setVisible(true);
        setLocationRelativeTo(null);
		
        setBounds(100, 100, 893, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 // create JFrame and JTable
        setTitle("OiS | Lend");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
        getContentPane().setBackground(SystemColor.textHighlight);
        JTable table = new JTable(); 
        
        try{
	    	 File file = new File("db/lend.txt");
			 // check if file dont exits, automatically create
	       	  if(!file.exists()){
	       		file.createNewFile();
	       	  }	
        	BufferedReader br = new BufferedReader(new FileReader(file));
	        // create a table model and set a Column Identifiers to this model 
        	String[] columns = { "Staff ID","Staff Name","Contact","Department","Code Item","Item Name","Category","Date Request","Location","Quantity"};
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
	       	table.revalidate();
	       	table.repaint();
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
	        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "INVENTORY DETAIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	        panel.setBounds(600, 56, 272, 177);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Code :");
	        lblNewLabel.setBounds(36, 51, 45, 14);
	        panel.add(lblNewLabel);
	        
	        JLabel lblName = new JLabel("Item Name :");
	        lblName.setBounds(10, 84, 73, 14);
	        panel.add(lblName);
	        
	        JLabel lblCategory = new JLabel("Category :");
	        lblCategory.setBounds(17, 119, 64, 14);
	        panel.add(lblCategory);
	        
	        JLabel lblViewCode = new JLabel("");
	        lblViewCode.setBounds(91, 51, 146, 14);
	        panel.add(lblViewCode);
	        
	        JLabel labelCategory = new JLabel("");
	        labelCategory.setBounds(91, 119, 146, 14);
	        panel.add(labelCategory);
	        
	        JLabel labelQty = new JLabel("");
	        labelQty.setBounds(93, 84, 146, 14);
	        panel.add(labelQty);
	        String pattern  = "dd-MM-yyyy";
	        DateFormat formatter = new SimpleDateFormat(pattern);
	        
	        JLabel lblNewLabel_1 = new JLabel("INVENTORY MANAGEMENT");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(606, 8, 266, 40);
	        getContentPane().add(lblNewLabel_1);
	        
	        ImageIcon stImg = new ImageIcon(new ImageIcon("image/stationery.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
	        ImageIcon empImg = new ImageIcon(new ImageIcon("image/register.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	        
	        ImageIcon frImg = new ImageIcon(new ImageIcon("image/furniture.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
//	        JButton btnDevice = new JButton("DEVICE");
	        ImageIcon deImg = new ImageIcon(new ImageIcon("image/device.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
	        ImageIcon backImg = new ImageIcon(new ImageIcon("image/close.png").getImage().getScaledInstance(20, 25, Image.SCALE_DEFAULT));
	        JButton btnBack = new JButton("CLOSE", backImg);
	        btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
	        btnBack.addActionListener(new ActionListener() {
	        		public void actionPerformed(ActionEvent back) {
		        		if(back.getActionCommand()==btnBack.getActionCommand())
						{
		        			setVisible(false);
						}
		        	}
	        });
	        btnBack.setBackground(new Color(255, 255, 255));
	        btnBack.setBounds(10, 14, 94, 37);
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
	        lblLocationUse.setBounds(10, 207, 88, 14);
	        
	        JLabel lblViewDepartment = new JLabel("");
	        lblViewDepartment.setBounds(94, 136, 150, 14);
	        panelBorrow.add(lblViewDepartment);
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
	            }
        	  
		        
	        }catch(FileNotFoundException fe)  {   System.out.println(fe.getMessage());  } 
	        
	        
	        JLabel lblQuantity = new JLabel("Quantity :");
	        lblQuantity.setBounds(26, 235, 58, 26);
	        panelBorrow.add(lblQuantity);
	        
	        JLabel lblStaffID = new JLabel("");
	        lblStaffID.setBounds(94, 39, 150, 14);
	        panelBorrow.add(lblStaffID);
	        
	        JLabel labelDate = new JLabel("");
	        labelDate.setBounds(94, 172, 150, 14);
	        panelBorrow.add(labelDate);
	        
	        JLabel labelUse = new JLabel("");
	        labelUse.setBounds(94, 207, 150, 14);
	        panelBorrow.add(labelUse);
	        
	        JLabel labelLendQty = new JLabel("");
	        labelLendQty.setBounds(94, 241, 150, 14);
	        panelBorrow.add(labelLendQty);
	        
	        ImageIcon reqImg = new ImageIcon(new ImageIcon("image/request.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	        
	        JLabel back = new JLabel("");
	        back.setIcon(new ImageIcon("image/background2.png"));
	        back.setBounds(-323, -12, 1210, 619);
	        getContentPane().add(back);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[1500];
	        
	        // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            lblStaffID.setText(model.getValueAt(i, 0).toString());
	            labelViewName.setText(model.getValueAt(i, 1).toString());
	            labelViewContact.setText(model.getValueAt(i, 2).toString());
	            lblViewDepartment.setText(model.getValueAt(i, 3).toString());
	            lblViewCode.setText(model.getValueAt(i, 4).toString());
	            labelQty.setText(model.getValueAt(i, 5).toString());
	            labelCategory.setText(model.getValueAt(i, 6).toString());
	            labelDate.setText(model.getValueAt(i, 7).toString());
	            labelUse.setText(model.getValueAt(i, 8).toString());
	            labelLendQty.setText(model.getValueAt(i, 9).toString());
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
