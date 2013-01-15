package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.Str;

public class TestFields extends TestExpressions {
	public TestFields(IParse parser) {
		super(parser);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(CurrentTest.parse("a").getClass(), Ident.class);
		assertEquals(CurrentTest.parse("abc").getClass(), Ident.class);
		assertEquals(CurrentTest.parse("ABC").getClass(), Ident.class);
		assertEquals(CurrentTest.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(CurrentTest.parse("abc2323").getClass(),
				Ident.class);
		assertEquals(CurrentTest.parse("a2bc232").getClass(),
				Ident.class);
		assertEquals(CurrentTest.parse("a2bc232aa").getClass(),
				Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(CurrentTest.parse("0").getClass(), Int.class);
		assertEquals(CurrentTest.parse("1223").getClass(), Int.class);
		assertEquals(CurrentTest.parse("234234234").getClass(),
				Int.class);
	}

	@Test
	public void testString() throws ParseError {
		assertEquals(CurrentTest.parse("\"a\"").getClass(), Str.class);
		assertEquals(CurrentTest.parse("\"1223\"").getClass(), Str.class);
		assertEquals(CurrentTest.parse("\"234234234\"").getClass(),
				Str.class);
		assertEquals(CurrentTest.parse("\"a\"").getClass(), Str.class);
		assertEquals(CurrentTest.parse("\"abc\"").getClass(), Str.class);
		assertEquals(CurrentTest.parse("\"ABC\"").getClass(), Str.class);
		assertEquals(CurrentTest.parse("\"ABCDEF\"").getClass(),
				Str.class);
		assertEquals(CurrentTest.parse("\"abc2323\"").getClass(),
				Str.class);
		assertEquals(CurrentTest.parse("\"a2bc232\"").getClass(),
				Str.class);
		assertEquals(CurrentTest.parse("\"a2bc232aa\"").getClass(),
				Str.class);
	}

	@Test
	public void testExample() throws ParseError {
		String example = "form Box1HouseOwning {"
				+ " hasSoldHouse: “Did you sell a house in 2010?” boolean"
				+ "hasBoughtHouse: “Did you buy a house in 2010?” boolean"
				+ " hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?” boolean"
				+ " if (hasSoldHouse) {"
				+ "    sellingPrice: “Price the house was sold for:” money"
				+ "   privateDebt: “Private debts for the sold house:” money"
				+ "     valueResidue: “Value residue:” money(sellingPrice - privateDebt)"
				+ " }" + "}";
		Expr e = CurrentTest.parse(example);
		assertEquals(Ident.class, e.getClass());
		fail("inconclusive");
	}
}
