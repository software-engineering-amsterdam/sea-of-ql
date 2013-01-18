package org.uva.sea.ql.ast;
/**
 * String
 * @author ckonig
 *
 */
public class Str extends Expr {
	private final String value;
	public Str(String s){
		this.value = s;
	}
	public String getValue(){
		return this.value;
	}
}
