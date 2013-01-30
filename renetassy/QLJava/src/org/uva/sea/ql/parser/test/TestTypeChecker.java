package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTVisitor;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestTypeChecker {

	private ANTLRParser parser;
	private Map<String,Type> typeEnvironment;
	private List<String> errors;
	private ASTVisitor typeChecker;

	public TestTypeChecker() {
		
		parser = new ANTLRParser();
		errors = new ArrayList<String>();
		typeEnvironment = new HashMap<String, Type> ();
		typeChecker = new ASTVisitor(typeEnvironment,errors);

	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		
		assertEquals(Form.class, typeChecker.check(parser.parse("5 + 6 && 8"),typeEnvironment, errors));
		
		for (String error : typeChecker.getErrors()){
			System.out.println(error);
		}
	}
	
	
	
}