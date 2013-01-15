package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class ConditionalStatement extends Statement {

	private final Expr expression;
	private final Statement trueCompound;
	private final Statement falseCompound;

	public ConditionalStatement(Expr expr, Statement ctrue, Statement cfalse) {
		expression = expr;
		trueCompound = ctrue;
		falseCompound = cfalse;
	}

	public Expr getExpression() {
		return expression;
	}

	public Statement getFalseCompound() {
		return falseCompound;
	}
	public Statement getTrueCompound() {
		return trueCompound;
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
