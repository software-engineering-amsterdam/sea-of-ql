package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
//import org.uva.sea.ql.parser.jacc.JACCParser;
//import org.uva.sea.ql.parser.rats.RatsParser;

@RunWith(Parameterized.class)
public class TestExpressions {
	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> retVal = new ArrayList<Object[]>();
		retVal.add(new Object[] {new ANTLRParser()});
		return retVal;
	}
	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		//assertEquals(parser.parse("5 + 6").getClass(), Add.class);
		//Why is this SUB? 
		//System.out.println(parser.parse("5 + 8 - 3"));
//		System.out.println(parser.parse("form testForm1 { question1 : \"alles goed ? \" boolean " +
//				"question2 : \"Heel goed ? \" boolean " +
//				"question3 : \"Super goed ? \" boolean " + 
//				"question4 : \"Niet goed ? \" boolean }"));
		
		//System.out.println(parser.parse("form testForm1 { question1 : \"alles goed ? \" money( a + b) } "));
		
		System.out.println(parser.parse(
				"form Box1HouseOwning {" +
					"hasSoldHouse: \"Did you sell a house in 2010?\" money(15 + 18) " +
					"hasBoughtHouse: \"Did you by a house in 2010?\" boolean " +
					"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\"" +
					"boolean " +
					"if (hasSoldHouse) {" +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(13 - 5) " +
						"}" +
					"}"));
		
		
		//parser.parse("true");
		
//		assertEquals(parser.parse("a + b").getClass(), Add.class);
//		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
//		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
//		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
//		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
//		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
//		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
//		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	//@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	//@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}


	//@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	//@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
}
