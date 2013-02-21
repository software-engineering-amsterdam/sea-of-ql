package org.uva.sea.ql.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.StatementTest;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.statement.VariableQuestion;

public class StatementParserTest extends ParserTest implements StatementTest {
	private final Parser parser;

	public StatementParserTest() {
		super();
		this.parser = this.getParser();
	}

	private void assertNode( Class<?> expected, String source ) {
		Statement root;

		try {
			root = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			fail( e.getMessage() );
			return ;
		}

		assertEquals( expected, root.getClass() );
	}

	private void assertVarDeclaration( String source ) {
		source = "\"\" " + source;
		Statement root;

		try {
			root = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			fail( e.getMessage() );
			return;
		}

		assertEquals( VariableQuestion.class, root.getClass() );
		assertEquals( VariableDeclaration.class, ( (VariableQuestion) root ).getVarDeclaration().getClass() );
	}

	@Test
	@Override
	public void testIfThen() {
		// literal conditions
		assertNode( IfThen.class, "if ( true ) { }" );
		assertNode( IfThen.class, "if ( false ) { }" );
		assertNode( IfThen.class, "if ( 1 ) { }" );
		assertNode( IfThen.class, "if ( \"str\" ) { }" );
		assertNode( IfThen.class, "if ( 131.5e-02 ) { }" );

		// comparison conditions
		assertNode( IfThen.class, "if ( a == b ) { }" );
		assertNode( IfThen.class, "if ( a != b ) { }" );
		assertNode( IfThen.class, "if ( a >= b ) { }" );
		assertNode( IfThen.class, "if ( a > b ) { }" );
		assertNode( IfThen.class, "if ( a < b ) { }" );
		assertNode( IfThen.class, "if ( a <= b && c ) { }" );

		// arithmetic conditions
		assertNode( IfThen.class, "if ( 12 + 123 - 1 ) { }" );
		assertNode( IfThen.class, "if ( 0 - 121 + .5 ) { }" );
		assertNode( IfThen.class, "if ( 3 * 55 ) { }" );
		assertNode( IfThen.class, "if ( 100 / 2 ) { }" );

		// logical conditions
		assertNode( IfThen.class, "if ( true && false ) { }" );
		assertNode( IfThen.class, "if ( a || b ) { }" );
		assertNode( IfThen.class, "if ( b && c ) { }" );
		assertNode( IfThen.class, "if ( a && b || c ) { }" );

		// unary numerical conditions
		assertNode( IfThen.class, "if ( +22 ) { }" );
		assertNode( IfThen.class, "if ( -22 ) { }" );
		assertNode( IfThen.class, "if ( --9 ) { }" );

		// unary logical conditions
		assertNode( IfThen.class, "if ( !a ) { }" );
		assertNode( IfThen.class, "if ( b && !a ) { }" );

		// nested IFs
		assertNode( IfThen.class, "if ( true ) { if ( false ) { } }" );
	}

	@Test
	@Override
	public void testIfThenElse() {
		// nested if
		assertNode( IfThenElse.class, "if ( true ) { } else if ( true ) { if ( false ) { } }" );

		// else variant
		assertNode( IfThenElse.class, "if ( true ) { } else { }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else { }" );
		assertNode( IfThenElse.class, "if ( true ) { } else { \"\" c: boolean }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else { \"\" c: boolean }" );

		// else-if variant
		assertNode( IfThenElse.class, "if ( true ) { } else if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( true ) { } else if ( false ) { \"\" c: boolean }" );
		assertNode( IfThenElse.class, "if ( true ) { \"\" c: boolean } else if ( false ) { \"\" c : boolean }" );

		// multiple else-if variant
		assertNode(
			IfThenElse.class, "if ( true ) { } else if ( false ) { } else if ( true && false ) { } else { }"
		);
	}

	@Test
	@Override
	public void testFormDeclaration() {
		assertNode( FormDeclaration.class, "form ThisForm {\t\"What?\" answer : boolean}" );
		assertNode( FormDeclaration.class, "form frm { if ( false ) {} }" );
		assertNode( FormDeclaration.class, "form f { if ( ident ) { } else if ( true ) { } else { } }" );
	}

	@Test
	@Override
	public void testAssignment() {
		assertNode( Assignment.class, "var = true" );
		assertNode( Assignment.class, "var = 1 + 45" );
		assertNode( Assignment.class, "var = 102 * 45 + .5e+3" );
	}

	@Test
	@Override
	public void testVarDeclaration() {
		assertVarDeclaration( "var: boolean" );
		assertVarDeclaration( "x : integer" );
		assertVarDeclaration( "y : money" );
		assertVarDeclaration( "str: string" );
	}

	@Test
	@Override
	public void testQuestionVariable() {
		assertNode( VariableQuestion.class, "\"What?\" answer: boolean" );
	}

	@Test
	@Override
	public void testQuestionComputed() {
		assertNode( ComputedQuestion.class, "\"This is the question?\" answer = (a && !b)" );
		assertNode( ComputedQuestion.class, "\"\" answer = 1 + answer2" );
	}
}
