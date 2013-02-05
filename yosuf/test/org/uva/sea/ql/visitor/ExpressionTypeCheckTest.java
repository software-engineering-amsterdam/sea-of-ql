package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.NotEquals;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.util.LogPrinter;

public class ExpressionTypeCheckTest {

	private ExpressionTypeCheck typeCheck;

	private final IntegerValue intValue = new IntegerValue(0);
	private final BooleanValue boolValue = new BooleanValue(true);
	private final StringValue stringValue = new StringValue("someString");

	@Before
	public void setUp() {
		typeCheck = new ExpressionTypeCheck();

		LogPrinter.setDebugOn(true);
	}

	@After
	public void tearDown() {
		LogPrinter.setDebugOn(false);
	}

	@Test
	public void testNestedErroneousExpressions() {
		// one error in each type.
		Add add = new Add(intValue, boolValue);
		Or or = new Or(boolValue, stringValue);
		Multiply multiply = new Multiply(add, or);

		typeCheck.visit(multiply);
		assertErrors(3);
	}

	@Test
	public void testNestedExpressions() {
		And and = new And(boolValue, boolValue);
		Or or = new Or(boolValue, new SmallerThan(intValue, intValue));
		And nestedAnd = new And(or, and);

		typeCheck.visit(nestedAnd);
		assertErrors(0);
	}

	@Test
	public void testVisitAdd() {
		typeCheck.visit(new Add(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Add(boolValue, stringValue));
		assertErrors(2);
	}

	@Test
	public void testVisitIntegerValue() {
		typeCheck.visit(intValue);
		assertErrors(0);
	}

	@Test
	public void testVisitAnd() {
		typeCheck.visit(new And(boolValue, boolValue));
		assertErrors(0);

		typeCheck.visit(new And(intValue, boolValue));
		assertErrors(1);
	}

	@Test
	public void testVisitDivide() {
		typeCheck.visit(new Divide(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Divide(stringValue, boolValue));
		assertErrors(2);
	}

	@Test
	public void testVisitEquals() {
		typeCheck.visit(new Equals(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Equals(stringValue, boolValue));
		assertErrors(2);
	}

	@Test
	public void testVisitGreaterOrEquals() {
		typeCheck.visit(new GreaterOrEquals(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new GreaterOrEquals(stringValue, intValue));
		assertErrors(1);
	}

	@Test
	public void testVisitBooleanValue() {
		typeCheck.visit(boolValue);
		assertErrors(0);
	}

	@Test
	public void testVisitStringValue() {
		typeCheck.visit(stringValue);
		assertErrors(0);
	}

	@Test
	public void testVisitGreaterThan() {
		typeCheck.visit(new GreaterThan(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new GreaterThan(intValue, boolValue));
		assertErrors(1);
	}

	@Test
	public void testVisitIdentifier() {
		typeCheck.visit(new Identifier("someIdentifier"));
		assertErrors(0);
	}

	@Test
	public void testVisitMultiply() {
		typeCheck.visit(new Multiply(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Multiply(boolValue, intValue));
		assertErrors(1);
	}

	@Test
	public void testVisitNegative() {
		typeCheck.visit(new Negative(intValue));
		assertErrors(0);

		typeCheck.visit(new Negative(boolValue));
		assertErrors(1);
	}

	@Test
	public void testVisitNot() {
		typeCheck.visit(new Not(boolValue));
		assertErrors(0);

		typeCheck.visit(new Not(stringValue));
		assertErrors(1);
	}

	@Test
	public void testVisitNotEquals() {
		typeCheck.visit(new NotEquals(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Add(boolValue, stringValue));
		assertErrors(2);
	}

	@Test
	public void testVisitOr() {
		typeCheck.visit(new Or(boolValue, boolValue));
		assertErrors(0);

		typeCheck.visit(new Or(boolValue, stringValue));
		assertErrors(1);
	}

	@Test
	public void testVisitPositive() {
		typeCheck.visit(new Positive(intValue));
		assertErrors(0);

		typeCheck.visit(new Positive(stringValue));
		assertErrors(1);
	}

	@Test
	public void testVisitSmallerOrEquals() {
		typeCheck.visit(new SmallerOrEquals(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new SmallerOrEquals(stringValue, boolValue));
		assertErrors(2);
	}

	@Test
	public void testVisitSmallerThan() {
		typeCheck.visit(new SmallerThan(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new SmallerThan(boolValue, stringValue));
		assertErrors(2);
	}

	@Test
	public void testVisitSubstitute() {
		typeCheck.visit(new Substitute(intValue, intValue));
		assertErrors(0);

		typeCheck.visit(new Substitute(intValue, stringValue));
		assertErrors(1);
	}

	private void assertErrors(final int numberofErrors) {
		assertEquals(numberofErrors, typeCheck.getTypeErrors().size());
	}
}