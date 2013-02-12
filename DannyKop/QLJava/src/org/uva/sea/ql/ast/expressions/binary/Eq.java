package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Eq
 * @author Danny
 * Eq: == (equal)
 */
public class Eq extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public Eq(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public Type typeOf(SymbolTable st) {
		return new BoolType();
	}

}
