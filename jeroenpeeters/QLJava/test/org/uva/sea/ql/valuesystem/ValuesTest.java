package org.uva.sea.ql.valuesystem;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValuesTest {

	@Test
	public void testBooleanValue(){
		
		assertTrue( ((BooleanValue) new BooleanValue(true).and(new BooleanValue(true))).getValue());
		assertFalse( ((BooleanValue) new BooleanValue(true).and(new BooleanValue(false))).getValue());
		
		assertTrue( ((BooleanValue) new BooleanValue(true).or(new BooleanValue(true))).getValue());
		assertTrue( ((BooleanValue) new BooleanValue(true).or(new BooleanValue(false))).getValue());
		
		assertFalse( ((BooleanValue) new BooleanValue(true).not()).getValue());
		
	}
	
	@Test
	public void testIntegerValue(){
		
		assertEquals(5, ((IntegerValue)new IntegerValue(3).add(new IntegerValue(2))).getValue());
	}

}
