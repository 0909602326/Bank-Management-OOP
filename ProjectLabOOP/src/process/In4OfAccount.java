package process;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class In4OfAccount extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private ExchangeHistory exh;
	private DataBase dataBase;

	/**
	 * Create the panel.
	 */
	public In4OfAccount(JPanel ex_panel, JFrame frame, Customer ctm) {
		exh = new ExchangeHistory();
		dataBase = new DataBase();
		String path = "src/question1/" + ctm.getPIN() + ".txt";
		try {
			exh = dataBase.readHistory(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(0, 24, 1248, 745);
		setLayout(null);

		JPanel panel_GeneralTitle = new JPanel();
		panel_GeneralTitle.setLayout(null);
		panel_GeneralTitle.setBackground(new Color(129, 207, 224));
		panel_GeneralTitle.setBounds(0, 0, 1248, 198);
		add(panel_GeneralTitle);
		

		JLabel lblNewLabel_3 = new JLabel("BALANCE: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_3.setBounds(314, 63, 278, 93);
		panel_GeneralTitle.add(lblNewLabel_3);
		
		JLabel lblMoney = new JLabel("");
		lblMoney.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 45));
		lblMoney.setText(String.valueOf(ctm.getBalance()));
		lblMoney.setBounds(594, 62, 442, 91);
		panel_GeneralTitle.add(lblMoney);

		JPanel panel_GenaralFunction = new JPanel();
		panel_GenaralFunction.setBounds(0, 197, 1248, 548);
		add(panel_GenaralFunction);
		panel_GenaralFunction.setLayout(null);
		
		JLabel lblCheck = new JLabel("");
		lblCheck.setBounds(30, 49, 45, 44);
		panel_GenaralFunction.add(lblCheck);
		lblCheck.setVisible(false);
		lblCheck.setIcon(new ImageIcon(CustomerProcess.class.getResource("/images/Check-icon.png")));
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 41, 965, 379);
		panel_GenaralFunction.add(scrollPane);

		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Date", "Category", "Money", "Receiver"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_Back = new JPanel();
		panel_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Back.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_Back.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to choose another function ?",
						"Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					General gnr = new General(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(gnr, BorderLayout.CENTER);
					ex_panel.validate();
				} else {
					panel_Back.removeAll();
					panel_Back.validate();
					panel_Back.setBorder(new EmptyBorder(1, 1, 1, 1));
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Back.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Back.removeAll();
				panel_Back.validate();
				panel_Back.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_Back.setBackground(Color.WHITE);
		panel_Back.setBounds(141, 466, 45, 44);
		panel_GenaralFunction.add(panel_Back);
		panel_Back.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_4_3 = new JLabel("Back");
		lblNewLabel_4_3.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_3.setBounds(199, 466, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_3);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Exchange ex : exh.getList()) {
			if(ex.getReceiver().equalsIgnoreCase("0")) {
				model.addRow(new Object[] { ex.getDate(), ex.getCategory(), ex.getMoney(), null });
			}
			else {
				model.addRow(new Object[] { ex.getDate(), ex.getCategory(), ex.getMoney(), ex.getReceiver() });
			}
		}

		JLabel lblNewLabel = new JLabel("PIN of Receiver");
		lblNewLabel.setForeground(new Color(153, 153, 153));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 27));
		lblNewLabel.setBounds(362, 33, 207, 71);
	}
}
