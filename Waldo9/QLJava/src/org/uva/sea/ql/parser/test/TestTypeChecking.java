package org.uva.sea.ql.parser.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.ASTNodeTypeCheckingVisitor;
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
		ASTNodeTypeCheckingVisitor typeChecker = new ASTNodeTypeCheckingVisitor();
		parser.parseForm(qlFileReader.readQLFile("QLTestcase2.ql")).accept(typeChecker);
	}

}
