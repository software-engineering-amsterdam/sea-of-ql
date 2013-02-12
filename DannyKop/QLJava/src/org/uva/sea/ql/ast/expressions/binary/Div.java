package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Div
 * @author Danny
 *
 */
public class Div extends BinExpr {
	/**
	 * Constructor
	 * @param l left
	 * @param r right
	 */
	public Div(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public Type typeOf(SymbolTable st) {
		// TODO Auto-generated method stub
		return new IntType();
	}
	
}
