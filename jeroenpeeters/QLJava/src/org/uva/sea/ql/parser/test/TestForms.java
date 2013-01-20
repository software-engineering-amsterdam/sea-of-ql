package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
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
	public void testSimpleQlForm1() throws ParseError, IOException {
		final String qlText = readResource("simpleQlForm1.ql");
		Form form = parser.parseForm(qlText);
		assertNotNull(form);
		
		TestVisitor tv = new TestVisitor(Form.class, CompoundStatement.class, Question.class, IfStatement.class, CompoundStatement.class, Question.class);
		form.accept(tv);
		tv.finish();
	}
	
	@Test
	public void testSimpleQlForm2() throws ParseError, IOException {
		final String qlText = readResource("simpleQlForm2.ql");
		Form form = parser.parseForm(qlText);
		assertNotNull(form);
		
		TestVisitor tv = new TestVisitor(Form.class, CompoundStatement.class, Question.class, 
				IfStatement.class, CompoundStatement.class, Question.class, Question.class, IfStatement.class, CompoundStatement.class, Question.class);
		form.accept(tv);
		tv.finish();
	}
	
	private String readResource(final String resourceName) throws IOException{
		return IOUtils.toString(this.getClass().getResourceAsStream("resources\\"+resourceName));
	}
}
