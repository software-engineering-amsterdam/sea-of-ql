package eu.karuza.ql.visitor;

import junit.framework.Assert;

import org.junit.Test;

import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.visitor.impl.StatementSemanticChecker;

public class TestTypeChecker {

	IParse parser = new ANTLRParser();

	@Test
	public void testInvalidTypes() throws ParseError {
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(1<\"kaas\") { question2: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(1>=\"kaas\") { question3: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(1<=\"kaas\") { question4: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(!\"kaas\") { question5: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(1+\"kaas\") { question6: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(2, runParserAndCheckType(parser.parseNode("form somelabel { if(1-\"kaas\") { question7: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(2, runParserAndCheckType(parser.parseNode("form somelabel { if(+\"kaas\") { question8: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(2, runParserAndCheckType(parser.parseNode("form somelabel { if(-\"kaas\") { question9: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question10: \"label\" boolean } question1: \"label\" \"string\" }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question11: \"label\" boolean } question1: \"label\" string }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question12: \"label\" boolean } question1: \"label\" integer }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question13: \"label\" boolean } question1: \"label\" money }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question14: \"label\" boolean } question1: \"label\" 1 }")).getErrors().size());
		Assert.assertEquals(1, runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question15: \"label\" boolean } question1: \"label\" 1 }")).getErrors().size());
	}

	@Test
	public void testValidTypes() throws ParseError {
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(1>2) { question1: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(1<2) { question2: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(1>=2) { question3: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(1<=2) { question4: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(!true) { question5: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true==true) { question6: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question7: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(false!=true) { question8: \" some text label\" boolean} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question9: \" some text label\" 1+2} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question10: \" some text label\" 1-2} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question11: \" some text label\" +2} }")).getErrors().size());
		Assert.assertEquals(0, runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question12: \" some text label\" -2} }")).getErrors().size());
	}

	@Test
	public void testTypeChecker() throws ParseError {
		ParserContext context = new ParserContext();
		Form form = (Form) parser.parseNode("form somelabel { if(1==question1) { question1: \" some text label\" boolean} }");
		form.accept(new StatementSemanticChecker(context));
	}

	private ParserContext runParserAndCheckType(ASTNode node) {
		Form form = (Form) node;
		ParserContext context = new ParserContext();
		form.accept(new StatementSemanticChecker(context));
		return context;
	}

}
