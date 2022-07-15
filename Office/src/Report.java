import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;


import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class Report extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setEnabled(false);
        setVisible(true);
        setLocationRelativeTo(null);
		
        setBounds(100, 100, 710, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 // create JFrame and JTable
        setTitle("OiS | Report");
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
       
	        JLabel lblNewLabel_1 = new JLabel("INVENTORY MANAGEMENT");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setBounds(160, 23, 403, 47);
	        getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblEmployee = new JLabel("EMPLOYEE");
	        lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblEmployee.setBounds(43, 106, 97, 28);
	        contentPane.add(lblEmployee);
	        
	        JLabel labelDeviceCount = new JLabel();
	        labelDeviceCount.setFont(new Font("Arial Black", Font.PLAIN, 28));
	        labelDeviceCount.setBounds(454, 132, 49, 37);
	        contentPane.add(labelDeviceCount);

	        JLabel labelFurnitureCount = new JLabel("");
	        labelFurnitureCount.setFont(new Font("Arial Black", Font.PLAIN, 28));
	        labelFurnitureCount.setBounds(614, 132, 42, 37);
	        contentPane.add(labelFurnitureCount);
	        
	        JLabel labelEmployeeCount = new JLabel("");
	        labelEmployeeCount.setFont(new Font("Arial Black", Font.PLAIN, 28));
	        labelEmployeeCount.setBounds(130, 131, 42, 37);
	        contentPane.add(labelEmployeeCount);
	        
	        JLabel lblStationaryCount = new JLabel("");
	        lblStationaryCount.setFont(new Font("Arial Black", Font.PLAIN, 28));
	        lblStationaryCount.setBounds(294, 131, 48, 37);
	        contentPane.add(lblStationaryCount);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setLayout(null);
	        panel_1.setBounds(0, 280, 704, 64);
	        contentPane.add(panel_1);
	        
	        JLabel lblTotalDevices = new JLabel("TOTAL DEVICES");
	        lblTotalDevices.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        lblTotalDevices.setBounds(22, 11, 277, 42);
	        panel_1.add(lblTotalDevices);
	        
	        JLabel label_1 = new JLabel("RM ");
	        label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        label_1.setBounds(519, 11, 48, 42);
	        panel_1.add(label_1);
	        
	        JLabel setDeicesRM = new JLabel("");
	        setDeicesRM.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        setDeicesRM.setBounds(568, 11, 126, 42);
	        panel_1.add(setDeicesRM);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setLayout(null);
	        panel_2.setBounds(0, 355, 704, 64);
	        contentPane.add(panel_2);
	        
	        JLabel lblTotalFurniture = new JLabel("TOTAL FURNITURE");
	        lblTotalFurniture.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        lblTotalFurniture.setBounds(22, 11, 277, 42);
	        panel_2.add(lblTotalFurniture);
	        

	        JLabel setFurnitureRM = new JLabel("");
	        setFurnitureRM.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        setFurnitureRM.setBounds(568, 11, 126, 42);
	        panel_2.add(setFurnitureRM);
	        
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(0, 205, 704, 64);
	        contentPane.add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("TOTAL STATIONARY");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        lblNewLabel.setBounds(22, 11, 277, 42);
	        panel.add(lblNewLabel);
	        
	        JLabel lblRm = new JLabel("RM ");
	        lblRm.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        lblRm.setBounds(520, 11, 53, 42);
	        panel.add(lblRm);
	        
	        JLabel setStationaryRM = new JLabel("");
	        setStationaryRM.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        setStationaryRM.setBounds(565, 11, 129, 42);
	        panel.add(setStationaryRM);
	        
	        JPanel panelEmployee = new JPanel();
	        panelEmployee.setBackground(Color.ORANGE);
	        panelEmployee.setForeground(Color.ORANGE);
	        panelEmployee.setBounds(30, 89, 151, 95);
	        contentPane.add(panelEmployee);
	        panelEmployee.setLayout(null);
	        
	        JPanel panelStationary = new JPanel();
	        panelStationary.setBackground(Color.CYAN);
	        panelStationary.setForeground(new Color(0, 204, 255));
	        panelStationary.setBounds(191, 89, 151, 95);
	        contentPane.add(panelStationary);
	        panelStationary.setLayout(null);
	        
	        JLabel lblStationary = new JLabel("STATIONARIES");
	        lblStationary.setBounds(10, 21, 124, 22);
	        panelStationary.add(lblStationary);
	        lblStationary.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        
	        JPanel panelDevices = new JPanel();
	        panelDevices.setBackground(new Color(0, 255, 153));
	        panelDevices.setForeground(new Color(153, 255, 153));
	        panelDevices.setBounds(352, 89, 151, 95);
	        contentPane.add(panelDevices);
	        panelDevices.setLayout(null);
	        
	        JLabel lblDevices = new JLabel("DEVICES");
	        lblDevices.setBounds(22, 21, 71, 22);
	        panelDevices.add(lblDevices);
	        lblDevices.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        
	        JPanel panelFurniture = new JPanel();
	        panelFurniture.setBackground(new Color(255, 51, 102));
	        panelFurniture.setForeground(new Color(153, 204, 102));
	        panelFurniture.setBounds(513, 89, 151, 95);
	        contentPane.add(panelFurniture);
	        panelFurniture.setLayout(null);
	        
	        JLabel labelFurniture = new JLabel("FURNITURE");
	        labelFurniture.setBounds(21, 24, 97, 14);
	        panelFurniture.add(labelFurniture);
	        labelFurniture.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        
	        JLabel label_4 = new JLabel("RM ");
	        label_4.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        label_4.setBounds(520, 11, 55, 42);
	        panel_2.add(label_4);
	        
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(0, 430, 704, 64);
			contentPane.add(panel_3);
			
			JLabel labelItemDisposed = new JLabel("0.0");
			labelItemDisposed.setFont(new Font("Tahoma", Font.PLAIN, 28));
			labelItemDisposed.setBounds(573, 11, 121, 42);
			panel_3.add(labelItemDisposed);
			
			JLabel lblTotalItemDisposed = new JLabel("TOTAL ITEM DISPOSED");
			lblTotalItemDisposed.setFont(new Font("Tahoma", Font.PLAIN, 28));
			lblTotalItemDisposed.setBounds(21, 11, 315, 42);
			panel_3.add(lblTotalItemDisposed);
			
			JLabel back = new JLabel("");
			back.setBounds(0, 0, 1064, 528);
			contentPane.add(back);
			back.setFont(new Font("Tahoma", Font.PLAIN, 28));
			back.setIcon(new ImageIcon("image/background2.png"));
	        
	        try{
		    	
		        // count device
		        int CountDevices = 0;
		        int dispose = 0;
				double totalDevices = 0.0;
		        BufferedReader in = new BufferedReader (new FileReader("db/devices.txt"));
				String inData;
				while((inData = in.readLine()) != null)   
				{    
					String[] dev = inData.split(";");
					String priceStored = dev[5];
					String status = dev[6];
					
					if(!status.equalsIgnoreCase("disposed")){
						double priceDB = Double.parseDouble(priceStored);
			        	totalDevices = totalDevices + priceDB;
						CountDevices++;
					}
					
					if(status.equalsIgnoreCase("disposed")){
			        	dispose++;
					}
				}
				
				// count furniture
				int CountFurniture = 0;
				double totalFurniture = 0.0;
		        BufferedReader Furniture = new BufferedReader (new FileReader("db/furniture.txt"));
				String inDataFurniture;
				while((inDataFurniture = Furniture.readLine()) != null)   
				{    
					String[] fur = inDataFurniture.split(";");
					String priceStored = fur[5];
					String status = fur[6];
					if(!status.equalsIgnoreCase("disposed")){
						double priceDB = Double.parseDouble(priceStored);
			        	totalFurniture = totalFurniture + priceDB;
						CountFurniture++;
					}
					
					if(status.equalsIgnoreCase("disposed")){
			        	dispose++;
					}
				}
				
				// count Employee
				int CountEmployee = 0;
		        BufferedReader Employee = new BufferedReader (new FileReader("db/userdb.txt"));
				String inDataEmployee;
				while((inDataEmployee = Employee.readLine()) != null)   
				{    
					CountEmployee++;
				}
				
				// count Stationary
				int CountStationary = 0;
				double totalStationary = 0.0;
		        BufferedReader Stationary = new BufferedReader (new FileReader("db/stationary.txt"));
				String inDataStationary;
				while((inDataStationary = Stationary.readLine()) != null)   
				{    
					String[] tokens = inDataStationary.split(";");
		        	String priceStored = tokens[5];
		        	String status = tokens[6];
					if(!status.equalsIgnoreCase("disposed")){
						double priceDB = Double.parseDouble(priceStored);
			        	totalStationary = totalStationary + priceDB;
						CountStationary++;
					}
					
					if(status.equalsIgnoreCase("disposed")){
			        	dispose++;
					}
				}
				
			    labelDeviceCount.setText(String.valueOf(CountDevices));
				labelFurnitureCount.setText(String.valueOf(CountFurniture));
				labelEmployeeCount.setText(String.valueOf(CountEmployee));
				lblStationaryCount.setText(String.valueOf(CountStationary));
				
				setStationaryRM.setText(String.valueOf(totalStationary));
				setFurnitureRM.setText(String.valueOf(totalFurniture));
				setDeicesRM.setText(String.valueOf(totalDevices));
				
				labelItemDisposed.setText(String.valueOf(dispose));
				
	        }catch (Exception ex) {
	        	 ex.printStackTrace();
	        }
	        
	}
	
	public void updateTable() {
		validate();
	   	repaint();
	}
}
