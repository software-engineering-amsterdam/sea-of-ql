package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class NegativeExpression extends UnaryExpression {
	public NegativeExpression(Expression expression) {
		super(expression);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Numeric();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}