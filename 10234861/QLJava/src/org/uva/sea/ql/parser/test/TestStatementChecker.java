package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checkers.StatementChecker;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.errors.QLError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatementChecker {

	private ANTLRParser parser;
	private Map<String, Type> typeEnvironment;
	private List<QLError> errors;

	public TestStatementChecker() {

		parser = new ANTLRParser();
		errors = new ArrayList<QLError>();
		typeEnvironment = new HashMap<String, Type>();

	}

	@Test
	public void testExprTypeChecker() throws ParseError {

		try {
			assertEquals(true, StatementChecker.check(parser.parseForm("form taxinfo {"
					+ " question1 : \"how old are you\" int (3 + 7) "
					+ " question2 : \"how much is your salary\" bool " + " if (true) { "
					+ " question3 : \"Your age probably about\" int (5+5) "
					+ " question4 : \" telephonenumber \" int (1+1) " + " } " + " }"), typeEnvironment,
					errors));
		} catch (org.uva.sea.ql.parser.test.ParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
