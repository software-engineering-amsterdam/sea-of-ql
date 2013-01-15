package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.base.Ident;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.operators.binary.Add;
import org.uva.sea.ql.ast.operators.binary.GT;
import org.uva.sea.ql.ast.operators.binary.LEq;
import org.uva.sea.ql.ast.operators.binary.LT;
import org.uva.sea.ql.ast.operators.binary.Mul;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions extends TestCase {
	private static final ANTLRParser parser = new ANTLRParser();

	
	@Test
	public void testAdds() throws RecognitionException {
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
	public void testMuls() throws RecognitionException {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws RecognitionException {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws RecognitionException {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws RecognitionException {
		assertEquals(parser.parse("0").getClass(), Int.class);

		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
	@Test
	public void testMoney() throws RecognitionException {
		assertEquals(parser.parse("0.000").getClass(), Money.class);

		assertEquals(parser.parse("1.234").getClass(), Money.class);
		assertEquals(parser.parse("1932.123214141").getClass(), Money.class);
	}
	
	@Test
	public void testSinglelineComments() throws RecognitionException {
		assertNull(parser.parse("// this is a comment\n"));
		assertNull(parser.parse("// this is a comment\r"));
	}
	
	@Test
	public void testMultilineComments() throws RecognitionException {
		assertNull(parser.parse("/* blabla\nhahaha\rqweqweq */"));
	}
	
	@Test
	public void testStringLiterals() throws RecognitionException {
		assertEquals(StringLiteral.class, parser.parse("\"Hello\"").getClass());
		
		// TODO: repair these statements
		/*
		assertEquals("Hello", ((StringLiteral)parser.parse("\"Hello\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((StringLiteral)parser.parse("\"\\\"Hello\\\"\"")).getValue());
		*/
		assertEquals(Ident.class, parser.parse("Hello").getClass());
	}
	
	@Test
	public void testIfElseExpression() throws RecognitionException {
		// TODO: make a different parser for just if statements, fails now as ifs are dependant on forms
		Node result = parser
				.parse("if (\"Hello\") { \"Hello\" } else { \"Hello\" }");
		assertEquals(IfThenElse.class, result.getClass());

		// Invalid else statement
		assertNotSame(IfThenElse.class,
				parser.parse("if (\"Hello\") { \"Hello\" } else \"Hello\"")
						.getClass());
	}
	
	@Test
	public void testIfExpression() throws RecognitionException {
		// TODO: make a different parser for just if statements, fails now as ifs are dependant on forms
		assertEquals(IfThen.class, parser.parse("if (\"Hello\") { \"Hello\" }").getClass());			
	}
	
	@Test
	public void testSimpleForm() throws RecognitionException {
			assertEquals(Form.class, ((ANTLRParser)parser).parseForm(
					"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you buy a house in 2010?\" boolean }").getClass());
	}
	
	@Test
	public void testFormWithIfExpressions() throws RecognitionException {
		
		Form form = (Form)((ANTLRParser)parser).parseForm(
				"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (hasSoldHouse) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}");
		assertEquals(Form.class, ((ANTLRParser)parser).parseForm(
				"form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (hasSoldHouse) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}").getClass());
		System.out.println("form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean\nhasBoughtHouse: \"Did you buy a house in 2010?\" boolean\nif (hasSoldHouse) { sellingPrice: \"Price was sold for:\" money\nprivateDebt: \"Private debts for the sold house:\" money\nvalueResidue: \"Value residue:\" money(sellingPrice - privateDebt) } else { reasonNotSelling: \"Why did you not sell the house?\" string\n }\n age: \"How old are you?\" integer\n\n}");
	}
}
