package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Div extends BinaryExpr{

	  private final Expr lhs;
      private final Expr rhs;
      public Div(Expr lhs, Expr rhs) {
    	  super(lhs,rhs);
         this.lhs = lhs;
         this.rhs = rhs;
}
      public Expr getLhs() {
         return lhs;
}
      public Expr getRhs() {
         return rhs;
}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
