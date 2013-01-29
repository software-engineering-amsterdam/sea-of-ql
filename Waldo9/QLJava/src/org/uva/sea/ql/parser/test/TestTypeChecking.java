package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

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
		List<String> messages = typeChecker.getErrorMessages();		
		for (String errorMessage : typeChecker.getErrorMessages())
			System.out.println(errorMessage);
		assertEquals(3, messages.size());
	}

}
