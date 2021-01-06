package process;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Management extends JPanel {

	/**
	 * Create the panel.
	 */
	public Management(String x) {
		setBounds(268, 24, 980, 745);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 980, 130);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(0, 130, 980, 614);
		add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Admin");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(24, 16, 69, 25);
		
		JPanel panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBackground(UIManager.getColor("Button.light"));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.removeAll();
				Manage_Admin mna = new Manage_Admin(x);
				panel_1.add(mna);
				panel_1.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(Color.WHITE);
				lblNewLabel_1_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(UIManager.getColor("Button.light"));
				lblNewLabel_1_1.setBorder(null);
			}
		});
		panel_2.setBounds(86, 70, 115, 60);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 16, 95, 25);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2_1.setBackground(UIManager.getColor("Button.light"));
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.removeAll();
				Manage_Customer mnc = new Manage_Customer();
				panel_1.add(mnc);
				panel_1.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1.setBackground(Color.WHITE);
				lblNewLabel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1.setBackground(UIManager.getColor("Button.light"));
				lblNewLabel_1.setBorder(null);
			}
		});
		panel_2_1.setBounds(259, 70, 115, 60);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.add(lblNewLabel_1);
		

	}

}
