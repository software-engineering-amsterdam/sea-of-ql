package org.uva.sea.ql.visitor.eval.value;

public class String extends AbstractValue {

	private final java.lang.String value;

	public String(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof String)) {
			return false;
		}

		String value = (String) obj;
		return this.value == value.getValue();
	}

	@Override
	public java.lang.String toString() {
		return this.value;
	}

}
