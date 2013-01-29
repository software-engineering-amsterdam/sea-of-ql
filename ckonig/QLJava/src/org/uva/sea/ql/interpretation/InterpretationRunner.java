package org.uva.sea.ql.interpretation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.interpretation.swing.QLFileFilter;
import org.uva.sea.ql.interpretation.swing.SwingDocument;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

public class InterpretationRunner extends JFrame {
	private static final long serialVersionUID = -1942492887122279651L;
	private JButton buttonOpenFile;
	private JButton buttonGenerate;
	final JFileChooser fileChooser;
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JTextArea log;
	private String fileContent;
	private Expr ast;

	public static void main(String[] args) {
		new InterpretationRunner();
	}

	public InterpretationRunner() {
		super("QL Interpreter");
		createComponents();
		setLayout();
		addOpenFileListener(buttonOpenFile);
		addGenerateListener(buttonGenerate);
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new QLFileFilter());
		setSize(800, 600);
		setVisible(true);
	}

	private void createComponents() {
		buttonOpenFile = new JButton("Open File");
		buttonGenerate = new JButton("Generate HTML");
		buttonGenerate.setEnabled(false);
		bottomPanel = new JPanel();
		topPanel = new JPanel();
		leftPanel = new JPanel();
		centerPanel = new JPanel();
		log = new JTextArea();
		leftPanel.add(log);
		leftPanel.setBackground(Color.red);
		topPanel.setSize(800, 200);
		centerPanel.setBackground(Color.green);
		centerPanel.setSize(500, 400);
		bottomPanel.setSize(800, 200);
		leftPanel.setSize(300, 400);
		log.setSize(300, 600);
		log.setText("");
		topPanel.add(buttonOpenFile);
		topPanel.add(buttonGenerate);
	}

	private void setLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		addToContentPane(0, 0, 2, topPanel, c);
		addToContentPane(0, 1, 1, leftPanel, c);
		addToContentPane(1, 1, 1, centerPanel, c);
		addToContentPane(0, 2, 2, bottomPanel, c);

	}

	private void addToContentPane(int x, int y, int gridwidth, JPanel p,
			GridBagConstraints c) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridy = y;
		c.gridwidth = gridwidth;
		getContentPane().add(p, c);
	}

	private void addOpenFileListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				openFile();
			}
		});
	}

	private void addGenerateListener(JButton b) {
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateHtml();
			}
		});
	}

	private void openFile() {
		int returnVal = fileChooser.showOpenDialog(InterpretationRunner.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				fileContent = IOHelper.read(file);
				log.append("file opened\n");
				parseFile();
			} catch (IOException ex) {
				log.setCaretColor(Color.red);
				log.append("error reading file");
			}

		}
	}

	private void parseFile() {
		if (fileContent != null) {
			IParse p = new ANTLRParser();
			try {
				ast = p.parseDefaultFile();
				log.append("File parsed\n");
				validateAst();
			} catch (ParseError e) {
				log.append(e.getMessage());
			}
		}
	}

	private void validateAst() {
		Validator v = new Validator();
		try {
			v.validate(ast);
			log.append("AST validated\n");
			interpretAst();
			buttonGenerate.setEnabled(true);
		} catch (AstValidationError ex) {
			log.setCaretColor(Color.red);
			log.append(ex.getMessage() + "\n");
		} catch (IOException e1) {
			log.setCaretColor(Color.red);
			log.append(e1.getMessage() + "\n");
		}
	}

	private void interpretAst() {
		VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
				new SwingDocument());
		if (ast != null && ast instanceof Form) {
			try {
				((Form) ast).accept(visitor);
				JPanel result = (JPanel) visitor.getOutput();
				centerPanel.add(result);
				result.setVisible(true);
				centerPanel.repaint();
				log.append("interpretation finished\n");
			} catch (VisitorException ex) {
				log.setCaretColor(Color.red);
				log.append(ex.getMessage() + "\n");
			}

		} else {
			log.append("AST INVALID\n");
		}
	}

	private void generateHtml() {

		if (ast != null && ast instanceof Form) {
			try {
				VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
						new HTMLDocument());
				Form f = (Form) ast;
				f.accept(visitor);
				String output = (String) visitor.getOutput();
				IOHelper.write(IOHelper.OUT_PATH + f.getName() + ".html",
						output);
				log.append(IOHelper.OUT_PATH + f.getName() + " created\n");
			} catch (VisitorException ex) {
				log.append(ex.getMessage());
			} catch (FileNotFoundException ex) {
				log.append(ex.getMessage());
			}
		} else {
			log.append("invalid AST\n");
		}

	}
}
