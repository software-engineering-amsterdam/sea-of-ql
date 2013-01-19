package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestTypes {

	private IParse parser;


	
	@Parameters
	public static List<Object[]> theParsers() {
		
		List<Object[]> listANTLR=  new ArrayList<Object[]>();
		listANTLR.add(new Object[] {new ANTLRParser()});
		return listANTLR;
			 
	}

	
	public TestTypes(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAllTypes() throws ParseError {
		assertEquals(IntType.class,parser.parseType("int").getClass());
		assertEquals(BoolType.class,parser.parseType("boolean").getClass());
		assertEquals(StringType.class,parser.parseType("string").getClass());
		
	}
	
	
	
}