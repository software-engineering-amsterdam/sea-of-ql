package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.UnaryExpression;

import org.uva.sea.ql.types.TNumeric;
import org.uva.sea.ql.types.Type;
/**
 * Computated Int Expression
 * Expl: integer (2 + 4)
 * @author Sven Rohde
 */
public class CompInt extends UnaryExpression  {
	
	public CompInt(Expr x){
		super(x);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TNumeric();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
