package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.symbol.DefinitionCollector;
import org.uva.sea.ql.symbol.SymbolTable;

public class TestVisitors {

	IParse parser = new ANTLRParser();

	@Test
	public void testPrintVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new StatementPrinter(new ExpressionPrinter()));
	}

	@Test // TODO
	public void testSymbolGenerator() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		SymbolTable table = new SymbolTable();
		form.accept(new DefinitionCollector(table, new ErrorHandler()));
//		assertEquals(false, ((Bool) table.getSymbol("question1").getVariable()).getValue());
	}
}
