package process;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Deposit extends JPanel {
	private ExchangeHistory exh;
	private ListOfCustomer list;
	private DataBase dataBase;
	private LocalDate date;
	/**
	 * Create the panel.
	 */
	public Deposit(JPanel ex_panel, JFrame frame, Customer ctm) {
		list = new ListOfCustomer();
		exh = new ExchangeHistory();
		dataBase = new DataBase();
		String path = "src/question1/" + ctm.getPIN() + ".txt";
		try {
			exh = dataBase.readHistory(path);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			list = dataBase.readCustomer("src/question1/customer.txt");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setBounds(0, 24, 1248, 745);
		setLayout(null);
		
		JPanel panel_GeneralTitle = new JPanel();
		panel_GeneralTitle.setBackground(new Color(129, 207, 224));
		panel_GeneralTitle.setLayout(null);
		panel_GeneralTitle.setBounds(0, 0, 1248, 198);
		add(panel_GeneralTitle);
		
		JLabel lblNewLabel_3 = new JLabel("DEPOSIT MONEY");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_3.setBounds(267, 63, 656, 93);
		panel_GeneralTitle.add(lblNewLabel_3);
		
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
		
		JPanel panel_50k = new JPanel();
		panel_50k.setLayout(new BorderLayout());
		panel_50k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_50k.setBorder(new EmptyBorder(1,1,1,1));
				panel_50k.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("50,000", ctm, 50000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_50k.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_50k.removeAll();
				panel_50k.validate();
				panel_50k.setBorder(null);
			}
		});
		panel_50k.setBackground(Color.WHITE);
		panel_50k.setBounds(101, 141, 45, 44);
		panel_GenaralFunction.add(panel_50k);

		
		JPanel panel_100k = new JPanel();
		panel_100k.setLayout(new BorderLayout());
		panel_100k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_100k.setBorder(new EmptyBorder(1,1,1,1));
				panel_100k.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("100,000", ctm, 100000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_100k.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_100k.removeAll();
				panel_100k.validate();
				panel_100k.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		panel_100k.setBackground(Color.WHITE);
		panel_100k.setBounds(101, 257, 45, 44);
		panel_GenaralFunction.add(panel_100k);

		
		JPanel panel_200k = new JPanel();
		panel_200k.setLayout(new BorderLayout());
		panel_200k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_200k.setBorder(new EmptyBorder(1,1,1,1));
				panel_200k.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("200,000", ctm, 200000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_200k.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_200k.removeAll();
				panel_200k.validate();
				panel_200k.setBorder(null);
			}
		});
		panel_200k.setBackground(Color.WHITE);
		panel_200k.setBounds(101, 362, 45, 44);
		panel_GenaralFunction.add(panel_200k);

		
		JPanel panel_500k = new JPanel();
		panel_500k.setLayout(new BorderLayout());
		panel_500k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_500k.setBorder(new EmptyBorder(1,1,1,1));
				panel_500k.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("500,000", ctm, 500000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_500k.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_500k.removeAll();
				panel_500k.validate();
				panel_500k.setBorder(null);
			}
		});
		panel_500k.setBackground(Color.WHITE);
		panel_500k.setBounds(1090, 141, 45, 44);
		panel_GenaralFunction.add(panel_500k);
	
		
		JPanel panel_1tr = new JPanel();
		panel_1tr.setLayout(new BorderLayout());
		panel_1tr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1tr.setBorder(new EmptyBorder(1,1,1,1));
				panel_1tr.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("1,000,000", ctm, 1000000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1tr.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1tr.removeAll();
				panel_1tr.validate();
				panel_1tr.setBorder(null);
			}
		});
		panel_1tr.setBackground(Color.WHITE);
		panel_1tr.setBounds(1090, 257, 45, 44);
		panel_GenaralFunction.add(panel_1tr);

		
		JPanel panel_2tr = new JPanel();
		panel_2tr.setLayout(new BorderLayout());
		panel_2tr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2tr.setBorder(new EmptyBorder(1,1,1,1));
				panel_2tr.add(lblCheck,BorderLayout.CENTER);
				lblCheck.setVisible(true);
				DepositMoney("2,000,000", ctm, 2000000);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2tr.setBorder(BorderFactory.createMatteBorder(1, 1,1, 1, Color.BLUE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2tr.removeAll();
				panel_2tr.validate();
				panel_2tr.setBorder(null);
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
		
		JPanel panel_Back = new JPanel();
		panel_Back.setLayout(new BorderLayout());
		panel_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Back.setBorder(new EmptyBorder(1,1,1,1));
				panel_Back.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to choose another function ?", "Alert", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					General gnr = new General(ex_panel, frame, ctm);
					ex_panel.removeAll();
					ex_panel.add(gnr, BorderLayout.CENTER);
					ex_panel.validate();
				}
				else {
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
				panel_Back.setBorder(new EmptyBorder(1,1,1,1));
			}
		});
		panel_Back.setBackground(Color.WHITE);
		panel_Back.setBounds(101, 457, 45, 44);
		panel_GenaralFunction.add(panel_Back);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("200,000");
		lblNewLabel_4_2_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_2_1.setBounds(179, 362, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_2_1);
		
		JPanel panel_Other = new JPanel();
		panel_Other.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Other.setBorder(new EmptyBorder(1,1,1,1));
				panel_Other.add(lblCheck, BorderLayout.CENTER);
				lblCheck.setVisible(true);
				String m = JOptionPane.showInputDialog(null, "Enter amount of money", "Message", JOptionPane.INFORMATION_MESSAGE);
				if (m != null) {
					if (m.equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "You must enter amount of money", "Error", 2);
					else if (!m.equalsIgnoreCase("")) {
						DepositMoney(m,ctm,Double.parseDouble(m));
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
				panel_Other.setBorder(null);
			}
		});
		panel_Other.setLayout(null);
		panel_Other.setBackground(Color.WHITE);
		panel_Other.setBounds(1090, 457, 45, 44);
		panel_GenaralFunction.add(panel_Other);
		
		JLabel lblNewLabel_4_6_1 = new JLabel("Other");
		lblNewLabel_4_6_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_6_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 40));
		lblNewLabel_4_6_1.setBounds(780, 457, 278, 44);
		panel_GenaralFunction.add(lblNewLabel_4_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Deposit.class.getResource("/images/Finance-Cash-Receiving-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel_1.setBounds(413, 10, 463, 441);
		lblNewLabel_1.setBounds(393, 49, 463, 441);
		panel_GenaralFunction.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("PIN of Receiver");
		lblNewLabel.setForeground(new Color(153, 153, 153));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 27));
		lblNewLabel.setBounds(362, 33, 207, 71);
	}
	
	private void DepositMoney(String t, Customer ctm, double money) {
		int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to deposit " + t + " VND?", "Message", JOptionPane.YES_NO_OPTION);
		if(click == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Successfully Deposit", "Message", 1);
			for(Customer cs : list.getList()) {
				if(cs.getPIN().equalsIgnoreCase(ctm.getPIN())) {
					ctm.Deposit(money);
					cs.Deposit(money);
				}
			}
			String month = String.valueOf(date.now().getMonth()).substring(0, 2);
			String time = month + "-" + date.now().getDayOfMonth() + "-" + date.now().getYear();
			Exchange ex = new Exchange(time,"Deposit", money, "0");
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
		}
	}
}
