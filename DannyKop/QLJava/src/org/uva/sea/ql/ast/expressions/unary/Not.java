package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.visitor.SymbolTable;

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
		super(argument, "!");
	}
	/**
	 * getType
	 * @param st - the table to check for the type
	 * @return Expr - type
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return new Bool();
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleWithBool();
	}
}
