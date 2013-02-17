package org.uva.sea.ql.ast.types.datatypes;

/**
 * Represents a string data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class StringType extends DataType {
	@Override
	public boolean isCompatibleToString() {
		return true;
	}
	
	@Override
	public boolean isAssignableFrom(String input) {
		if ("".equals(input)) {
			return false;
		}
		
		return true;
	}
}
