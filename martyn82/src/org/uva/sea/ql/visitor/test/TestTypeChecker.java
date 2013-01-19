package org.uva.sea.ql.visitor.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.visitor.typecheck.TypeChecker;

public class TestTypeChecker extends VisitorTest {
	/**
	 * Constructs a new TypeChecker test.
	 */
	public TestTypeChecker() {
		super( new TypeChecker() );
	}

	@Test
	public void test() throws ParseError {
		program = "if ( 1 ) {}";

		parser.parse( program ).accept( visitor );
	}
}
