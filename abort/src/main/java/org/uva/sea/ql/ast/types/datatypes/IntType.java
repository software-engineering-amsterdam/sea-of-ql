package org.uva.sea.ql.ast.types.datatypes;


/**
 * Represents integer data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class IntType extends NumericType {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public boolean isAssignableFrom(String input) {
		try {
			new Integer(input);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
}
