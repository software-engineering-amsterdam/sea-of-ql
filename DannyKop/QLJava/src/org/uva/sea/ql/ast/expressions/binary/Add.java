package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;
import org.uva.sea.ql.ast.visitor.Visitor;

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
	/**
	 * accept
	 * @param visitor
	 */
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}
}
