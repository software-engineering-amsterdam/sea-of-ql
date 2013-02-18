package org.uva.sea.ql.visitor.eval.value.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;

public class Arithmetic {

	@Test
	public void ints() {
		AbstractValue zero = new Int(0);
		AbstractValue one = new Int(1);
		AbstractValue ten = new Int(10);

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
	public void moneys() {
		AbstractValue zero = new Money(new BigDecimal("0.00"));
		AbstractValue one = new Money(new BigDecimal("1.00"));
		AbstractValue ten = new Money(new BigDecimal("10.00"));

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
	public void numerics() {
		AbstractValue intZero = new Int(0);
		AbstractValue intOne = new Int(1);
		AbstractValue intTen = new Int(10);

		AbstractValue moneyZero = new Money(new BigDecimal("0.00"));
		AbstractValue moneyOne = new Money(new BigDecimal("1.00"));
		AbstractValue moneyTen = new Money(new BigDecimal("10.00"));

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
