package org.uva.sea.ql.parser.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.statements.StatementTypeCheckingVisitor;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestTypeChecking {

	private IParse parser;

	@Before
	public void setUp() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testTypeChecking() throws ParseError, IOException {		
		QLFileReader qlFileReader = new QLFileReader();
		StatementTypeCheckingVisitor typeChecker = new StatementTypeCheckingVisitor();
		parser.parseForm(qlFileReader.readQLFile("QLTestcase2.ql")).getBlock().accept(typeChecker);
		for (String errorMessage : typeChecker.getErrorMessages())
			System.out.println(errorMessage);
	}

}
