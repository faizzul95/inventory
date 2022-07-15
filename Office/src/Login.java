import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OptionalDataException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.png"));
		setResizable(false);
		setForeground(Color.CYAN);
		setTitle("OiS | LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 512);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBG = new JPanel();
		panelBG.setBackground(new Color(0,0,0,125));
		panelBG.setBounds(-1, -3, 779, 527);
		contentPane.add(panelBG);
		panelBG.setLayout(null);
		
		JLabel lblOffice = new JLabel("OFFICE INVENTORY");
		lblOffice.setBounds(216, 77, 332, 54);
		panelBG.add(lblOffice);
		lblOffice.setBackground(new Color(102, 204, 204));
		lblOffice.setForeground(Color.CYAN);
		lblOffice.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setBounds(329, 118, 99, 42);
		panelBG.add(lblSystem);
		lblSystem.setForeground(Color.CYAN);
		lblSystem.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(216, 160, 325, 190);
		panelBG.add(panel);
		panel.setBackground(new Color(255, 250, 250));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LOGIN", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(209, 135, 83, 32);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
		        if(ae.getActionCommand()==btnLogin.getActionCommand())
				{
			        String uname = username.getText();
			        String pwd = new String(password.getPassword());
			        boolean checkData = false;
			        String roleLogin = null;
			        
				        if((uname.equalsIgnoreCase(null)) || (pwd.equals("")))
				        {
				            JOptionPane.showMessageDialog(null,
				                "Please Insert Username Or Password",
				                "Incorrect",
				                JOptionPane.ERROR_MESSAGE);
				        }else{
				        	try {
				        		BufferedReader input = new BufferedReader (new FileReader("db/userdb.txt")); 
				                
				        		String data = null;
				                while((data = input.readLine()) != null)
								{
									String[] tokens = data.split(";");
	                	        	String username = tokens[4];
	                	        	String password = tokens[5];
	                	        	String roles = tokens[6];
									
									if(uname.equalsIgnoreCase(username) && pwd.equalsIgnoreCase(password))
					                {
										checkData = true;
										roleLogin = tokens[6];
					                } 
								}
								input.close();
								if(!checkData){
					                JOptionPane.showMessageDialog(null,
					                    "Error Username or Password, Please Try Again.",
					                    "Incorrect",
					                    JOptionPane.ERROR_MESSAGE);
					            }else{
									if(roleLogin.equalsIgnoreCase("Admin")){
						                    AdminMenu openMenu = new AdminMenu();
						                    openMenu.setVisible(true);
						                    setVisible(false);
							                JOptionPane.showMessageDialog(null, "Successfully Login");
									}else{
											Staffstationary openMenu = new Staffstationary();
						                    openMenu.setVisible(true);
						                    setVisible(false);
							                JOptionPane.showMessageDialog(null, "Successfully Login");
									}
					            }
								
							}catch (EOFException ex) {
								JOptionPane.showMessageDialog(null,"\nAll data have been read ");
							} catch(FileNotFoundException fe){
					            JOptionPane.showMessageDialog(null,fe.getMessage());
							}catch (IOException ex) {
								ex.printStackTrace();
							}
				        }
					}
				}
		});
		btnLogin.setBackground(new Color(30, 144, 255));
		
		password = new JPasswordField();
		password.setBounds(127, 90, 166, 29);
		panel.add(password);
		
		username = new JTextField();
		username.setBounds(128, 47, 166, 32);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Staff ID  :");
		lblUsername.setBounds(42, 47, 76, 32);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(42, 91, 88, 28);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(new ImageIcon("image/login2.jpg").getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT)));
		label.setBounds(-1, -3, 790, 546);
		contentPane.add(label);
	}
}
