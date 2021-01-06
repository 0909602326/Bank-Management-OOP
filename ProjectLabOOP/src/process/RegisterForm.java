package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

public class RegisterForm extends JPanel {
	private JPasswordField Password;
	private JPasswordField ConfirmPassword;
	public boolean flag = false;
	private int type;
	private ListOfCustomer list;
	private DataBase dataBase;
	private String PIN;
	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Create the panel.
	 */
	public RegisterForm(JPanel ex_panel, String text, JFrame frame) {
		list = new ListOfCustomer();
		dataBase = new DataBase();
		try {
			list = dataBase.readCustomer("src/question1/customer.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBackground(Color.WHITE);
		setLayout(null);

		// Border
		Border txtUsername_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(108, 122, 137));
		panel.setBounds(0, 0, 625, 62);
		add(panel);
		panel.setLayout(null);

		JLabel Register = new JLabel("Register");
		Register.setBounds(205, 0, 192, 62);
		panel.add(Register);
		Register.setHorizontalAlignment(SwingConstants.CENTER);
		Register.setFont(new Font("Arial", Font.BOLD, 40));
		Register.setForeground(new Color(247, 202, 24));
		// CoverName
		JLabel lblCoverName = new JLabel("Fullname");
		lblCoverName.setEnabled(false);
		lblCoverName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCoverName.setForeground(new Color(153, 153, 153));
		lblCoverName.setBounds(72, 106, 128, 41);

		// Name
		JTextField txtFullname = new JTextField();
		txtFullname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
				if (txtFullname.getText().equalsIgnoreCase("")) {
					lblCoverName.setVisible(true);
				} else
					lblCoverName.setVisible(false);
			}
		});
		txtFullname.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		txtFullname.setFont(new Font("Arial", Font.PLAIN, 20));
		txtFullname.setBorder(txtUsername_border);
		txtFullname.setBounds(72, 82, 468, 41);
		txtFullname.add(lblCoverName);
		add(txtFullname);
		txtFullname.setColumns(10);

		// CoverPhone
		JLabel lblCoverPhonenumber = new JLabel("Phonenumber");
		lblCoverPhonenumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCoverPhonenumber.setEnabled(false);
		lblCoverPhonenumber.setBounds(72, 174, 128, 41);
		lblCoverPhonenumber.setForeground(new Color(153, 153, 153));

		// Phonenumber
		JTextField txtPhonenumber = new JTextField();
		txtPhonenumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();
				if (txtPhonenumber.getText().equalsIgnoreCase(""))
					lblCoverPhonenumber.setVisible(true);
				else
					lblCoverPhonenumber.setVisible(false);
			}
		});
		txtPhonenumber.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPhonenumber.setBorder(txtUsername_border);
		txtPhonenumber.setColumns(10);
		txtPhonenumber.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		txtPhonenumber.add(lblCoverPhonenumber);
		txtPhonenumber.setBounds(72, 145, 468, 41);
		add(txtPhonenumber);

		// CoverID
		JLabel lblCoverId = new JLabel("ID");
		lblCoverId.setEnabled(false);
		lblCoverId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCoverId.setBounds(72, 243, 88, 41);
		lblCoverId.setForeground(new Color(153, 153, 153));

		// IDno
		JTextField txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();
				if (txtID.getText().equalsIgnoreCase(""))
					lblCoverId.setVisible(true);
				else
					lblCoverId.setVisible(false);
			}
		});
		txtID.setFont(new Font("Arial", Font.PLAIN, 20));
		txtID.setBorder(txtUsername_border);
		txtID.setColumns(10);
		txtID.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		txtID.add(lblCoverId);
		txtID.setBounds(72, 200, 468, 41);
		add(txtID);

		JTextField txtPin = new JTextField();
		txtPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin.setDisabledTextColor(Color.WHITE);
		txtPin.setBackground(new Color(31, 58, 147));
		txtPin.setFont(new Font("Arial", Font.BOLD, 23));
		txtPin.setEnabled(false);
		txtPin.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		txtPin.setColumns(10);
		txtPin.setBounds(230, 260, 310, 41);
		add(txtPin);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 241, 239));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(232, 232, 232));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(242, 241, 239));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txtPin.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You already have PIN", "Error", 2);
				} else {
					Random r = new Random();
					int number1;
					int number2;
					int number3;
					while(true) {
						flag = false;
						number1 = r.nextInt(8999) + 1000;
						number2 = r.nextInt(8999) + 1000;
						number3 = r.nextInt(8999) + 1000;
						PIN = String.valueOf(number1) + String.valueOf(number2) + String.valueOf(number3);
						for(Customer cs : list.getList()) {
							if(cs.getPIN().equalsIgnoreCase(PIN)) {
								flag = true;
								break;
							}
						}
						if(flag == false)
							break;
					}
					txtPin.setText(String.valueOf(number1) + " - " + String.valueOf(number2) + " - "
							+ String.valueOf(number3));
				}
			}
		});
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBorder(null);
		panel_2.setBounds(72, 260, 128, 41);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Get PIN");
		lblNewLabel_2.setBounds(0, 0, 128, 41);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_2.setBorder(null);
		panel_2.add(lblNewLabel_2);
		
		// Cover Password
				JLabel lblNewLabel_3 = new JLabel("Password");
				lblNewLabel_3.setEnabled(false);
				lblNewLabel_3.setForeground(new Color(153, 153, 153));
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
				lblNewLabel_3.setBounds(72, 326, 128, 41);

				// Password
				Password = new JPasswordField();
				Password.addKeyListener(new KeyAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void keyTyped(KeyEvent e) {
						if(Password.getText().equalsIgnoreCase("")) {
							lblNewLabel_3.setVisible(true);
						}
						else
							lblNewLabel_3.setVisible(false);
					}
				});
				Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
				Password.setBounds(72, 326, 468, 41);
				Password.setBorder(txtUsername_border);
				Password.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
				Password.add(lblNewLabel_3);
				add(Password);

				// Cover confirm
				JLabel lblNewLabel_4 = new JLabel("Confirm");
				lblNewLabel_4.setEnabled(false);
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
				lblNewLabel_4.setForeground(new Color(153, 153, 153));
				lblNewLabel_4.setBounds(72, 377, 113, 41);

				// Confirm
				ConfirmPassword = new JPasswordField();
				ConfirmPassword.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						String pass = String.valueOf(ConfirmPassword.getPassword());
						if(pass.equalsIgnoreCase("")) {
							lblNewLabel_4.setVisible(true);
						}
						else
							lblNewLabel_4.setVisible(false);
					}
				});
				ConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
				ConfirmPassword.setBorder(txtUsername_border);
				ConfirmPassword.setBounds(72, 377, 468, 41);
				ConfirmPassword.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
				ConfirmPassword.add(lblNewLabel_4);
				add(ConfirmPassword);

		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBackground(new Color(235, 47, 6));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(225, 20, 2).brighter());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(225, 20, 2));
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!Password.getText().equalsIgnoreCase(ConfirmPassword.getText())) {
					JOptionPane.showMessageDialog(null, "Password does not match", "Error", 2);
				}
				else if(txtFullname.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Fullname is empty", "Error", 2);
					txtFullname.requestFocus();
				}
				else if(txtID.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "ID is empty", "Error", 2);
					txtID.requestFocus();
				}
				else if(txtPhonenumber.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Phonenumber is empty", "Error", 2);
					txtPhonenumber.requestFocus();
				}
				else if(txtPin.getText().equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(null, "You haven't get PIN yet", "Error", 2);
				else {
					if(text.equalsIgnoreCase("customer")) {
						String pass = String.valueOf(Password.getPassword());
						Customer cs = new Customer(PIN,txtFullname.getText(),txtPhonenumber.getText(),txtID.getText(),pass);
						list.addCustomer(cs);
						try {
							dataBase.writeCustomer("src/question1/customer.txt", list);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						CustomerProcess ctp = new CustomerProcess();
						ctp.setCustomer(cs);
						ctp.addGeneral();
						ctp.setVisible(true);
						frame.dispose();
					}
					JOptionPane.showMessageDialog(null, "Successfully Register", "Message", 1);
				}
					
			}
		});
		panel_3.setBorder(null);
		panel_3.setBounds(72, 441, 468, 48);
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Register");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(0, 0, 468, 48);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Already Have an Account? Login!");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(new Color(25, 181, 254));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(25, 181, 254)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBorder(null);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				LoginForm Lgf = new LoginForm(ex_panel, text, frame);
//				ex_panel.removeAll();
//				ex_panel.add(Lgf, BorderLayout.CENTER);
//				ex_panel.validate();
				Create(ex_panel, Lgf);
				//Lgf.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(174, 499, 277, 32);
		add(lblNewLabel);

	}

	public void Create(JPanel panel, LoginForm lgf) {
		lgf.setVisible(true);
		panel.setBounds(217, 103, 562, 388);
		panel.add(lgf);
	}
}
