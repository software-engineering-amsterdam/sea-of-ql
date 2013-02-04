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

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.nodevisitor.TypeCheckVisitor;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

public class QLDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5869298083469486262L;
	private JButton btnNewButton;
	private JTextPane txtpnFormNameofForm;

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
		setBounds(100, 100, 480, 328);

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

		txtpnFormNameofForm = new JTextPane();
		txtpnFormNameofForm.setBounds(16, 15, 390, 219);
		txtpnFormNameofForm
				.setText("form First_Form { \r\n\tdoit: \"Give me some java baby....\" boolean\r\n\tif ( doit ) {\n\t\ttonight: \"after dinner \" money\n\t} \r\n}");
		getContentPane().add(txtpnFormNameofForm);

		btnNewButton = new JButton("Run");
		btnNewButton.setBounds(16, 246, 96, 29);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			try {
				ANTLRStringStream stream = new ANTLRStringStream(
						txtpnFormNameofForm.getText());
				CommonTokenStream tokens = new CommonTokenStream();
				tokens.setTokenSource(new QLLexer(stream));
				QLParser parser = new QLParser(tokens);

				QLProgram qlprogram = parser.qlprogram();
				if (parser.getErrorCount() == 0) {

					TypeCheckVisitor typeCheck = new TypeCheckVisitor();
					qlprogram.accept(typeCheck);

					if (typeCheck.getErrorCount() == 0) {
						QLForm frame = new QLForm(qlprogram);
						frame.setVisible(true);
					} else {
						for (String errorString : typeCheck.getErrorList())
							System.out.println(errorString);
					}
				} else {
					for (String errorString : parser.getErrors())
						System.out.println(errorString);
				}
			} catch (Exception be) {
				be.printStackTrace();
			}
		}
	}
}