package org.uva.sea.ql.visitor.typechecker.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.test.VisitorTest;
import org.uva.sea.ql.visitor.typechecker.TypeChecker;

/**
 * TypeChecker test.
 */
public class TestTypeChecker extends VisitorTest<java.lang.Boolean> {
	/**
	 * Holds the context for the typechecker.
	 */
	private Environment context;

	/**
	 * Constructs a new TypeChecker test.
	 */
	public TestTypeChecker() {
		super( new TypeChecker() );
	}

	/**
	 * Runs the typechecker on the given source string.
	 *
	 * @param source
	 *
	 * @return True if typecheck was OK, false otherwise.
	 *
	 * @throws ParseError
	 */
	private java.lang.Boolean typeCheck( java.lang.String source ) throws ParseError {
		context = new Environment();
		return parser.parse( source ).accept( visitor, context );
	}

	/**
	 * Tests boolean types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testBooleanTypes() throws ParseError {
		assertTrue( typeCheck( "true" ) );
		assertTrue( typeCheck( "false" ) );
		assertTrue( typeCheck( "!true" ) );

		assertTrue( typeCheck( "true && true && false" ) );
		assertTrue( typeCheck( "true && false" ) );
		assertTrue( typeCheck( "!true || true" ) );
		assertTrue( typeCheck( "true || false" ) );

		assertTrue( typeCheck( ".5 < .1" ) );
		assertTrue( typeCheck( "23 <= .10" ) );
		assertTrue( typeCheck( "\"a\" >= \"\"" ) );
		assertTrue( typeCheck( "true == !false" ) );
		assertTrue( typeCheck( "false != true" ) );
	}

	/**
	 * Tests integer types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIntegerTypes() throws ParseError {
		assertTrue( typeCheck( "12" ) );
		assertTrue( typeCheck( "0" ) );
		assertTrue( typeCheck( "-3" ) );
		assertTrue( typeCheck( "+2" ) );

		assertTrue( typeCheck( "12 + 1" ) );
		assertTrue( typeCheck( "1 / 12" ) );
		assertTrue( typeCheck( "9 * 7 + 1" ) );
		assertTrue( typeCheck( "10 - -2" ) );
	}

	/**
	 * Tests money types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testMoneyTypes() throws ParseError {
		assertTrue( typeCheck( ".1" ) );
		assertTrue( typeCheck( "13141.0" ) );
		assertTrue( typeCheck( ".1e+1" ) );

		assertTrue( typeCheck( "12 + .1" ) );
		assertTrue( typeCheck( "7 - .0001" ) );
		assertTrue( typeCheck( ".889e+121 + 7" ) );
		assertTrue( typeCheck( ".5 * .25 + .125" ) );
	}

	/**
	 * Tests string types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testStringTypes() throws ParseError {
		assertTrue( typeCheck( "\"\"" ) );
		assertTrue( typeCheck( "\"yes\"" )  );
		assertTrue( typeCheck( "\"this is a string\"" )  );
	}

	/**
	 * Tests (un)defined variables.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testVariableDefinitions() throws ParseError {
		typeCheck( "x = y" );
		assertEquals( "Undefined variable: y", context.getErrors().get( 0 ) );

		typeCheck( "x = 24 * .5 + y" );
		assertEquals( "Undefined variable: y", context.getErrors().get( 0 ) );

		typeCheck( "if ( true ) { x = 24 \n \"\" x: boolean }" );
		assertEquals( "The variable x is already declared elsewhere.", context.getErrors().get( 0 ) );
	}

	/**
	 * Tests IF-THEN-ELSE statements.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIfThenElse() throws ParseError {
		typeCheck( "if ( 1 ) {}" );
		assertEquals( "Condition of an IF block should evaluate to Boolean.", context.getErrors().get( 0 ) );
	}

	/**
	 * Tests variable assignment.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testTypeMismatch() throws ParseError {
		typeCheck( "if ( true ) { \"\" x: boolean \n x = 23 }" );
		assertEquals( "Type mismatch: cannot convert from Bool to Int.", context.getErrors().get( 0 ) );
	}

	/**
	 * Tests comparison operators.
	 * They have to compare values of the same (sub)type.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testComparison() throws ParseError {
		typeCheck( "true == false" );
		assertEquals( 0, context.getErrors().size() );

		typeCheck( "true != !false" );
		assertEquals( 0, context.getErrors().size() );

		typeCheck( "12 >= .3" );
		assertEquals( 0, context.getErrors().size() );

		typeCheck( "12 != true" );
		assertEquals( "Both sides of the comparison must be of the same (sub)type.", context.getErrors().get( 0 ) );

		typeCheck( "\"\" != true" );
		assertEquals( "Both sides of the comparison must be of the same (sub)type.", context.getErrors().get( 0 ) );

		typeCheck( "\"hello\" == \"world\"" );
		assertEquals( 0, context.getErrors().size() );
	}

	/**
	 * Perform typechecker on the example program string as defined in abstract parent class.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testExample() throws ParseError {
		typeCheck( program );

		if ( context.getErrors().size() > 0 ) {
			for ( java.lang.String error : context.getErrors() ) {
				System.err.println( error );
			}
		}
	}
}
