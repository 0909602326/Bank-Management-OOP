package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import java.awt.Toolkit;

public class AdminProcess extends JFrame {
	
	private Admin admin;
	private JPanel contentPane;
	private JTextField txtFullname;
	private JTextField txtPin;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminProcess frame = new AdminProcess();
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
	public AdminProcess() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminProcess.class.getResource("/images/Bank-icon-program.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 769);

		contentPane = new MotionPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Title_bar
		JPanel Title_bar = new JPanel();
		Title_bar.setBackground(new Color(68, 108, 179));
		Title_bar.setBounds(0, 0, 1152, 24);
		contentPane.add(Title_bar);
		Title_bar.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("ATM Management System");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("YouYuan", Font.PLAIN, 23));
		lblNewLabel_8.setBounds(34, 0, 269, 24);
		Title_bar.add(lblNewLabel_8);

		// Icon
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 24, 25);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/images/Bank-icon.png")));
		Title_bar.add(lblNewLabel);

		// Close
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 48, 24);

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

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 24, 269, 745);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AdminProcess.class.getResource("/images/Administrator-2-Big-icon.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(15, 100, 238, 238);
		panel.add(lblNewLabel_3);

		txtFullname = new JTextField();
		txtFullname.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtFullname.setBackground(Color.WHITE);
		txtFullname.setDisabledTextColor(Color.BLACK);
		txtFullname.setEnabled(false);
		txtFullname.setBounds(103, 394, 156, 32);
		panel.add(txtFullname);
		txtFullname.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Fullname");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 394, 83, 32);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("PIN");
		lblNewLabel_4_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(10, 461, 94, 32);
		panel.add(lblNewLabel_4_1);

		txtPin = new JTextField();
		txtPin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtPin.setDisabledTextColor(Color.BLACK);
		txtPin.setBackground(Color.WHITE);
		txtPin.setEnabled(false);
		txtPin.setColumns(10);
		txtPin.setBounds(103, 461, 156, 32);
		panel.add(txtPin);

		JLabel lblNewLabel_6 = new JLabel("Log out");
		lblNewLabel_6.setBounds(6, 77, 60, 20);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JPanel panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int click = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					GUI gui = new GUI();
					gui.setVisible(true);
					dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setBorder(null);
			}
		});
		panel_2.setBounds(89, 544, 70, 100);
		panel_2.add(lblNewLabel_6);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 70, 70);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(AdminProcess.class.getResource("/images/Log-Out-icon.png")));

		panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(268, 24, 980, 745);
		contentPane.add(panel_1);
		setLocationRelativeTo(null);
	}
	
	public void setAdmin(Admin ad) {
		this.admin = ad;
		txtFullname.setText(admin.getFullname());
		txtPin.setText(admin.getPIN());
		Management mnm = new Management(admin.getPIN());
		panel_1.add(mnm, BorderLayout.CENTER);
	}
	
//	public void setIn4() {
//		txtFullname.setText(admin.getFullname());
//		txtPin.setText(admin.getPIN());
//	}
}
