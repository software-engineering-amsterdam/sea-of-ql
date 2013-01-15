package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.Neg;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.Or;

public class TestLogical extends TestExpressions {
	public TestLogical(IParse parser) {
		super(parser);
	}

	@Test
	public void testAnd() throws ParseError {
		new Operation(And.class).testBools();
	}

	@Test
	public void TestAndWithOr() throws ParseError {
		new Operation(And.class).testBools(new Operation(Or.class));
	}

	@Test
	public void testOr() throws ParseError {
		new Operation(Or.class).testBools();
	}

	@Test
	public void TestOrWithAnd() throws ParseError {
		new Operation(Or.class).testBools(new Operation(And.class));
	}

	@Test
	public void testComplexBooleans() throws ParseError {
		new Operation(Or.class).testComplexBools(new Operation(And.class));
		new Operation(And.class).testComplexBools(new Operation(Or.class));
		new Operation(Or.class).testComplexBools(new Operation(Or.class));
		new Operation(And.class).testComplexBools(new Operation(And.class));
	}

	@Test
	public void testBooleanPriorities() throws ParseError {
		new MathOperation(Or.class).testMathOperations(new MathOperation(And.class));
		new MathOperation(And.class).testMathOperations(new MathOperation(Or.class));
	}

	@Test
	public void testNeg() throws ParseError {
		new Operation(Neg.class).testUnary();
	}

	@Test
	public void testNot() throws ParseError {
		new Operation(Not.class).testUnary();
	}

}
