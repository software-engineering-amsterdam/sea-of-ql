package org.uva.sea.ql;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.ParseError;

public class Generator {
	
	private Form ast;
	
	private ANTLRParser parser = new ANTLRParser();
	private Map<String,Type> typeEnvironment;
	private List<QLError> errors;
	
	private JFrame frame;

	final int FRAME_WIDTH = 500;
	final int FRAME_HEIGHT = 500;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Generator();

	}
	
	public Generator() {
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		frame.setVisible(true);
		
		errors = new ArrayList<QLError>();
		typeEnvironment = new HashMap<String, Type> ();
		
		try {
			
			ast = parser.parseForm("form arxigos { question1 : \"inta fasi?\" int" +
					" question2 : \"ti fasi?\" bool  }");
			
			StatementChecker.check(ast, typeEnvironment, errors);
			
			frame.getContentPane().add(Renderer.render(ast));
			
		} catch (ParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//frame.pack();
		frame.setVisible(true);
		
	}

}
