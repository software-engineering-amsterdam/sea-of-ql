package eu.karuza.ql.visitor;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.expr.type.BoolType;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.symbol.DefinitionCollector;
import eu.karuza.ql.visitor.ExpressionPrinter;
import eu.karuza.ql.visitor.StatementPrinter;

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
