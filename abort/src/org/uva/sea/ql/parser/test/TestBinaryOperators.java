package org.uva.sea.ql.parser.test;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.operators.binary.Add;
import org.uva.sea.ql.ast.operators.binary.And;
import org.uva.sea.ql.ast.operators.binary.Div;
import org.uva.sea.ql.ast.operators.binary.Eq;
import org.uva.sea.ql.ast.operators.binary.GEq;
import org.uva.sea.ql.ast.operators.binary.GT;
import org.uva.sea.ql.ast.operators.binary.LEq;
import org.uva.sea.ql.ast.operators.binary.LT;
import org.uva.sea.ql.ast.operators.binary.Mul;
import org.uva.sea.ql.ast.operators.binary.NEq;
import org.uva.sea.ql.ast.operators.binary.Or;
import org.uva.sea.ql.ast.operators.binary.Sub;

public class TestBinaryOperators extends TestBase {	
	@Test
	public void testAdd() throws RecognitionException {
		Node node = parse("1 + 1").addExpression();
		assertNotNull(node);
		assertEquals(Add.class, node.getClass());

		node = parse("1 + (1 + 20)").addExpression();
		assertNotNull(node);
		assertEquals(Add.class, node.getClass());
		
		node = parse("+ 1 1").addExpression();
		assertFalse(Add.class.equals(node));
	}
	
	@Test	
	public void testAnd() throws RecognitionException {
		Node node = parse("(1 > 0) && (2 > 1)").andExpression();
		assertNotNull(node);
		assertEquals(And.class, node.getClass());

		node = parse("(1 == 1) && (0 == 0)").andExpression();
		assertNotNull(node);
		assertEquals(And.class, node.getClass());
		
		node = parse("(apple == banana) && (1 == 1)").andExpression();
		assertFalse(And.class.equals(node));
		
		node = parse("1 && 1").andExpression();
		assertFalse(And.class.equals(node));

		node = parse("(1 == 1) & (0 == 0)").andExpression();
		assertFalse(And.class.equals(node));
		
		node = parse("&& 1 1").andExpression();
		assertFalse(And.class.equals(node));
	}
	
	@Test
	public void testDiv() throws RecognitionException {
		Node node = parse("1 / 1").mulExpression();
		assertNotNull(node);
		assertEquals(Div.class, node.getClass());

		node = parse("20 / (20 / 2)").mulExpression();
		assertNotNull(node);
		assertEquals(Div.class, node.getClass());
		
		node = parse("/ 20 20").addExpression();
		assertFalse(Add.class.equals(node));				
	}
	
	@Test
	public void testEq() throws RecognitionException {
		Node node = parse("1 == 1").relExpression();
		assertNotNull(node);
		assertEquals(Eq.class, node.getClass());

		node = parse("20 == 10").relExpression();
		assertNotNull(node);
		assertEquals(Eq.class, node.getClass());
		
		node = parse("== 20 20").relExpression();
		assertFalse(Eq.class.equals(node));
	}
	
	@Test
	public void testGEq() throws RecognitionException {
		Node node = parse("1 >= 1").relExpression();
		assertNotNull(node);
		assertEquals(GEq.class, node.getClass());

		node = parse("20 >= 10").relExpression();
		assertNotNull(node);
		assertEquals(GEq.class, node.getClass());
		
		node = parse(">= 20 20").relExpression();
		assertFalse(GEq.class.equals(node));		
	}
	
	@Test
	public void testGT() throws RecognitionException {
		Node node = parse("1 > 1").relExpression();
		assertNotNull(node);
		assertEquals(GT.class, node.getClass());

		node = parse("20 > 10").relExpression();
		assertNotNull(node);
		assertEquals(GT.class, node.getClass());
		
		node = parse("> 20 20").relExpression();
		assertFalse(GT.class.equals(node));			
	}
	
	@Test
	public void testLEq() throws RecognitionException {
		Node node = parse("1 <= 1").relExpression();
		assertNotNull(node);
		assertEquals(LEq.class, node.getClass());

		node = parse("20 <= 10").relExpression();
		assertNotNull(node);
		assertEquals(LEq.class, node.getClass());
		
		node = parse("<= 20 20").relExpression();
		assertFalse(LEq.class.equals(node));			
	}
	
	@Test
	public void testLT() throws RecognitionException {
		Node node = parse("1 < 1").relExpression();
		assertNotNull(node);
		assertEquals(LT.class, node.getClass());

		node = parse("20 < 10").relExpression();
		assertNotNull(node);
		assertEquals(LT.class, node.getClass());
		
		node = parse("< 20 20").relExpression();
		assertFalse(LT.class.equals(node));				
	}
	
	@Test
	public void testMul() throws RecognitionException {
		Node node = parse("1 * 1").mulExpression();
		assertNotNull(node);
		assertEquals(Mul.class, node.getClass());

		node = parse("20 * 10").mulExpression();
		assertNotNull(node);
		assertEquals(Mul.class, node.getClass());
		
		node = parse("* 20 20").mulExpression();
		assertFalse(Mul.class.equals(node));				
	}
	
	@Test
	public void testNEq() throws RecognitionException {
		Node node = parse("1 != 1").relExpression();
		assertNotNull(node);
		assertEquals(NEq.class, node.getClass());

		node = parse("20 != 10").relExpression();
		assertNotNull(node);
		assertEquals(NEq.class, node.getClass());
		
		node = parse("!= 20 20").relExpression();
		assertFalse(NEq.class.equals(node));				
	}
	
	@Test
	public void testOr() throws RecognitionException {
		Node node = parse("(1 > 0) || (1 * 2 > 20)").orExpression();
		assertNotNull(node);
		assertEquals(Or.class, node.getClass());

		node = parse("1 > 2 || 1 < 3").orExpression();
		assertNotNull(node);
		assertEquals(Or.class, node.getClass());
		
		node = parse("20 || 20").orExpression();
		assertFalse(Or.class.equals(node));
		
		node = parse("|| 20 20").orExpression();
		assertFalse(Or.class.equals(node));				
		
		node = parse("(1 > 0) | (20 > 1)").orExpression();
		assertFalse(Or.class.equals(node));				
	}
	
	@Test
	public void testSub() throws RecognitionException {
		Node node = parse("1 - 1").addExpression();
		assertNotNull(node);
		assertEquals(Sub.class, node.getClass());

		node = parse("1 - (1 - 20)").addExpression();
		assertNotNull(node);
		assertEquals(Sub.class, node.getClass());
		
		node = parse("- 1 1").addExpression();
		assertFalse(Sub.class.equals(node));		
	}
}
