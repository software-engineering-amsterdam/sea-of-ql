package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.math.MathOperand;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.CurrentTest;

public class TestAssignments extends TestExpressions {

	@Test
	public void testExampleFile() throws ParseError, IOException {
		Expr e = CurrentTest.parseFile();
		assertNotNull("result was null", e);
		assertEquals(Form.class, e.getClass());
		Form f = (Form) e;
		assertNotNull(f.getBlock());
		assertNotNull(f.getName());
		assertEquals("Box1HouseOwning", f.getName());
		Block b = f.getBlock();
		testBlock(b);
	}

	private void testBlock(Block b) {
		for (Expr line : b.getContent()) {
			Assert.assertTrue(line.getClass().equals(IfStatement.class)
					|| line.getClass().equals(Question.class));
			if (line.getClass().equals(Question.class)) {
				Question q = (Question) line;
				if (q.getIdent().getName().equals("hasSoldHouse")) {
					assertEquals(Bool.class, q.getType().getClass());
				}
				if (q.getIdent().getName().equals("hasBoughtHouse")) {
					assertEquals(Bool.class, q.getType().getClass());
				}
				if (q.getIdent().getName().equals("hasBoughtHouse")) {
					assertEquals(Bool.class, q.getType().getClass());
				}
				if (q.getIdent().getName().equals("taxId")) {
					assertEquals(StrType.class, q.getType().getClass());
				}
				if (q.getIdent().getName().equals("sellingPrice")) {
					assertEquals(Money.class, q.getType().getClass());
					Money m = (Money) q.getType();
					Assert.assertNull(m.getExpr());
				}
				if (q.getIdent().getName().equals("privateDebt")) {
					assertEquals(Money.class, q.getType().getClass());
					Money m = (Money) q.getType();
					Assert.assertNull(m.getExpr());
				}
				if (q.getIdent().getName().equals("valueResidue")) {
					assertEquals(Money.class, q.getType().getClass());
					Money m = (Money) q.getType();
					Assert.assertNotNull(m.getExpr());
					Assert.assertTrue(m.getExpr() instanceof MathOperand);
				}
			}
			if (line.getClass().equals(IfStatement.class)) {
				IfStatement i = (IfStatement) line;
				Assert.assertNotNull(i.getCondition());

				testBlock(i.getContent());
			}
		}
	}

}