package process;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;

public class LoginForm extends JPanel {
	private JTextField txtPIN;
	private JPasswordField passwordField;
	private boolean flag = false;
	private boolean boom = false;
	private DataBase dataBase;
	// private DataProcess dataProcess;
	private ListOfCustomer list_Cus;
	private ListOfAdmin list_Admin;

	/**
	 * Create the panel.
	 */
	public LoginForm(JPanel ex_panel, String text, JFrame frame) {
		dataBase = new DataBase();
		list_Cus = new ListOfCustomer();
		list_Admin = new ListOfAdmin();

		setBackground(Color.WHITE);

		// Border
		Border txtUsername_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		// lblCoverUserName
		JLabel lblCoverUserName = new JLabel("Pin");
		lblCoverUserName.setEnabled(false);
		lblCoverUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoverUserName.setBounds(44, 118, 98, 41);
		lblCoverUserName.setForeground(new Color(153, 153, 153));

		// txtUsername
		txtPIN = new JTextField();
		txtPIN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();
				if (txtPIN.getText().equalsIgnoreCase("")) {
					lblCoverUserName.setVisible(true);
				} else
					lblCoverUserName.setVisible(false);
			}
		});
		txtPIN.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtPIN.setBackground(Color.WHITE);
		txtPIN.setBorder(txtUsername_border);
		txtPIN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPIN.setBounds(44, 118, 468, 41);
		txtPIN.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		txtPIN.add(lblCoverUserName);
		add(txtPIN);
		txtPIN.setColumns(10);

		// lblCoverPassword
		JLabel lblCoverPass = new JLabel("Password");
		lblCoverPass.setEnabled(false);
		lblCoverPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoverPass.setForeground(new Color(153, 153, 153));
		lblCoverPass.setBounds(44, 187, 122, 41);

		// txtpassword
		passwordField = new JPasswordField();
		String pass = String.valueOf(passwordField.getPassword());
		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				if (passwordField.getText().equalsIgnoreCase("")) {
					lblCoverPass.setVisible(true);
				} else
					lblCoverPass.setVisible(false);
			}
		});
		passwordField.setBorder(txtUsername_border);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		passwordField.setForeground(Color.BLACK);
		passwordField.setCaretPosition(0);
		passwordField.add(lblCoverPass);
		passwordField.setBounds(44, 187, 468, 41);
		add(passwordField);

		// Create account
		JLabel lblCreate = new JLabel("Create one!");
		lblCreate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(25, 181, 254));
				lblCreate.setBorder(label_border);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCreate.setBorder(null);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterForm rgf = new RegisterForm(ex_panel, text, frame);
//				rgf.setVisible(true);
				Create(ex_panel, rgf);
				setVisible(false);
			}
		});
		lblCreate.setForeground(new Color(25, 181, 254));
		lblCreate.setBorder(null);
		lblCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCreate.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCreate.setBounds(162, 259, 109, 32);
		if(!text.equalsIgnoreCase("administrator"))
			add(lblCreate);

		JLabel lblNoAccount = new JLabel("No account?");
		lblNoAccount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNoAccount.setBounds(44, 263, 122, 32);
		if(!text.equalsIgnoreCase("administrator"))
			add(lblNoAccount);

		// Login button
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(58, 83, 155).brighter());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(58, 83, 155));
			}

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				String pass = String.valueOf(passwordField.getPassword());
				if (txtPIN.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN", "Error", 2);
					txtPIN.requestFocus();
				} else if (pass.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter password", "Error", 2);
					passwordField.requestFocus();
				} else {
					if (text.equalsIgnoreCase("customer")) {
						try {
							list_Cus = dataBase.readCustomer("src/question1/customer.txt");
						} catch (Exception e1) {
							System.out.println(e1);
							e1.printStackTrace();
						}
						for (Customer cs : list_Cus.getList()) {
							boom = false;
							if (txtPIN.getText().equalsIgnoreCase(cs.getPIN())) {
								if (pass.equals(cs.getPassword())) {
									CustomerProcess ctp = new CustomerProcess();
									ctp.setCustomer(cs);
									ctp.addGeneral();
									ctp.setVisible(true);
									frame.dispose();
									flag = true;
									break;
								} else {
									JOptionPane.showMessageDialog(null, "Your password is incorrect", "Alert", 2);
									passwordField.requestFocus();
									break;
								}
							} else {
								boom = true;
							}
						}
						if (boom == true) {
							JOptionPane.showMessageDialog(null, "Your PIN is incorrect", "Alert", 2);
							txtPIN.requestFocus();
						}

					}
					else {
						try {
							list_Admin = dataBase.readAdmin("src/question1/admin.txt");
						} catch (Exception e1) {
							System.out.println(e1);
							e1.printStackTrace();
						}
						for (Admin ad : list_Admin.getList()) {
							boom = false;
							if (txtPIN.getText().equalsIgnoreCase(ad.getPIN())) {
								if (pass.equals(ad.getPassword())) {
									AdminProcess amp = new AdminProcess();
									amp.setVisible(true);
									amp.setAdmin(ad);
									frame.dispose();
									flag = true;
									break;
								} else {
									JOptionPane.showMessageDialog(null, "Your password is incorrect", "Alert", 2);
									passwordField.requestFocus();
									break;
								}
							} else {
								boom = true;
							}
						}
						if (boom == true) {
							JOptionPane.showMessageDialog(null, "Your PIN is incorrect", "Alert", 2);
							txtPIN.requestFocus();
						}
					}
				}
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(new Color(58, 83, 155));
		panel.setBounds(381, 319, 131, 41);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(0, 0, 131, 41);
		panel.add(lblNewLabel_2);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(108, 122, 137));
		panel_1.setBounds(0, 0, 562, 82);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(29, 3, 72, 72);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/images/messages-icon.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("You login as " + text);
		lblNewLabel_1.setBounds(111, 20, 402, 41);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(247, 202, 24));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 23));

	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void Create(JPanel panel, RegisterForm rgf) {
		rgf.setVisible(true);
		panel.setBounds(184, 47, 625, 541);
		panel.add(rgf);
	}
}
