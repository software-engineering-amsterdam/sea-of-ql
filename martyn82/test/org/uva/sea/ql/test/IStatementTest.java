package org.uva.sea.ql.test;

/**
 * Interface for implementing statement tests.
 */
public interface IStatementTest {
	/**
	 * Test IF-THEN-ELSE.
	 */
	void testIfThenElse();

	/**
	 * Test FormDeclaration.
	 */
	void testFormDeclaration();

	/**
	 * Test VarDeclaration.
	 */
	void testVarDeclaration();

	/**
	 * Test QuestionDeclaration.
	 */
	void testQuestionDeclaration();

	/**
	 * Test Assignment.
	 */
	void testAssignment();
}
