package org.uva.sea.ql.test.typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.arithmetic.Mul;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.test.IStatementTest;
import org.uva.sea.ql.test.visitor.VisitorTest;
import org.uva.sea.ql.typechecker.ExpressionChecker;
import org.uva.sea.ql.typechecker.StatementChecker;

/**
 * Tests statements type checker.
 */
public class StatementTypeCheckerTest extends VisitorTest<Boolean> implements IStatementTest {
	/**
	 * Holds the statement checker.
	 */
	private final StatementChecker statementVisitor;

	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionVisitor;

	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new TypeChecker test.
	 */
	public StatementTypeCheckerTest() {
		super();

		this.environment = new Environment();
		this.expressionVisitor = new ExpressionChecker( this.environment );
		this.statementVisitor = new StatementChecker( this.environment, this.expressionVisitor );
	}

	/**
	 * Typechecks the given statement.
	 *
	 * @param statement
	 *
	 * @return True if typecheck OK, false otherwise.
	 */
	private Boolean typeCheck( Statement statement ) {
		this.environment.getErrors().clear();
		return statement.accept( this.statementVisitor );
	}

	@Override
	@Test
	public void testVarDeclaration() {
		assertTrue( typeCheck( new Assignment( new Ident( "x" ), new Int( 23 ) ) ) );

		assertFalse( typeCheck( new Assignment( new Ident( "x" ), new Ident( "y" ) ) ) );
		assertEquals( "Undefined variable: y", environment.getErrors().get( 0 ).getMessage() );

		assertFalse(
			typeCheck(
				new Assignment(
					new Ident( "x" ), new Add( new Mul( new Int( 24 ), new Money( .5 ) ), new Ident( "y" ) )
				)
			)
		);
		assertEquals( "Undefined variable: y", environment.getErrors().get( 0 ).getMessage() );

		/*
		 * if ( true ) {
		 * 		x = 24
		 * 		x: boolean
		 * }
		 */
		assertFalse(
			typeCheck(
				new IfThenElse(
					new Bool( true ),
					new Statements(
						new Assignment( new Ident( "x" ), new Int( 24 ) ),
						new Statements( new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Bool() ) )
					),
					new ElseIfs()
				)
			)
		);

		assertEquals(
			"The variable x is already declared elsewhere.",
			environment.getErrors().get( 0 ).getMessage()
		);
	}

	@Override
	@Test
	public void testIfThenElse() {
		assertTrue( typeCheck( new IfThenElse( new Bool( true ), new Statements(), new ElseIfs() ) ) );

		assertFalse( typeCheck( new IfThenElse( new Int( 1 ), new Statements(), new ElseIfs() ) ) );
		assertEquals(
			"Condition of an IF block should evaluate to Boolean.",
			environment.getErrors().get( 0 ).getMessage()
		);

		/*
		 * if ( true ) {
		 *		"" x: boolean
		 *		x = 23
		 * }
		 */
		assertFalse(
			typeCheck(
				new IfThenElse(
					new Bool( true ),
					new Statements(
						new QuestionDeclaration(
							new Str( "" ), new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Bool() )
						),
						new Statements(
							new Assignment( new Ident( "x" ), new Int( 23 ) )
						)
					),
					new ElseIfs()
				)
			)
		);
		assertEquals(
			"Type mismatch: cannot convert from Boolean to Integer.",
			environment.getErrors().get( 0 ).getMessage()
		);
	}

	@Override
	@Test
	public void testFormDeclaration() {
		assertTrue( typeCheck( new FormDeclaration( new Ident( "x" ), new Statements() ) ) );
		assertTrue(
			typeCheck(
				new FormDeclaration(
					new Ident( "formVar" ),
					new Statements(
						new QuestionDeclaration(
							new Str( "label" ),
							new VarDeclaration(
								new Ident( "questionVar" ),
								new org.uva.sea.ql.ast.type.Int()
							)
						)
					)
				)
			)
		);
	}

	@Override
	@Test
	public void testQuestionDeclaration() {
		assertTrue(
			typeCheck(
				new QuestionDeclaration(
					new Str( "label" ),
					new VarDeclaration(
						new Ident( "var" ),
						new org.uva.sea.ql.ast.type.Bool()
					)
				)
			)
		);

		assertTrue(
			typeCheck(
				new QuestionDeclaration(
					new Str( "label" ),
					new Assignment(
						new Ident( "x" ),
						new Add(
							new Int( 6 ),
							new Money( 19.99 )
						)
					)
				)
			)
		);

		assertFalse(
			typeCheck(
				new QuestionDeclaration(
					new Str( "label" ),
					new Assignment(
						new Ident( "x" ),
						new Add(
							new Ident( "y" ), // undefined variable
							new Ident( "z" )  // undefined variable
						)
					)
				)
			)
		);
	}

	@Override
	@Test
	public void testAssignment() {
		assertTrue( typeCheck( new Assignment( new Ident( "x" ), new Int( 99 ) ) ) );
		assertTrue( typeCheck( new Assignment( new Ident( "y" ), new And( new Bool( true ), new Bool( false ) ) ) ) );
		assertTrue( typeCheck( new Assignment( new Ident( "y" ), new Eq( new Str( "" ), new Str( "" ) ) ) ) );

		// variable 'x' is already declared as type Int
		assertFalse( typeCheck( new Assignment( new Ident( "x" ), new Bool( true ) ) ) );
		// variable 'y' is already declared as type Bool
		assertFalse( typeCheck( new Assignment( new Ident( "y" ), new Mul( new Ident( "x" ), new Int( 4 ) ) ) ) );
	}
}
