package org.uva.sea.ql.symbol;

import org.junit.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.DependencyChecker;
import org.uva.sea.ql.semantic.DereferenceChecker;

public class TestDependencyChecker {
	
	private IParse parser = new ANTLRParser();
	
	@Test
	public void testCyclicDependency() throws ParseError {
		Form form = (Form) parser.parseNode("form form1 { if(symbol1) { symbol2: \"label\" boolean } if (symbol2) { symbol1: \"label\" boolean} }");
		form.accept(new SymbolGenerator());
		form.accept(new DereferenceChecker());
		DependencyChecker.newInstance(SymbolTable.getInstance(), ErrorHandler.getInstance()).checkDependencies();
		ErrorHandler.printErrors();
		Assert.assertEquals(2, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.getInstance().getErrors().clear();
		SymbolTable.getInstance().getSymbols().clear();
		
		form = (Form) parser.parseNode("form form1 { if(symbol1) { symbol1: \"label\" boolean } if (symbol2) { symbol2: \"label\" boolean} }");
		form.accept(new SymbolGenerator());
		form.accept(new DereferenceChecker());
		DependencyChecker.newInstance(SymbolTable.getInstance(), ErrorHandler.getInstance()).checkDependencies();
		ErrorHandler.printErrors();
		Assert.assertEquals(2, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.getInstance().getErrors().clear();
		SymbolTable.getInstance().getSymbols().clear();
	}
	
	@Test
	public void testAlmostCyclicDependency() throws ParseError {
		Form form = (Form) parser.parseNode("form form1 { symbol1: \"label\" boolean if(symbol1) { symbol2: \"label\" boolean } if (symbol2) { symbol3: \"label\" boolean} }");
		form.accept(new SymbolGenerator());
		form.accept(new DereferenceChecker());
		DependencyChecker.newInstance(SymbolTable.getInstance(), ErrorHandler.getInstance()).checkDependencies();
		ErrorHandler.printErrors();
		Assert.assertEquals(0, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.getInstance().getErrors().clear();
		SymbolTable.getInstance().getSymbols().clear();
	}

}
