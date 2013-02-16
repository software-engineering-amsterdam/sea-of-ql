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
	public Value not() {
		return new BoolVal(!getValue());
	}
	
	@Override
	public Value and(Value arg) {
		return arg.andWith(this);
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orWith(this);
	}
	
	@Override
	public Value eq(Value arg) {
		return new BoolVal(arg.compareToBool(this));
	}
	
	@Override
	public Value neq(Value arg) {
		return new BoolVal(!arg.compareToBool(this));
	}
	
	@Override
	protected Value andWith(BoolVal arg) {
		return new BoolVal(arg.getValue() && getValue());
	}
	
	@Override
	protected Value orWith(BoolVal arg) {
		return new BoolVal(arg.getValue() || getValue());
	}
	
	@Override
	protected boolean compareToBool(BoolVal arg) {
		return arg.getValue().compareTo(getValue()) == 0;
	}
}
