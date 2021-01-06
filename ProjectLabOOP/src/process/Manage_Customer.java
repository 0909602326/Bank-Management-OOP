package process;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;

public class Manage_Customer extends JPanel {
	
	private ListOfCustomer list;
	private DataBase dataBase;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Manage_Customer() {
		list = new ListOfCustomer();
		dataBase = new DataBase();
		try {
			list = dataBase.readCustomer("src/question1/customer.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(0, 130, 980, 614);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 57, 37);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fullname", "Phonenumber", "ID", "PIN"}));
		comboBox.setBounds(70, 18, 136, 21);
		add(comboBox);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(10, 49, 203, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Manage_Admin.class.getResource("/images/search-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(152, 101, 45, 30);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		panel.setBounds(212, 49, 45, 30);
		add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 89, 960, 472);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 960, 472);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PIN", "Fullname", "ID", "Phonenumber", "Balance"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		//load data to table
		loadData();
//		model.setRowCount(0);
//		for (Customer cs : list.getList()) {
//			model.addRow(new Object[] { cs.getPIN(),cs.getFullname(),cs.getID(),cs.getPhonenumber(), cs.getBalance()});
//		}
		
		JLabel lblNewLabel_2 = new JLabel("Total customer :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(795, 49, 119, 22);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setText(String.valueOf(model.getRowCount()));
		lblNewLabel_3.setBounds(925, 49, 45, 22);
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
				int click = JOptionPane.showConfirmDialog(null, "Do you want to add customer?", "Message", JOptionPane.YES_NO_OPTION);
				if(click == JOptionPane.YES_OPTION) {
					AddCustomer addC = new AddCustomer();
					addC.setVisible(true);
					if(addC.isDisplayable()) {
						loadData();
						list.toString_1();
					}
				}

			}
		});
		loadData();
		panel_Add.setBackground(Color.WHITE);
		panel_Add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_Add.setBounds(228, 571, 112, 33);
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
					int click = JOptionPane.showConfirmDialog(null, "Do you want to delete this customer?", "Alert" , JOptionPane.YES_NO_OPTION);
					if(click == JOptionPane.YES_OPTION) {
						list.removeCustomer(row);
						model.removeRow(row);
						try {
							dataBase.writeCustomer("src/question1/customer.txt", list);
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
		panel_Delete.setBackground(Color.WHITE);
		panel_Delete.setBounds(648, 571, 112, 33);
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
		
		JPanel panel_Detail = new JPanel();
		panel_Detail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_Detail.setLayout(null);
		panel_Detail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row < 0 || row > list.getList().size()) {
					JOptionPane.showMessageDialog(null, "Please choose the customer you want to show details!", "Alert", 2);
				}
				else {
					AccountIn4 aci = new AccountIn4();
					aci.setVisible(true);
					aci.setCtm(list.getList().get(row));
					aci.loadDataToTable();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Detail.setBackground(new Color(82, 179, 217));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Detail.setBackground(Color.WHITE);
			}
		});

		panel_Detail.setBackground(Color.WHITE);
		panel_Detail.setBounds(432, 571, 112, 33);
		add(panel_Detail);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(Manage_Customer.class.getResource("/images/information-icon.png")));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(0, 0, 40, 33);
		panel_Detail.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Detail");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_2.setBounds(40, 0, 72, 33);
		panel_Detail.add(lblNewLabel_5_2);
	}
	
	public void loadData() {
		model.setRowCount(0);
		for (Customer cs : list.getList()) {
			model.addRow(new Object[] { cs.getPIN(),cs.getFullname(),cs.getID(),cs.getPhonenumber(), cs.getBalance()});
		}
		model.fireTableDataChanged();
	}
}
