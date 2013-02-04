package org.uva.sea.ql.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.IStatementTest;

/**
 * Represents a parser test for statements.
 */
public class StatementParserTest extends ParserTest implements IStatementTest {
	/**
	 * Holds the parser.
	 */
	private final IParser parser;

	/**
	 * Constructs a new statement parser test.
	 */
	public StatementParserTest() {
		super();
		this.parser = this.getParser();
	}

	/**
	 * Shorthand method for asserting a node type.
	 *
	 * @param expected
	 * @param source
	 */
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

	/**
	 * Shorthand method for asserting a VarDeclaration node.
	 *
	 * @param source
	 */
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

		assertEquals( QuestionDeclaration.class, root.getClass() );
		assertEquals( VarDeclaration.class, ( (QuestionDeclaration) root ).getDeclaration().getClass() );
	}

	@Override
	@Test
	public void testIfThenElse() {
		// literal conditions
		assertNode( IfThenElse.class, "if ( true ) { }" );
		assertNode( IfThenElse.class, "if ( false ) { }" );
		assertNode( IfThenElse.class, "if ( 1 ) { }" );
		assertNode( IfThenElse.class, "if ( \"str\" ) { }" );
		assertNode( IfThenElse.class, "if ( 131.5e-02 ) { }" );

		// comparison conditions
		assertNode( IfThenElse.class, "if ( a == b ) { }" );
		assertNode( IfThenElse.class, "if ( a != b ) { }" );
		assertNode( IfThenElse.class, "if ( a >= b ) { }" );
		assertNode( IfThenElse.class, "if ( a > b ) { }" );
		assertNode( IfThenElse.class, "if ( a < b ) { }" );
		assertNode( IfThenElse.class, "if ( a <= b && c ) { }" );

		// arithmetic conditions
		assertNode( IfThenElse.class, "if ( 12 + 123 - 1 ) { }" );
		assertNode( IfThenElse.class, "if ( 0 - 121 + .5 ) { }" );
		assertNode( IfThenElse.class, "if ( 3 * 55 ) { }" );
		assertNode( IfThenElse.class, "if ( 100 / 2 ) { }" );

		// logical conditions
		assertNode( IfThenElse.class, "if ( true && false ) { }" );
		assertNode( IfThenElse.class, "if ( a || b ) { }" );
		assertNode( IfThenElse.class, "if ( b && c ) { }" );
		assertNode( IfThenElse.class, "if ( a && b || c ) { }" );

		// unary numerical conditions
		assertNode( IfThenElse.class, "if ( +22 ) { }" );
		assertNode( IfThenElse.class, "if ( -22 ) { }" );
		assertNode( IfThenElse.class, "if ( --9 ) { }" );

		// unary logical conditions
		assertNode( IfThenElse.class, "if ( !a ) { }" );
		assertNode( IfThenElse.class, "if ( b && !a ) { }" );

		// nested IFs
		assertNode( IfThenElse.class, "if ( true ) { if ( false ) { } }" );
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

	@Override
	@Test
	public void testFormDeclaration() {
		assertNode( FormDeclaration.class, "form ThisForm {\t\"What?\" answer : boolean}" );
		assertNode( FormDeclaration.class, "form frm { if ( false ) {} }" );
		assertNode( FormDeclaration.class, "form f { if ( ident ) { } else if ( true ) { } else { } }" );
	}

	@Override
	@Test
	public void testQuestionDeclaration() {
		assertNode( QuestionDeclaration.class, "\"What?\" answer: boolean" );
		assertNode( QuestionDeclaration.class, "\"This is the question?\" answer = (a && !b)" );
		assertNode( QuestionDeclaration.class, "\"\" answer = 1 + answer2" );
	}

	@Override
	@Test
	public void testAssignment() {
		assertNode( Assignment.class, "var = true" );
		assertNode( Assignment.class, "var = 1 + 45" );
		assertNode( Assignment.class, "var = 102 * 45 + .5e+3" );
	}

	@Override
	@Test
	public void testVarDeclaration() {
		assertVarDeclaration( "var: boolean" );
		assertVarDeclaration( "x : integer" );
		assertVarDeclaration( "y : money" );
		assertVarDeclaration( "str: string" );
	}
}
