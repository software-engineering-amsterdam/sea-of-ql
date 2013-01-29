package org.uva.sea.ql.driver;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class QLDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5869298083469486262L;
	private JButton btnNewButton;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDriver frame = new QLDriver();
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
	public QLDriver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		getContentPane().setLayout(null);

		JTextPane txtpnFormNameofForm = new JTextPane();
		txtpnFormNameofForm.setBounds(16, 15, 390, 219);
		txtpnFormNameofForm
				.setText("form Name_of_form { \r\n\r\n\tdoit: \"Do it to me baby....\" boolean\r\n\r\n}");
		getContentPane().add(txtpnFormNameofForm);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(16, 239, 390, 236);
		textPane.setText("form Name_of_form { \r\n\r\n\tdoit: \"Do it to me baby....\" boolean\r\n\r\n}");
		getContentPane().add(textPane);

		btnNewButton = new JButton("Compile");
		btnNewButton.setBounds(16, 501, 96, 29);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(118, 504, 26, 23);
		chckbxNewCheckBox.addActionListener(this);
		getContentPane().add(chckbxNewCheckBox);

		textField = new JTextField();
		textField.setBounds(275, 501, 103, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 486, 271, 16);
		getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			btnNewButton.setText("pushed");
		}
		if (e.getSource() == chckbxNewCheckBox) {
			btnNewButton.setText("check");
		}
	}
}