package org.uva.sea.ql.visitor;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.TypeChecker;
import org.uva.sea.ql.symbol.SymbolGenerator;
import org.uva.sea.ql.symbol.SymbolTable;

public class TestTypeChecker {

	IParse parser = new ANTLRParser();

	@Test
	public void testInvalidTypes() throws ParseError {
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(!\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1+\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1-\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(+\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(-\"kaas\") { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" \"string\" }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" string }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" integer }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" money }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" 1 }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(question1) { question2: \"label\" boolean } question1: \"label\" 1 }"));
		ErrorHandler.printErrors();
		Assert.assertEquals(19, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.getInstance().getErrors().clear();
	}

	@Test
	public void testValidTypes() throws ParseError {
		ErrorHandler.getInstance().getErrors().clear();
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>2) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<2) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1>=2) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(1<=2) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(!true) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true==true) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(false!=true) { question1: \" some text label\" boolean} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" 1+2} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" \"kaas\"+\"kaas\"} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" 1-2} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" +2} }"));
		runParserAndCheckType(parser.parseNode("form somelabel { if(true) { question1: \" some text label\" -2} }"));
		ErrorHandler.printErrors();
		Assert.assertEquals(0, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.getInstance().getErrors().clear();
		SymbolTable.getInstance().getSymbols().clear();
	}

	@Test
	public void testTypeChecker() throws ParseError {
		ErrorHandler.getInstance().getErrors().clear();
		SymbolTable.getInstance().getSymbols().clear();
		Form form = (Form) parser.parseNode("form somelabel { if(1==kaas) { question1: \" some text label\" boolean} }");
		form.accept(new SymbolGenerator());
		form.accept(new TypeChecker());
		ErrorHandler.printErrors();
		ErrorHandler.getInstance().getErrors().clear();
	}

	private void runParserAndCheckType(ASTNode node) {
		SymbolTable.getInstance().getSymbols().clear();
		Form form = (Form) node;
		form.accept(new SymbolGenerator());
		form.accept(new TypeChecker());
		SymbolTable.getInstance().getSymbols().clear();
	}

}
