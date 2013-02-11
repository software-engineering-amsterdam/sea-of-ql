package org.uva.sea.ql.symbol;

import org.junit.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.StatementSemanticChecker;

public class TestDependencyChecker {
	
	private IParse parser = new ANTLRParser();
	
	@Test
	public void testCyclicDependency() throws ParseError {
		ParserContext context = new ParserContext();
		Form form = (Form) parser.parseNode("form form1 { if(symbol1) { symbol2: \"label\" boolean } if (symbol2) { symbol1: \"label\" boolean} }");
		form.accept(new StatementSemanticChecker(context));
		Assert.assertEquals(2, context.getErrors().size());
		context = new ParserContext();
		form = (Form) parser.parseNode("form form1 { if(symbol1) { symbol1: \"label\" boolean } if (symbol2) { symbol2: \"label\" boolean} }");
		form.accept(new StatementSemanticChecker(context));
		Assert.assertEquals(2, context.getErrors().size());
	}
	
	@Test
	public void testAlmostCyclicDependency() throws ParseError {
		ParserContext context = new ParserContext();
		Form form = (Form) parser.parseNode("form form1 { symbol1: \"label\" boolean if(symbol1) { symbol2: \"label\" boolean } if (symbol2) { symbol3: \"label\" boolean} }");
		form.accept(new StatementSemanticChecker(context));
		context.getHandler().printErrors();
		Assert.assertEquals(0, context.getErrors().size());
	}

}
