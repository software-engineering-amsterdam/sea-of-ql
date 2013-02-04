package khosrow.uva.sea.ql.values;

public class BoolVal implements IValue {	
	private final Boolean value;
	
	public BoolVal(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	public int compareTo(IValue value) {
		return getValue().compareTo(((BoolVal)value).getValue());
	}
}
