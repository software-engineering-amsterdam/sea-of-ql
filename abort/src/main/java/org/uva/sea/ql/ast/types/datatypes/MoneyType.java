package org.uva.sea.ql.ast.types.datatypes;

/**
 * Represents money data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class MoneyType extends NumericType {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
}
