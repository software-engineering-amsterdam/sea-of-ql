package org.uva.sea.ql.test;

/**
 * Interface for implementing expression tests.
 */
public interface IExpressionTest {
	/**
	 * Test addition.
	 */
	void testAdd();

	/**
	 * Test subtraction.
	 */
	void testSub();

	/**
	 * Test multiplication.
	 */
	void testMul();

	/**
	 * Test division.
	 */
	void testDiv();

	/**
	 * Test negative.
	 */
	void testNeg();

	/**
	 * Test positive.
	 */
	void testPos();

	/**
	 * Test logical and.
	 */
	void testAnd();

	/**
	 * Test logical or.
	 */
	void testOr();

	/**
	 * Test logical not.
	 */
	void testNot();

	/**
	 * Test equation.
	 */
	void testEq();

	/**
	 * Test not-equals.
	 */
	void testNEq();

	/**
	 * Test greater-than.
	 */
	void testGT();

	/**
	 * Test greater-than-equals.
	 */
	void testGEq();

	/**
	 * Test lesser-than.
	 */
	void testLT();

	/**
	 * Test lesser-than-equals.
	 */
	void testLEq();

	/**
	 * Test identifiers.
	 */
	void testId();

	/**
	 * Test boolean literals.
	 */
	void testBool();

	/**
	 * Test integer literals.
	 */
	void testInt();

	/**
	 * Test money literals.
	 */
	void testMoney();

	/**
	 * Test string literals.
	 */
	void testStr();
}
