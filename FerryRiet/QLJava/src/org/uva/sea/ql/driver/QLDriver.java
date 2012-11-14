package org.uva.sea.ql.driver;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.visitor.TypeCheck;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class QLDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5869298083469486262L;
	private JButton btnNewButton;
	private JTextPane txtpnFormNameofForm;
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
		setBounds(100, 100, 480, 355);

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
		txtpnFormNameofForm.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnFormNameofForm.setBounds(16, 15, 438, 219);
		txtpnFormNameofForm
				.setText("form First_Form { \r\n  doit:      \"1   line type boolean ...\" boolean\r\n  do  :      \"2    line type money.\" money\r\n  again:   \"3    line type integer\" integer\r\n  again2: \"4    line type boolean\" boolean\r\n   if ( again2 ) {\r\n            tomorow: \"5 conditional money\" money( do + again )  \r\n   }\r\n    if ( doit ) {\r\n          if ( doit == again2 ) {\r\n               tonight: \"6 double conditional money \" money\n\r\n          }\r\n    }\r\n}");
		getContentPane().add(txtpnFormNameofForm);

		btnNewButton = new JButton("Run");
		btnNewButton.setBounds(16, 246, 96, 29);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 245, 260, 30);
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[18px][][][][][][grow]", "[14px]"));
		
		JLabel lblEee = new JLabel("eee");
		panel.add(lblEee, "cell 0 0,alignx left,aligny top");
		
		textField = new JTextField();
		panel.add(textField, "cell 5 0 2 1,growx");
		textField.setColumns(10);
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

					TypeCheck typeCheck = new TypeCheck();
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