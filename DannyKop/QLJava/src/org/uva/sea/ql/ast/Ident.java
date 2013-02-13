package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;
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
	@Override
	public Type typeOf(SymbolTable st) {
		return st.getTypeForIdentifier(this);
	}
}
