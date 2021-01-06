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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class CustomerProcess extends JFrame {

	private Customer customer;
	public void setCustomer(Customer x) {
		this.customer = x;
	}

	private JPanel contentPane;
	private JPanel childPanel;
	private JPanel panel_General;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerProcess frame = new CustomerProcess();
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
	public CustomerProcess() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerProcess.class.getResource("/images/Bank-icon-program.png")));
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 769);
		contentPane = new MotionPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//border
		Border option_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE);
		
		// Title_bar
		JPanel Title_bar = new JPanel();
		Title_bar.setBackground(new Color(68, 108, 179));
		Title_bar.setBounds(0, 0, 1152, 24);
		contentPane.add(Title_bar);
		Title_bar.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("ATM User");
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
				int click = JOptionPane.showConfirmDialog(null, "Do you want to close the program?", "Alert", JOptionPane.YES_NO_OPTION);
				if(click == JOptionPane.YES_OPTION)
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
		
		panel_General = new JPanel();
		panel_General.setBounds(0, 24, 1248, 745);
		contentPane.add(panel_General);
		panel_General.setLayout(new BorderLayout());
		
		
		setLocationRelativeTo(null);
	}
	public void addGeneral() {
		General gnr = new General(panel_General, this, customer);
		panel_General.add(gnr, BorderLayout.CENTER);
	}
}
