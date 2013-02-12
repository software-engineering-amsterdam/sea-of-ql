package org.uva.sea.ql.test.visitor.typechecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.logical.AndExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVariable;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.StatementTest;
import org.uva.sea.ql.test.visitor.VisitorTest;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Error;
import org.uva.sea.ql.visitor.typechecker.ExpressionChecker;
import org.uva.sea.ql.visitor.typechecker.StatementChecker;
import org.uva.sea.ql.visitor.typechecker.TypeError;

public class StatementTypeCheckerTest extends VisitorTest<Boolean> implements StatementTest {
	private final StatementChecker statementChecker;
	private final ExpressionChecker expressionChecker;
	private final Environment environment;

	public StatementTypeCheckerTest() {
		super();

		this.environment = new Environment();
		this.expressionChecker = new ExpressionChecker( this.environment );
		this.statementChecker = new StatementChecker( this.environment, this.expressionChecker );
	}

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

	private Boolean typeCheck( Statement statement ) {
		this.environment.getErrors().clear();

		if ( !statement.accept( this.statementChecker ) ) {
			return false;
		}

		return true;
	}

	private Boolean typeCheck( Expression expression ) {
		if ( !expression.accept( this.expressionChecker ) ) {
			return false;
		}

		return true;
	}

	private void dumpErrors() {
		for ( Error error : this.environment.getErrors() ) {
			System.err.println( error.toString() );
		}
	}

	@Override
	@Test
	public void testVarDeclaration() {
		assertTrue( typeCheck( new VarDeclaration( new IdentifierExpression( "z" ), BooleanType.BOOLEAN ) ) );
		assertFalse( typeCheck( new AddExpression( new IntegerLiteral( 1 ), new IdentifierExpression( "z" ) ) ) );

		assertTrue( typeCheck( new VarDeclaration( new IdentifierExpression( "x" ), IntegerType.INTEGER ) ) );
		assertTrue( typeCheck( new Assignment( new IdentifierExpression( "x" ), new IntegerLiteral( 23 ) ) ) );

		assertFalse( typeCheck( new Assignment( new IdentifierExpression( "x" ), new IdentifierExpression( "y" ) ) ) );
		assertEquals( TypeError.TYPE_UNDEFINED, this.environment.getErrors().get( 0 ).getCode() );

		assertFalse(
			typeCheck(
				new Assignment(
					new IdentifierExpression( "x" ), new AddExpression( new MultiplyExpression( new IntegerLiteral( 24 ), new MoneyLiteral( .5 ) ), new IdentifierExpression( "y" ) )
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
					new BooleanLiteral( true ),
					new Statements(
						new Assignment( new IdentifierExpression( "x" ), new IntegerLiteral( 24 ) ),
						new Statements( new VarDeclaration( new IdentifierExpression( "x" ), BooleanType.BOOLEAN ) )
					)
				)
			)
		);

		assertEquals( TypeError.TYPE_ERROR, this.environment.getErrors().get( 0 ).getCode() );
	}

	@Override
	@Test
	public void testIfThen() {
		assertTrue( typeCheck( new IfThen( new BooleanLiteral( true ), new Statements() ) ) );

		assertFalse( typeCheck( new IfThen( new IntegerLiteral( 1 ), new Statements() ) ) );
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
					new BooleanLiteral( true ),
					new Statements(
						new QuestionVariable(
							new StringLiteral( "" ), new VarDeclaration( new IdentifierExpression( "x" ), BooleanType.BOOLEAN )
						),
						new Statements(
							new Assignment( new IdentifierExpression( "x" ), new IntegerLiteral( 23 ) )
						)
					)
				)
			)
		);
		assertEquals( TypeError.TYPE_MISMATCH, this.environment.getErrors().get( 0 ).getCode() );
	}

	@Override
	@Test
	public void testIfThenElse() {
		assertTrue(
			typeCheck(
				new IfThenElse(
					new BooleanLiteral( true ),
					new Statements(), // empty body
					new Statements(
						new IfThen(
							new BooleanLiteral( false ),
							new Statements() // empty body
						)
					)
				)
			)
		);

		assertFalse( typeCheck( new IfThenElse( new IntegerLiteral( 1 ), new Statements(), new Statements() ) ) );
		assertEquals( TypeError.TYPE_INVALID, this.environment.getErrors().get( 0 ).getCode() );

		/*
		 * if ( true ) {
		 *		"" x: boolean
		 *		x = 23
		 * }
		 */
		assertFalse(
			typeCheck(
				new IfThenElse(
					new BooleanLiteral( true ),
					new Statements(
						new QuestionVariable(
							new StringLiteral( "" ), new VarDeclaration( new IdentifierExpression( "x" ), BooleanType.BOOLEAN )
						),
						new Statements(
							new Assignment( new IdentifierExpression( "x" ), new IntegerLiteral( 23 ) )
						)
					),
					new Statements()
				)
			)
		);
		assertEquals( TypeError.TYPE_MISMATCH, this.environment.getErrors().get( 0 ).getCode() );

	}

	@Override
	@Test
	public void testFormDeclaration() {
		assertTrue( typeCheck( new FormDeclaration( "x", new Statements() ) ) );
		assertTrue(
			typeCheck(
				new FormDeclaration(
					"formVar",
					new Statements(
						new QuestionVariable(
							new StringLiteral( "label" ),
							new VarDeclaration(
								new IdentifierExpression( "questionVar" ),
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
	public void testQuestionVariable() {
		assertTrue(
			typeCheck(
				new QuestionVariable(
					new StringLiteral( "label" ),
					new VarDeclaration(
						new IdentifierExpression( "var" ),
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
					new StringLiteral( "label" ),
					new Assignment(
						new IdentifierExpression( "x" ),
						new AddExpression(
							new IntegerLiteral( 6 ),
							new MoneyLiteral( 19.99 )
						)
					)
				)
			)
		);

		assertFalse(
			typeCheck(
				new QuestionComputed(
					new StringLiteral( "label" ),
					new Assignment(
						new IdentifierExpression( "x" ),
						new AddExpression(
							new IdentifierExpression( "y" ), // undefined variable
							new IdentifierExpression( "z" )  // undefined variable
						)
					)
				)
			)
		);
	}

	@Override
	@Test
	public void testAssignment() {
		assertTrue( typeCheck( new Assignment( new IdentifierExpression( "x" ), new IntegerLiteral( 99 ) ) ) );
		assertTrue( typeCheck( new Assignment( new IdentifierExpression( "y" ), new AndExpression( new BooleanLiteral( true ), new BooleanLiteral( false ) ) ) ) );
		assertTrue( typeCheck( new Assignment( new IdentifierExpression( "y" ), new EqualExpression( new StringLiteral( "" ), new StringLiteral( "" ) ) ) ) );

		// variable 'x' is already declared as type Int
		assertFalse( typeCheck( new Assignment( new IdentifierExpression( "x" ), new BooleanLiteral( true ) ) ) );
		// variable 'y' is already declared as type Bool
		assertFalse( typeCheck( new Assignment( new IdentifierExpression( "y" ), new MultiplyExpression( new IdentifierExpression( "x" ), new IntegerLiteral( 4 ) ) ) ) );
	}
}
