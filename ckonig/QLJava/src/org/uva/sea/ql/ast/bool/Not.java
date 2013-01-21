package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.UnaryExpr;

public class Not extends UnaryExpr {
	public static final String str = "!";

	public Not(Expr ex) {
		super(ex);
	}
}
