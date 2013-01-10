package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Questions;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.PrintVisitor;

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
	public void testPrintVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new PrintVisitor());
	}

}
