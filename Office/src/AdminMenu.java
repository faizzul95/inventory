import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java Programming Workspace\\Office\\image\\logo.png"));
		setResizable(false);
		setTitle("OIS | ADMIN MENU");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 985, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(531, 0, 451, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDev = new JLabel("");
		lblDev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent device) {
				 setVisible(false);
				 Devices openMenu = new Devices();
                 openMenu.setVisible(true);
			}
		});
		lblDev.setBounds(82, 256, 103, 109);
		panel.add(lblDev);
		lblDev.setIcon(new ImageIcon(new ImageIcon("image/device.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		JLabel lblFur = new JLabel("");
		lblFur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent furniture) {
				 setVisible(false);
				 Furniture openMenu = new Furniture();
                 openMenu.setVisible(true);
			}
		});
		lblFur.setBounds(276, 256, 100, 109);
		panel.add(lblFur);
		lblFur.setIcon(new ImageIcon(new ImageIcon("image/furniture.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		JLabel lblFurniture = new JLabel("FURNITURE");
		lblFurniture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Furniture openMenu = new Furniture();
                openMenu.setVisible(true);
			}
		});
		lblFurniture.setBounds(257, 230, 148, 29);
		panel.add(lblFurniture);
		lblFurniture.setFont(new Font("Arial Black", Font.PLAIN, 22));
		
		JLabel lblDevices = new JLabel("DEVICES");
		lblDevices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Devices openMenu = new Devices();
                openMenu.setVisible(true);
			}
		});
		lblDevices.setBounds(72, 230, 113, 29);
		panel.add(lblDevices);
		lblDevices.setFont(new Font("Arial Black", Font.PLAIN, 22));
		
		JLabel lblReg = new JLabel("");
		lblReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent test) {
				 setVisible(false);
				 Employee openMenu = new Employee();
                 openMenu.setVisible(true);
			}
		});
		lblReg.setBounds(80, 101, 105, 109);
		panel.add(lblReg);
		lblReg.setIcon(new ImageIcon(new ImageIcon("image/register.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		JLabel lblEmployee = new JLabel("EMPLOYEE");
		lblEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 setVisible(false);
				 Employee openMenu = new Employee();
                 openMenu.setVisible(true);
			}
		});
		lblEmployee.setBounds(62, 72, 143, 29);
		panel.add(lblEmployee);
		lblEmployee.setFont(new Font("Arial Black", Font.PLAIN, 22));
		
		JLabel lblStationary = new JLabel("STATIONARY");
		lblStationary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 setVisible(false);
				 Stationaries openMenu = new Stationaries();
                 openMenu.setVisible(true);
			}
		});
		lblStationary.setBounds(248, 72, 168, 29);
		panel.add(lblStationary);
		lblStationary.setFont(new Font("Arial Black", Font.PLAIN, 22));
		
		JLabel labelStation = new JLabel("");
		labelStation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent st) {
				 setVisible(false);
				 Stationaries openMenu = new Stationaries();
                 openMenu.setVisible(true);
			}
		});
		labelStation.setBounds(273, 101, 103, 109);
		panel.add(labelStation);
		labelStation.setIcon(new ImageIcon(new ImageIcon("image/stationery.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		JLabel labelReq = new JLabel("");
		labelReq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Request openMenu = new Request();
                 openMenu.setVisible(true);
			}
		});
		labelReq.setIcon(new ImageIcon(new ImageIcon("image/Request.png").getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT)));
		labelReq.setBounds(80, 404, 105, 112);
		panel.add(labelReq);
		
		JLabel labelreport = new JLabel("");
		labelreport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Report openMenu = new Report();
                 openMenu.setVisible(true);
			}
		});
		labelreport.setIcon(new ImageIcon(new ImageIcon("image/report.png").getImage().getScaledInstance(105, 105, Image.SCALE_DEFAULT)));
		labelreport.setBounds(276, 406, 107, 110);
		panel.add(labelreport);
		
		JLabel lblReport = new JLabel("REPORT");
		lblReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Report openMenu = new Report();
                 openMenu.setVisible(true);
			}
		});
		lblReport.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblReport.setBounds(276, 380, 107, 29);
		panel.add(lblReport);
		
		JLabel lblRequest = new JLabel("REQUEST");
		lblRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Request openMenu = new Request();
                 openMenu.setVisible(true);
			}
		});
		lblRequest.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblRequest.setBounds(72, 380, 121, 29);
		panel.add(lblRequest);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setBounds(0, 0, 450, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnNewButton.setBounds(349, 10, 89, 23);
		panel_1.add(btnNewButton);
		
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("E, hh:mm a");
		JLabel lblTime = new JLabel(ft.format(date));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTime.setBounds(10, 14, 207, 14);
		panel_1.add(lblTime);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image/bgAdmin.jpg"));
		label.setBounds(-44, 0, 595, 563);
		contentPane.add(label);
	}
}
