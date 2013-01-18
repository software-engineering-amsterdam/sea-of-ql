package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.utility.ErrorHandler;

public class TestNodes {

	IParse parser = new ANTLRParser();

	@Test
	public void testBaseForm() throws ParseError {
		assertEquals(parser.parseNode("form somename {}").getClass(), Form.class);
	}

	@Test
	public void testComplexForm() throws ParseError {
		assertEquals(parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }").getClass(), Form.class);
	}

	@Test
	public void testNestedIf() throws ParseError {
		Form form = (Form) parser
				.parseNode("form somelabel { if(1==kaas) { if(someTest) {question2: \"label \" boolean } question1: \" some text label\" boolean} }");
		assertEquals(form.getStatements().get(0).getClass(), ConditionalStatement.class);
		assertEquals(((ConditionalStatement) form.getStatements().get(0)).getStatements().get(0).getClass(), ConditionalStatement.class);
		assertEquals(((ConditionalStatement) ((ConditionalStatement) form.getStatements().get(0)).getStatements().get(0)).getStatements().get(0).getClass(),
				Question.class);
		ErrorHandler.getInstance().printErrors();
	}

	

}
