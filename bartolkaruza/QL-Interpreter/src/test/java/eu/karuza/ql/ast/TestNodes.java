package eu.karuza.ql.ast;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

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
		assertEquals(IfConditionalStatement.class, form.getStatements().get(0).getClass());
		assertEquals(IfConditionalStatement.class, ((IfConditionalStatement) form.getStatements().get(0)).getStatements().get(0).getClass());
		assertEquals(AnswerableQuestion.class, ((IfConditionalStatement) ((IfConditionalStatement) form.getStatements().get(0)).getStatements().get(0)).getStatements()
				.get(0).getClass());
	}
	
	@Test
	public void testElse() throws ParseError {
		Form form = (Form) parser.parseNode("form form1 { if(1==kaas) { question1: \"label1\" boolean } else { question2: \"label2\" boolean} }");
		List<Statement> statements = form.getStatements();
		IfElseConditionalStatement statement = (IfElseConditionalStatement) statements.get(0);
		AnswerableQuestion question1 = (AnswerableQuestion) statement.getIfStatements().get(0);
		AnswerableQuestion question2 = (AnswerableQuestion) statement.getElseStatements().get(0);
		assertEquals("label1", question1.getLabel());
		assertEquals("label2", question2.getLabel());
	}

	@Test
	public void testSingleLineComment() throws ParseError {
		Form form = (Form) parser
				.parseNode("form somelabel { \nif(1==kaas) { \n//if(someTest) {question2: \"label \" boolean }\n question1: \" some text label\" boolean} }");
		assertEquals(AnswerableQuestion.class, ((IfConditionalStatement) form.getStatements().get(0)).getStatements().get(0).getClass());
	}

}
