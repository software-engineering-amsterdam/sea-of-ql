package org.uva.sea.ql.parser.test.ast.forms;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserForms;
import org.uva.sea.ql.parser.errors.ParseError;
import org.uva.sea.ql.parser.test.ast.ASTNodeChecker;

public class TestForms extends ASTNodeChecker {
	public TestForms() {
		super(new ANTLRParserForms());
	}
	
	@Test
	public void testFormSingleQuestion() throws ParseError {
		inputMatchesFormAST("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }");
	}
	@Test
	public void testFormMultipleQuestions() throws ParseError {
		inputMatchesFormAST("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean \"Price the house was sold for:\" sellingPrice: integer }");
	}
	@Test
	public void testFormWithIfStatement() throws ParseError {
		inputMatchesFormAST("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean if (hasSoldHouse) { \"Qualifies for loan:\" qualifiesForLoan = \"true\" } }");
	}
}