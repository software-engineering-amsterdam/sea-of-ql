package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.Expr;
/**
 * Class: Literal<T>
 * @author Danny
 *
 * @param <T>
 */
public abstract class Literal<T> extends Expr {
	/**
	 * getValue
	 * @return T 
	 */
	public abstract T getValue();
}
