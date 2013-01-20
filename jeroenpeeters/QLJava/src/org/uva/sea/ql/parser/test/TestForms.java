package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

public class TestForms {

	private IParse parser;
	
	@Before
	public void setup(){
		parser = new JaccQLParser();
	}
	
	@Test
	public void testForm() throws ParseError, IOException {
		final String qlText = readResource("simpleQlForm1.ql");
		Expr expression = parser.parse(qlText);
		assertEquals(expression.getClass(), Form.class);
		
		TestVisitor tv = new TestVisitor(Form.class, CompoundStatement.class, Question.class, If.class, CompoundStatement.class, Question.class);
		expression.accept(tv);
		tv.finish();
	}
	
	private String readResource(final String resourceName) throws IOException{
		return IOUtils.toString(this.getClass().getResourceAsStream("resources\\"+resourceName));
	}
}
