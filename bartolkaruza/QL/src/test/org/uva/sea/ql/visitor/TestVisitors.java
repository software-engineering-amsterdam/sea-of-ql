package org.uva.sea.ql.visitor;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.symbol.DefinitionCollector;

public class TestVisitors {

	IParse parser = new ANTLRParser();

	@Test
	public void testPrintVisitor() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		form.accept(new StatementPrinter(new ExpressionPrinter()));
	}

	@Test
	public void testSymbolGenerator() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1+1) { question1: \" some text label\" boolean} }");
		ParserContext context = new ParserContext();
		form.accept(new DefinitionCollector(context));
		assertTrue(context.getSymbol("question1").getExpr().typeOf(context.getTable()) instanceof BoolType);
	}
}
