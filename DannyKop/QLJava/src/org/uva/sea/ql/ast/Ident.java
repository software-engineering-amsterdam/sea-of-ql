package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.SymbolTable;
import org.uva.sea.ql.ast.visitor.Visitor;

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
	public void accept(Visitor visitor) { 
		visitor.visit(this);
	}
	/**
	 * getType
	 * @param st - SymbolTable with data
	 * @return Type of the current Identifier
	 */
	@Override
	public Expr getType(SymbolTable st) {
		return st.getTypeForIdentifier(this);
	}
	/**
	 * isCompatibleTo
	 * @param t type
	 * @return boolean - true if compatible false otherwise
	 */
	@Override
	public boolean isCompatibleTo(Expr t) {
		return t.isCompatibleTo(this);
	}
}
