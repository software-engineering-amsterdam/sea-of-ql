package org.uva.sea.ql.ast.expressions.binaryExpressions;

import java.util.Map;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.semanticCheck.ExprVisitor;

public class And extends ABinaryExpr {

	public And(AExpr lhs, AExpr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new BoolType();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}