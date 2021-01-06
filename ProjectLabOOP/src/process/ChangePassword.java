package process;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ChangePassword extends JPanel {
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField confirm;
	private ListOfCustomer list;
	private DataBase dataBase;

	/**
	 * Create the panel.
	 */
	public ChangePassword(JPanel ex_panel, JFrame frame, Customer ctm) {

		setBounds(0, 24, 1248, 745);
		setLayout(null);

		JPanel panel_GeneralTitle = new JPanel();
		panel_GeneralTitle.setLayout(null);
		panel_GeneralTitle.setBounds(0, 0, 1248, 198);
		panel_GeneralTitle.setBackground(new Color(129, 207, 224));
		add(panel_GeneralTitle);

		JPanel panel_GenaralFunction = new JPanel();
		panel_GenaralFunction.setLayout(null);
		panel_GenaralFunction.setBounds(0, 197, 1248, 548);
		add(panel_GenaralFunction);

		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_3.setBounds(267, 63, 656, 93);
		panel_GeneralTitle.add(lblNewLabel_3);

		// Cover Old Password
		JLabel lblCoverOld = new JLabel("Old Password");
		lblCoverOld.setEnabled(false);
		lblCoverOld.setForeground(new Color(153, 153, 153));
		lblCoverOld.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCoverOld.setBounds(282, 72, 216, 65);

		// Old Password
		oldPass = new JPasswordField();
		oldPass.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 14));
		oldPass.add(lblCoverOld);
		oldPass.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				if (oldPass.getText().equalsIgnoreCase("")) {
					lblCoverOld.setVisible(true);
				} else
					lblCoverOld.setVisible(false);
			}
		});
		oldPass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		oldPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		oldPass.setBounds(282, 72, 607, 65);
		panel_GenaralFunction.add(oldPass);

		// Cover New Password
		JLabel lblCoverNew = new JLabel("New Password");
		lblCoverNew.setEnabled(false);
		lblCoverNew.setForeground(new Color(153, 153, 153));
		lblCoverNew.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCoverNew.setBounds(282, 192, 185, 65);

		// new Password
		newPass = new JPasswordField();
		newPass.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 14));
		newPass.add(lblCoverNew);
		newPass.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				String pass = String.valueOf(newPass.getPassword());
				if (pass.equalsIgnoreCase("")) {
					lblCoverNew.setVisible(true);
				} else
					lblCoverNew.setVisible(false);
			}
		});
		newPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		newPass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		newPass.setBounds(282, 192, 607, 65);
		panel_GenaralFunction.add(newPass);

		// Cover Confirm
		JLabel lblConfirm = new JLabel("Confirm");
		lblConfirm.setEnabled(false);
		lblConfirm.setForeground(new Color(153, 153, 153));
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblConfirm.setBounds(282, 311, 182, 65);

		// Confirm
		confirm = new JPasswordField();
		confirm.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 14));
		confirm.add(lblConfirm);
		confirm.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				String pass = String.valueOf(confirm.getPassword());
				if (pass.equalsIgnoreCase("")) {
					lblConfirm.setVisible(true);
				} else
					lblConfirm.setVisible(false);
			}
		});
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		confirm.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		confirm.setBounds(282, 311, 607, 65);
		panel_GenaralFunction.add(confirm);

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!String.valueOf(oldPass.getPassword()).equalsIgnoreCase(ctm.getPassword())) {
					JOptionPane.showMessageDialog(null, "Old password is incorrect", "Alert", 2);
					oldPass.requestFocus();
				} else if (!String.valueOf(newPass.getPassword())
						.equalsIgnoreCase(String.valueOf(confirm.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Password does not match", "Alert", 2);
					newPass.requestFocus();
				} else {
					list = new ListOfCustomer();
					dataBase = new DataBase();
					try {

						list = dataBase.readCustomer("src/question1/customer.txt");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(ctm.getPIN())) {
							cs.setPassword(String.valueOf(confirm.getPassword()));
							break;
						}
					}
					try {

						dataBase.writeCustomer("src/question1/customer.txt", list);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Successfully change password", "Message", 1);
					General gnr = new General(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(gnr, BorderLayout.CENTER);
					ex_panel.validate();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(235, 47, 6).brighter());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(235, 47, 6));
			}
		});
		panel.setBackground(new Color(235, 47, 6));
		panel.setBounds(685, 432, 204, 57);
		panel_GenaralFunction.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(0, 0, 204, 57);
		panel.add(lblNewLabel);

		JLabel lblCheck = new JLabel("");
		lblCheck.setBounds(30, 69, 45, 44);
		panel_GenaralFunction.add(lblCheck);
		lblCheck.setVisible(false);
		lblCheck.setIcon(new ImageIcon(CustomerProcess.class.getResource("/images/Check-icon.png")));
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_Back = new JPanel();
		panel_Back.setLayout(new BorderLayout());
		panel_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Back.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

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
			public void mouseExited(MouseEvent e) {
				panel_Back.removeAll();
				panel_Back.validate();
				panel_Back.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_Back.setBackground(Color.WHITE);
		panel_Back.setBounds(282, 432, 45, 44);
		panel_GenaralFunction.add(panel_Back);

		JLabel lblNewLabel_4_3 = new JLabel("Back");
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_4_3.setBounds(342, 432, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_3);
	}
}
