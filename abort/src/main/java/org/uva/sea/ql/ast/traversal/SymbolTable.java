package org.uva.sea.ql.ast.traversal;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.literals.LiteralType;
import org.uva.sea.ql.ast.types.literals.Ident;

/**
 * Stores labels from the grammar with their result types.
 * References to these labels their value could be used (e.g. in a computation)
 * @author J. Dijkstra
 */
public class SymbolTable {
	/**
	 * Map that stores idents and the type they should result to
	 */
	private Map<Ident, DataType> types = new HashMap<Ident, DataType>();
	
	/**
	 * Constructor that limits scope to the current package.
	 */
	protected SymbolTable() { }
	
	/**
	 * Check if the ident is declared in the symbol table.
	 * @param ident ident
	 * @return whether the ident is declared in the symbol table or not
	 */
	public boolean isDeclared(final Ident ident) {
		return types.containsKey(ident);
	}
	
	public DataType get(final Ident ident) {
		return types.get(ident);
	}
	
	public void add(final Ident ident, final DataType dataType) {
		types.put(ident, dataType);
	}
}
