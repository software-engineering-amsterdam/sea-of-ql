package org.uva.sea.ql.ast.traversal.typechecking.base;

import java.util.Set;

import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Represents a symbol table used for type checking the QL language.
 * 
 * @author J. Dijkstra
 */
public interface ISymbolTable {
	/**
	 * Retrieve data type by an ident name.
	 * 
	 * @param identName
	 *            name of the ident
	 * @return data type
	 */
	DataType getDataTypeByName(String identName);

	/**
	 * Verify whether the symbol table contains a specific ident name.
	 * 
	 * @param identName
	 *            name of the ident
	 * @return whether the symbol table contains a specific ident name or not
	 */
	boolean containsIdentName(String identName);

	/**
	 * Verify whether the input is complete.
	 * 
	 * @param identName
	 *            name of the ident
	 * @return whether the symbol table contains a specific ident name or not
	 */
	boolean isInputIncomplete(Set<String> identNames);

	/**
	 * Add an ident to the symbol table.
	 * 
	 * @param ident
	 *            ident to add
	 * @param dataType
	 *            data type of the ident
	 */
	void add(Ident ident, DataType dataType);

	/**
	 * Retrieve the datatype from the symbol table by its ident.
	 * 
	 * @param ident
	 *            ident to retrieve data type of
	 * @return data type
	 */
	DataType get(Ident ident);
}
