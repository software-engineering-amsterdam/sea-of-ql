package khosrow.uva.sea.ql.values;

public abstract class Value {
	
	/**
	 * @param value
	 * @return
	 * zero if this object represents the same value as the argument; 
	 * a positive value if this object represents a value greater than the argument; 
	 * and a negative value if this object represents a value less than the argument.

	 */
	public abstract int compareTo(Value value);
	
}
