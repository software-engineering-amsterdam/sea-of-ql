package org.uva.sea.ql;

public interface ExpressionTest {
	// arithmetic
	void testAddExpression();
	void testSubtractExpression();
	void testMultiplyExpression();
	void testDivideExpression();

	// unary numeric

	void testNegativeExpression();
	void testPositiveExpression();

	// logical

	void testAndExpression();
	void testOrExpression();
	void testNotExpression();

	// comparison

	void testEqualExpression();
	void testNotEqualExpression();
	void testGreaterThanExpression();
	void testGreaterThanOrEqualExpression();
	void testLesserThanExpression();
	void testLesserThanOrEqualExpression();

	// identifier

	void testIdentifierExpression();

	// literals

	void testBooleanLiteral();
	void testIntegerLiteral();
	void testMoneyLiteral();
	void testStringLiteral();
}
