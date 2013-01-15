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
import org.uva.sea.ql.ast.expr.value.Bool;

public class TypeBooleanUtility {

	public static boolean areNodesBoolean(Expr node) {
		return isNodeBoolean(node.getLhs()) && (node.getRhs() == null || isNodeBoolean(node.getRhs()));
	}

	public static boolean isNodeBoolean(Expr node) {
		return isBool(node) || isBooleanExpression(node.getLhs()) || (node instanceof Ident && isVariableBoolean((Ident) node));
	}

	public static boolean isBooleanExpression(Expr expression) {
		return expression instanceof And || expression instanceof Eq || expression instanceof GEq || expression instanceof GT || expression instanceof LEq
				|| expression instanceof LT || expression instanceof NEq || expression instanceof Not || expression instanceof Or;
	}

	public static boolean isBool(Expr expr) {
		return expr instanceof Bool;
	}

	public static boolean isVariableBoolean(Ident node) {
		return isNodeBoolean(SymbolTable.getInstance().getSymbol(node.getName()));
	}

}
