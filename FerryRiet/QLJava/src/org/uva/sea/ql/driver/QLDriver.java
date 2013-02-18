package org.uva.sea.ql.driver;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.statements.QLProgram;
import org.uva.sea.ql.ast.visitor.QLFormTypeCheck;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.ui.QLForm;

public class QLDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5869298083469486262L;
	private JButton runButton;
	private JTextPane sourcePane;

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
		setBounds(100, 100, 480, 492);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		menu.add(menuItem);
		getContentPane().setLayout(null);

		sourcePane = new JTextPane();
		sourcePane.setFont(new Font("Arial", Font.PLAIN, 12));
		sourcePane.setBounds(10, 0, 444, 382);
		sourcePane
				.setText("form Box1HouseOwning {\n    hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n "
						+ "  hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n "
						+ "  hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n "
						+ "if (hasSoldHouse) {\n     sellingPrice: \"Price the house was sold for:\" money\n "
						+ "privateDebt: \"Private debts for the sold house:\" money\n "
						+ "    valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)\n  "
						+ "   taxOwed: \"Tax payment due, amount:\" money(valueResidue * 0.21 )\n  "
						+ "  }\n   else {\n     happyLiving: \"Do you like your current house?\" boolean    \n   }\n}\n");
		getContentPane().add(sourcePane);

		runButton = new JButton("Run");
		runButton.setBounds(16, 393, 96, 29);
		runButton.addActionListener(this);
		getContentPane().add(runButton);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(211, 412, 10, 10);
		getContentPane().add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == runButton) {
			ANTLRStringStream stream = new ANTLRStringStream(sourcePane.getText());
			CommonTokenStream tokens = new CommonTokenStream();
			tokens.setTokenSource(new QLLexer(stream));
			QLParser parser = new QLParser(tokens);

			try {
				QLProgram qlprogram = parser.qlprogram();

				if (parser.getErrorCount() == 0) {

					QLFormTypeCheck qlFormtypeCheck = new QLFormTypeCheck();
					qlprogram.accept(qlFormtypeCheck);

					if (qlFormtypeCheck.getErrorCount() == 0) {
						// No errors create and show jFrame with nested panels
						QLForm frame = new QLForm(qlprogram);
						frame.setVisible(true);
					} else {
						for (String errorString : qlFormtypeCheck.getErrorList())
							System.out.println(errorString);
					}
				} else {
					for (String errorString : parser.getErrors())
						System.out.println(errorString);
				}
			} catch (RecognitionException e1) {
				// 
				e1.printStackTrace();
			}

		}
	}
}