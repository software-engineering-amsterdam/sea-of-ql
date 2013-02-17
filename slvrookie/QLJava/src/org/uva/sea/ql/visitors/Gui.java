package org.uva.sea.ql.visitors;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Gui extends JFrame {

	private static final long serialVersionUID = 168935475998687670L;
	private final Form ast;
	private final IParse parser = new ANTLRParser();
	private final String path = "src/org/uva/sea/ql/tests/TestQL.ql";
	private final State state = new State();
	private final Errors errors = new Errors();
	private JPanel log = new JPanel(new MigLayout());

	public static void main(String[] args) throws IOException, ParseError {
		new Gui();
	}

	private Gui() throws IOException, ParseError {
		File filePath = new File(path);
		ANTLRFileStream charStream;
		charStream = new ANTLRFileStream(filePath.getAbsolutePath());
		ast = parser.parseForm(charStream.toString());
		setFrame();
		validateAst();
	}

	private void validateAst() {
		ElementChecker.check(ast, state, errors);
		if (errors.isEmpty()) {
			setQuestionPanel();
		} else {
			setErrorPanel();
		}
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout());
		setTitle("QL Interpreter");
		setVisible(true);
	}

	private void setErrorPanel() {
		log.add(new JLabel("The following errors occured when checking for type consistency:"), "wrap");
		for (String error : errors.returnErrors()) {
			log.add(new JLabel(error), "wrap");
			log.setBorder(BorderFactory.createTitledBorder("ERRORS"));
			getContentPane().add(log);
			getContentPane().validate();
			pack();
			getContentPane().repaint();
		}
	}

	public void setQuestionPanel() {
		cleanOldPanels();
		getContentPane().add(Renderer.render(ast, state, this));
		getContentPane().validate();
		pack();
		getContentPane().repaint();
	}

	private void cleanOldPanels() {
		Component[] components = getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			remove(components[i]);
		}
	}

}
