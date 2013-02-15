package org.uva.sea.ql.tests.semantic.expression;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.visitor.typeCheck.ExpressionTypeVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

@RunWith(Parameterized.class)
public class TestBinary {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static TypeMapper typeMapper = new TypeMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestBinary(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testAdd() throws ParseError {
		assertTrue(isValidExpression("1 + 1"));
		assertTrue(isValidExpression("12 + 10"));
		assertTrue(isValidExpression("100 + 1 + 1"));
		
		assertFalse(isValidExpression("1 + true"));	
		assertFalse(isValidExpression("true + 10"));	
		assertFalse(isValidExpression("true + true"));	
	}

	@Test
	public void testAnd() throws ParseError {
		assertTrue(isValidExpression("true && true"));
		assertTrue(isValidExpression("true && false"));
		assertTrue(isValidExpression("false && false"));
		assertTrue(isValidExpression("false && false && true"));
		
		assertFalse(isValidExpression("true && 1"));	
		assertFalse(isValidExpression("101 && 102"));	
		assertFalse(isValidExpression("true && true && 1"));	
		assertFalse(isValidExpression("true && 1 && true"));	
	}

	@Test
	public void testDiv() throws ParseError {
		assertTrue(isValidExpression("2 - 1"));
		assertTrue(isValidExpression("2 - 10"));
		assertTrue(isValidExpression("10 - 2 - 1"));
		
		assertFalse(isValidExpression("2 - true"));	
		assertFalse(isValidExpression("true - true"));	
		assertFalse(isValidExpression("2 - 3 - true"));	
	}
	
	@Test
	public void testEq() throws ParseError {
		assertTrue(isValidExpression("1 == 10"));
		assertTrue(isValidExpression("true == true"));
		assertTrue(isValidExpression("false == true"));
		assertTrue(isValidExpression("false == false"));
		assertTrue(isValidExpression("false == (3 > 5)"));
		assertTrue(isValidExpression("3 > 5 == true"));
		assertTrue(isValidExpression("true == (3 > 5)"));
    	
    	assertFalse(isValidExpression("true == 1"));
		assertFalse(isValidExpression("true == 100"));
		assertFalse(isValidExpression("1 == 10 == 4"));
	}
	
	@Test
	public void testGT() throws ParseError {
		assertTrue(isValidExpression("10 > 1"));
		assertTrue(isValidExpression("1 > 121"));
		assertTrue(isValidExpression("102 > 10"));
		
		assertFalse(isValidExpression("10 > true"));	
		assertFalse(isValidExpression("true > true"));	
		assertFalse(isValidExpression("1000 > false"));	
		assertFalse(isValidExpression("false > 1000"));	
	}
	
	@Test
	public void testGEq() throws ParseError {
		assertTrue(isValidExpression("1 >= 3"));
		assertTrue(isValidExpression("1 >= 123"));
		assertTrue(isValidExpression("102 >= 30"));
		
		assertFalse(isValidExpression("1 >= true"));	
		assertFalse(isValidExpression("true >= true"));	
		assertFalse(isValidExpression("1000 >= false"));	
		assertFalse(isValidExpression("false >= 1000"));	
	}
	
	@Test
	public void testLEq() throws ParseError {
		assertTrue(isValidExpression("1 <= 3"));
		assertTrue(isValidExpression("1 <= 123"));
		assertTrue(isValidExpression("102 <= 30"));

		assertFalse(isValidExpression("1 <= true"));	
		assertFalse(isValidExpression("true <= true"));	
		assertFalse(isValidExpression("1000 <= false"));	
		assertFalse(isValidExpression("false <= 1000"));	
	}	
	
	@Test
	public void testLT() throws ParseError {
		assertTrue(isValidExpression("1 < 3"));
		assertTrue(isValidExpression("1 < 123"));
		assertTrue(isValidExpression("102 < 30"));

		assertFalse(isValidExpression("1 < true"));	
		assertFalse(isValidExpression("true < true"));	
		assertFalse(isValidExpression("1000 < false"));	
		assertFalse(isValidExpression("false < 1000"));	
	}
	
	@Test
	public void testMul() throws ParseError {
		assertTrue(isValidExpression("1 * 10"));
		assertTrue(isValidExpression("10 * 10"));
		assertTrue(isValidExpression("10 * 10 * 10"));
		
		assertFalse(isValidExpression("1 * true"));	
		assertFalse(isValidExpression("false * 100"));	
		assertFalse(isValidExpression("false * true"));	
	}	
	
	@Test
	public void testNEq() throws ParseError {
		assertTrue(isValidExpression("true != true"));
		assertTrue(isValidExpression("false != true"));
		assertTrue(isValidExpression("false != false"));
		assertTrue(isValidExpression("3 > 4 != false"));
		assertTrue(isValidExpression("10 != 1"));
		assertTrue(isValidExpression("10 != 1"));
		assertTrue(isValidExpression("10+10 != 1*1"));
		
		assertFalse(isValidExpression("true != 1"));
		assertFalse(isValidExpression("true != 11"));
		assertFalse(isValidExpression("false != 101"));
		assertFalse(isValidExpression("true != true != 11"));
	}
	
	@Test
	public void testOr() throws ParseError {
		assertTrue(isValidExpression("true || false"));
		assertTrue(isValidExpression("true || true"));
		assertTrue(isValidExpression("true || false || true"));
		assertTrue(isValidExpression("100 > 100 || 50 > 50"));
		
		assertFalse(isValidExpression("1 || true"));	
		assertFalse(isValidExpression("100 || true || true"));
		assertFalse(isValidExpression("false || 100 || true"));	
		assertFalse(isValidExpression("false || true || 100"));	
		assertFalse(isValidExpression("100 || false || true || 100"));	
	}
	
	@Test
	public void testSub() throws ParseError {
		assertTrue(isValidExpression("10 / 1"));
		assertTrue(isValidExpression("1120 / 451"));
		assertTrue(isValidExpression("10 / 10 / 10"));
		
		assertFalse(isValidExpression("10 / true"));
		assertFalse(isValidExpression("false / true"));
		assertFalse(isValidExpression("10 / 10 / true"));
	}
	
	private boolean isValidExpression(String expression) throws ParseError {
		return parser.parseExpression(expression).accept(new ExpressionTypeVisitor(typeMapper, errors));
	}
}