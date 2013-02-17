package org.uva.sea.ql.ast.traversal.typechecking;

import java.util.*;

import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Stores labels from the grammar with their result types. References to these labels their value could be used (e.g. in
 * a computation)
 * 
 * @author J. Dijkstra
 */
public class SymbolTable {
	/**
	 * Map that stores idents and the type they should result to.
	 */
	private final Map<Ident, DataType> types = new HashMap<Ident, DataType>();

	/**
	 * Constructor that limits scope to the current package.
	 */
	protected SymbolTable() {
	}

	/**
	 * Retrieve the data type for a declared identifier.
	 * 
	 * @param ident
	 *            identifier to retrieve the data type for
	 * @return data type
	 */
	public DataType get(final Ident ident) {
		return types.get(ident);
	}

	/**
	 * Add a declared identifier to the symbol table.
	 * 
	 * @param ident
	 *            identifier
	 * @param dataType
	 *            data type
	 */
	public void add(final Ident ident, final DataType dataType) {
		types.put(ident, dataType);
	}
	
	public DataType getDataTypeByName(final String identName) {
		for (Map.Entry<Ident, DataType> entry : types.entrySet()) {
			if (entry.getKey().getName().equals(identName)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	public boolean containsIdentName(final String identName) {
		for (Map.Entry<Ident, DataType> entry : types.entrySet()) {
			if (entry.getKey().getName().equals(identName)) {
				return true;
			}
		}
		
		return false;
	}
}
