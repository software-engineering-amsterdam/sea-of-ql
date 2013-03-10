package org.uva.sea.ql.ast.expression.operators.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * Represents the relational inequality (!=) operator
 */
public class NEq extends BinaryOperator {

	public NEq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
	public Type typeOf(TypeEnvironment typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getRepresentation() {
		return "!=";
	}
	
}