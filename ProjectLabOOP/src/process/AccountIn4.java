package process;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class AccountIn4 extends JFrame {

	private JPanel contentPane;
	private ExchangeHistory exh;
	private DataBase dataBase;
	private JTable table;
	private Customer ctm;
	private DefaultTableModel tableModel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountIn4 frame = new AccountIn4();
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
	public AccountIn4() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccountIn4.class.getResource("/images/Bank-icon-program.png")));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				dispose();
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 431);
		contentPane = new MotionPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title_bar
				JPanel Title_bar = new JPanel();
				Title_bar.setBackground(new Color(68, 108, 179));
				Title_bar.setBounds(0, 0, 486, 24);
				contentPane.add(Title_bar);
				Title_bar.setLayout(null);
				
				JLabel lblNewLabel_8 = new JLabel("Account Information");
				lblNewLabel_8.setForeground(Color.WHITE);
				lblNewLabel_8.setFont(new Font("YouYuan", Font.PLAIN, 20));
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
				lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 17));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(0, 0, 48, 24);
				lblNewLabel_2.setForeground(Color.WHITE);

				JPanel Exit = new JPanel();
				Exit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
							dispose();
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
				Exit.setBounds(485, 0, 48, 24);
				contentPane.add(Exit);
				Exit.setLayout(null);
				Exit.add(lblNewLabel_2);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 116, 513, 305);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Date", "Category", "Money", "Receiver"
					}
				));
				scrollPane.setViewportView(table);
				tableModel = (DefaultTableModel) table.getModel();
				
				JPanel panel = new JPanel();
				panel.setBounds(10, 41, 513, 65);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Exchange");
				lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 28));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(25, 10, 467, 45);
				panel.add(lblNewLabel_1);
	}
	
	public void setCtm(Customer ctm) {
		this.ctm = ctm;
	}
	
	public void loadDataToTable() {
		exh = new ExchangeHistory();
		dataBase = new DataBase();
		String path = "src/question1/" + ctm.getPIN() + ".txt";
		try {
			exh = dataBase.readHistory(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableModel.setRowCount(0);
		for (Exchange ex :	exh.getList()) {
			if(!ex.getReceiver().equalsIgnoreCase("0"))
				tableModel.addRow(new Object[] { ex.getDate(), ex.getCategory(), ex.getMoney(), ex.getReceiver()});
			else
				tableModel.addRow(new Object[] { ex.getDate(), ex.getCategory(), ex.getMoney(), null});
		}
	}
}
