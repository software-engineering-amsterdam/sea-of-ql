package org.uva.sea.ql;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.test.ParseError;

public class Generator {
	
	private Form ast;
	
	private ANTLRParser parser = new ANTLRParser();
	private ArrayList<QLError> errors;
	private Map<String,Type> typeEnvironment;
	private JFrame frame;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Generator();

	}
	
	public Generator() {
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		
		try {
			
			ast = parser.parseForm("form arxigos { question1 : \"inta fasi?\" int" +
					" question2 : \"ti fasi?\" bool  }");
			
			//StatementChecker.check(ast, typeEnvironment, errors);
			
			//Renderer.render(ast);
			
			
			frame.getContentPane().add(Renderer.render(ast));
			
		} catch (ParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
		//System.out.println(ast.toString());
		
	}

}
