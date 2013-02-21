package org.uva.sea.ql.renderer;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.uva.sea.ql.QLError;
import org.uva.sea.ql.StatementChecker;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.ParseError;

public class GUIGenerator {
	
	private Form ast;
	
	private ANTLRParser parser = new ANTLRParser();
	private Map<String,Type> typeEnvironment;
	private List<QLError> errors;
	private Renderer renderer;
	private State state;
	private StatementChecker checker;
	
	private JFrame frame;

	final int FRAME_WIDTH = 500;
	final int FRAME_HEIGHT = 500;
	
	/**
	 * @param args
	 * @throws ParseError 
	 */
	public static void main(String[] args) throws ParseError {
		
		new GUIGenerator();

	}
	
	public GUIGenerator() throws ParseError {
		
		errors = new ArrayList<QLError>();
		
		typeEnvironment = new HashMap<String, Type> ();
		
		state = new State();
		
		renderer = new Renderer(state);
		
		
		ast = parser.parseForm("form arxigos { question1 : \"inta fasi?\" int" +
				" question2 : \"ti fasi?\" bool " +
				" akyri: \" akyri erotisi \" int " +
				" if (question2) { " +
					" 	question5 : \"ante geia\" int " +
					"	question6 : \"youhou \" bool " +
					"	question7 : \"gia na doume\" int (question1+question5) " +
				"	 }" +
				" }");
		
		checker = new StatementChecker(typeEnvironment, errors);
		
		boolean typeChecking = StatementChecker.check(ast, typeEnvironment, errors);
		
		errors = checker.getErrors();
			
		if (typeChecking) {
			
			frame = new JFrame();
			
			ast.accept(renderer);
			
			frame.setContentPane(renderer.getPanel());
			
			configureFrame(frame);
		
		}
		else {
			printErrors();
		}
	}
	
	public void printErrors() {
		
		for (QLError error : errors) {
			System.out.println(error.getMessage());
		}
	}
	
	public void configureFrame(JFrame frame) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setVisible(true);
		//frame.pack();
	}
}
