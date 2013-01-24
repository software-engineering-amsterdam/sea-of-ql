package org.uva.sea.ql.ast.expression; 
import org.uva.sea.ql.ast.*;

public class And extends Binary{

	public And(Expr lhs, Expr rhs) {
			super(lhs,rhs);
	}
}
