package org.uva.sea.ql.ast.nodes.expressions;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.composite.UnaryExpression;
import org.uva.sea.ql.types.TBool;
import org.uva.sea.ql.types.Type;
/**
 * Computated Boolean Expression
 * Expl: boolean (true && true)
 * 
 * @author Sven Rohde
 */
public class CompBool extends UnaryExpression {
	
	public CompBool(Expr x){
		super(x);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new TBool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
