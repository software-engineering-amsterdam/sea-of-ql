package org.uva.sea.ql.renderer;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.uva.sea.ql.StatementChecker;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.errors.QLError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.QLFileReader;

public class UIGenerator {
	
	private Form ast;
	
	private ANTLRParser parser = new ANTLRParser();
	private Map<String,Type> typeEnvironment;
	private List<QLError> errors;
	private Renderer renderer;
	private State state;
	private StatementChecker checker;
	
	private QLFileReader fileReader;
	
	private JFrame frame;

	final int FRAME_WIDTH = 500;
	final int FRAME_HEIGHT = 500;
	
	
	public static void main(String[] args) throws ParseError, IOException {
		
		new UIGenerator();

	}
	
	public UIGenerator() throws ParseError, IOException {
		
		errors = new ArrayList<QLError>();
		
		typeEnvironment = new HashMap<String, Type>();
		
		String filePath = "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/test/pdfSample.ql";
		
		fileReader = new QLFileReader(filePath);
		
		String fileContent = fileReader.getContent();
		
		ast = parser.parseForm(fileContent);
		
		checker = new StatementChecker(typeEnvironment, errors);
		
		boolean typeChecking = StatementChecker.check(ast, typeEnvironment, errors);
			
		if (typeChecking) {
			
			state = new State();
			
			renderer = new Renderer(state);
			
			ast.accept(renderer);
			
			frame = new JFrame(ast.getID().getName());
			
			configureFrame(frame);
			
			frame.setContentPane(renderer.getPanel());
		}
		else {
			errors = checker.getErrors();
			printErrors();
		}
	}
	
	private void printErrors() {
		
		for (QLError error : errors) {
			System.out.println(error.getMessage());
		}
	}
	
	private void configureFrame(JFrame frame) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setVisible(true);
		
	}
}
