package org.uva.sea.ql.ast.expression.operators.numeric;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.operators.UnaryOperator;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;
import org.uva.sea.ql.visitor.ExpressionVisitor;


public class Pos extends UnaryOperator {

	public Pos(Expression operand) {
		super(operand);
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
