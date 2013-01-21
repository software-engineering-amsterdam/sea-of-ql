package org.uva.sea.ql.typeutil;

import org.uva.sea.ql.ast.expr.grouping.BooleanExpr;
import org.uva.sea.ql.ast.expr.grouping.EqualityExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.symbol.SymbolTable;

public class BooleanUtility {

	public static boolean areNodesBoolean(Expr node) {
		return isNodeBoolean(node.getLhs()) && (node.getRhs() == null || isNodeBoolean(node.getRhs()));
	}

	public static boolean isNodeBoolean(Expr node) {
		return isBool(node) || isBooleanExpression(node) || (node instanceof Ident && isVariableBoolean((Ident) node));
	}

	public static boolean isBooleanExpression(Expr expression) {
		return expression instanceof BooleanExpr || expression instanceof EqualityExpr;
	}

	public static boolean isBool(Expr expr) {
		return expr instanceof Bool;
	}

	public static boolean isVariableBoolean(Ident node) {
		return isNodeBoolean(SymbolTable.getInstance().getSymbol(node.getName()).getVariable());
	}

}
