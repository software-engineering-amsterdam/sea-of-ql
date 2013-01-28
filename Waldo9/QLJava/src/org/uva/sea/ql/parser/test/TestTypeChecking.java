package org.uva.sea.ql.parser.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.statements.StatementTypeCheckingVisitor;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestTypeChecking {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
	  List<Object[]> parserList = new ArrayList<Object[]>();
	  parserList.add(new Object[] {new ANTLRParser()});
	  return parserList;
	}
	
	public TestTypeChecking(IParse parser) {
		this.parser = parser;
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
