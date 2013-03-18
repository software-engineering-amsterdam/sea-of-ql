package org.uva.sea.ql.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.Value;

public class ValuesTest {

	@Test
	public void testBooleanValue(){
		assertEquals(new BooleanType().getClass(), new BooleanValue(true).getType().getClass());
		
		assertTrue(booleanValue(new BooleanValue(true).and(new BooleanValue(true))));
		assertFalse(booleanValue(new BooleanValue(true).and(new BooleanValue(false))));
		
		assertTrue(booleanValue(new BooleanValue(true).or(new BooleanValue(true))));
		assertTrue(booleanValue(new BooleanValue(true).or(new BooleanValue(false))));
		
		assertFalse(booleanValue(new BooleanValue(true).not()));
	}
	
	@Test
	public void testIntegerValue(){
		assertEquals(new IntegerType().getClass(), new IntegerValue(1).getType().getClass());
		
		assertEquals(5, intValue(new IntegerValue(3).add(new IntegerValue(2))));
		assertEquals(3, intValue(new IntegerValue(6).div(new IntegerValue(2))));
		assertEquals(12, intValue(new IntegerValue(6).mul(new IntegerValue(2))));
		assertEquals(-6, intValue(new IntegerValue(6).neg()));
		assertEquals(-6, intValue(new IntegerValue(-6).pos()));
		assertEquals(4, intValue(new IntegerValue(6).sub(new IntegerValue(2))));
		
		assertTrue(booleanValue(new IntegerValue(6).geq(new IntegerValue(2))));
		assertTrue(booleanValue(new IntegerValue(6).geq(new IntegerValue(6))));
		assertFalse(booleanValue(new IntegerValue(6).geq(new IntegerValue(12))));
			
		assertTrue(booleanValue(new IntegerValue(6).lt(new IntegerValue(12))));
		assertFalse(booleanValue(new IntegerValue(6).lt(new IntegerValue(2))));
		
		assertTrue(booleanValue(new IntegerValue(6).gt(new IntegerValue(2))));
		assertFalse(booleanValue(new IntegerValue(6).gt(new IntegerValue(12))));
		
		assertTrue(booleanValue(new IntegerValue(2).eq(new IntegerValue(2))));
		assertFalse(booleanValue(new IntegerValue(2).eq(new IntegerValue(16))));
		
		assertFalse(booleanValue(new IntegerValue(2).neq(new IntegerValue(2))));
		assertTrue(booleanValue(new IntegerValue(2).neq(new IntegerValue(16))));
	}
	
	@Test
	public void testMoneyValue(){
		assertEquals(new MoneyType().getClass(), new MoneyValue(9.95).getType().getClass());
		
		assertTrue(5 == moneyValue(new MoneyValue(3).add(new MoneyValue(2))));
		assertTrue(5.5 == moneyValue(new MoneyValue(3).add(new MoneyValue(2.5))));
		assertTrue(3 == moneyValue(new MoneyValue(6).div(new MoneyValue(2))));
		assertTrue(12 == moneyValue(new MoneyValue(6).mul(new MoneyValue(2))));
		assertTrue(-6 == moneyValue(new MoneyValue(6).neg()));
		assertTrue(-6 == moneyValue(new MoneyValue(-6).pos()));
		assertTrue(4 == moneyValue(new MoneyValue(6).sub(new MoneyValue(2))));
		
		assertTrue(booleanValue(new MoneyValue(6).geq(new MoneyValue(2))));
		assertTrue(booleanValue(new MoneyValue(6).geq(new MoneyValue(6))));
		assertFalse(booleanValue(new MoneyValue(6).geq(new MoneyValue(12))));
			
		assertTrue(booleanValue(new MoneyValue(6).lt(new MoneyValue(12))));
		assertFalse(booleanValue(new MoneyValue(6).lt(new MoneyValue(2))));
		
		assertTrue(booleanValue(new MoneyValue(6).gt(new MoneyValue(2))));
		assertFalse(booleanValue(new MoneyValue(6).gt(new MoneyValue(12))));
		
		assertTrue(booleanValue(new MoneyValue(2).eq(new MoneyValue(2))));
		assertFalse(booleanValue(new MoneyValue(2).eq(new MoneyValue(16))));
		
		assertFalse(booleanValue(new MoneyValue(2).neq(new MoneyValue(2))));
		assertTrue(booleanValue(new MoneyValue(2).neq(new MoneyValue(16))));
	}
	
	private boolean booleanValue(Value value){
		assertEquals(BooleanValue.class, value.getClass());
		return ((BooleanValue)value).getValue();
	}
	
	private int intValue(Value value){
		assertEquals(IntegerValue.class, value.getClass());
		return ((IntegerValue)value).getValue();
	}
	
	private double moneyValue(Value value){
		assertEquals(MoneyValue.class, value.getClass());
		return ((MoneyValue)value).getValue();
	}

}
