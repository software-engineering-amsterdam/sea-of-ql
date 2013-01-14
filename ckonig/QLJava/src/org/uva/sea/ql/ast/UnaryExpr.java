package org.uva.sea.ql.ast;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * 
 * @author ckonig
 *
 */
public class UnaryExpr extends Expr {
	private Expr adjacent;
	/**
	 * 
	 * @param ex
	 */
	public UnaryExpr(Expr ex){
		this.adjacent = ex;
	}
	public Expr getAdjacent(){
		return this.adjacent;
	}
}
