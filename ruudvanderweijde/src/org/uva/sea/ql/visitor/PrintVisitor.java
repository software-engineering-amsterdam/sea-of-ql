package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.stmt.IfElse;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Statement;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Statement statement) {
		if (statement.getClass() == Question.class) {
			System.out.println("Question [" + ((Question) statement).getId() + "]: " + ((Question) statement).getLabel());
		} else if (statement.getClass() == IfThen.class) {
			System.out.println("IfThen (" + ((IfThen) statement).getCondition() + "): " + ((IfThen) statement).getIfBlock());
		} else if (statement.getClass() == IfElse.class) {
			System.out.println("IfElse [" + ((IfElse) statement).getCondition() + "]: " + ((IfThen) statement).getIfBlock());
		}
	}

	@Override
	public void visit(Binary binary) {
		System.out.println("Binary class: " + binary.getClass());
	}

	@Override
	public void visit(Unary unary) {
		System.out.println("Unary class: " + unary.getClass());		
	}

	@Override
	public void visit(Expr expr) {
		System.out.println("Expr class: " + expr.getClass());
		
	}

	@Override
	public void visit(ASTNode node) {
		System.out.println("ASTNode interface");
	}

	@Override
	public void visit(Form form) {
		System.out.println("Form id: " + form.getId());		
	}


}
