package org.uva.sea.ql.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.test.common.CurrentTest;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorDocumentBuilder;

public class TestHtmlGenerator extends TestExpressions {

	@Test
	public void TestHtmlVisitor() {
		try {
			Expr e = CurrentTest.parseFile();
			Assert.assertTrue(e.getClass().equals(Form.class));
			Form f = (Form) e;
			ASTVisitor html = new VisitorDocumentBuilder(new HTMLDocument());
			html.visit(f);
		} catch (Exception ex) {
			Assert.fail("Exception occured during test: " + ex.getMessage());
		}
	}
}
