package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Neg extends UnaryExpr{
	public static final String str = "-";
	/**
	 * Negative
	 * @param ex
	 */
	public Neg(Expr ex){
		super(ex);
	}
}
