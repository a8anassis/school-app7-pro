package gr.aueb.cf.schoolapp.view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection connection;
	
	public Dashboard() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String sql = "jdbc:mysql://localhost:3306/school7dbpro?serverTimezone=UTC";
				String username = "user7pro";
				String password = "12345";
				
				try {
					// Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(sql, username, password);
					System.out.println("Connection success");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
//				catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});

		setTitle("Ποιότητα στην Εκπαίδευση");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 745, 52);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(Dashboard.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(0, 0, 100, 52);
		header.add(govImage);
		
		JLabel firstLastName = new JLabel("ΑΘΑΝΑΣΙΟΣ ΑΝΔΡΟΥΤΣΟΣ");
		firstLastName.setForeground(new Color(255, 255, 255));
		firstLastName.setBounds(562, 11, 183, 30);
		header.add(firstLastName);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(3, 340, 742, 90);
		contentPane.add(footer);
		
		JLabel lbl_manual = new JLabel("Εγχειρίδιο Χρήσης");
		lbl_manual.setForeground(new Color(0, 52, 117));
		lbl_manual.setBounds(123, 37, 151, 29);
		footer.add(lbl_manual);
		
		JLabel lbl_oftenQuestions = new JLabel("Συχνές Ερωτήσεις");
		lbl_oftenQuestions.setForeground(new Color(0, 52, 117));
		lbl_oftenQuestions.setBounds(284, 37, 151, 29);
		footer.add(lbl_oftenQuestions);
		
		JLabel lbl_support = new JLabel("Υποστήριξη Πολιτών");
		lbl_support.setForeground(new Color(0, 52, 117));
		lbl_support.setBounds(445, 37, 151, 29);
		footer.add(lbl_support);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(0, 52, 117));
		leftPanel.setBounds(0, 55, 178, 282);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel lbl_home = new JLabel("Αρχική");
		lbl_home.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_home.setForeground(new Color(240, 240, 0));
		lbl_home.setBounds(10, 10, 85, 26);
		leftPanel.add(lbl_home);
		
		JLabel lbl_teachers = new JLabel("Εκπαιδευτές");
		lbl_teachers.setForeground(Color.WHITE);
		lbl_teachers.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_teachers.setBounds(10, 35, 158, 26);
		leftPanel.add(lbl_teachers);
		
		JLabel lbl_teachersView = new JLabel("Προβολή Εκπαιδευτών");
		lbl_teachersView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teachersView.setText("<html><font color='blue'>Προβολή Εκπαιδευτών</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teachersView.setText("Προβολή Εκπαιδευτών");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
					Main.getDashboard().setEnabled(false);
					Main.getViewTeachersPage().setVisible(true);
				
			}
		});

		lbl_teachersView.setForeground(Color.WHITE);
		lbl_teachersView.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_teachersView.setBounds(15, 61, 153, 26);
		leftPanel.add(lbl_teachersView);
		
		JLabel lbl_teacherInsert = new JLabel("Εισαγωγή Εκπαιδευτή");
		lbl_teacherInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_teacherInsert.setText("<html><font color='blue'>Εισαγωγή Εκπαιδευτή</font></html>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_teacherInsert.setText("Εισαγωγή Εκπαιδευτή");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});

		lbl_teacherInsert.setForeground(Color.WHITE);
		lbl_teacherInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_teacherInsert.setBounds(15, 87, 153, 26);
		leftPanel.add(lbl_teacherInsert);
		
		JSeparator line = new JSeparator();
		line.setBounds(3, 52, 759, 2);
		contentPane.add(line);
		line.setBackground(new Color(0, 0, 255));
		
		JSeparator lineBottom = new JSeparator();
		lineBottom.setBackground(Color.BLUE);
		lineBottom.setBounds(0, 338, 759, 2);
		contentPane.add(lineBottom);
		
		JLabel lbl_quality = new JLabel("Ποιότητα στην Εκπαίδευση");
		lbl_quality.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_quality.setBounds(293, 63, 310, 52);
		contentPane.add(lbl_quality);
		
		JLabel lblNewLabel = new JLabel("Προβολή Μητρώου Εκπαιδευτών");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(202, 129, 237, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Προβολή Μητρώου Εγγεγραμμένων Εκπαιδευτών στο Μητρώο του Coding Factory");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(202, 148, 533, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnViewTeachers = new JButton("Συνέχεια");
		btnViewTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getViewTeachersPage().setVisible(true);
			}
		});

		btnViewTeachers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnViewTeachers.setForeground(new Color(255, 255, 255));
		btnViewTeachers.setBackground(new Color(0, 128, 64));
		btnViewTeachers.setBounds(202, 183, 94, 31);
		contentPane.add(btnViewTeachers);
		
		JLabel lblNewLabel_2 = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο Εκπαιδευτών");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(202, 225, 359, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Εισαγωγή Εκπαιδευτή στο Μητρώο του Coding Factory");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(202, 244, 533, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnInsertTeacher = new JButton("Συνέχεια");
		btnInsertTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(false);
				Main.getInsertTeacherPage().setVisible(true);
			}
		});

		btnInsertTeacher.setForeground(Color.WHITE);
		btnInsertTeacher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInsertTeacher.setBackground(new Color(0, 128, 64));
		btnInsertTeacher.setBounds(202, 279, 94, 31);
		contentPane.add(btnInsertTeacher);
	}

	public static Connection getConnection() {
		return connection;
	}
}
