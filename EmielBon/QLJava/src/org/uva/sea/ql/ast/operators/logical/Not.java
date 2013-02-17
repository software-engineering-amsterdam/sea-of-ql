package org.uva.sea.ql.ast.operators.logical;

import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.UnaryOperator;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Not extends UnaryOperator {

	public Not(Expression operand) {
		super(operand);
	}
	
	public Type typeOf(Map<Identifier, Type> typeEnv) {
		return new Bool();
	}

	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String getRepresentation() {
		return "!";
	}
	
}