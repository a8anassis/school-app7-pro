package gr.aueb.cf.schoolapp.view_controller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewTeachersPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lastnameText;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	//private int selectedId;
	private String selectedId;
	private String selectedUUID;

	public ViewTeachersPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
//				buildTable();
			}
			@Override
			public void windowActivated(WindowEvent e) {
				buildTable();
			}
		});
		setTitle("Ποιότητα στην Εκπαίδευση");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 891, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 867, 52);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(ViewTeachersPage.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(0, 0, 100, 52);
		header.add(govImage);
		
		JLabel firstLastName = new JLabel("ΑΘΑΝΑΣΙΟΣ ΑΝΔΡΟΥΤΣΟΣ");
		firstLastName.setForeground(Color.WHITE);
		firstLastName.setBounds(674, 11, 183, 30);
		header.add(firstLastName);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(0, 516, 877, 90);
		contentPane.add(footer);
		
		JLabel lbl_manual = new JLabel("Εγχειρίδιο Χρήσης");
		lbl_manual.setForeground(new Color(0, 52, 117));
		lbl_manual.setBounds(197, 37, 151, 29);
		footer.add(lbl_manual);
		
		JLabel lbl_oftenQuestions = new JLabel("Συχνές Ερωτήσεις");
		lbl_oftenQuestions.setForeground(new Color(0, 52, 117));
		lbl_oftenQuestions.setBounds(358, 37, 151, 29);
		footer.add(lbl_oftenQuestions);
		
		JLabel lbl_support = new JLabel("Υποστήριξη Πολιτών");
		lbl_support.setForeground(new Color(0, 52, 117));
		lbl_support.setBounds(519, 37, 151, 29);
		footer.add(lbl_support);
		
		lastnameText = new JTextField();
		lastnameText.setBounds(110, 130, 181, 40);
		contentPane.add(lastnameText);
		lastnameText.setColumns(10);
		
		JButton btnNewButton = new JButton("Αναζήτηση");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildTable();
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(304, 130, 125, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Εκκαθάριση");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastnameText.setText("");
				buildTable();
			}
		});
		btnNewButton_1.setForeground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(439, 130, 125, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Αιτήσεις Εκπαιδευτών");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(282, 77, 267, 27);
		contentPane.add(lblNewLabel);
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check if the selection is still adjusting
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int selectedRow = table.getSelectedRow();

                    // Check if a row is selected
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        //String selectedStr = (String) model.getValueAt(selectedRow, 0); // ID column
                        //selectedId = Integer.parseInt(selectedStr);
                        //selectedId = Integer.parseInt(selectedStr);
                    	selectedUUID = (String) model.getValueAt(selectedRow, 0);
                        
                    }
                }
            }
        });
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Κωδικός", "Όνομα", "Επώνυμο"
			}
		));
		table.setBounds(57, 192, 507, 307);
		model = (DefaultTableModel) table.getModel();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(57, 192, 507, 307);
		contentPane.add(scrollPane);
		
		JButton viewBtn = new JButton("Προβολή");
		viewBtn.setForeground(new Color(255, 255, 255));
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getViewTeachersPage().setEnabled(false);
				Main.getTeacherView().setVisible(true);
			}
		});
		viewBtn.setBackground(new Color(0, 128, 0));
		viewBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewBtn.setBounds(619, 229, 202, 52);
		contentPane.add(viewBtn);
		
		JButton updateBtn = new JButton("Επεξεργασία");
		updateBtn.setForeground(new Color(255, 255, 255));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getViewTeachersPage().setEnabled(false);
				Main.getUpdateTeacherPage().setVisible(true);
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateBtn.setBackground(new Color(0, 128, 64));
		updateBtn.setBounds(619, 292, 202, 52);
		contentPane.add(updateBtn);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//doDelete(selectedId);
				doDelete(selectedUUID);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBackground(new Color(0, 128, 64));
		btnDelete.setBounds(619, 355, 202, 52);
		contentPane.add(btnDelete);
		
		JSeparator lineBottom_2 = new JSeparator();
		lineBottom_2.setBackground(Color.BLUE);
		lineBottom_2.setBounds(0, 516, 875, 2);
		contentPane.add(lineBottom_2);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getDashboard().setEnabled(true);
				Main.getViewTeachersPage().setVisible(false);
			}
		});
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeBtn.setBackground(Color.LIGHT_GRAY);
		closeBtn.setBounds(619, 445, 202, 52);
		contentPane.add(closeBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Επώνυμο");
		lblNewLabel_1.setBounds(57, 128, 57, 44);
		contentPane.add(lblNewLabel_1);
		//contentPane.add(table);
	}
	
	
//	public int getSelectedId() {
//		return selectedId;
//	}
	public String getSelectedId() {
		return selectedUUID;
	}



	private void buildTable() {
//	    String sql = "SELECT id, firstname, lastname FROM teachers WHERE lastname LIKE ?";
		//String sql = "SELECT uuid, firstname, lastname FROM teachers WHERE lastname LIKE ?";
//	    Connection conn = Dashboard.getConnection();
//
//	    try (
//	         PreparedStatement ps = conn.prepareStatement(sql)) {
//
//	        ps.setString(1, lastnameText.getText().trim() + "%");
//	        ResultSet rs = ps.executeQuery();
//
//	        model.setRowCount(0); // Clear the table
//	        while (rs.next()) {
//	            Object[] row = {
//	            	rs.getString("uuid"), //.substring(0, 8),
////	                rs.getString("id"),
//	                rs.getString("firstname"),
//	                rs.getString("lastname")
//	            };
//	            model.addRow(row);
//	        }
//	    } catch (SQLException e) {
//	    	e.printStackTrace();
//	        JOptionPane.showMessageDialog(null, "Select error", "Error", JOptionPane.ERROR_MESSAGE);
//	    }
	}
	
	//private void doDelete(int id) {
	private void doDelete(String uuid) {
//		String sql = "DELETE FROM teachers WHERE id = ?";
//		String sql = "DELETE FROM teachers WHERE uuid = ?";
//		Connection conn = Dashboard.getConnection();
//
//		try (PreparedStatement ps = conn.prepareStatement(sql)) {
//
//			//ps.setInt(1, id);
//			ps.setString(1, uuid);
//
//			int answer = JOptionPane.showConfirmDialog(null, "Είστε σίγουρη/ος", "Διαγραφή",
//					JOptionPane.YES_NO_OPTION);
//			if (answer == JOptionPane.YES_OPTION) {
//				int rowsAffected = ps.executeUpdate();
//				JOptionPane.showMessageDialog(null, rowsAffected + " γρααμμή/ες διαγράφηκαν", "Διαγραφή",
//						JOptionPane.INFORMATION_MESSAGE);
//			} else {
//				return;
//			}
//		} catch (SQLException ex) {
//			//ex.printStackTrace();
//			JOptionPane.showMessageDialog(null,  "Delete error", "Error", JOptionPane.ERROR_MESSAGE);
//		}
	}
}
