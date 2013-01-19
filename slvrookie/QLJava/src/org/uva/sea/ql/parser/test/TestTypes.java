package org.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestTypes {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParser() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ANTLRParser() });
		return parserList;
	}

	public TestTypes(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBoolType() throws ParseError {
		assertEquals(BoolType.class, parser.parseType("boolean").getClass());
	}

	@Test
	public void testMoneyType() throws ParseError {
		assertEquals(MoneyType.class, parser.parseType("money").getClass());
	}

	@Test
	public void testIntType() throws ParseError {
		assertEquals(IntType.class, parser.parseType("int").getClass());
	}

	@Test
	public void testStringType() throws ParseError {
		assertEquals(StringType.class, parser.parseType("string").getClass());
	}

}
