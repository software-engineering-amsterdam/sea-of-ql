package khosrow.uva.sea.ql.values;

public class StrVal extends Value {
	private final String value;
	
	public StrVal(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int compareTo(Value value) {
		return getValue().compareTo(((StrVal)value).getValue());
	}
}
