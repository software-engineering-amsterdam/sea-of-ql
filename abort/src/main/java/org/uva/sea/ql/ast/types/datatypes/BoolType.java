package org.uva.sea.ql.ast.types.datatypes;

import org.uva.sea.ql.parser.antlr.*;

import antlr.TokenStream;

/**
 * Represents a boolean data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class BoolType extends DataType {
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public boolean isAssignableFrom(final String input) {
		return false;
	}
}
