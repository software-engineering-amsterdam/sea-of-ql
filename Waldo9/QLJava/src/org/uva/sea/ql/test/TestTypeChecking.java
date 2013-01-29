package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.typechecking.StatementTypeCheckingVisitor;

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
		assertEquals(3, typeChecker.getErrorMessages().size());
	}

}
