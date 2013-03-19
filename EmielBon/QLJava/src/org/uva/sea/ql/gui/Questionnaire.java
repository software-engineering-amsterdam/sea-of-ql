package org.uva.sea.ql.gui;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.typechecker.TypeChecker;

public class Questionnaire extends JFrame {

	private static final long serialVersionUID = 4400094493031598350L;
	private Form form;
	
	public static void main(String[] args) throws ParseError, IOException {
		new Questionnaire("test.ql");
	}
	
	public Questionnaire(String qlSourcePath) throws ParseError, IOException {
		form = QLFileReader.read(qlSourcePath);
		TypeChecker.check(form);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		render();
	}
	
	public void render() {
		State state = new State();
		JPanel formPanel = Renderer.render(form, state);
		getContentPane().setLayout(new MigLayout("insets 10"));
		getContentPane().add(formPanel);
		pack();
		setVisible(true);
	}
	
}
