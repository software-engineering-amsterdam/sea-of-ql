package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Ident;
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
	
	/* A Valid Form */
	private String test1 = "form Box1HouseOwning { houses : \"Ask me something here\" integer (1+2) \n" + 
			"blabla: \"This is a question\" boolean  \n "+
			"if(\"a\"== \"b\") {anotherQ: \"What else to ask\" string} }";

	/* A Non-Valid Form: the if-condition is not a valid statement (bool  integer) */
	private String test2 = "form testFormErrors { \n" +
			"houses: \"Ask me something here\" integer \n" +
			"sold: \"Ask something else\" boolean \n" +
			"bought: \"Ask something else\" integer \n" +
			"if (sold+bought) {" +
			"anotherQ: \"What else to ask\" string } " +
			   "}";
	
	/* A Valid Form */
	private String test3 = "form thisIsAProperForm { \n" +
			"anId1: \"This is a nonComputed question\" integer \n" + 
			"anId2: \"This is another nonComputed question\" integer \n" + 
			"anId3: \"This is a computed question\" integer (anId1 + anId2)\n }" ; 
	
	private String test4 = "form thisIsAProperForm { \n" +
			"anId4: \"This is a nonComputed question\" integer \n" + 
			"anId5: \"This is another nonComputed question\" integer \n" + 
			"anId6: \"This is a computed question\" integer (anId4 + anId5)\n" +
			"if (anId3 > 10) { \n" +
			"anId7: \"This is another nonComputedQuestion\" boolean \n } \n }";  
			

	@Test
	public void testStatChecking() throws ParseError {
		assertTrue(CheckStat.check(parser.parseForm(test1), typeEnv, errMsgs));
		assertFalse(CheckStat.check(parser.parseForm(test2), typeEnv, errMsgs));
		assertTrue(CheckStat.check(parser.parseForm(test3), typeEnv, errMsgs));
		assertTrue(CheckStat.check(parser.parseForm(test4), typeEnv, errMsgs));

	}
}