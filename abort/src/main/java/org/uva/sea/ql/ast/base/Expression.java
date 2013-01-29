package org.uva.sea.ql.ast.base;

import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.types.datatypes.DataType;

/**
 * Represents an expression in the AST.
 * 
 * @author J. Dijkstra
 */
public abstract class Expression extends Node {
	public abstract DataType typeOf(final SymbolTable symbolTable);
}
