package org.uva.sea.ql.ast.expressions.unaryExpressions;

import java.util.Map;
import org.uva.sea.ql.ast.types.AType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.semanticCheck.ExprVisitor;

public class Pos extends AUnaryExpr {

	public Pos(AExpr unExpr) {
		super(unExpr);
	}
	
	@Override
	public AType typeOf(Map<Ident, AType> typeEnv) {
		return new IntType();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}