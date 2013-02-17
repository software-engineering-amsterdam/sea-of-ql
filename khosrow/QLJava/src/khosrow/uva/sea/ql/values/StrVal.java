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
	public String toString(){
		return getValue().toString();
	}
	
	@Override
	public Value eq(Value arg) {
		return new BoolVal(arg.compareToString(this));
	}
	
	@Override
	public Value neq(Value arg) {
		return new BoolVal(!arg.compareToString(this));
	}
	
	@Override
	protected boolean compareToString(StrVal arg) {
		return arg.getValue().equalsIgnoreCase(getValue());
	}
}
