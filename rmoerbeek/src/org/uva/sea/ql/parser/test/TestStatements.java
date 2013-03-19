package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatements {
	
	private IParse parser;

	public TestStatements() {
		this.parser = new ANTLRParser();
	}
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals(NonComputedQuestion.class, parser.parseQuestion(
				"valueResidue : \"Value residue:\" money").getClass());
		assertEquals(ComputedQuestion.class, parser.parseQuestion(
				"sahdg : \"JKGHhjdsgfdks:\" money (a + b)").getClass());
		
	}
	
	@Test
	public void testIfElse() throws ParseError {	
	assertEquals(IfStat.class, parser.parseIfElse("if (a==b) {}").getClass());
	}
	
	
	@Test
	public void testForm() throws ParseError {
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {valueResidue : \"Value residue:\" money " +
				"sahdg : \"JKGHhjdsgfdks:\" money (a + b)}").getClass());
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {valueResidue : \"Value residue:\" money \n" +
				"sahdg : \"JKGHhjdsgfdks:\" money (a + b)}").getClass());
		assertEquals(Form.class, parser.parseForm(
				"form Box1HouseOwning {valueResidue : \"Value residue:\" money \n" +
				"sahdg : \"JKGHhjdsgfdks:\" money (a + b) \n" +
				"if (a==b) { \n" +
				"valueResidue : \"Value residue:\" money } }").getClass());	
	}
	
}


