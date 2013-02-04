package org.uva.sea.ql.visitor;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.StatementSemanticChecker;

public class TestTypeChecker {

	IParse parser = new ANTLRParser();

	@Test
	public void testInvalidTypes() throws ParseError {
		ParserContext context = new ParserContext();
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<\"kaas\") { question2: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=\"kaas\") { question3: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=\"kaas\") { question4: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(!\"kaas\") { question5: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1+\"kaas\") { question6: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1-\"kaas\") { question7: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(+\"kaas\") { question8: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(-\"kaas\") { question9: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question10: \"label\" boolean } question1: \"label\" \"string\" }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question11: \"label\" boolean } question1: \"label\" string }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question12: \"label\" boolean } question1: \"label\" integer }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question13: \"label\" boolean } question1: \"label\" money }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question14: \"label\" boolean } question1: \"label\" 1 }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question15: \"label\" boolean } question1: \"label\" 1 }"), context);
		context.getHandler().printErrors();
		Assert.assertEquals(19, context.getErrors().size());
	}

	@Test
	public void testValidTypes() throws ParseError {
		ParserContext context = new ParserContext();
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>2) { question1: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<2) { question2: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=2) { question3: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=2) { question4: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(!true) { question5: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true==true) { question6: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question7: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(false!=true) { question8: \" some text label\" boolean} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question9: \" some text label\" 1+2} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question10: \" some text label\" 1-2} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question11: \" some text label\" +2} }"), context);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question12: \" some text label\" -2} }"), context);
		context.getHandler().printErrors();
		Assert.assertEquals(0, context.getErrors().size());
	}

	@Test
	public void testTypeChecker() throws ParseError {
		ParserContext context = new ParserContext();
		Form form = (Form) parser.parseNode("form somelabel { if(1==question1) { question1: \" some text label\" boolean} }");
		form.accept(new StatementSemanticChecker(context));
		context.getHandler().printErrors();
	}

	private void runParserAndCheckType(ASTNode node, ParserContext context) {
		Form form = (Form) node;
		form.accept(new StatementSemanticChecker(context));
	}

}
