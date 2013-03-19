package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.typechecker.CheckStat;

public class TestCheckStat {
	private ANTLRParser parser;
	
	private Map<Ident, Type> typeEnv;
	private List<String> errMsgs;

	public TestCheckStat() {
		parser = new ANTLRParser();
		typeEnv = new HashMap<Ident, Type>();
		errMsgs = new ArrayList<String>();
		
	}
	
	private String test1 = "form Box1HouseOwning { houses : \"Ask me something here\" integer (1+2) \n" + 
			"blabla: \"This is a question\" boolean  \n "+
			"if(\"a\"== \"b\") {anotherQ: \"What else to ask\" string} }";

	private String test2 = "form testFormErrors { \n" +
			"houses: \"Ask me something here\" integer \n" +
			"sold: \"Ask something else\" boolean \n" +
			"bought: \"Ask something else\" integer \n" +
			"if (sold+bought) {" +
			"anotherQ: \"What else to ask\" string } " +
			   "}";

	@Test
	public void testStatChecking() throws ParseError {
		//typeEnv.put(new Ident("a"), new IntType());
		//typeEnv.put(new Ident("b"), new IntType());
		assertTrue(CheckStat.check(parser.parseForm(test1), typeEnv, errMsgs));
		//assertTrue(CheckStat.check(parser.parse("true || false"), typeEnv, errMsgs));
		//assertTrue(CheckStat.check(parser.parse("23 >= 56"), typeEnv, errMsgs));
		//assertTrue(CheckStat.check(parser.parse("25+56*(3/1)"), typeEnv, errMsgs));
		//assertTrue(CheckStat.check(parser.parse("\"abc\"==\"abc\""), typeEnv, errMsgs));
		//assertFalse(CheckStat.check(parser.parse("10-true"), typeEnv, errMsgs));
		//assertFalse(CheckStat.check(parser.parse("true || 20"), typeEnv, errMsgs));
		//assertFalse(CheckStat.check(parser.parse("\"abc\" + 56"), typeEnv, errMsgs));
	}
}