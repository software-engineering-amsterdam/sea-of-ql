package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.util.LogPrinter;

public class ExpressionTypeCheckTest {

	private ExpressionTypeCheck typeCheck;

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
	public void testVisitAdd() {
		Add add = new Add(new IntegerValue(5), new IntegerValue(6));
		typeCheck.visit(add);

		assertEquals(0, typeCheck.getValidationExceptions().size());

		Add erroneous = new Add(new BooleanValue(false),
				new BooleanValue(false));
		typeCheck.visit(erroneous);

		assertEquals(2, typeCheck.getValidationExceptions().size());
		LogPrinter.debugInfo(typeCheck.getValidationExceptions());
	}

	@Test
	public void testVisitIntegerValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitAnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitDivide() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitGreaterOrEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitBooleanValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitStringValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitGreaterThan() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitIdentifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitNegative() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitNot() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitNotEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitOr() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitPositive() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitSmallerOrEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitSmallerThan() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitSubstitute() {
		fail("Not yet implemented");
	}

}
