package org.uva.sea.ql.test.evaluator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.Evaluator;
import org.uva.sea.ql.evaluator.Renderer;
import org.uva.sea.ql.test.IStatementTest;

/**
 * Test statement evaluator.
 */
public class RendererTest implements IStatementTest {
	/**
	 * Holds the expression evaluator.
	 */
	private final Evaluator expressionEvaluator;

	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new statement evaluator test.
	 */
	public RendererTest() {
		this.environment = new Environment();
		this.expressionEvaluator = new Evaluator( this.environment );
	}

	/**
	 * Evaluates the given statement.
	 *
	 * @param statement
	 */
	private void eval( Statement statement ) {
		Renderer.render( statement, this.environment );
	}

	/**
	 * Evaluates the given expression.
	 *
	 * @param expression
	 *
	 * @return The evaluated value.
	 */
	private Object eval( Expression expression ) {
		return expression.accept( this.expressionEvaluator ).getValue();
	}

	@Override
	@Test
	public void testIfThenElse() {
		/*
		 * if ( true ) {
		 * 		x = 1
		 * }
		 */
		eval(
			new IfThenElse(
				new Bool( true ),
				new Statements(
					new Assignment(
						new Ident( "x" ),
						new Int( 1 )
					)
				),
				new ElseIfs()
			)
		);
		assertEquals( 1, eval( new Ident( "x" ) ) ); // x is assigned to be 1

		/*
		 * if ( false ) {
		 * 		x = 1
		 * }
		 * else if ( true ) {
		 * 		x = 2
		 * }
		 */
		eval(
			new IfThenElse(
				new Bool( false ),
				new Statements(
					new Assignment(
						new Ident( "x" ),
						new Int( 1 )
					)
				),
				new ElseIfs(
					new ElseIf(
						new Bool( true ),
						new Statements(
							new Assignment(
								new Ident( "x" ),
								new Int( 2 )
							)
						)
					)
				)
			)
		);
		assertEquals( 2, eval( new Ident( "x" ) ) ); // x is assigned to be 2

		/*
		 * if ( false ) {
		 * 		x = 1
		 * }
		 * else if ( true == false ) {
		 * 		x = 2
		 * }
		 * else {
		 * 		x = 10
		 * }
		 */
		eval(
			new IfThenElse(
				new Bool( false ),
				new Statements(
					new Assignment(
						new Ident( "x" ),
						new Int( 3 )
					)
				),
				new ElseIfs(
					new ElseIf(
						new Eq( new Bool( true ), new Bool( false ) ),
						new Statements(
							new Assignment(
								new Ident( "x" ),
								new Int( 4 )
							)
						)
					)
				),
				new Else(
					new Statements(
						new Assignment(
							new Ident( "x" ),
							new Int( 10 )
						)
					)
				)
			)
		);
		assertEquals( 10, eval( new Ident( "x" ) ) ); // x is assigned to be 10
	}

	@Override
	@Test
	public void testFormDeclaration() {
		// TODO Auto-generated method stub
		fail( "Unimplemented testcase" );
	}

	@Override
	@Test
	public void testVarDeclaration() {
		eval( new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Bool() ) );
		assertEquals( false, eval( new Ident( "x" ) ) );

		eval( new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Int() ) );
		assertEquals( 0, eval( new Ident( "x" ) ) );

		eval( new VarDeclaration( new Ident( "x" ), new org.uva.sea.ql.ast.type.Str() ) );
		assertEquals( "", eval( new Ident( "x" ) ) );

		eval( new VarDeclaration( new Ident( "x" ), new Money() ) );
		assertEquals( 0d, eval( new Ident( "x" ) ) );
	}

	@Override
	@Test
	public void testAssignment() {
		eval( new Assignment( new Ident( "x" ), new Str( "hello world!" ) ) );
		assertEquals( "hello world!", eval( new Ident( "x" ) ) );
	}

	@Override
	@Test
	public void testQuestionVar() {
		// TODO Auto-generated method stub
		fail( "Unimplemented testcase" );
	}

	@Override
	@Test
	public void testQuestionComputed() {
		// TODO Auto-generated method stub
		fail( "Unimplemented testcase" );
	}
}
