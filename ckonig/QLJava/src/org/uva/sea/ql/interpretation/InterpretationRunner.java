package org.uva.sea.ql.interpretation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.interpretation.swing.QLFileFilter;
import org.uva.sea.ql.interpretation.swing.SwingHelper;

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
	private Expr ast;
	private SwingHelper helper;

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
				generate();
			}
		});
	}
	private void generate(){
		helper.generateHtml();
	}
	private void openFile() {
		int returnVal = fileChooser.showOpenDialog(InterpretationRunner.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			helper = new SwingHelper(ast, log, buttonGenerate, centerPanel);
			helper.openFile(file);

		}
	}	
}
