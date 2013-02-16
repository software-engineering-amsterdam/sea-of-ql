package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.statements.questions.AnswerableQuestion;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;

public class TestQuestions extends ASTNodeChecker {
	public TestQuestions() {
		super(new ANTLRParserQuestions());
	}
	
	@Test
	public void testQuestions() throws ParseError {
		expressionMatchesASTClass("\"Did you sell a house in 2010?\" hasSoldHouse: boolean", AnswerableQuestion.class);
		expressionMatchesASTClass("\"Price the house was sold for:\" sellingPrice: integer", AnswerableQuestion.class);
		expressionMatchesASTClass("\"What is your name?\" userName: string", AnswerableQuestion.class);
	}
	
	@Test
	public void testComputedQuestions() throws ParseError {
		expressionMatchesASTClass("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt", ComputedQuestion.class);
		expressionMatchesASTClass("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt", ComputedQuestion.class);
		expressionMatchesASTClass("\"Full name:\" fullName = firstName + lastName", ComputedQuestion.class);
	}
}