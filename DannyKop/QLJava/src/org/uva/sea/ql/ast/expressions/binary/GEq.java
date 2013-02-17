package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

/**
 * Class: GEq
 * @author Danny
 *
 *GEq:  >= (greater then or equal)
 */
public class GEq extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public GEq(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}

}
