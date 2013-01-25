<<<<<<< HEAD
package org.uva.sea.ql.ast.values;

public class BoolValue extends Value {
	
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
}
=======
package org.uva.sea.ql.ast.values;

public class BoolValue extends Value {
	
	private final boolean value;
	
	public BoolValue() {
		this(false);
	}
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != getClass())
			return false;
		if (obj == this)
			return true;
		
		return ((BoolValue)obj).getValue() == getValue();
	}
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e
