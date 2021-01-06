package process;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Manage_Admin extends JPanel {
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;
	private ListOfAdmin list;
	private DataBase dataBase;


	/**
	 * Create the panel.
	 */
	public Manage_Admin(String x) {
		setBounds(0, 130, 980, 614);
		setLayout(null);

		list = new ListOfAdmin();
		dataBase = new DataBase();
		try {
			list = dataBase.readAdmin("src/question1/admin.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 57, 37);
		add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Fullname", "Phonenumber", "ID", "PIN" }));
		comboBox.setBounds(70, 18, 136, 21);
		add(comboBox);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int option = comboBox.getSelectedIndex();
				if(option == 0) {
					if(Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
				else {
					if(!Character.isDigit(e.getKeyChar()))
						e.consume();
				}
			}
		});
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSearch.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		txtSearch.setBounds(10, 49, 203, 30);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JPanel panel_Cancel = new JPanel();
		panel_Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				for (Admin admin : list.getList()) {
					model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getPhonenumber(), admin.getID() });
				}
				panel_Cancel.setVisible(false);
			}
		});
		panel_Cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_Cancel.setVisible(false);
		panel_Cancel.setLayout(null);
		panel_Cancel.setBackground(Color.WHITE);
		panel_Cancel.setBounds(432, 571, 112, 33);
		add(panel_Cancel);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(Manage_Admin.class.getResource("/images/Close-icon.png")));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(0, 0, 40, 33);
		panel_Cancel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Cancel");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_2.setBounds(40, 0, 72, 33);
		panel_Cancel.add(lblNewLabel_5_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Manage_Admin.class.getResource("/images/search-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(152, 101, 45, 30);
		

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtSearch.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,
							"You must enter " + String.valueOf(comboBox.getSelectedItem()).toLowerCase(), "Error", 2);
				} else {
					panel_Cancel.setVisible(true);
					if (String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("fullname")) {
						model.setRowCount(0);
						for (Admin admin : list.getList()) {
							if (admin.getFullname().toLowerCase().contains((CharSequence) txtSearch.getText().toLowerCase())) {
								model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getPhonenumber(), admin.getID() });
							}
						}
					}
					else if(String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("pin")) {
						model.setRowCount(0);
						for (Admin admin : list.getList()) {
							if (admin.getPIN().toLowerCase().contains((CharSequence) txtSearch.getText().toLowerCase())) {
								model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getPhonenumber(), admin.getID() });
							}
						}
					}
					else if(String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("phonenumber")) {
						model.setRowCount(0);
						for (Admin admin : list.getList()) {
							if (admin.getPhonenumber().toLowerCase().contains((CharSequence) txtSearch.getText().toLowerCase())) {
								model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getPhonenumber(), admin.getID() });
							}
						}
					}
					else if(String.valueOf(comboBox.getSelectedItem()).equalsIgnoreCase("ID")) {
						model.setRowCount(0);
						for (Admin admin : list.getList()) {
							if (admin.getID().toLowerCase().contains((CharSequence) txtSearch.getText().toLowerCase())) {
								model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getPhonenumber(), admin.getID() });
							}
						}
					}
				}
			}
		});
		panel.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		panel.setBounds(212, 49, 45, 30);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 960, 472);
		add(scrollPane);

		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PIN", "Fullname", "ID", "Phonenumber"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		// load data to table
		model.setRowCount(0);
		for (Admin admin : list.getList()) {
			model.addRow(new Object[] { admin.getPIN(), admin.getFullname(), admin.getID() , admin.getPhonenumber()});
		}

		JLabel lblNewLabel_2 = new JLabel("Total administrator :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(769, 49, 145, 22);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(925, 49, 45, 22);
		lblNewLabel_3.setText(String.valueOf(model.getRowCount()));
		add(lblNewLabel_3);

		JPanel panel_Add = new JPanel();
		panel_Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Add.setBackground(new Color(82, 179, 217));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Add.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_Add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_Add.setBounds(228, 571, 112, 33);
		panel_Add.setBackground(Color.WHITE);
		if(x.equalsIgnoreCase("777777777777"))
			add(panel_Add);
		panel_Add.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Manage_Admin.class.getResource("/images/add-icon.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 40, 33);
		panel_Add.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Add");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(40, 0, 72, 33);
		panel_Add.add(lblNewLabel_5);

		JPanel panel_Delete = new JPanel();
		panel_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row < 0 || row > list.getList().size()) {
					JOptionPane.showMessageDialog(null, "Please choose the customer you want to delete!", "Alert", 2);
				}
				else {
					int click = JOptionPane.showConfirmDialog(null, "Do you want to delete this administrator?", "Alert" , JOptionPane.YES_NO_OPTION);
					if(click == JOptionPane.YES_OPTION) {
						list.removeAdmin(row);
						model.removeRow(row);
						try {
							dataBase.writeAdmin("src/question1/admin.txt", list);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Delete.setBackground(new Color(214, 69, 65));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Delete.setBackground(Color.WHITE);
			}
		});
		panel_Delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_Delete.setBounds(648, 571, 112, 33);
		panel_Delete.setBackground(Color.WHITE);
		if(x.equalsIgnoreCase("777777777777"))
			add(panel_Delete);
		panel_Delete.setLayout(null);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(Manage_Admin.class.getResource("/images/bin-blue-full-icon.png")));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(0, 0, 40, 33);
		panel_Delete.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Delete");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(40, 0, 72, 33);
		panel_Delete.add(lblNewLabel_5_1);
		
	}
}
