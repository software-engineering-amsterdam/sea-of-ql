package org.uva.sea.ql.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVariable;
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

		assertEquals( QuestionVariable.class, root.getClass() );
		assertEquals( VarDeclaration.class, ( (QuestionVariable) root ).getVarDeclaration().getClass() );
	}

	@Override
	@Test
	public void testIfThenElse() {
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

	@Override
	@Test
	public void testQuestionVar() {
		assertNode( QuestionVariable.class, "\"What?\" answer: boolean" );
	}

	@Override
	@Test
	public void testQuestionComputed() {
		assertNode( QuestionComputed.class, "\"This is the question?\" answer = (a && !b)" );
		assertNode( QuestionComputed.class, "\"\" answer = 1 + answer2" );
	}
}
