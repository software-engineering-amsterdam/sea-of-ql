package org.uva.sea.ql.ast;
/**
 * 
 * @author ckonig
 *
 */
public class Ident extends Expr {

	private final String name;
	/**
	 * 
	 * @param name
	 */
	public Ident(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

}
