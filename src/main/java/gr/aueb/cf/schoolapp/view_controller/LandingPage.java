package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public LandingPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LandingPage.class.getResource("/images/eduv2.png")));
		setTitle("Ποιότητα στην Εκπαίδευση");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 746, 56);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(LandingPage.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(10, 0, 154, 56);
		header.add(govImage);
		
		JLabel lblAuthRequired = new JLabel("Απαιτείται ταυτοποίηση");
		lblAuthRequired.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthRequired.setBounds(35, 79, 286, 56);
		contentPane.add(lblAuthRequired);
		
		JLabel lblMustConnect = new JLabel("Για να προχωρήσετε πρέπει να συνδεθείτε");
		lblMustConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMustConnect.setBounds(35, 146, 259, 42);
		contentPane.add(lblMustConnect);
		
		JButton btnConnect = new JButton("Σύνδεση");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getLandingPage().setVisible(false);
				Main.getLoginPage().setVisible(true);
			}
		});
		btnConnect.setEnabled(false);
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBackground(new Color(0, 128, 0));
		btnConnect.setBounds(35, 241, 138, 48);
		
		JCheckBox privacyCheckBox = new JCheckBox("Δηλώνω ότι αποδέχομαι τη");
		privacyCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnConnect.setEnabled(true);
				} else {
					btnConnect.setEnabled(false);
				}
			}
		});
		privacyCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		privacyCheckBox.setBounds(35, 196, 200, 23);
		contentPane.add(privacyCheckBox);
		
		JLabel lblPrivacy = new JLabel("Δήλωση Ιδιωτικότητας");
		lblPrivacy.setForeground(new Color(0, 0, 255));
		lblPrivacy.setBounds(241, 196, 130, 23);
		contentPane.add(lblPrivacy);
		
		
		contentPane.add(btnConnect);
		
		JPanel footer = new JPanel();
		footer.setBounds(0, 330, 746, 97);
		contentPane.add(footer);
		footer.setLayout(null);
		
		JLabel lblManual = new JLabel("Εγχειρίδιο Χρήσης");
		lblManual.setForeground(new Color(0, 0, 255));
		lblManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManual.setBounds(68, 33, 112, 34);
		footer.add(lblManual);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setForeground(Color.BLUE);
		lblQuestions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuestions.setBounds(290, 33, 112, 34);
		footer.add(lblQuestions);
		
		JLabel lblSupport = new JLabel("Υποστήριξη Πολιτών");
		lblSupport.setForeground(Color.BLUE);
		lblSupport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupport.setBounds(512, 33, 112, 34);
		footer.add(lblSupport);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setBounds(0, 2, 746, 1);
		footer.add(separator);
	}
}
