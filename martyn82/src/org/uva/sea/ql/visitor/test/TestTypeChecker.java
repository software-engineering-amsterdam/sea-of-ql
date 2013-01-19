package org.uva.sea.ql.visitor.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.evaluate.value.Boolean;
import org.uva.sea.ql.evaluate.value.Integer;
import org.uva.sea.ql.evaluate.value.Money;
import org.uva.sea.ql.evaluate.value.String;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.eval.TypeChecker;

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
	 * Tests boolean types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testBooleanTypes() throws ParseError {
		assertEquals( Boolean.class, parser.parse( "true" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "false" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "!true" ).accept( visitor, context ).getClass() );

		assertEquals( Boolean.class, parser.parse( "true && true && false" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "true && false" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "!true || true" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "true || false" ).accept( visitor, context ).getClass() );

		assertEquals( Boolean.class, parser.parse( ".5 < .1" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "23 <= .10" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "\"a\" >= \"\"" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "true == !false" ).accept( visitor, context ).getClass() );
		assertEquals( Boolean.class, parser.parse( "false != true" ).accept( visitor, context ).getClass() );
	}

	/**
	 * Tests integer types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testIntegerTypes() throws ParseError {
		assertEquals( Integer.class, parser.parse( "12" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "0" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "-3" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "+2" ).accept( visitor, context ).getClass() );

		assertEquals( Integer.class, parser.parse( "12 + 1" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "1 / 12" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "9 * 7 + 1" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "10 - -2" ).accept( visitor, context ).getClass() );
		assertEquals( Integer.class, parser.parse( "12^2" ).accept( visitor, context ).getClass() );
	}

	/**
	 * Tests money types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testMoneyTypes() throws ParseError {
		assertEquals( Money.class, parser.parse( ".1" ).accept( visitor, context ).getClass() );
		assertEquals( Money.class, parser.parse( "13141.0" ).accept( visitor, context ).getClass() );
		assertEquals( Money.class, parser.parse( ".1e+1" ).accept( visitor, context ).getClass() );

		assertEquals( Money.class, parser.parse( "12 + .1" ).accept( visitor, context ).getClass() );
		assertEquals( Money.class, parser.parse( "7 - .0001" ).accept( visitor, context ).getClass() );
		assertEquals( Money.class, parser.parse( ".889e+121 + 7" ).accept( visitor, context ).getClass() );
		assertEquals( Money.class, parser.parse( ".5 * .25 ^ .125" ).accept( visitor, context ).getClass() );
	}

	/**
	 * Tests string types.
	 *
	 * @throws ParseError
	 */
	@Test
	public void testStringTypes() throws ParseError {
		assertEquals( String.class, parser.parse( "\"\"" ).accept( visitor, context ).getClass() );
		assertEquals( String.class, parser.parse( "\"yes\"" ).accept( visitor, context ).getClass() );
		assertEquals( String.class, parser.parse( "\"this is a string\"" ).accept( visitor, context ).getClass() );
	}

	@Test
	public void testExample() throws ParseError {
		program = "form Box1HouseOwning {\n" +
				"\t\"Q1\" q1: boolean\n" +
				"\t\"Q2\" q1 = 1 + 1\n" +
			"}\n";

		Context context = new Context();
		INode root = parser.parse( program );
		Value value = root.accept( visitor, context );

		if ( context.getErrors().size() == 0 ) {
			System.out.println( "Output type: " + value.getClass().getSimpleName() );
			System.out.println( "OK" );
		}
		else {
			for ( java.lang.String error : context.getErrors() ) {
				System.err.println( error );
			}
		}
	}
}
