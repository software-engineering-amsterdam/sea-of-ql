package org.uva.sea.ql.visitor.typechecker.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Boolean;
import org.uva.sea.ql.eval.value.Integer;
import org.uva.sea.ql.eval.value.Money;
import org.uva.sea.ql.eval.value.String;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.test.VisitorTest;
import org.uva.sea.ql.visitor.typechecker.TypeChecker;

/**
 * TypeChecker test.
 */
public class TestTypeChecker extends VisitorTest {
	/**
	 * Holds the context for the typechecker.
	 */
	private final Context context;

	/**
	 * Constructs a new TypeChecker test.
	 */
	public TestTypeChecker() {
		super( new TypeChecker() );
		this.context = new Context();
	}

	/**
	 * Runs the typechecker on the given source string.
	 *
	 * @param source
	 *
	 * @return The output value of source.
	 *
	 * @throws ParseError
	 */
	private Value typeCheck( java.lang.String source ) throws ParseError {
		context.getErrors().clear();
		return parser.parse( source ).accept( visitor, context );
	}

	/**
	 * Tests boolean types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testBooleanTypes() throws ParseError {
		assertEquals( Boolean.class, typeCheck( "true" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "false" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "!true" ).getClass() );

		assertEquals( Boolean.class, typeCheck( "true && true && false" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "true && false" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "!true || true" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "true || false" ).getClass() );

		assertEquals( Boolean.class, typeCheck( ".5 < .1" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "23 <= .10" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "\"a\" >= \"\"" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "true == !false" ).getClass() );
		assertEquals( Boolean.class, typeCheck( "false != true" ).getClass() );
	}

	/**
	 * Tests integer types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIntegerTypes() throws ParseError {
		assertEquals( Integer.class, typeCheck( "12" ).getClass() );
		assertEquals( Integer.class, typeCheck( "0" ).getClass() );
		assertEquals( Integer.class, typeCheck( "-3" ).getClass() );
		assertEquals( Integer.class, typeCheck( "+2" ).getClass() );

		assertEquals( Integer.class, typeCheck( "12 + 1" ).getClass() );
		assertEquals( Integer.class, typeCheck( "1 / 12" ).getClass() );
		assertEquals( Integer.class, typeCheck( "9 * 7 + 1" ).getClass() );
		assertEquals( Integer.class, typeCheck( "10 - -2" ).getClass() );
		assertEquals( Integer.class, typeCheck( "12^2" ).getClass() );
	}

	/**
	 * Tests money types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testMoneyTypes() throws ParseError {
		assertEquals( Money.class, typeCheck( ".1" ).getClass() );
		assertEquals( Money.class, typeCheck( "13141.0" ).getClass() );
		assertEquals( Money.class, typeCheck( ".1e+1" ).getClass() );

		assertEquals( Money.class, typeCheck( "12 + .1" ).getClass() );
		assertEquals( Money.class, typeCheck( "7 - .0001" ).getClass() );
		assertEquals( Money.class, typeCheck( ".889e+121 + 7" ).getClass() );
		assertEquals( Money.class, typeCheck( ".5 * .25 ^ .125" ).getClass() );
	}

	/**
	 * Tests string types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testStringTypes() throws ParseError {
		assertEquals( String.class, typeCheck( "\"\"" ).getClass() );
		assertEquals( String.class, typeCheck( "\"yes\"" ).getClass() );
		assertEquals( String.class, typeCheck( "\"this is a string\"" ).getClass() );
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

		typeCheck( "x = 24 * .5 + y ^ 2" );
		assertEquals( "Undefined variable: y", context.getErrors().get( 0 ) );
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
		typeCheck( "if ( true ) { x: boolean \n x = 23 }" );
		assertEquals( "Type mismatch: cannot convert from Boolean to Integer.", context.getErrors().get( 0 ) );
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
