package org.uva.sea.ql.ast.base;

import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Represents an expression in the AST.
 * 
 * @author J. Dijkstra
 */
public abstract class Expression extends Node {
	/**
	 * Retrieve the type the expression will return (necessary for typechecking).
	 * 
	 * @param symbolTable symbol table to look up the type, in case of an identifier
	 * @return data type we expect
	 */
	public abstract DataType typeOf(final SymbolTable symbolTable);
}
