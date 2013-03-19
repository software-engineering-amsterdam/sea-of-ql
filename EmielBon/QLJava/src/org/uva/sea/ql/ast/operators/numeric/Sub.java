package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

/**
 * Represents the numeric subtraction (-) operator
 */
public class Sub extends BinaryOperator {

	public Sub(Expression leftOperand, Expression rightOperand) {
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
		return "-";
	}
	
}
