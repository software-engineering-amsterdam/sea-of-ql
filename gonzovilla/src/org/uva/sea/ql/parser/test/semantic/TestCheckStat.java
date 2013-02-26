package org.uva.sea.ql.parser.test.semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.CheckStat;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestCheckStat {

	private IParse parser;
	private CheckStat checkStat;
	private Map<String, Type> tenv; 
	private List<String> messages;

	public TestCheckStat() {
		parser = new ANTLRParser();
		tenv = new HashMap<String, Type>();
		messages = new ArrayList<String>();
		checkStat = new CheckStat(tenv, messages);
	}
	
	@Test
	public void testStatementChecking() throws ParseError {
		assertEquals(true, checkStat.check(parser.parseForm(
				"form Box1HouseOwning { " +
				"hasSoldHouse: \"Did you sell a house in 2010?\" [Bool] " +
				"hasBoughtHouse: \"Did you buy a house in 2010\" [Bool]" +
				"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" [Bool]" +
				"if (hasSoldHouse) then { " +
				"sellingPrice: \"Price the house was sold for:\" [Int]" +
				"privateDebt: \"Private debts for the sold house:\" [Int]" +
				"valueResidue: \"Value residue:\" (sellingPrice - privateDebt) [Int] } endif}"
				), tenv, messages));
	}

}
