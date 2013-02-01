package org.uva.sea.ql.ast.types.datatypes;

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
}
