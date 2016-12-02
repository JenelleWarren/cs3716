

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Account {

	private JFrame frmVolleyballGame;
	private JTextField textField;
	private JTextField textField_1;
    private TournamentPanel panel1;
    private TournamentPanel tourpanel;
    private test test;
    private JLabel lblPleaseEnterYour;
    private JFrame frame1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
					window.frmVolleyballGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tourpanel = new TournamentPanel();
		test = new test();
		frmVolleyballGame = new JFrame();
		frmVolleyballGame.setTitle("Volleyball Game");
		frmVolleyballGame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmVolleyballGame.setBounds(100, 100, 750, 600);
		frmVolleyballGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVolleyballGame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(228, 102, 86, 38);
		frmVolleyballGame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(228, 175, 108, 25);
		frmVolleyballGame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(330, 107, 151, 29);
		frmVolleyballGame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(331, 173, 150, 29);
		frmVolleyballGame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblPleaseEnterYour = new JLabel("Please enter your login information.");
		lblPleaseEnterYour.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPleaseEnterYour.setBounds(262, 27, 326, 38);
		frmVolleyballGame.getContentPane().add(lblPleaseEnterYour);
		
		//
		frame1 = new JFrame("Tournament runner");
	    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame1.setSize(500, 200);
	    frame1.setBounds(100, 100, 750, 600);
	    panel1 = new TournamentPanel();
	    frame1.getContentPane().add(panel1);
		//
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(UIManager.getColor("MenuItem.foreground"));
		btnLogin.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(234, 270, 102, 38);
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(textField.getText().equals("coach") && textField_1.getText().equals("coachpass")){
				lblPleaseEnterYour.setText("It worked, login was successful");
				frmVolleyballGame.dispose();
				panel1.setPermissions(2);
				frame1.setVisible(true);
				}
				else if(textField.getText().equals("referee") && textField_1.getText().equals("refereepass")){
					lblPleaseEnterYour.setText("It worked, login was successful");
					frmVolleyballGame.dispose();
					panel1.setPermissions(1);
					frame1.setVisible(true);
					}

					else if(textField.getText().equals("organizer") && textField_1.getText().equals("organizerpass")){
					lblPleaseEnterYour.setText("It worked, login was successful");
					frmVolleyballGame.dispose();
					panel1.setPermissions(3);
					frame1.setVisible(true);
					}
					else{
					lblPleaseEnterYour.setText(" Wrong username or password, please try again ");
					}
				}
					
				
			
			
		});
		frmVolleyballGame.getContentPane().add(btnLogin);
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.setForeground(UIManager.getColor("MenuItem.foreground"));
		btnGuest.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		btnGuest.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuest.setBounds(379, 272, 102, 36);

	btnGuest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				frmVolleyballGame.dispose();
				frame1.setVisible(true);	
				}
		});
		frmVolleyballGame.getContentPane().add(btnGuest);
		
		
	
	}
}
