package eu.karuza.ql.ast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.antlr.ANTLRParser;

public class TestNodes {

	IParse parser = new ANTLRParser();

	@Test
	public void testBaseForm() throws ParseError {
		assertEquals(Form.class, parser.parseNode("form somename {}").getClass());
	}

	@Test
	public void testComplexForm() throws ParseError {
		assertEquals(Form.class, parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }").getClass());
	}

	@Test
	public void testNestedIf() throws ParseError {
		Form form = (Form) parser
				.parseNode("form somelabel { if(1==kaas) { if(someTest) {question2: \"label \" boolean } question1: \" some text label\" boolean} }");
		assertEquals(ConditionalStatement.class, form.getStatements().get(0).getClass());
		assertEquals(ConditionalStatement.class, ((ConditionalStatement) form.getStatements().get(0)).getStatements().get(0).getClass());
		assertEquals(AnswerableQuestion.class, ((ConditionalStatement) ((ConditionalStatement) form.getStatements().get(0)).getStatements().get(0)).getStatements()
				.get(0).getClass());
		
	}

	@Test
	public void testSingleLineComment() throws ParseError {
		Form form = (Form) parser
				.parseNode("form somelabel { \nif(1==kaas) { \n//if(someTest) {question2: \"label \" boolean }\n question1: \" some text label\" boolean} }");
		assertEquals(AnswerableQuestion.class, ((ConditionalStatement) form.getStatements().get(0)).getStatements().get(0).getClass());
	}

}
