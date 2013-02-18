package org.uva.sea.ql.ast.types.datatypes;

import java.math.BigDecimal;

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

	@Override
	public boolean isAssignableFrom(final String input) {
		try {
			new BigDecimal(input);
			return true;
		} catch (final NumberFormatException e) {
			return false;
		}
	}
}
