package org.uva.sea.ql.visitor.eval.value.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.visitor.eval.value.Bool;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;

public class Logical {

	@Test
	public void testBools() {
		Bool boolTrue = new Bool(true);
		Bool boolFalse = new Bool(false);

		assertEquals(new Bool(false), boolTrue.eq(boolFalse));
		assertEquals(new Bool(true), boolTrue.eq(new Bool(true)));

		assertEquals(new Bool(false), boolTrue.neq(new Bool(true)));
		assertEquals(new Bool(true), boolTrue.neq(boolFalse));

		assertEquals(new Bool(false), boolTrue.and(boolFalse));
		assertEquals(new Bool(true), boolTrue.and(new Bool(true)));

		assertEquals(new Bool(true), boolTrue.or(boolFalse));
		assertEquals(new Bool(true), boolTrue.or(new Bool(true)));
		assertEquals(new Bool(false), boolFalse.or(new Bool(false)));

		assertEquals(new Bool(false), boolTrue.not());
		assertEquals(new Bool(true), boolFalse.not());
	}

	@Test
	public void testInts() {
		Int zero = new Int(0);
		Int one = new Int(1);
		Int ten = new Int(10);

		assertEquals(new Bool(false), ten.eq(zero));
		assertEquals(new Bool(true), one.eq(new Int(1)));

		assertEquals(new Bool(false), ten.neq(new Int(10)));
		assertEquals(new Bool(true), zero.neq(one));

		assertEquals(new Bool(false), one.geq(ten));
		assertEquals(new Bool(true), one.geq(one));
		assertEquals(new Bool(true), ten.geq(zero));

		assertEquals(new Bool(true), one.leq(ten));
		assertEquals(new Bool(true), one.leq(one));
		assertEquals(new Bool(false), ten.leq(zero));

		assertEquals(new Bool(true), one.lt(ten));
		assertEquals(new Bool(false), one.lt(one));
		assertEquals(new Bool(false), ten.lt(zero));

		assertEquals(new Bool(false), one.gt(ten));
		assertEquals(new Bool(false), one.gt(one));
		assertEquals(new Bool(true), ten.gt(zero));
	}

	@Test
	public void testMoneys() {
		Money zero = new Money(new BigDecimal("0.00"));
		Money one = new Money(new BigDecimal("1.00"));
		Money ten = new Money(new BigDecimal("10.00"));

		assertEquals(new Bool(false), ten.eq(zero));
		assertEquals(new Bool(true), one.eq(new Money(new BigDecimal("1.00"))));

		assertEquals(new Bool(false),
				ten.neq(new Money(new BigDecimal("10.00"))));
		assertEquals(new Bool(true), zero.neq(one));

		assertEquals(new Bool(false), one.geq(ten));
		assertEquals(new Bool(true), one.geq(one));
		assertEquals(new Bool(true), ten.geq(zero));

		assertEquals(new Bool(true), one.leq(ten));
		assertEquals(new Bool(true), one.leq(one));
		assertEquals(new Bool(false), ten.leq(zero));

		assertEquals(new Bool(true), one.lt(ten));
		assertEquals(new Bool(false), one.lt(one));
		assertEquals(new Bool(false), ten.lt(zero));

		assertEquals(new Bool(false), one.gt(ten));
		assertEquals(new Bool(false), one.gt(one));
		assertEquals(new Bool(true), ten.gt(zero));
	}

	@Test
	public void testNumerics() {
		Int intZero = new Int(0);
		Int intOne = new Int(1);
		Int intTen = new Int(10);

		Money moneyZero = new Money(new BigDecimal("0.00"));
		Money moneyOne = new Money(new BigDecimal("1.00"));
		Money moneyTen = new Money(new BigDecimal("10.00"));

		assertEquals(new Bool(false), intTen.eq(moneyZero));
		assertEquals(new Bool(true), intOne.eq(moneyOne));
		assertEquals(new Bool(false), moneyZero.eq(intTen));
		assertEquals(new Bool(true), moneyOne.eq(intOne));

		assertEquals(new Bool(false), intTen.neq(moneyTen));
		assertEquals(new Bool(true), intZero.neq(moneyOne));
		assertEquals(new Bool(false), moneyTen.neq(intTen));
		assertEquals(new Bool(true), moneyOne.neq(intZero));

		assertEquals(new Bool(false), intOne.geq(moneyTen));
		assertEquals(new Bool(true), intOne.geq(moneyOne));
		assertEquals(new Bool(true), intTen.geq(moneyZero));
		assertEquals(new Bool(false), moneyOne.geq(intTen));
		assertEquals(new Bool(true), moneyOne.geq(intOne));
		assertEquals(new Bool(true), moneyTen.geq(intZero));

		assertEquals(new Bool(true), intOne.leq(moneyTen));
		assertEquals(new Bool(true), intOne.leq(moneyOne));
		assertEquals(new Bool(false), intTen.leq(moneyZero));
		assertEquals(new Bool(true), moneyOne.leq(intTen));
		assertEquals(new Bool(true), moneyOne.leq(intOne));
		assertEquals(new Bool(false), moneyTen.leq(intZero));

		assertEquals(new Bool(true), intOne.lt(moneyTen));
		assertEquals(new Bool(false), intOne.lt(moneyOne));
		assertEquals(new Bool(false), intTen.lt(moneyZero));
		assertEquals(new Bool(true), moneyOne.lt(intTen));
		assertEquals(new Bool(false), moneyOne.lt(intOne));
		assertEquals(new Bool(false), moneyTen.lt(intZero));

		assertEquals(new Bool(false), intOne.gt(moneyTen));
		assertEquals(new Bool(false), intOne.gt(moneyOne));
		assertEquals(new Bool(true), intTen.gt(moneyZero));
		assertEquals(new Bool(false), moneyOne.gt(intTen));
		assertEquals(new Bool(false), moneyOne.gt(intOne));
		assertEquals(new Bool(true), moneyTen.gt(intZero));
	}
}
