package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.Expr;

/**
 * Class: Pos
 * @author Danny
 *
 * Pos: positive
 */
public class Pos extends UnaryExpr {
	
	
	public Pos(Expr expr){
		super(expr, "+"); // Test if the + is required here!
	}
}
