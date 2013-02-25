package org.uva.sea.ql.checker.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.checker.FormStmtChecker;

public class TestStmtChecking {
	private ANTLRParser parser;
	private FormStmtChecker formStmtChecker;
	private Map<Ident,AType> typeEnv;
	private List<String> errMsgs;
	
	private String testForm1 = "form Box1HouseOwning { \n" +
            "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n" +
            "hasBoughtHouse: \"Did you by a house in 2010?\" boolean    \n"+
            "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" \n" +
            	"boolean\n" +
            "if (hasSoldHouse) {" +
            "sellingPrice: \"Price the house was sold for:\" int \n" +
            "privateDebt: \"Private debts for the sold house:\" int\n" +
            "valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n" +         
				"}\n" +
			  "}";
	
	private String testForm2 = "form testFormErrors { \n" +
			"houses: \"Ask me something here\" int \n" +
			"sold: \"Ask something else\" boolean \n" +
			"bought: \"Ask something else\" int \n" +
			"if (sold+bought) {" +
			"anotherQ: \"What else to ask\" string } " +
			   "}";
	
	public TestStmtChecking() {
		parser = new ANTLRParser();
		typeEnv = new HashMap<Ident, AType>();
		errMsgs = new ArrayList<String>();
		formStmtChecker = new FormStmtChecker(typeEnv, errMsgs);
	}

	@Test
	public void testStmtChecking() throws ParseError {
		assertTrue(formStmtChecker.check(parser.parseForm(testForm1), typeEnv, errMsgs));
		assertFalse(formStmtChecker.check(parser.parseForm(testForm2), typeEnv, errMsgs));
	}
}