package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.visitor.SymbolTable;

public class NullType extends Expr {
	/**
	 * Constructor
	 */
	public NullType() {
	}
	public String getValue() {
		return "";
	}
	@Override
	public boolean isCompatibleTo(Expr t) {
		return false;
	}
	@Override
	public Expr getType(SymbolTable st) {
		return this;
	}

}
