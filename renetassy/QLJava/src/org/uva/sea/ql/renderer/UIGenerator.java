package org.uva.sea.ql.renderer;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.antlr.runtime.ANTLRFileStream;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checkers.StatementChecker;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.errors.QLError;
import org.uva.sea.ql.output.SaveButtonListener;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class UIGenerator {
	
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
	
	
	public static void main(String[] args) throws ParseError, IOException {
		
		new UIGenerator();
	}
	
	public UIGenerator() throws ParseError, IOException {
		
		errors = new ArrayList<QLError>();
		
		typeEnvironment = new HashMap<String, Type>();
		
		File file = new File("src/org/uva/sea/ql/test/pdfSample.ql");
		System.out.println(file.getAbsolutePath());
		///src/org/uva/sea/ql/test
		//String filePath = "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/test/pdfSample.ql";
		
		ANTLRFileStream fileReader = new ANTLRFileStream(file.getAbsolutePath());
		
		//String fileContent = fileReader.getContent();
		
		ast = parser.parseForm(fileReader.toString());
		
		checker = new StatementChecker(typeEnvironment, errors);
		
		boolean typeChecking = StatementChecker.check(ast, typeEnvironment, errors);
			
		if (typeChecking) {
			
			state = new State();
			renderer = new Renderer(state);
			
			ast.accept(renderer);
			
			frame = new JFrame(ast.getID().getName());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
			frame.setVisible(true);
			
			JButton button = new JButton("Save");
			button.addActionListener(new SaveButtonListener(renderer));
			renderer.getPanel().add(button);
			
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
	
}
