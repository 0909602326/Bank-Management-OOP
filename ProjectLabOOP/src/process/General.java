package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class General extends JPanel {

	/**
	 * Create the panel.
	 */
	public General(JPanel ex_panel, JFrame frame, Customer ctm) {
		setBounds(0, 24, 1248, 745);
		setLayout(null);

		JPanel panel_GeneralTitle = new JPanel();
		panel_GeneralTitle.setBackground(new Color(129, 207, 224));
		panel_GeneralTitle.setBounds(0, 0, 1248, 198);
		add(panel_GeneralTitle);
		panel_GeneralTitle.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("PLEASE CHOOSE THE FUNCTION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_3.setBounds(197, 62, 855, 93);
		panel_GeneralTitle.add(lblNewLabel_3);

		JPanel panel_GenaralFunction = new JPanel();
		panel_GenaralFunction.setBounds(0, 197, 1248, 548);
		add(panel_GenaralFunction);
		panel_GenaralFunction.setLayout(null);

		JLabel lblCheck = new JLabel("");
		lblCheck.setBounds(30, 69, 45, 44);
		panel_GenaralFunction.add(lblCheck);
		lblCheck.setVisible(false);
		lblCheck.setIcon(new ImageIcon(CustomerProcess.class.getResource("/images/Check-icon.png")));
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_ChangePassword = new JPanel();
		panel_ChangePassword.setLayout(new BorderLayout());
		panel_ChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_ChangePassword.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_ChangePassword.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to change password ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					ChangePassword change = new ChangePassword(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(change, BorderLayout.CENTER);
					ex_panel.validate();
				}
				else {
					panel_ChangePassword.removeAll();
					panel_ChangePassword.validate();
					panel_ChangePassword.setBorder(new EmptyBorder(1, 1, 1, 1));
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_ChangePassword.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_ChangePassword.removeAll();
				panel_ChangePassword.validate();
				panel_ChangePassword.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_ChangePassword.setBackground(Color.WHITE);
		panel_ChangePassword.setBounds(101, 141, 45, 44);
		panel_GenaralFunction.add(panel_ChangePassword);

		JPanel panel_Information = new JPanel();
		panel_Information.setLayout(new BorderLayout());
		panel_Information.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Information.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_Information.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				In4OfAccount in4 = new In4OfAccount(ex_panel, frame, ctm);
				ex_panel.removeAll();
				ex_panel.add(in4, BorderLayout.CENTER);
				ex_panel.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Information.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Information.removeAll();
				panel_Information.validate();
				panel_Information.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_Information.setBackground(Color.WHITE);
		panel_Information.setBounds(101, 257, 45, 44);
		panel_GenaralFunction.add(panel_Information);


		JPanel panel_LogOut = new JPanel();
		panel_LogOut.setLayout(new BorderLayout());
		panel_LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_LogOut.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_LogOut.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					GUI gui = new GUI();
					gui.setVisible(true);
					frame.dispose();
				}
				else {
					panel_LogOut.removeAll();
					panel_LogOut.validate();
					panel_LogOut.setBorder(new EmptyBorder(1, 1, 1, 1));
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_LogOut.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
				panel_LogOut.removeAll();
				panel_LogOut.validate();
				panel_LogOut.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_LogOut.setBackground(Color.WHITE);
		panel_LogOut.setBounds(101, 374, 45, 44);
		panel_GenaralFunction.add(panel_LogOut);


		JPanel panel_Transfer = new JPanel();
		panel_Transfer.setLayout(new BorderLayout());
		panel_Transfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Transfer.setBorder(new EmptyBorder(1,1,1,1));
				panel_Transfer.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to transfer ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					Transfer trf = new Transfer(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(trf, BorderLayout.CENTER);
					ex_panel.validate();
				}
				else {
					panel_Transfer.removeAll();
					panel_Transfer.validate();
					panel_Transfer.setBorder(new EmptyBorder(1,1,1,1));
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Transfer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1 , Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Transfer.removeAll();
				panel_Transfer.validate();
				panel_Transfer.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		panel_Transfer.setBackground(Color.WHITE);
		panel_Transfer.setBounds(1090, 141, 45, 44);
		panel_GenaralFunction.add(panel_Transfer);

		JPanel panel_Deposit = new JPanel();
		panel_Deposit.setLayout(new BorderLayout());
		panel_Deposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Deposit.setBorder(new EmptyBorder(1,1,1,1));
				panel_Deposit.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					Deposit dps = new Deposit(ex_panel, frame,ctm);
					ex_panel.removeAll();
					ex_panel.add(dps, BorderLayout.CENTER);
					ex_panel.validate();
				}
				else {
					panel_Deposit.removeAll();
					panel_Deposit.validate();
					panel_Deposit.setBorder(new EmptyBorder(1, 1, 1, 1));
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Deposit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1 , Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Deposit.removeAll();
				panel_Deposit.validate();
				panel_Deposit.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		panel_Deposit.setBackground(Color.WHITE);
		panel_Deposit.setBounds(1090, 257, 45, 44);
		panel_GenaralFunction.add(panel_Deposit);
	

		JPanel panel_Withdraw = new JPanel();
		panel_Withdraw.setLayout(new BorderLayout());
		panel_Withdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Withdraw.setBorder(new EmptyBorder(1,1,1,1));
				panel_Withdraw.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to withdraw ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					Withdraw wd = new Withdraw(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(wd, BorderLayout.CENTER);
					ex_panel.validate();
				}
				else {
					panel_Withdraw.removeAll();
					panel_Withdraw.validate();
					panel_Withdraw.setBorder(new EmptyBorder(1,1,1,1));
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Withdraw.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1 , Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Withdraw.removeAll();
				panel_Withdraw.validate();
				panel_Withdraw.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		panel_Withdraw.setBackground(Color.WHITE);
		panel_Withdraw.setBounds(1090, 374, 45, 44);
		panel_GenaralFunction.add(panel_Withdraw);


		JLabel lblNewLabel_4_1 = new JLabel("Change Password");
		lblNewLabel_4_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_1.setBounds(179, 141, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_1);

		JLabel lblinFormation = new JLabel("Information");
		lblinFormation.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblinFormation.setBounds(179, 257, 278, 44);
		panel_GenaralFunction.add(lblinFormation);

		JLabel lblNewLabel_4_3 = new JLabel("Log out");
		lblNewLabel_4_3.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_3.setBounds(179, 374, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_5 = new JLabel("Transfer");
		lblNewLabel_4_5.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_5.setBounds(780, 141, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_6 = new JLabel("Deposit");
		lblNewLabel_4_6.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_6.setBounds(780, 257, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_7 = new JLabel("Withdraw");
		lblNewLabel_4_7.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_7.setBounds(780, 374, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(General.class.getResource("/images/Finance-Cash-Receiving-icon.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(413, 10, 463, 441);
		lblNewLabel.setBounds(393, 49, 463, 441);
		panel_GenaralFunction.add(lblNewLabel);
	}
}
