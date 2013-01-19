package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.eval.TypeChecker;

public class TestTypeChecker extends VisitorTest {
	/**
	 * Constructs a new TypeChecker test.
	 */
	public TestTypeChecker() {
		super( new TypeChecker() );
	}

	@Test
	public void test() throws ParseError {
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
			for ( String error : context.getErrors() ) {
				System.err.println( error );
			}
		}
	}
}
