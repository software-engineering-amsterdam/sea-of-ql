package org.uva.sea.ql.ast.types.datatypes;

/**
 * Represents a data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public abstract class DataType {
	/**
	 * Retrieves whether the current type is compatible with an int or not
	 * @return whether the current type is compatible with an int or not
	 */
	public boolean isCompatibleToInt() {
		return false;
	}

	/**
	 * Retrieves whether the current type is compatible with a numeric or not
	 * @return whether the current type is compatible with a numeric or not
	 */
	public boolean isCompatibleToNumeric() {
		return false;
	}
	
	/**
	 * Retrieves whether the current type is compatible with a string or not
	 * @return whether the current type is compatible with a string or not
	 */
	public boolean isCompatibleToString() {
		return false;
	}

	/**
	 * Retrieves whether the current type is compatible with a bool or not
	 * @return whether the current type is compatible with an bool or not
	 */
	public boolean isCompatibleToBool() {
		return false;
	}

	/**
	 * Retrieves whether the current type is compatible with the money type or not
	 * @return whether the current type is compatible with the money type or not
	 */
	public boolean isCompatibleToMoney() {
		return false;
	}

	/**
	 * Retrieves whether the current type is the same as the given type
	 * @return whether the current type is the same as the given type
	 */
	public boolean isSameTypeAs(final DataType dataType) {
		if (dataType == null)
		{
			return false;
		}

		return getClass().equals(dataType.getClass());
	}
}
