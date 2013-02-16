package org.uva.sea.ql.ast.operators.relational;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.BinaryOperator;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class GEq extends BinaryOperator {

	public GEq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
