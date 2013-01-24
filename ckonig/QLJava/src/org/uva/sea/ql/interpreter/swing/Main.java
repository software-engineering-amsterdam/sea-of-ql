package org.uva.sea.ql.interpreter.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.interpreter.IOHelper;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;
import org.uva.sea.ql.visitor.VisitorException;

public class Main extends JFrame {
	private static final long serialVersionUID = -1942492887122279651L;
	private JButton buttonFile;
	private JLabel display;
	private JLabel error;
	final JFileChooser fileChooser;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private String fileContent;
	private Expr ast;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super("QL Interpreter");
		createComponents();
		setLayout();
		addOpenFileListener(buttonFile);
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new QLFileFilter());
		pack();
		setVisible(true);
	}

	private void createComponents() {
		buttonFile = new JButton("Open File");
		bottomPanel = new JPanel();
		topPanel = new JPanel();
		display = new JLabel();
		error = new JLabel();
		centerPanel = new JPanel();
		topPanel.add(buttonFile);
		bottomPanel.add(error);
		topPanel.add(display);
	}

	private void setLayout() {
		setLocation(300, 300);
		setSize(300, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(topPanel, BorderLayout.PAGE_START);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.PAGE_END);
		topPanel.setAlignmentX(LEFT_ALIGNMENT);
	}

	private void addOpenFileListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				openFile();
			}
		});
	}

	private void openFile() {
		error.setText("");
		int returnVal = fileChooser.showOpenDialog(Main.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				fileContent = IOHelper.read(file);
				display.setText(fileContent);
				parseFile();
			} catch (IOException ex) {
				error.setText("error reading file");
			}

		}
	}

	private void parseFile() {
		if (fileContent != null) {
			IParse p = new ANTLRParser();
			try {
				ast = p.parseDefaultFile();
				display.setText("parsed successfully");
				validateAst();
			} catch (ParseError e) {
				error.setText(e.getMessage());
			}
		}
	}

	private void validateAst() {
		error.setText("");
		Validator v = new Validator();
		display.setText("Validation successfull");
		try {
			v.validate(ast);
			interpretAst();
		} catch (AstValidationError ex) {
			error.setText(ex.getMessage());
		} catch (IOException e1) {
			error.setText(e1.getMessage());
		}
	}

	private void interpretAst() {
		error.setText("");
		SwingVisitor visitor = new SwingVisitor();
		if (ast != null && ast instanceof Form) {
			try {
				((Form) ast).accept(visitor);
				JPanel result = visitor.getPanel();
				centerPanel.add(result);
				result.setVisible(true);
				centerPanel.repaint();
				display.setText("interpretation finished");
			} catch (VisitorException ex) {
				error.setText(ex.getMessage());
			}

		} else {
			error.setText("AST INVALID");
		}
	}
}
