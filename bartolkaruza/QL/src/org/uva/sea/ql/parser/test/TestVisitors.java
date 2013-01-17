package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.utility.ErrorHandler;
import org.uva.sea.ql.utility.SymbolTable;
import org.uva.sea.ql.visitor.PrintVisitor;
import org.uva.sea.ql.visitor.SymbolTableVisitor;
import org.uva.sea.ql.visitor.TypeCheckVisitor;

public class TestVisitors {
	
	IParse parser = new ANTLRParser();

	@Test
	public void testPrintVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new PrintVisitor());
	}
	
	@Test
	public void testSymbolTableVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new SymbolTableVisitor());
		SymbolTable table = SymbolTable.getInstance();
		assertNotNull(table.getSymbol("question1"));
		assertEquals(table.getSymbol("question1").getClass(), org.uva.sea.ql.ast.expr.value.Bool.class);
		assertEquals(((Bool)table.getSymbol("question1")).getValue(), false);
	}

	@Test
	public void testTypeChecker() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1==kaas) { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		ErrorHandler.getInstance().printErrors();
	}
}
