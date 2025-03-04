package gr.aueb.cf.schoolapp.view_controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.model.City;

public class UpdateTeacherPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnameText;
	private JTextField lastnameText;
	private JTextField vatText;
	private JTextField fathernameText;
	private JTextField phoneNumberText;
	private JTextField emailText;
	private JTextField streetText;
	private JTextField streetNumberText;
	private JTextField zipcodeText;
	private JLabel errorFirstname;
	private JLabel errorLastname;
	private JComboBox<City> cityComboBox;
	private List<City> cities = new ArrayList<>();

	public UpdateTeacherPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cities = fetchCitiesFromDatabase();
				cities.forEach(city -> cityComboBox.addItem(city));
				fetchTeacherFromDatabase(Main.getViewTeachersPage().getSelectedId());

				errorFirstname.setText("");
				errorLastname.setText("");
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
//				cities = fetchCitiesFromDatabase();
//				cities.forEach(city -> cityComboBox.addItem(city));
//				
//				fetchTeacherFromDatabase(Main.getViewTeachersPage().getSelectedId());

			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Ποιότητα στην Εκπαίδευση");
		setBounds(100, 100, 857, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherInfo = new JLabel("Στοιχεία Εκπαιδευτή");
		lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTeacherInfo.setBounds(267, 63, 341, 44);
		contentPane.add(lblTeacherInfo);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 842, 52);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(InsertTeacherPage.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(0, 0, 100, 52);
		header.add(govImage);
		
		JLabel firstLastName = new JLabel("ΑΘΑΝΑΣΙΟΣ ΑΝΔΡΟΥΤΣΟΣ");
		firstLastName.setForeground(Color.WHITE);
		firstLastName.setBounds(649, 11, 183, 30);
		header.add(firstLastName);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(0, 574, 842, 90);
		contentPane.add(footer);
		
		JLabel lbl_manual = new JLabel("Εγχειρίδιο Χρήσης");
		lbl_manual.setForeground(new Color(0, 52, 117));
		lbl_manual.setBounds(199, 37, 151, 29);
		footer.add(lbl_manual);
		
		JLabel lbl_oftenQuestions = new JLabel("Συχνές Ερωτήσεις");
		lbl_oftenQuestions.setForeground(new Color(0, 52, 117));
		lbl_oftenQuestions.setBounds(360, 37, 151, 29);
		footer.add(lbl_oftenQuestions);
		
		JLabel lbl_support = new JLabel("Υποστήριξη Πολιτών");
		lbl_support.setForeground(new Color(0, 52, 117));
		lbl_support.setBounds(521, 37, 151, 29);
		footer.add(lbl_support);
		
		JSeparator lineBottom = new JSeparator();
		lineBottom.setBackground(Color.BLUE);
		lineBottom.setBounds(0, 0, 850, 2);
		footer.add(lineBottom);
		
		firstnameText = new JTextField();
		firstnameText.setBounds(91, 131, 263, 37);
		contentPane.add(firstnameText);
		firstnameText.setColumns(10);
		
		firstnameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inputFirstname;	
				inputFirstname = firstnameText.getText().trim();	
				
				errorFirstname.setText(inputFirstname.equals("") ? "Το όνομα είναι υποχρεωτικό" : "");
			}
		});
		
		lastnameText = new JTextField();
		lastnameText.setColumns(10);
		lastnameText.setBounds(512, 131, 263, 37);
		contentPane.add(lastnameText);
		
		lastnameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inputLastname;	
				inputLastname = lastnameText.getText().trim();	
				
				errorLastname.setText(inputLastname.equals("") ? "Το επώνυμο είναι υποχρεωτικό" : "");
			}
		});
		
		JLabel lblFirstname = new JLabel("Όνομα*");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstname.setBounds(29, 135, 62, 29);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Επώνυμο*");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastname.setBounds(432, 135, 84, 29);
		contentPane.add(lblLastname);
		
		JLabel lblVat = new JLabel("ΑΦΜ*");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVat.setBounds(41, 202, 50, 29);
		contentPane.add(lblVat);
		
		vatText = new JTextField();
		vatText.setColumns(10);
		vatText.setBounds(91, 198, 263, 37);
		contentPane.add(vatText);
		
		JLabel lblFathername = new JLabel("Πατρώνυμο*");
		lblFathername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername.setBounds(421, 202, 95, 29);
		contentPane.add(lblFathername);
		
		fathernameText = new JTextField();
		fathernameText.setColumns(10);
		fathernameText.setBounds(512, 198, 263, 37);
		contentPane.add(fathernameText);
		
		JLabel lblPhoneNumber = new JLabel("Τηλέφωνο*");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(10, 275, 81, 29);
		contentPane.add(lblPhoneNumber);
		
		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(91, 271, 263, 37);
		contentPane.add(phoneNumberText);
		
		JLabel lblEmail = new JLabel("e-mail*");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(460, 275, 56, 29);
		contentPane.add(lblEmail);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(512, 271, 263, 37);
		contentPane.add(emailText);
		
		JLabel lblStreet = new JLabel("Διεύθυνση*");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreet.setBounds(10, 342, 81, 29);
		contentPane.add(lblStreet);
		
		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(91, 338, 263, 37);
		contentPane.add(streetText);
		
		JLabel lblStreetNumber = new JLabel("Αριθμός*");
		lblStreetNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreetNumber.setBounds(446, 342, 70, 29);
		contentPane.add(lblStreetNumber);
		
		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		streetNumberText.setBounds(512, 338, 263, 37);
		contentPane.add(streetNumberText);
		
		JLabel lblCity = new JLabel("Πόλη*");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(41, 411, 50, 29);
		contentPane.add(lblCity);
		
		JLabel lblZipCode = new JLabel("ΤΚ*");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZipCode.setBounds(481, 411, 35, 29);
		contentPane.add(lblZipCode);
		
		zipcodeText = new JTextField();
		zipcodeText.setColumns(10);
		zipcodeText.setBounds(512, 407, 263, 37);
		contentPane.add(zipcodeText);
		
		errorFirstname = new JLabel("");
		errorFirstname.setForeground(new Color(255, 0, 0));
		errorFirstname.setBounds(92, 167, 260, 29);
		contentPane.add(errorFirstname);
		
		errorLastname = new JLabel("");
		errorLastname.setForeground(new Color(255, 0, 0));
		errorLastname.setBounds(514, 167, 260, 29);
		contentPane.add(errorLastname);
		
		cityComboBox = new JComboBox<>();
		cityComboBox.setBounds(89, 407, 263, 37);
		contentPane.add(cityComboBox);
        
		
		JButton updateBtn = new JButton("Ενημέρωση");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Data binding
				String firstname = firstnameText.getText().trim();
				String lastname = lastnameText.getText().trim();
				String vat = vatText.getText();
				String fathername = fathernameText.getText();
				String phoneNumber = phoneNumberText.getText();
				String email = emailText.getText();
				String street = streetText.getText();
				String streetNumber = streetNumberText.getText();
				City selectedCity = (City) cityComboBox.getSelectedItem();
				int cityId = selectedCity.getId();
				String zipcode = zipcodeText.getText();
				
				
				// Validation
				// Validate first name
				errorFirstname.setText(firstname.equals("") ? "Το όνομα είναι υποχρεωτικό" : "");

				// Validate last name
				errorLastname.setText(lastname.equals("") ? "Το επώνυμο είναι υποχρεωτικό" : "");

				// Return if any field is empty
				if (firstname.equals("") || lastname.equals("")) {
				    return;
				}
               

                // Check if all fields are filled
                if (selectedCity != null && !firstname.isEmpty() && !lastname.isEmpty()) {
                    // Get the city_id from the selected City object
                    

                	String sql = "UPDATE teachers "
                			+ "SET firstname = ?, lastname = ?, vat = ?, fathername = ?, phone_num = ?, email = ?, "
                			+ "street = ?, street_num = ?, zipcode = ?, city_id = ? "
                			+ "WHERE uuid = ?";
    				
                	Connection conn = Dashboard.getConnection();
                	
    				try (PreparedStatement ps = conn.prepareStatement(sql)) {
    					
    					ps.setString(1, firstname);
    					ps.setString(2, lastname);
    					ps.setString(3, vat);
    					ps.setString(4, fathername);
    					ps.setString(5, phoneNumber);
    					ps.setString(6, email);
    					ps.setString(7, street);
    					ps.setString(8, streetNumber);
    					ps.setString(9, zipcode);
    					ps.setInt(10,cityId);
    					//ps.setInt(11, Main.getViewTeachersPage().getSelectedId());
    					ps.setString(11, Main.getViewTeachersPage().getSelectedId());
    					
    					int n = ps.executeUpdate();
    					
    					JOptionPane.showMessageDialog(null,  n + " record(s) inserted", "INSERT", JOptionPane.PLAIN_MESSAGE);	
    				} catch (SQLException e1) {			
    					e1.printStackTrace();
    					JOptionPane.showMessageDialog(null,  "Insertion error", "Error", JOptionPane.ERROR_MESSAGE);
    				}
                } else {
                    // Show an error message if any field is empty
                    JOptionPane.showMessageDialog(null, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateBtn.setForeground(new Color(255, 255, 255));
		updateBtn.setBackground(new Color(64, 128, 128));
		updateBtn.setBounds(512, 485, 263, 54);
		contentPane.add(updateBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getViewTeachersPage().setEnabled(true);
				Main.getUpdateTeacherPage().setVisible(false);
			}
		});
		closeBtn.setForeground(new Color(0, 0, 0));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeBtn.setBackground(new Color(192, 192, 192));
		closeBtn.setBounds(91, 485, 263, 54);
		contentPane.add(closeBtn);	
	}
	
	private List<City> fetchCitiesFromDatabase() {
		String sql = "SELECT * FROM cities order by name asc";
		List<City> cities = new ArrayList<>();
		Connection conn = Dashboard.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
	        while (rs.next()) {
	            int id = rs.getInt("id"); // Get the id column
	            String name = rs.getString("name"); // Get the name column

	            // Create a City object and add it to the list
	            City city = new City(id, name);
	            cities.add(city);
	        }     
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,  "Select error in fetch cities", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return cities;	
	}
	
	//private void fetchTeacherFromDatabase(int id) {
	private void fetchTeacherFromDatabase(String id) {
//		String sql = "SELECT * FROM teachers WHERE id = ?";
		String sql = "SELECT * FROM teachers WHERE uuid = ?";
		Connection conn = Dashboard.getConnection();
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			//ps.setInt(1, id);
			ps.setString(1,  id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				firstnameText.setText(rs.getString("firstname"));
				lastnameText.setText(rs.getString("lastname"));
				vatText.setText(rs.getString("vat"));
				fathernameText.setText(rs.getString("fathername"));
				phoneNumberText.setText(rs.getString("phone_num"));
				emailText.setText(rs.getString("email"));
				streetText.setText(rs.getString("street"));
				streetNumberText.setText(rs.getString("street_num"));
				//cityComboBox.setSelectedIndex(rs.getInt("city_id")-1);
				int cityIdFromDB = rs.getInt("city_id"); // Get city_id from DB
//				System.out.println("city_id" + cityIdFromDB);
				// Find the matching city using Streams
				City selectedCity = cities.stream()
				    .filter(city -> city.getId() == cityIdFromDB)
				    .findFirst()
				    .orElse(null); // Returns null if no match is found
//				System.out.println("Selected City: " + selectedCity);
				// Select the city in the JComboBox
				if (selectedCity != null) {
				    cityComboBox.setSelectedItem(selectedCity);
				} else cityComboBox.setSelectedIndex(0);
				
//				City selectedCity = (City) cityComboBox.getSelectedItem();
//				int cityId = selectedCity.getId();
				
				zipcodeText.setText(rs.getString("zipcode"));
//				errorFirstname.setText("");
//				errorLastname.setText("");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,  "Select error in fetch teacher", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}

}


