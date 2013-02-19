package org.uva.sea.ql.ast.statements;

import java.util.Map;

import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class ConditionalStatement extends Statement {

	private final Expr condStateExpression;
	private final Statement trueCompound;
	private final Statement falseCompound;

	public ConditionalStatement(Expr expr, Statement ctrue, Statement cfalse) {
		condStateExpression = expr;
		trueCompound = ctrue;
		falseCompound = cfalse;
	}

	public Expr getExpression() {
		return condStateExpression;
	}

	public Type getExpressionType(Map<String, Statement> symbolMap) {
		return condStateExpression.typeOf(symbolMap);
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
