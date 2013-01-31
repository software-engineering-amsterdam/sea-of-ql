package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.ExprTypeChecker;
import org.uva.sea.ql.ast.StatementChecker;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatementChecker {
	
	private ANTLRParser parser;
	private Map<String,Type> typeEnvironment;
	private List<String> errors;
	private StatementChecker stmntChecker;

	public TestStatementChecker() {
		
		parser = new ANTLRParser();
		errors = new ArrayList<String>();
		typeEnvironment = new HashMap<String, Type> ();
		stmntChecker = new StatementChecker(typeEnvironment,errors);

	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		
		assertEquals(true, stmntChecker.check(parser.parseForm("form arxigos { question1 : \"pou ise milto?\" int " +
				"question1 : \"omonoia arxige\" bool" +
				"  }"),typeEnvironment, errors));
	}

}
