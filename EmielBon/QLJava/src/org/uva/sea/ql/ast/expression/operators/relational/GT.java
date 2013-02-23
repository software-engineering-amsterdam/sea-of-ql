package org.uva.sea.ql.ast.expression.operators.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class GT extends BinaryOperator {

	public GT(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
	public Type typeOf(TypeEnvironment typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getRepresentation() {
		return ">";
	}
	
}
