package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

/**
 * Class: Add
 * @author Danny
 */
public class Add extends BinExpr {

	/**
	 * Constructor
	 * @param result
	 * @param rhs
	 */
	public Add(Expr l, Expr r) {
		super(l, r);
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}
}
