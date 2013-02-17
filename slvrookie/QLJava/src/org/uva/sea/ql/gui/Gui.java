package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.rendering.Renderer;
import org.uva.sea.ql.visitors.typechecking.ElementChecker;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class Gui extends JFrame {

	private static final long serialVersionUID = 168935475998687670L;
	private Form ast;
	private final IParse parser = new ANTLRParser();
	private final State state = new State();
	private final Errors errors = new Errors();
	private JPanel errorlog = new JPanel(new MigLayout());
	private JButton open = new JButton("Open QL");
	private JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));
	private JPanel centerPanel = new JPanel(new MigLayout());
	private final JFileChooser fileChooser = new JFileChooser();

	public static void main(String[] args) throws IOException, ParseError {
		new Gui();
	}

	private Gui() throws IOException, ParseError {
		fileChooser.setFileFilter(new QLFilter());
		addOpenListener(open);
		setInitialFrame();
	}

	private void addOpenListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setQLChooser();
			}
		});
	}

	private void setQLChooser() {
		final int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final File file = fileChooser.getSelectedFile();
			openQLFile(file);
		}
	}

	private void openQLFile(File file) {
		errors.clear();
		state.clearState();
		try {
			ANTLRFileStream charStream = new ANTLRFileStream(file.getAbsolutePath());
			parseFile(charStream);
		} catch (IOException e) {
			errors.addError("The following errors occured while READING the selected file: \n " + e.getMessage());
		}
	}

	private void parseFile(ANTLRFileStream charStream) {
		try {
			ast = parser.parseForm(charStream.toString());
			TypeCheckAst();
		} catch (ParseError e) {
			errors.addError("The following errors occured while PARSING the selected file: \n" + e.getMessage().toString());
		}

	}

	/*
	 * If there are no errors return render the QL
	 * else render the Error Panel
	 */
	
	private void TypeCheckAst() {
		ElementChecker.check(ast, state, errors);
		if (errors.isEmpty()) {
			setQuestionPanel();
		} else {
			setErrorPanel();
		}
	}

	private void setInitialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout());
		setTitle("QL Interpreter");
		setButtonPane();
		pack();
		setVisible(true);
	}

	private void setErrorPanel() {
		setButtonPane();
		for (String error : errors.returnErrors()) {
			errorlog.add(new JLabel(error), "wrap");
			errorlog.setBorder(BorderFactory.createTitledBorder("ERRORS"));
			setButtonPane();
			add(errorlog);
			pack();
			validate();
			repaint();
		}
	}

	public void setQuestionPanel() {
		cleanOldPanels();
		setButtonPane();
		add(centerPanel.add(Renderer.render(ast, state, this)));
		pack();
		centerPanel.validate();
		centerPanel.repaint();
	}

	private void setButtonPane() {
		open.setMnemonic('O');
		buttonPanel.add(open, "split,left,width 100!");
		add(buttonPanel, "wrap");
	}
	
	private void cleanOldPanels() {
		Component[] components = getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			remove(components[i]);
		}
	}

}
