package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;
import org.uva.sea.ql.visitor.Visitor;

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
	/**
	 * accept()
	 * @param visitor
	 */
	@Override
	public <T> T accept(Visitor<T> visitor) { 
		return visitor.visit(this);
	}
	@Override
	public Type typeOf(SymbolTable st) {
		return st.getTypeForIdentifier(this);
	}
}
