package org.uva.sea.ql.interpreter;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.typechecker.CheckStatement;
import org.uva.sea.ql.typechecker.Message;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class Questionnaire extends JFrame {

	private static final long serialVersionUID = 4400094493031598350L;
	
	private IParse parser;
	Form form;
	String source;
	
	public static void main(String[] args) throws ParseError {
		new Questionnaire();
	}
	
	public Questionnaire() throws ParseError {
		
		parser = new JACCParser();
		source = "form a { \n" +
				 "	hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n" +
				 "	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
				 "	if (hasSoldHouse) {\n" +
				 "		sellingPrice: \"Price the house was sold for:\" integer\n" +
				 "	}\n" +
				 "}";
		
		form = (Form) parser.parse(source);
		CheckStatement.check(form, new TypeEnvironment(), new ArrayList<Message>());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		render();
		setVisible(true);
	}
	
	public void render() {
		
		State state = new State();
		JPanel formPanel = Renderer.render(form, state);
		getContentPane().add(formPanel, BorderLayout.CENTER);
		pack();
	}
	
}
