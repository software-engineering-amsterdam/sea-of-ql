package org.uva.sea.ql.ast.types.datatypes;

/**
 * Represents a numeric type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class NumericType extends DataType {
	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}
}
