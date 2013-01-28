package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Represents an abstract type.
 */
abstract public class Type extends Node {
	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( ITypeVisitor<T> visitor );

	/**
	 * Determines whether this type is compatible to the given type.
	 *
	 * @param type
	 *
	 * @return True if this type is compatible to the given type, false if it is not.
	 */
	abstract public boolean isCompatibleTo( Type type );

	@Override
	abstract public String toString();

	/**
	 * Determines whether this type is compatible to integer.
	 *
	 * @return True if it is, false if it is not.
	 */
	public boolean isCompatibleToInt() {
		return false;
	}

	/**
	 * Determines whether this type is compatible to boolean.
	 *
	 * @return True if it is, false if it is not.
	 */
	public boolean isCompatibleToBool() {
		return false;
	}

	/**
	 * Determines whether this type is compatible to number.
	 *
	 * @return True if it is, false if it is not.
	 */
	public boolean isCompatibleToNumber() {
		return false;
	}

	/**
	 * Determines whether this type is compatible to string.
	 *
	 * @return True if it is, false if it is not.
	 */
	public boolean isCompatibleToStr() {
		return false;
	}

	/**
	 * Determines whether this type is compatible to money.
	 *
	 * @return True if it is, false if it is not.
	 */
	public boolean isCompatibleToMoney() {
		return false;
	}
}
