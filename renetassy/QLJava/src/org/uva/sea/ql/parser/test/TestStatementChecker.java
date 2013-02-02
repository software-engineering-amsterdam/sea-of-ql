package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.StatementChecker;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatementChecker {
	
	private ANTLRParser parser;
	private Map<String,Type> typeEnvironment;
	private List<String> errors;
	//private StatementChecker stmntChecker;

	public TestStatementChecker() {
		
		parser = new ANTLRParser();
		errors = new ArrayList<String>();
		typeEnvironment = new HashMap<String, Type> ();
		//stmntChecker = new StatementChecker(typeEnvironment,errors);

	}
	
	@Test
	public void testExprTypeChecker() throws ParseError {
		
		assertEquals(true, StatementChecker.check(parser.parseForm("form arxigos {" +
				" question1 : \"pou ise milto?\" int (3 + 7) " +
				" question2 : \"omonoia arxige\" bool " +
				" if (true) { " +
				" 	question3 : \"ti leei psile\" int (5+5) " +
				" 	question6 : \" ena kai ena ison tessera \" int (1+1) " +
				" } " +
				" }"),typeEnvironment, errors));
	}

	
}
