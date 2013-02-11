package org.uva.sea.ql.test.visitor.typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
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
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVar;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.IStatementTest;
import org.uva.sea.ql.test.visitor.VisitorTest;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Error;
import org.uva.sea.ql.visitor.typechecker.ExpressionChecker;
import org.uva.sea.ql.visitor.typechecker.StatementChecker;
import org.uva.sea.ql.visitor.typechecker.TypeError;

/**
 * Tests statements type checker.
 */
public class StatementTypeCheckerTest extends VisitorTest<Boolean> implements IStatementTest {
	/**
	 * Holds the statement checker.
	 */
	private final StatementChecker statementChecker;

	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionChecker;

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
		this.expressionChecker = new ExpressionChecker( this.environment );
		this.statementChecker = new StatementChecker( this.environment, this.expressionChecker );
	}

	/**
	 * Perform typechecker on the example program string as defined in abstract parent class.
	 */
	@Test
	public void testExample() {
		try {
			this.parser.parse( program ).accept( this.statementChecker );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			fail( e.getMessage() );
			return;
		}

		if ( this.environment.getErrors().size() > 0 ) {
			this.dumpErrors();
		}
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

		if ( !statement.accept( this.statementChecker ) ) {
			return false;
		}

		return true;
	}

	/**
	 * TypeChecks the given expression.
	 *
	 * @param expression
	 *
	 * @return True if typecheck OK, false otherwise.
	 */
	private Boolean typeCheck( Expression expression ) {
		if ( !expression.accept( this.expressionChecker ) ) {
			return false;
		}

		return true;
	}

	/**
	 * Dumps the error list to std error.
	 */
	private void dumpErrors() {
		for ( Error error : this.environment.getErrors() ) {
			System.err.println( error.toString() );
		}
	}

	@Override
	@Test
	public void testVarDeclaration() {
		assertTrue( typeCheck( new VarDeclaration( new Ident( "z" ), BooleanType.BOOLEAN ) ) );
		assertFalse( typeCheck( new Add( new Int( 1 ), new Ident( "z" ) ) ) );

		assertTrue( typeCheck( new VarDeclaration( new Ident( "x" ), IntegerType.INTEGER ) ) );
		assertTrue( typeCheck( new Assignment( new Ident( "x" ), new Int( 23 ) ) ) );

		assertFalse( typeCheck( new Assignment( new Ident( "x" ), new Ident( "y" ) ) ) );
		assertEquals( TypeError.TYPE_UNDEFINED, this.environment.getErrors().get( 0 ).getCode() );

		assertFalse(
			typeCheck(
				new Assignment(
					new Ident( "x" ), new Add( new Mul( new Int( 24 ), new Money( .5 ) ), new Ident( "y" ) )
				)
			)
		);
		assertEquals( TypeError.TYPE_UNDEFINED, this.environment.getErrors().get( 0 ).getCode() );

		/*
		 * if ( true ) {
		 * 		x = 24
		 * 		x: boolean
		 * }
		 */
		assertFalse(
			typeCheck(
				new IfThen(
					new Bool( true ),
					new Statements(
						new Assignment( new Ident( "x" ), new Int( 24 ) ),
						new Statements( new VarDeclaration( new Ident( "x" ), BooleanType.BOOLEAN ) )
					)
				)
			)
		);

		assertEquals( TypeError.TYPE_ERROR, this.environment.getErrors().get( 0 ).getCode() );
	}

	@Override
	@Test
	public void testIfThenElse() {
		assertTrue( typeCheck( new IfThen( new Bool( true ), new Statements() ) ) );

		assertFalse( typeCheck( new IfThen( new Int( 1 ), new Statements() ) ) );
		assertEquals( TypeError.TYPE_INVALID, this.environment.getErrors().get( 0 ).getCode() );

		/*
		 * if ( true ) {
		 *		"" x: boolean
		 *		x = 23
		 * }
		 */
		assertFalse(
			typeCheck(
				new IfThen(
					new Bool( true ),
					new Statements(
						new QuestionVar(
							new Str( "" ), new VarDeclaration( new Ident( "x" ), BooleanType.BOOLEAN )
						),
						new Statements(
							new Assignment( new Ident( "x" ), new Int( 23 ) )
						)
					)
				)
			)
		);
		assertEquals( TypeError.TYPE_MISMATCH, this.environment.getErrors().get( 0 ).getCode() );
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
						new QuestionVar(
							new Str( "label" ),
							new VarDeclaration(
								new Ident( "questionVar" ),
								IntegerType.INTEGER
							)
						)
					)
				)
			)
		);
	}

	@Override
	@Test
	public void testQuestionVar() {
		assertTrue(
			typeCheck(
				new QuestionVar(
					new Str( "label" ),
					new VarDeclaration(
						new Ident( "var" ),
						BooleanType.BOOLEAN
					)
				)
			)
		);
	}

	@Override
	@Test
	public void testQuestionComputed() {
		assertTrue(
			typeCheck(
				new QuestionComputed(
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
				new QuestionComputed(
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
