package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.utility.SymbolTable;
import org.uva.sea.ql.visitor.NodePrinter;
import org.uva.sea.ql.visitor.SymbolGenerator;

public class TestVisitors {
	
	IParse parser = new ANTLRParser();

	@Test
	public void testPrintVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new NodePrinter());
	}
	
	@Test
	public void testSymbolGenerator() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new SymbolGenerator());
		SymbolTable table = SymbolTable.getInstance();
		assertEquals(false, ((Bool)table.getSymbol("question1").getVariable()).getValue());
	}
}
