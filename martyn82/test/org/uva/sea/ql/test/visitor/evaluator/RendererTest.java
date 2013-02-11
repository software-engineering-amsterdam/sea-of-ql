package org.uva.sea.ql.test.visitor.evaluator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
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
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.test.IStatementTest;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.swing.SwingControlFactory;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Renderer;

public class RendererTest extends EvaluatorTest implements IStatementTest {
	private final ControlFactory factory;

	public RendererTest() {
		super( new Environment() );
		this.factory = new SwingControlFactory();
	}

	private void eval( Statement statement ) {
		Renderer.render( statement, this.environment, this.factory );
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
			new IfThen(
				new Bool( true ),
				new Statements(
					new Assignment(
						new Ident( "x" ),
						new Int( 1 )
					)
				)
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
				new Statements(
					new IfThen(
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
				new Statements(
					new IfThenElse(
						new Eq( new Bool( true ), new Bool( false ) ),
						new Statements(
							new Assignment(
								new Ident( "x" ),
								new Int( 4 )
							)
						),
						new Statements(
							new Assignment(
								new Ident( "x" ),
								new Int( 10 )
							)
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
		eval( new FormDeclaration( "form1", new Statements() ) );
	}

	@Override
	@Test
	public void testVarDeclaration() {
		eval( new VarDeclaration( new Ident( "x" ), BooleanType.BOOLEAN ) );
		assertEquals( false, eval( new Ident( "x" ) ) );

		eval( new VarDeclaration( new Ident( "y" ), IntegerType.INTEGER ) );
		assertEquals( 0, eval( new Ident( "y" ) ) );

		eval( new VarDeclaration( new Ident( "z" ), StringType.STRING ) );
		assertEquals( "", eval( new Ident( "z" ) ) );

		eval( new VarDeclaration( new Ident( "u" ), MoneyType.MONEY ) );
		assertEquals( 0d, eval( new Ident( "u" ) ) );
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
		eval(
			new QuestionVariable( new Str( "Foo bar?" ), new VarDeclaration( new Ident( "x" ), BooleanType.BOOLEAN ) )
		);
		assertEquals( false, eval( new Ident( "x" ) ) );

		eval(
			new QuestionVariable( new Str( "Foo bar?" ), new VarDeclaration( new Ident( "x" ), IntegerType.INTEGER ) )
		);
		assertEquals( 0, eval( new Ident( "x" ) ) );
	}

	@Override
	@Test
	public void testQuestionComputed() {
		eval(
			new QuestionComputed(
				new Str( "Foo Bar?" ),
				new Assignment( new Ident( "y" ), new Eq( new Bool( true ), new Bool( true ) ) ) )
		);
		assertEquals( true, eval( new Ident( "y" ) ) );

		eval(
			new QuestionComputed(
				new Str( "Foo Bar?" ),
				new Assignment( new Ident( "y" ), new Add( new Int( 12 ), new Money( 23.4 ) ) ) )
		);
		assertEquals( 35.4, eval( new Ident( "y" ) ) );
	}
}
