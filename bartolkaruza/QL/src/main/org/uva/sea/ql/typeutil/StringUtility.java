package org.uva.sea.ql.typeutil;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.TextString;
import org.uva.sea.ql.symbol.SymbolTable;

public class StringUtility {

	public static boolean isNodeString(Expr node) {
		if (node instanceof TextString) {
			return true;
		} else if (node instanceof Ident) {
			return isNodeString(SymbolTable.getInstance().getSymbol(((Ident) node).getName()).getVariable());
		} else {
			return false;
		}
	}
}
