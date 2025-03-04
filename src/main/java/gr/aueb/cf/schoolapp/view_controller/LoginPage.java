package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public LoginPage() {
		setTitle("Αυθεντικοποίηση Χρήστη");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/eduv2.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Σύνδεση");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(184, 11, 73, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblMessage = new JLabel("Παρακαλώ εισάγετε τους κωδικούς σας για να συνδεθείτε");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(47, 40, 347, 38);
		contentPane.add(lblMessage);
		
		JLabel lblUser = new JLabel("Χρήστης:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(127, 99, 60, 24);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Κωδικός:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(127, 157, 60, 29);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(127, 124, 197, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(127, 183, 197, 30);
		contentPane.add(password);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 77, 360, 1);
		contentPane.add(separator);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((username.getText().matches("[aA]dmin")) && (Arrays.equals(password.getPassword(), "12345".toCharArray()))) {
					Main.getLoginPage().setVisible(false);
					Main.getDashboard().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Λάθος username ή password", "Αδυναμία Σύνδεσης",  JOptionPane.ERROR_MESSAGE);
					username.setText("");
					password.setText("");
				}
			}
		});
		
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConnect.setBackground(new Color(0, 128, 0));
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBounds(127, 234, 197, 38);
		contentPane.add(btnConnect);
	}
}
