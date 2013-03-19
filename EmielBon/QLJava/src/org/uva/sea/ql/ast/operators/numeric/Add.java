package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * Represents the numeric addition (+) operator
 */
public class Add extends BinaryOperator {

	public Add(Expression leftOperand, Expression rightOperand) {
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
		return "+";
	}
	
}
