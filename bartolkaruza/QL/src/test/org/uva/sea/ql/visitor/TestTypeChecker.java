package org.uva.sea.ql.visitor;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.ExpressionSemanticChecker;
import org.uva.sea.ql.semantic.StatementSemanticChecker;
import org.uva.sea.ql.symbol.SymbolGenerator;
import org.uva.sea.ql.symbol.SymbolTable;

public class TestTypeChecker {

	IParse parser = new ANTLRParser();

	@Test
	public void testInvalidTypes() throws ParseError {
		ErrorHandler handler = new ErrorHandler();
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(!\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1+\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1-\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(+\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(-\"kaas\") { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" \"string\" }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" string }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" integer }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" money }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" 1 }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" 1 }"), handler);
		handler.printErrors();
		Assert.assertEquals(19, handler.getErrors().size());
	}

	@Test
	public void testValidTypes() throws ParseError {
		ErrorHandler handler = new ErrorHandler();
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>2) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<2) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=2) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=2) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(!true) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true==true) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(false!=true) { question1: \" some text label\" boolean} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" 1+2} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" 1-2} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" +2} }"), handler);
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" -2} }"), handler);
		handler.printErrors();
		Assert.assertEquals(0, handler.getErrors().size());
	}

	@Test
	public void testTypeChecker() throws ParseError {
		ErrorHandler handler = new ErrorHandler();
		SymbolTable table = new SymbolTable();
		Form form = (Form) parser.parseNode("form somelabel { if(1==question1) { question1: \" some text label\" boolean} }");
		ExpressionSemanticChecker exprCheck = new ExpressionSemanticChecker(table, handler);
		form.accept(new StatementSemanticChecker(table, handler, new SymbolGenerator(table, handler), exprCheck));
		handler.printErrors();
	}

	private void runParserAndCheckType(ASTNode node, ErrorHandler handler) {
		SymbolTable table = new SymbolTable();
		Form form = (Form) node;
		form.accept(new StatementSemanticChecker(table, handler, new SymbolGenerator(table, handler), new ExpressionSemanticChecker(table, handler)));
	}

}
