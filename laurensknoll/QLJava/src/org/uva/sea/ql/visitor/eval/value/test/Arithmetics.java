package org.uva.sea.ql.visitor.eval.value.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;

public class Arithmetics {

	@Test
	public void testInts() {
		Int zero = new Int(0);
		Int one = new Int(1);
		Int ten = new Int(10);

		assertEquals(new Int(10), ten.add(zero));
		assertEquals(new Int(11), one.add(ten));

		assertEquals(new Int(9), ten.sub(one));
		assertEquals(new Int(-1), zero.sub(one));

		assertEquals(new Int(1), one.mul(one));
		assertEquals(new Int(0), ten.mul(zero));

		// Division by zero defaults to zero.
		assertEquals(new Int(0), ten.div(zero));
		assertEquals(new Int(10), ten.div(one));
		assertEquals(new Int(0), one.div(ten));
	}

	@Test
	public void testMoneys() {
		Money zero = new Money(new BigDecimal("0.00"));
		Money one = new Money(new BigDecimal("1.00"));
		Money ten = new Money(new BigDecimal("10.00"));

		assertEquals(new Money(new BigDecimal("10.00")), ten.add(zero));
		assertEquals(new Money(new BigDecimal("11.00")), one.add(ten));

		assertEquals(new Money(new BigDecimal("9.00")), ten.sub(one));
		assertEquals(new Money(new BigDecimal("-1.00")), zero.sub(one));

		assertEquals(new Money(new BigDecimal("1.00")), one.mul(one));
		assertEquals(new Money(new BigDecimal("0.00")), ten.mul(zero));

		// Division by zero defaults to zero.
		assertEquals(new Money(new BigDecimal("0.00")), ten.div(zero));
		assertEquals(new Money(new BigDecimal("10.00")), ten.div(one));
		assertEquals(new Money(new BigDecimal("0.10")), one.div(ten));
	}

	@Test
	public void testNumerics() {
		Int intZero = new Int(0);
		Int intOne = new Int(1);
		Int intTen = new Int(10);

		Money moneyZero = new Money(new BigDecimal("0.00"));
		Money moneyOne = new Money(new BigDecimal("1.00"));
		Money moneyTen = new Money(new BigDecimal("10.00"));

		assertEquals(new Money(new BigDecimal("10.00")), intTen.add(moneyZero));
		assertEquals(new Money(new BigDecimal("11.00")), intOne.add(moneyTen));

		assertEquals(new Money(new BigDecimal("10.00")), moneyTen.add(intZero));
		assertEquals(new Money(new BigDecimal("11.00")), moneyOne.add(intTen));

		assertEquals(new Money(new BigDecimal("9.00")), intTen.sub(moneyOne));
		assertEquals(new Money(new BigDecimal("-1.00")), intZero.sub(moneyOne));

		assertEquals(new Money(new BigDecimal("9.00")), moneyTen.sub(intOne));
		assertEquals(new Money(new BigDecimal("-1.00")), moneyZero.sub(intOne));

		assertEquals(new Money(new BigDecimal("1.00")), intOne.mul(moneyOne));
		assertEquals(new Money(new BigDecimal("0.00")), intZero.mul(moneyTen));

		assertEquals(new Money(new BigDecimal("1.00")), moneyOne.mul(intOne));
		assertEquals(new Money(new BigDecimal("0.00")), moneyTen.mul(intZero));

		// Division by zero defaults to zero.
		assertEquals(new Money(new BigDecimal("0.00")), intTen.div(moneyZero));
		assertEquals(new Money(new BigDecimal("10.00")), intTen.div(moneyOne));
		assertEquals(new Money(new BigDecimal("0.00")), intOne.div(moneyTen));

		// Division by zero defaults to zero.
		assertEquals(new Money(new BigDecimal("0.00")), moneyTen.div(intZero));
		assertEquals(new Money(new BigDecimal("10.00")), moneyTen.div(intOne));
		assertEquals(new Money(new BigDecimal("0.10")), moneyOne.div(intTen));
	}
}
