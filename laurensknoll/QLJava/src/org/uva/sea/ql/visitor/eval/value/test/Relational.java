package org.uva.sea.ql.visitor.eval.value.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Bool;
import org.uva.sea.ql.visitor.eval.value.Int;
import org.uva.sea.ql.visitor.eval.value.Money;

public class Relational {

	@Test
	public void bools() {
		AbstractValue boolTrue = new Bool(true);
		AbstractValue boolFalse = new Bool(false);

		assertEquals(new Bool(false), boolTrue.and(boolFalse));
		assertEquals(new Bool(true), boolTrue.and(new Bool(true)));

		assertEquals(new Bool(true), boolTrue.or(boolFalse));
		assertEquals(new Bool(true), boolTrue.or(new Bool(true)));
		assertEquals(new Bool(false), boolFalse.or(new Bool(false)));

		assertEquals(new Bool(false), boolTrue.not());
		assertEquals(new Bool(true), boolFalse.not());
	}

	@Test
	public void ints() {
		AbstractValue zero = new Int(0);
		AbstractValue one = new Int(1);
		AbstractValue ten = new Int(10);

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
	public void moneys() {
		AbstractValue zero = new Money(new BigDecimal("0.00"));
		AbstractValue one = new Money(new BigDecimal("1.00"));
		AbstractValue ten = new Money(new BigDecimal("10.00"));

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
	public void numerics() {
		AbstractValue intZero = new Int(0);
		AbstractValue intOne = new Int(1);
		AbstractValue intTen = new Int(10);

		AbstractValue moneyZero = new Money(new BigDecimal("0.00"));
		AbstractValue moneyOne = new Money(new BigDecimal("1.00"));
		AbstractValue moneyTen = new Money(new BigDecimal("10.00"));

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
