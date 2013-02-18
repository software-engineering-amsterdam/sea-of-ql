package org.uva.sea.ql.visitor.eval.value.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Bool;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;

public class Equality {

	@Test
	public void testBools() {
		AbstractValue boolTrue = new Bool(true);
		AbstractValue boolFalse = new Bool(false);

		assertEquals(new Bool(false), boolTrue.eq(boolFalse));
		assertEquals(new Bool(true), boolTrue.eq(new Bool(true)));

		assertEquals(new Bool(false), boolTrue.neq(new Bool(true)));
		assertEquals(new Bool(true), boolTrue.neq(boolFalse));
	}

	@Test
	public void testInts() {
		AbstractValue zero = new Int(0);
		AbstractValue one = new Int(1);
		AbstractValue ten = new Int(10);

		assertEquals(new Bool(false), ten.eq(zero));
		assertEquals(new Bool(true), one.eq(new Int(1)));

		assertEquals(new Bool(false), ten.neq(new Int(10)));
		assertEquals(new Bool(true), zero.neq(one));
	}

	@Test
	public void testMoneys() {
		AbstractValue zero = new Money(new BigDecimal("0.00"));
		AbstractValue one = new Money(new BigDecimal("1.00"));
		AbstractValue ten = new Money(new BigDecimal("10.00"));

		assertEquals(new Bool(false), ten.eq(zero));
		assertEquals(new Bool(true), one.eq(new Money(new BigDecimal("1.00"))));

		assertEquals(new Bool(false),
				ten.neq(new Money(new BigDecimal("10.00"))));
		assertEquals(new Bool(true), zero.neq(one));
	}

	@Test
	public void testNumerics() {
		AbstractValue intZero = new Int(0);
		AbstractValue intOne = new Int(1);
		AbstractValue intTen = new Int(10);

		AbstractValue moneyZero = new Money(new BigDecimal("0.00"));
		AbstractValue moneyOne = new Money(new BigDecimal("1.00"));
		AbstractValue moneyTen = new Money(new BigDecimal("10.00"));

		assertEquals(new Bool(false), intTen.eq(moneyZero));
		assertEquals(new Bool(true), intOne.eq(moneyOne));
		assertEquals(new Bool(false), moneyZero.eq(intTen));
		assertEquals(new Bool(true), moneyOne.eq(intOne));

		assertEquals(new Bool(false), intTen.neq(moneyTen));
		assertEquals(new Bool(true), intZero.neq(moneyOne));
		assertEquals(new Bool(false), moneyTen.neq(intTen));
		assertEquals(new Bool(true), moneyOne.neq(intZero));
	}

}
