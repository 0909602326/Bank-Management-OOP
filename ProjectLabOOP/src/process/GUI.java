package process;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.SwingConstants;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel btnCustomer;
	private JPanel btnAdmin;
	private LoginForm lgf;
	private RegisterForm rgf;
	private boolean flag_admin = true;
	private boolean flag_customer = true;
	private JFrame GUI = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/Bank-icon-program.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 769);
		contentPane = new MotionPanel(this);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Background
		// Background
		JPanel Background = new JPanel();
		Background.setBounds(268, 126, 980, 643);
		contentPane.add(Background);
		Background.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(217, 103, 562, 388);
		panel.setVisible(false);
		Background.add(panel);

//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(184, 47, 625, 541);
//		Background.add(panel_1);
//		panel_1.setVisible(false);

		// Background Image
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 980, 643);
		Background.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon(GUI.class.getResource("/images/Background_1.png")));

		// Title_bar
		JPanel Title_bar = new JPanel();
		Title_bar.setBackground(new Color(68, 108, 179));
		Title_bar.setBounds(0, 0, 1152, 24);
		contentPane.add(Title_bar);
		Title_bar.setLayout(null);

		// Icon
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 24, 25);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/images/Bank-icon.png")));
		Title_bar.add(lblNewLabel);

		// Close
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 48, 24);
		lblNewLabel_2.setForeground(Color.WHITE);

		JPanel Exit = new JPanel();
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int click = JOptionPane.showConfirmDialog(null, "Do you want to close the program?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION)
					System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Exit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Exit.setBackground(new Color(68, 108, 179));
			}
		});
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.setBackground(new Color(68, 108, 179));
		Exit.setBounds(1200, 0, 48, 24);
		contentPane.add(Exit);
		Exit.setLayout(null);
		Exit.add(lblNewLabel_2);

		// Minimize
		JPanel Minimize = new JPanel();
		Minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Minimize.setBackground(new Color(191, 191, 191));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Minimize.setBackground(new Color(68, 108, 179));
			}
		});
		Minimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Minimize.setBackground(new Color(68, 108, 179));
		Minimize.setBounds(1152, 0, 48, 24);
		contentPane.add(Minimize);
		Minimize.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 48, 24);
		Minimize.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(218, 223, 225));
		panel_2.setBounds(0, 24, 269, 745);
		// panel_2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 729, 269, 16);
		panel_4.setBackground(Color.GRAY);
		panel_2.add(panel_4);

		btnCustomer = new JPanel();
		btnCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCustomer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (flag_customer == true) {
					btnCustomer.setBackground(new Color(218, 223, 225).brighter());
					btnAdmin.setBackground(new Color(218, 223, 225));
					lgf = new LoginForm(panel, "customer", GUI);
					panel.removeAll();
					panel.setBounds(217, 103, 562, 388);
					panel.setLayout(new BorderLayout());
					panel.add(lgf, BorderLayout.CENTER);
					panel.setVisible(true);
					panel.validate();
					flag_customer = false;
					flag_admin = true;
					if (lgf.getFlag()) {
						lgf.setFlag(false);
						dispose();
					}
				}
			}
		});
		btnCustomer.setBackground(new Color(218, 223, 225));
		btnCustomer.setBounds(47, 79, 171, 192);
		panel_2.add(btnCustomer);
		btnCustomer.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 171, 158);
		btnCustomer.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(GUI.class.getResource("/images/Customer-icon.png")));
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblNewLabel_4 = new JLabel("Customer");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(0, 158, 171, 24);
		btnCustomer.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));

		// btnAdmin
		btnAdmin = new JPanel();
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (flag_admin == true) {
					btnAdmin.setBackground(new Color(218, 223, 225).brighter());
					btnCustomer.setBackground(new Color(218, 223, 225));
					lgf = new LoginForm(panel, "administrator", GUI);
					panel.removeAll();
					panel.setBounds(217, 103, 562, 388);
					panel.setLayout(new BorderLayout());
					panel.add(lgf, BorderLayout.CENTER);
					panel.setVisible(true);
					panel.validate();
					flag_admin = false;
					flag_customer = true;
//					if(lgf.getFlag()) {
//						lgf.setFlag(false);
//						dispose();
//					}
				}
			}
		});
		btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdmin.setBackground(new Color(218, 223, 225));
		btnAdmin.setBounds(48, 352, 171, 202);
		panel_2.add(btnAdmin);
		btnAdmin.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(0, 0, 171, 158);
		btnAdmin.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3_1.setIcon(new ImageIcon(GUI.class.getResource("/images/Administrator-2-icon.png")));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblNewLabel_5 = new JLabel("Administrator");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(0, 168, 171, 24);
		btnAdmin.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel lblNewLabel_8 = new JLabel("ATM Management System");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("YouYuan", Font.PLAIN, 23));
		lblNewLabel_8.setBounds(34, 0, 269, 24);
		Title_bar.add(lblNewLabel_8);

		// Title
		JPanel Title = new JPanel();
		Title.setBackground(Color.WHITE);
		// Title.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		Title.setBounds(268, 24, 980, 103);
		contentPane.add(Title);
		Title.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(GUI.class.getResource("/images/Title.jpg")));
		lblNewLabel_7.setForeground(Color.GREEN);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 45));
		lblNewLabel_7.setBounds(0, 0, 980, 103);
		Title.add(lblNewLabel_7);

		setLocationRelativeTo(null);
	}
}
