package org.uva.sc.antlr;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClass {
	
	public int multiply(int arg1, int arg2){
		return arg1 * arg2;
	}
	
	
	@Test
	public void testMultiply() {
		MyClass aTester = new MyClass();
		
		assertEquals("Result ", 60, aTester.multiply(10, 5));
	}
}
