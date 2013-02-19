package org.uva.sea.ql.parser.test.statements.conditions;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestIfThenStatements extends ConditionTypeChecker {
	@Test
	public void testIfThenElse() throws ParseError {
		// Single If-Then condition block with Question as body
		isAValidStatement("if (true) { \"Did you want to buy a house?\" wantsToBuyHouse: boolean }");
		isAValidStatement("if (wantsToBuyHouse) { \"What is your name?\" age: integer }");
		isAValidStatement("if (wantsToBuyHouse && age >= 18) { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
	}
}