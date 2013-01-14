package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Not extends UnaryExpr{
	public static final String str = "!";
	/**
	 * 
	 * @param ex
	 */
	public Not(Expr ex){
		super(ex);
	}
}
