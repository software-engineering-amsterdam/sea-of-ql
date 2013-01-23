package org.uva.sea.ql.driver;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JButton;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5869298083469486262L;
	private JButton btnNewButton;

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
		setBounds(100, 100, 505, 718);

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
		txtpnFormNameofForm
				.setText("form Name_of_form { \r\n\r\n\tdoit: \"Do it to me baby....\" boolean\r\n\r\n}");
		txtpnFormNameofForm.setBounds(0, 0, 371, 288);
		getContentPane().add(txtpnFormNameofForm);

		JTextPane textPane = new JTextPane();
		textPane.setText("form Name_of_form { \r\n\r\n\tdoit: \"Do it to me baby....\" boolean\r\n\r\n}");
		textPane.setBounds(0, 306, 371, 288);
		getContentPane().add(textPane);

		btnNewButton = new JButton("Compile");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 625, 89, 23);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.equals(btnNewButton)) {
			e.
			btnNewButton.setText("pushed");
		}
		btnNewButton.setText("pushed");
	}
}