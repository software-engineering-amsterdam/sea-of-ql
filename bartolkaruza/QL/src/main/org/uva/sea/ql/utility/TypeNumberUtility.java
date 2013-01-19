package org.uva.sea.ql.utility;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.grouping.ArithmeticExpr;
import org.uva.sea.ql.ast.expr.grouping.Expr;
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
		return node instanceof ArithmeticExpr;
	}

	public static boolean isNumber(Expr node) {
		return node instanceof Money || node instanceof Int;
	}

	public static boolean isVariableNumber(Ident node) {
		return isNodeNumber(SymbolTable.getInstance().getSymbol(node.getName()).getVariable());
	}
	
	public static boolean isReal(Expr node) {
		if(node instanceof Money) {
			return true;
		} else if(node instanceof ArithmeticExpr) {
			return isReal(node.getLhs()) || node.getRhs() != null ? isReal(node.getRhs()) : false;
		} else if(node instanceof Ident) {
			return isReal(SymbolTable.getInstance().getSymbol(((Ident) node).getName()).getVariable());
		} else {
			return false;
		}
	}
}
