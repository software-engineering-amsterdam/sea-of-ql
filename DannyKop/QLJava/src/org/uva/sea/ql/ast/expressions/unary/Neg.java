package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Neg
 * @author Danny
 *
 * Neg: negative
 */
public class Neg extends UnaryExpr {
	/**
	 * Constructor
	 * @param argument
	 */
	public Neg(Expr argument) {
		super(argument, "-");
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return new Int();
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return (t.isCompatibleWithInt() || t.isCompatibleWithMoney());
	}
}
