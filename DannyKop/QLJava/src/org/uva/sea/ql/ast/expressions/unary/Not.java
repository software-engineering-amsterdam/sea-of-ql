package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;

/**
 * Class: Not
 * @author Danny
 * 
 */
public class Not extends UnaryExpr {
	/**
	 * Constructor
	 * @param argument
	 */
	public Not(Expr argument) {
		super(argument);
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new BoolType();
	}
}
