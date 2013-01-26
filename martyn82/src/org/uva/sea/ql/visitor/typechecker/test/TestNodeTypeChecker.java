package org.uva.sea.ql.visitor.typechecker.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.eval.Error;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.test.VisitorTest;
import org.uva.sea.ql.visitor.typechecker.ExpressionChecker;
import org.uva.sea.ql.visitor.typechecker.StatementChecker;

/**
 * TypeChecker test.
 */
public class TestNodeTypeChecker extends VisitorTest<Boolean> {
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
	public TestNodeTypeChecker() {
		super();

		this.expressionVisitor = new ExpressionChecker();
		this.statementVisitor = new StatementChecker( this.expressionVisitor );
		this.environment = this.statementVisitor.getEnvironment();
	}

	/**
	 * Type checks the given source program.
	 *
	 * @param source
	 *
	 * @return True if typecheck OK, false otherwise.
	 *
	 * @throws ParseError
	 */
	private Boolean typeCheck( String source ) throws ParseError {
		this.environment.getErrors().clear();
		return this.parser.parse( source ).accept( this.statementVisitor );
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

	/**
	 * Typechecks the given expression.
	 *
	 * @param expression
	 *
	 * @return True if typecheck OK, false otherwise.
	 */
	private Boolean typeCheck( Expression expression ) {
		this.environment.getErrors().clear();
		return expression.accept( this.expressionVisitor );
	}

	/**
	 * Tests boolean types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testBooleanTypes() throws ParseError {
		assertTrue( typeCheck( new Bool( true ) ) );
		assertTrue( typeCheck( new Bool( false ) ) );
		assertTrue( typeCheck( new Not( new Bool( true ) ) ) );

		assertTrue( typeCheck( new And( new Bool( true ), new Bool( false ) ) ) );
		assertTrue( typeCheck( new Or( new Bool( true ), new Bool( false ) ) ) );

		assertTrue( typeCheck( new LT( new Money( .5 ), new Money( .1 ) ) ) );
		assertTrue( typeCheck( new LEq( new Int( 23 ), new Money( .10 ) ) ) );
		assertTrue( typeCheck( new GEq( new Str( "a" ), new Str( "" ) ) ) );
		assertTrue( typeCheck( new Eq( new Bool( true ), new Not( new Bool( false ) ) ) ) );
		assertTrue( typeCheck( new NEq( new Bool( false ), new Bool( true ) ) ) );
	}

	/**
	 * Tests integer types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIntegerTypes() throws ParseError {
		assertTrue( typeCheck( new Int( 12 ) ) );
		assertTrue( typeCheck( new Int( 0 ) ) );
		assertTrue( typeCheck( new Neg( new Int( 3 ) ) ) );
		assertTrue( typeCheck( new Pos( new Int( 2 ) ) ) );

		assertTrue( typeCheck( new Add( new Int( 12 ), new Int( 1 ) ) ) );
		assertTrue( typeCheck( new Div( new Int( 1 ), new Int( 12 ) ) ) );
		assertTrue( typeCheck( new Add( new Mul( new Int( 9 ), new Int( 7 ) ), new Int( 1 ) ) ) );
		assertTrue( typeCheck( new Sub( new Int( 10 ), new Neg( new Int( 2 ) ) ) ) );
	}

	/**
	 * Tests money types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testMoneyTypes() throws ParseError {
		assertTrue( typeCheck( new Money( .1 ) ) );
		assertTrue( typeCheck( new Money( 13141.0 ) ) );
		assertTrue( typeCheck( new Money( .1e+1 ) ) );

		assertTrue( typeCheck( new Add( new Int( 12 ), new Money( .1 ) ) ) );
		assertTrue( typeCheck( new Sub( new Int( 7 ), new Money( .0001 ) ) ) );
		assertTrue( typeCheck( new Add( new Money( .889e+121 ), new Int( 7 ) ) ) );
		assertTrue( typeCheck( new Add( new Mul( new Money( .5 ), new Money( .25 ) ), new Money( .125 ) ) ) );
	}

	/**
	 * Tests string types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testStringTypes() throws ParseError {
		assertTrue( typeCheck( new Str( "" ) ) );
		assertTrue( typeCheck( new Str( "yes" ) )  );
		assertTrue( typeCheck( new Str( "this is a string" ) ) );
	}

	/**
	 * Tests (un)defined variables.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testVariableDefinitions() throws ParseError {
		typeCheck( new Assignment( new Ident( "x" ), new Ident( "y" ) ) );
		assertEquals( "Undefined variable: y", environment.getErrors().get( 0 ).getMessage() );

		typeCheck( new Assignment( new Ident( "x" ), new Add( new Mul( new Int( 24 ), new Money( .5 ) ), new Ident( "y" ) ) ) );
		assertEquals( "Undefined variable: y", environment.getErrors().get( 0 ).getMessage() );

		/*
		 * if ( true ) {
		 * 		x = 24
		 * 		x: boolean
		 * }
		 */
		typeCheck(
			new IfThenElse(
				new Bool( true ),
				new Statements(
					new Assignment( new Ident( "x" ), new Int( 24 ) ),
					new Statements( new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Bool() ) )
				),
				new ElseIfs()
			)
		);

		assertEquals(
			"The variable x is already declared elsewhere.",
			environment.getErrors().get( 0 ).getMessage()
		);
	}

	/**
	 * Tests IF-THEN-ELSE statements.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIfThenElse() throws ParseError {
		typeCheck( new IfThenElse( new Int( 1 ), new Statements(), new ElseIfs() ) );
		assertEquals(
			"Condition of an IF block should evaluate to Boolean.",
			environment.getErrors().get( 0 ).getMessage()
		);
	}

	/**
	 * Tests variable assignment.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testTypeMismatch() throws ParseError {
		/*
		 * if ( true ) {
		 *		"" x: boolean
		 *		x = 23
		 * }
		 */
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
		);
		assertEquals(
			"Type mismatch: cannot convert from Bool to Int.",
			environment.getErrors().get( 0 ).getMessage()
		);
	}

	/**
	 * Tests comparison operators.
	 * They have to compare values of the same (sub)type.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testComparison() throws ParseError {
		typeCheck( new Eq( new Bool( true ), new Bool( false ) ) );
		assertEquals( 0, environment.getErrors().size() );

		typeCheck( new NEq( new Bool( true ), new Not( new Bool( false ) ) ) );
		assertEquals( 0, environment.getErrors().size() );

		typeCheck( new GEq( new Int( 12 ), new Money( .3 ) ) );
		assertEquals( 0, environment.getErrors().size() );

		typeCheck( new NEq( new Int( 12 ), new Bool( true ) ) );
		assertEquals(
			"Both sides of the comparison must be of the same (sub)type.",
			environment.getErrors().get( 0 ).getMessage()
		);

		typeCheck( new NEq( new Str( "" ), new Bool( true ) ) );
		assertEquals(
			"Both sides of the comparison must be of the same (sub)type.",
			environment.getErrors().get( 0 ).getMessage()
		);

		typeCheck( new NEq( new Str( "hello" ), new Str( "world" ) ) );
		assertEquals( 0, environment.getErrors().size() );
	}

	/**
	 * Perform typechecker on the example program string as defined in abstract parent class.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testExample() throws ParseError {
		typeCheck( program );

		if ( environment.getErrors().size() > 0 ) {
			for ( Error error : environment.getErrors() ) {
				System.err.println(
					error.getMessage()
					+ " at "
					+ error.getNode().getClass().getSimpleName()
				);
			}
		}
	}
}
