package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

/**
 * Class: GT
 * @author Danny
 *
 * GT: > (greater then)
 */
public class GT extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public GT(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}

}
