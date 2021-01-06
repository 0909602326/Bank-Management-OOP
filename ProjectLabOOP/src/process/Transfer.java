package process;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Transfer extends JPanel {
	private JTextField txtPinOfReceiver;
	private JPanel panel_50k;
	private JPanel panel_100k;
	private JPanel panel_200k;
	private JPanel panel_500k;
	private JPanel panel_1tr;
	private JPanel panel_2tr;
	private JPanel panel_Back;
	private JPanel panel_Other;
	private DataBase dataBase;
	private ListOfCustomer list;
	private ExchangeHistory exh;
	private LocalDate date;
	private boolean flag = false;

	/**
	 * Create the panel.
	 */
	public Transfer(JPanel ex_panel, JFrame frame, Customer ctm) {
		exh = new ExchangeHistory();
		list = new ListOfCustomer();
		dataBase = new DataBase();
		String path = "src/question1/" + ctm.getPIN() + ".txt";
		try {
			exh = dataBase.readHistory(path);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			list = dataBase.readCustomer("src/question1/customer.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(0, 24, 1248, 745);
		setLayout(null);

		JPanel panel_GeneralTitle = new JPanel();
		panel_GeneralTitle.setLayout(null);
		panel_GeneralTitle.setBackground(new Color(129, 207, 224));
		panel_GeneralTitle.setBounds(0, 0, 1248, 198);
		add(panel_GeneralTitle);

		JLabel lblNewLabel_3 = new JLabel("TRANSFER MONEY");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_3.setBounds(267, 63, 656, 93);
		panel_GeneralTitle.add(lblNewLabel_3);

		JPanel panel_GenaralFunction = new JPanel();
		panel_GenaralFunction.setBounds(0, 197, 1248, 548);
		add(panel_GenaralFunction);
		panel_GenaralFunction.setLayout(null);

		JLabel lblNewLabel = new JLabel("PIN of Receiver");
		lblNewLabel.setForeground(new Color(153, 153, 153));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 27));
		lblNewLabel.setBounds(362, 33, 207, 71);

		JLabel lblCheck = new JLabel("");
		lblCheck.setBounds(30, 49, 45, 44);
		panel_GenaralFunction.add(lblCheck);
		lblCheck.setVisible(false);
		lblCheck.setIcon(new ImageIcon(CustomerProcess.class.getResource("/images/Check-icon.png")));
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);

		txtPinOfReceiver = new JTextField();
		txtPinOfReceiver.requestFocus();
		txtPinOfReceiver.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();
				txtPinOfReceiver.setHorizontalAlignment(SwingConstants.CENTER);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					txtPinOfReceiver.setHorizontalAlignment(SwingConstants.LEADING);
					lblNewLabel.setVisible(true);
				} else {
					txtPinOfReceiver.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setVisible(false);
				}
			}
		});
		txtPinOfReceiver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPinOfReceiver.setHorizontalAlignment(SwingConstants.LEADING);
		txtPinOfReceiver.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 14));
		txtPinOfReceiver.add(lblNewLabel);
		txtPinOfReceiver.setBounds(362, 33, 485, 71);
		panel_GenaralFunction.add(txtPinOfReceiver);
		txtPinOfReceiver.setColumns(10);

		panel_50k = new JPanel();
		panel_50k.setLayout(new BorderLayout());
		panel_50k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_50k.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_50k.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("50,000", ctm, 50000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_50k.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_50k.removeAll();
				panel_50k.validate();
				panel_50k.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_50k.setBackground(Color.WHITE);
		panel_50k.setBounds(101, 141, 45, 44);
		panel_GenaralFunction.add(panel_50k);

		panel_100k = new JPanel();
		panel_100k.setLayout(new BorderLayout());
		panel_100k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_100k.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_100k.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("100,000", ctm, 100000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_100k.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_100k.removeAll();
				panel_100k.validate();
				panel_100k.setBorder(new EmptyBorder(1, 1, 1, 1));

			}
		});
		panel_100k.setBackground(Color.WHITE);
		panel_100k.setBounds(101, 257, 45, 44);
		panel_GenaralFunction.add(panel_100k);

		panel_200k = new JPanel();
		panel_200k.setLayout(new BorderLayout());
		panel_200k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_200k.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_200k.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("200,000", ctm, 200000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_200k.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_200k.removeAll();
				panel_200k.validate();
				panel_200k.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_200k.setBackground(Color.WHITE);
		panel_200k.setBounds(101, 362, 45, 44);
		panel_GenaralFunction.add(panel_200k);

		panel_500k = new JPanel();
		panel_500k.setLayout(new BorderLayout());
		panel_500k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_500k.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_500k.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("500,000", ctm, 500000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_500k.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_500k.removeAll();
				panel_500k.validate();
				panel_500k.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_500k.setBackground(Color.WHITE);
		panel_500k.setBounds(1090, 141, 45, 44);
		panel_GenaralFunction.add(panel_500k);

		panel_1tr = new JPanel();
		panel_1tr.setLayout(new BorderLayout());
		panel_1tr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1tr.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_1tr.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("1,000,000", ctm, 1000000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1tr.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1tr.removeAll();
				panel_1tr.validate();
				panel_1tr.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_1tr.setBackground(Color.WHITE);
		panel_1tr.setBounds(1090, 257, 45, 44);
		panel_GenaralFunction.add(panel_1tr);

		panel_2tr = new JPanel();
		panel_2tr.setLayout(new BorderLayout());
		panel_2tr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2tr.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_2tr.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver!", "Error", 2);
				} else {
					for (Customer cs : list.getList()) {
						if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
						txtPinOfReceiver.requestFocus();
					} else {
						TransferMoney("2,000,000", ctm, 2000000, txtPinOfReceiver.getText());
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2tr.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_2tr.removeAll();
				panel_2tr.validate();
				panel_2tr.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_2tr.setBackground(Color.WHITE);
		panel_2tr.setBounds(1090, 362, 45, 44);
		panel_GenaralFunction.add(panel_2tr);

		JLabel lblNewLabel_4_1 = new JLabel("50,000");
		lblNewLabel_4_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_1.setBounds(179, 141, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("100,000");
		lblNewLabel_4_2.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_2.setBounds(179, 257, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("Back");
		lblNewLabel_4_3.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_3.setBounds(179, 457, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_5 = new JLabel("500,000");
		lblNewLabel_4_5.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_5.setBounds(780, 141, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_6 = new JLabel("1,000,000");
		lblNewLabel_4_6.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_6.setBounds(780, 257, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_7 = new JLabel("2,000,000");
		lblNewLabel_4_7.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_7.setBounds(780, 362, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_7);

		panel_Back = new JPanel();
		panel_Back.setLayout(new BorderLayout());
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
		panel_Back.setBounds(101, 457, 45, 44);
		panel_GenaralFunction.add(panel_Back);

		JLabel lblNewLabel_4_2_1 = new JLabel("200,000");
		lblNewLabel_4_2_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_2_1.setBounds(179, 362, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_2_1);

		panel_Other = new JPanel();
		panel_Other.setLayout(new BorderLayout());
		panel_Other.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Other.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_Other.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				if (txtPinOfReceiver.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You must enter PIN of receiver", "Error", 2);
				} else {
					String m = JOptionPane.showInputDialog(null, "Enter amount of money", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					if (m != null) {
						if (m.equalsIgnoreCase(""))
							JOptionPane.showMessageDialog(null, "You must enter amount of money", "Error", 2);
						else if (!m.equalsIgnoreCase("")) {
							for (Customer cs : list.getList()) {
								if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
									flag = true;
									break;
								}
							}
							if (flag == false) {
								JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
								txtPinOfReceiver.requestFocus();
							}
							else {
								TransferMoney(m,ctm, Double.parseDouble(m),txtPinOfReceiver.getText());
							}
						}
					}

				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Other.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_Other.removeAll();
				panel_Other.validate();
				panel_Other.setBorder(new EmptyBorder(1, 1, 1, 1));
			}
		});
		panel_Other.setBackground(Color.WHITE);
		panel_Other.setBounds(1090, 457, 45, 44);
		panel_GenaralFunction.add(panel_Other);

		JLabel lblNewLabel_4_6_1 = new JLabel("Other");
		lblNewLabel_4_6_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_6_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_6_1.setBounds(780, 457, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_6_1);

	}
	
	public void TransferMoney(String t, Customer ctm, double money, String pIN) {
		boolean flag = false;
		for (Customer cs : list.getList()) {
			if (cs.getPIN().equalsIgnoreCase(txtPinOfReceiver.getText())) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			JOptionPane.showMessageDialog(null, "Incorrect PIN", "Alert", 2);
			txtPinOfReceiver.requestFocus();
		}
		else {
			int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to transfer " + t + " VND to " + pIN, "Message", JOptionPane.YES_NO_OPTION);
			if (click == JOptionPane.YES_OPTION) {
				if(ctm.getBalance() < money)
					JOptionPane.showMessageDialog(null, "Please check your balance or choose another amount of money", "Error", 2);
				else {
					for(Customer cs: list.getList()) {
						if(cs.getPIN().equalsIgnoreCase(pIN)) {
							cs.Deposit(money);
						}
						else if(cs.getPIN().equalsIgnoreCase(ctm.getPIN())) {
							ctm.Withdraw(money);
							cs.Withdraw(money);
						}
					}
					String month = String.valueOf(date.now().getMonth()).substring(0, 2);
					String time = month + "-" + date.now().getDayOfMonth() + "-" + date.now().getYear();
					Exchange ex = new Exchange(time,"Transfer", money, pIN);
					exh.addEvent(ex);
					try {
						dataBase.writeEvent("src/question1/" + ctm.getPIN() +".txt", exh);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						dataBase.writeCustomer("src/question1/customer.txt", list);
					} catch (Exception e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Successfully transfer", "Message", 1);
					txtPinOfReceiver.setText("");
				}
			}
			
		}
	}
}
