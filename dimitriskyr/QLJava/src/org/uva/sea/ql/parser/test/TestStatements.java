package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatements {
	private final String form = "form ident { name: \"body\" boolean }";
	private final String simplequestion = "bye : \"body\" money ";
	private final String comquestion = "hello : \"body\" integer (43-30)";
	private final String ifBlock="if (expression) {"+simplequestion+""+comquestion+"}";
	private final String elseBlock="else {"+simplequestion+"}";
	ANTLRParser parser= new ANTLRParser();
	
	@Test	 
	public void testForm() throws ParseError {
		assertEquals(Form.class, parser.parseForm(form).getClass());
	}
	
	@Test	
	public void testSimpeQuestion() throws ParseError{
		assertEquals(SimpleQuestion.class, parser.parseSimpleQuestion(simplequestion).getClass());
	}
	
	@Test	
	public void testIfThen() throws ParseError{
		assertEquals(IfThen.class, parser.parseIfThen(ifBlock).getClass());
	}
	
	@Test	
	public void testIfThenElse() throws ParseError{
		assertEquals(IfThenElse.class, parser.parseIfThenElse(ifBlock + elseBlock).getClass());
	}

}
