package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.QLProgram;

public class TestExpressions extends TestCase {

	static final private IParse parser = new ANTLRParser();

	@Test
	public void testSTMT() throws ParseError {
		String a0 = "form Small { hasSoldHouse: \"Did you sell a house in 2010?\" boolean } ";
		String a1 = "form bigBox1HouseOwning {\n"
				+ "   one: \"Did you sell a house in 2010?\" money ( 10 + 20 )\n"
				+ "   two: \"Did you by a house in 2010?\" boolean\n"
				+ "   three: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n }";
		String a2 = "form bigBox1HouseOwning {\n"
				+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
				+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
				+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"\n"
				+ "boolean\n"
				+ "   if (hasSoldHouse < 10 && 20 > 10) {\n"
				+ "     sellingPrice:    \"Price the house was sold for:\" money\n"
				+ "     privateDebt:   \"Private debts for the sold house:\" money\n"
				+ "     valueResidue: \"Value residue:\" money(sellingPrice + privateDebt + 12)\n"
				+ "   }\n" + "}";
		String s1 = "if (hasSoldHouse < 100 || 10 < 20) {\n"
				+ "     sellingPrice:    \"Price the house was sold for:\" money\n"
				+ "     privateDebt:   \"Private debts for the sold house:\" money\n"
				+ "     valueResidue: \"Value residue:\" money(sellingPrice + privateDebt + 12)\n"
				+ "   }\n" + "}";

		assertEquals(
				parser.stmt(
						"sellingPrice: \"Price the house was sold for:\" money\n")
						.getClass(), LineStatement.class);
		assertEquals(parser.stmt(s1).getClass(), ConditionalStatement.class);
		assertEquals(parser.qlprogram(a0).getClass(), QLProgram.class);
		assertEquals(parser.qlprogram(a1).getClass(), QLProgram.class);
		parser.qlprogram(a2).eval();
	}

	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}

}
