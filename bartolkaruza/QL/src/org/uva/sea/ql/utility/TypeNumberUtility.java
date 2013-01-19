package org.uva.sea.ql.utility;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;

public class TypeNumberUtility {

	public static boolean areNodesNumbers(Expr node) {
		return isNodeNumber(node.getLhs()) && (node.getRhs() == null || isNodeNumber(node.getRhs()));
	}

	public static boolean isNodeNumber(Expr node) {
		return isNumber(node) || isNumberExpression(node) || (node instanceof Ident && isVariableNumber((Ident) node));
	}

	public static boolean isNumberExpression(Expr node) {
		return node instanceof Add || node instanceof Sub || node instanceof Pos || node instanceof Neg || node instanceof Div || node instanceof Mul;
	}

	public static boolean isNumber(Expr node) {
		return node instanceof Money || node instanceof Int;
	}

	public static boolean isVariableNumber(Ident node) {
		return isNodeNumber(SymbolTable.getInstance().getSymbol(node.getName()));
	}

}
