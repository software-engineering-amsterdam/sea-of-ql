package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.SymbolTable;

/**
 * Class: Pos
 * @author Danny
 *
 * Pos: positive
 */
public class Pos extends UnaryExpr {
	
	/**
	 * Constructor
	 * @param argument
	 */
	public Pos(Expr argument){
		super(argument); 
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return new IntType();
	}
}
