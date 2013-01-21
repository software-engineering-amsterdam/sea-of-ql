package org.uva.sea.ql.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.test.common.CurrentTest;
import org.uva.sea.ql.validation.ValidationVisitor;
import org.uva.sea.ql.visitor.ASTVisitor;

public class TestValidator extends TestExpressions {
	@Test
	public void TestValidatorVisitor() {
		try {
			Expr e = CurrentTest.parseFile();
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (Exception ex) {
			Assert.fail("Exception occured during test: " + ex.getMessage());
		}
	}
}
