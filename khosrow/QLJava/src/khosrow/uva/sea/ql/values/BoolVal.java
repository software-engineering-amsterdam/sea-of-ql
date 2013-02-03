package khosrow.uva.sea.ql.values;

public class BoolVal extends Value {	
	private final Boolean value;
	
	public BoolVal(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	@Override
	public int compareTo(Value value) {
		return getValue().compareTo(((BoolVal)value).getValue());
	}
}
