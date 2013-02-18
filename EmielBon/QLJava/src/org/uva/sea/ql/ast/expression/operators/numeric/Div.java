package org.uva.sea.ql.ast.expression.operators.numeric;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Div extends BinaryOperator {

	public Div(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}

	public Type typeOf(TypeEnvironment typeEnv) {
		return new Numeric();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getRepresentation() {
		return "/";
	}
	
}
