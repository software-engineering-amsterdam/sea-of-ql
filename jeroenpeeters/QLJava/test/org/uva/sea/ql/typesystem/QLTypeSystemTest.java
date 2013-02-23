package org.uva.sea.ql.typesystem;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.DataType;

public class QLTypeSystemTest {

	private QLTypeSystem ts;
	
	@Before
	public void setup(){
		ts = new QLTypeSystem();
	}
	
	@Test
	public void testValidCasts(){
		assertEquals(DataType.INTEGER, ts.cast(DataType.INTEGER, DataType.INTEGER));
		
		assertEquals(DataType.MONEY, ts.cast(DataType.INTEGER, DataType.MONEY));
		assertEquals(DataType.MONEY, ts.cast(DataType.MONEY, DataType.INTEGER));
		assertEquals(DataType.MONEY, ts.cast(DataType.MONEY, DataType.MONEY));
		
		assertEquals(DataType.TEXT, ts.cast(DataType.TEXT, DataType.TEXT));
		assertEquals(DataType.TEXT, ts.cast(DataType.TEXT, DataType.INTEGER));
		assertEquals(DataType.TEXT, ts.cast(DataType.INTEGER, DataType.TEXT));
		
		assertEquals(DataType.BOOLEAN, ts.cast(DataType.BOOLEAN, DataType.BOOLEAN));
	}
	
	@Test
	public void testInValidCasts(){
		assertEquals(null, ts.cast(DataType.INTEGER, DataType.BOOLEAN));
		assertEquals(null, ts.cast(DataType.TEXT, DataType.BOOLEAN));
		assertEquals(null, ts.cast(DataType.MONEY, DataType.BOOLEAN));
		
	}

}
