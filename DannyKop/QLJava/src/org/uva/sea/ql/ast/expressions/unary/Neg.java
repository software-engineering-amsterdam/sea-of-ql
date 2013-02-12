package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
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
		super(argument);
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}
}
