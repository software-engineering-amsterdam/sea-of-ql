package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class DataTypeTest {
	private IParse parser;

	@Before
	public void setUp() {
		parser = new JACCParser();
	}

	@Test
	public void testString() throws ParseError {
		assertEquals(StringType.class, parser.parse("String").getClass());
		assertEquals(StringType.class, parser.parse(" String").getClass());
		assertEquals(StringType.class, parser.parse("String ").getClass());
		assertEquals(StringType.class, parser.parse(" String \n\n").getClass());

		assertFalse(StringType.class == parser.parse("SString").getClass());
	}

	@Test
	public void testInteger() throws ParseError {
		assertEquals(IntegerType.class, parser.parse("Integer").getClass());
		assertEquals(IntegerType.class, parser.parse(" Integer").getClass());
		assertEquals(IntegerType.class, parser.parse("\n\tInteger").getClass());
		assertEquals(IntegerType.class, parser.parse(" Integer \n\n")
				.getClass());

		assertFalse(IntegerType.class == parser.parse(" Integerr \n\n")
				.getClass());
	}

	@Test
	public void testBoolean() throws ParseError {
		assertEquals(BooleanType.class, parser.parse("Boolean").getClass());
		assertEquals(BooleanType.class, parser.parse(" Boolean").getClass());
		assertEquals(BooleanType.class, parser.parse("\n\tBoolean").getClass());
		assertEquals(BooleanType.class, parser.parse(" Boolean \n\n")
				.getClass());

		assertFalse(BooleanType.class == parser.parse(" BBooleann \n\n")
				.getClass());
	}

	@Test
	public void testMoney() throws ParseError {
		assertEquals(MoneyType.class, parser.parse("Money").getClass());
		assertEquals(MoneyType.class, parser.parse(" Money").getClass());
		assertEquals(MoneyType.class, parser.parse("\n\tMoney").getClass());
		assertEquals(MoneyType.class, parser.parse(" Money \n\n").getClass());

		assertFalse(MoneyType.class == parser.parse(" MMoneyy \n\n").getClass());
	}
}
