package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.lead.Model;

public class ExpressoinEvaluatorTest {

	private final IntegerValue one = new IntegerValue(1);
	private final IntegerValue two = new IntegerValue(2);

	private final BooleanValue trueVal = new BooleanValue(true);
	private final BooleanValue falseVal = new BooleanValue(false);

	private ExpressionVisitor evaluator;
	private Model model;

	@Before
	public void setUp() {
		model = new Model();
		evaluator = new ExpressionEvaluator(model);
	}

	@Test
	public void testVisitAdd() {
		assertAsInteger(3, evaluator.visit(new Add(one, two)));
	}

	@Test
	public void testVisitDivide() {
		assertAsInteger(2, evaluator.visit(new Divide(two, one)));
	}

	@Test
	public void testVisitMultiply() {
		assertAsInteger(4, evaluator.visit(new Multiply(two, two)));
	}

	@Test
	public void testVisitSubstitute() {
		assertAsInteger(0, evaluator.visit(new Substitute(one, one)));
	}

	@Test
	public void testVisitAnd() {
		assertAsBoolean(true, evaluator.visit(new And(trueVal, trueVal)));
		assertAsBoolean(false, evaluator.visit(new And(trueVal, falseVal)));
		assertAsBoolean(false, evaluator.visit(new And(falseVal, trueVal)));
		assertAsBoolean(false, evaluator.visit(new And(falseVal, falseVal)));
	}

	@Test
	public void testVisitEquals() {
		assertAsBoolean(true, evaluator.visit(new Equals(one, one)));
		assertAsBoolean(false, evaluator.visit(new Equals(one, two)));
	}

	@Test
	public void testVisitGreaterOrEquals() {
		assertAsBoolean(true, evaluator.visit(new GreaterOrEquals(one, one)));
		assertAsBoolean(false, evaluator.visit(new GreaterOrEquals(one, two)));
		assertAsBoolean(true, evaluator.visit(new GreaterOrEquals(two, one)));

	}

	@Test
	public void testVisitGreaterThan() {
		assertAsBoolean(false, evaluator.visit(new GreaterThan(one, one)));
		assertAsBoolean(true, evaluator.visit(new GreaterThan(two, one)));
	}

	@Test
	public void testVisitIdentifier() {
		Identifier identifier = new Identifier("test");
		// model has no reference for this id yet.
		assertNull(identifier.accept(evaluator));

		model.registerComputed(new Computed(new IntegerType(), identifier, one));
		assertEquals(one, identifier.accept(evaluator));
	}

	@Test
	public void testVisitNegative() {
		assertAsInteger(0, evaluator.visit(new Negative(one)));
	}

	@Test
	public void testVisitNot() {
		assertAsBoolean(true, evaluator.visit(new Not(falseVal)));
		assertAsBoolean(false, evaluator.visit(new Not(trueVal)));
	}

	@Test
	public void testVisitNotEquals() {
		assertAsBoolean(false, evaluator.visit(new NotEquals(one, one)));
		assertAsBoolean(true, evaluator.visit(new NotEquals(one, two)));
	}

	@Test
	public void testVisitOr() {
		assertAsBoolean(true, evaluator.visit(new Or(trueVal, trueVal)));
		assertAsBoolean(true, evaluator.visit(new Or(trueVal, falseVal)));
		assertAsBoolean(true, evaluator.visit(new Or(falseVal, trueVal)));
		assertAsBoolean(false, evaluator.visit(new Or(falseVal, falseVal)));
	}

	@Test
	public void testVisitPositive() {
		assertAsInteger(2, evaluator.visit(new Positive(one)));
	}

	@Test
	public void testVisitSmallerOrEquals() {
		assertAsBoolean(true, evaluator.visit(new SmallerOrEquals(one, one)));
		assertAsBoolean(false, evaluator.visit(new SmallerOrEquals(two, one)));
		assertAsBoolean(true, evaluator.visit(new SmallerOrEquals(one, two)));
	}

	@Test
	public void testVisitSmallerThan() {
		assertAsBoolean(true, evaluator.visit(new SmallerThan(one, two)));
		assertAsBoolean(false, evaluator.visit(new SmallerThan(one, one)));
		assertAsBoolean(false, evaluator.visit(new SmallerThan(two, one)));
	}

	@Test
	public void testVisitIntegerValue() {
		assertAsInteger(1, evaluator.visit(one));
		assertAsInteger(2, evaluator.visit(two));
	}

	@Test
	public void testVisitBooleanValue() {
		assertAsBoolean(true, trueVal);
		assertAsBoolean(false, falseVal);
	}

	@Test
	public void testVisitStringValue() {
		StringValue value = evaluator.visit(new StringValue(
				"Software Construction"));

		assertTrue(value instanceof StringValue);
		assertEquals("Software Construction", value.getValue());
	}

	private void assertAsInteger(final int value, final IntegerValue exp) {
		assertEquals(value, exp.getValue());
	}

	private void assertAsBoolean(final boolean value, final BooleanValue exp) {
		assertEquals(value, exp.getValue());
	}
}
