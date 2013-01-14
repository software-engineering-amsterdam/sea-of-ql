package org.uva.sea.ql.utility;

import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;

public class TypeUtility {

	public static boolean isValidCondition(Expr expression) {

		if (expression instanceof And || expression instanceof Eq || expression instanceof GEq || expression instanceof GT || expression instanceof LEq
				|| expression instanceof LT || expression instanceof NEq || expression instanceof Not || expression instanceof Or) {
			return true;
		} else {
			return false;
		}
	}

}
