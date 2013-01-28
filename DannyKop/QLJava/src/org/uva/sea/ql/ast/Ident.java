package org.uva.sea.ql.ast;

/**
 * Class: Ident
 * 
 * @author Danny
 *
 * Identifier
 */
public class Ident extends Expr {

	/**
	 * Name of the identifier
	 */
	private final String name;

	/**
	 * Constructor
	 * @param name - name of the identifier
	 */
	public Ident(String name) {
		this.name = name;
	}
	/**
	 * getName()
	 * @return name of the identifier
	 */
	public String getName() {
		return name;
	}
}
