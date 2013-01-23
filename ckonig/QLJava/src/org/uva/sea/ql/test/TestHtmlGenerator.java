package org.uva.sea.ql.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.interpreter.html.HTMLVisitor;
import org.uva.sea.ql.test.common.CurrentTest;
import org.uva.sea.ql.visitor.ASTVisitor;

public class TestHtmlGenerator extends TestExpressions {

	@Test
	public void TestHtmlVisitor() {
		try {
			Expr e = CurrentTest.parseFile();
			Assert.assertTrue(e.getClass().equals(Form.class));
			Form f = (Form) e;
			ASTVisitor html = new HTMLVisitor();
			html.visit(f);
		} catch (Exception ex) {
			Assert.fail("Exception occured during test: " + ex.getMessage());
		}
	}
}
