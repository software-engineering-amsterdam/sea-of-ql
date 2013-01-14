package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.QuestionElement;
import org.uva.sea.ql.ast.Stmt;
import org.uva.sea.ql.ast.expr.Expr;

public class PrintVisitor implements NodeVisitor {

	@Override
	public void visit(Form node) {
		System.out.println("Form name: " + node.getLabel());
	}

	@Override
	public void visit(Ident node) {
		// Empty by design, handled by non-terminals
	}

	@Override
	public void visit(Int node) {
		// Empty by design, handled by non-terminals
	}

	@Override
	public void visit(Expr expr) {
		System.out.println("Expression");
	}

	@Override
	public void visit(QuestionElement node) {
		System.out.println("QuestionElement");
	}

	@Override
	public void visit(Stmt node) {
		System.out.println("Statement");
	}

}
