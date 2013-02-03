package khosrow.uva.sea.ql.values;

public class StrVal implements IValue {
	private final String value;
	
	public StrVal(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public int compareTo(IValue value) {
		return getValue().compareTo(((StrVal)value).getValue());
	}
}
