package org.uva.sea.ql.ast.statements;

import java.util.HashMap;

import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

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

	public Type getExpressionType(
			HashMap<String, Statement> symbolMap) {
		return expression.typeOf(symbolMap);
	}

	public Statement getFalseCompound() {
		return falseCompound;
	}

	public Statement getTrueCompound() {
		return trueCompound;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
