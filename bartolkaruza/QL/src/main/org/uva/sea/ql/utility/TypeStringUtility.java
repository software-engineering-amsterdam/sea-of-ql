package org.uva.sea.ql.utility;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.value.TextString;


public class TypeStringUtility {
	
	public static boolean isNodeString(Expr node) {
		if(node instanceof TextString) { 
			return true;
		} else if(node instanceof Ident) {
			return isNodeString(SymbolTable.getInstance().getSymbol(((Ident) node).getName()).getVariable());
		} else {
			return false;
		}	
	}
}
