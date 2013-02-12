package khosrow.uva.sea.ql.values;

public class IntVal extends NumericVal {
	private final Integer value;
	
	public IntVal(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public boolean isCompatibleToInt() { return true; }
	
	@Override
	public int compareTo(Value value) {
		return getValue() - ((IntVal)value).getValue();
	}
		
	@Override
	public Value add(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.addInt(this);
		return arg.add(this.convertToMoney());
	}
	
	@Override
	public Value sub(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.subInt(this);
		return arg.sub(this.convertToMoney());
	}
	
	@Override
	public Value mul(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.mulInt(this);
		return arg.mul(this.convertToMoney());
	}
	
	@Override
	public Value mod(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.modInt(this);
		return arg.mod(this.convertToMoney());
	}	
	
	@Override
	public Value div(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.divInt(this);
		return arg.div(this.convertToMoney());
	}
	
	@Override
	public Value pos() {
		return this;
	}
	
	@Override
	public Value neg() {
		return new IntVal(-1 * getValue());
	}
	
	public Value eq(Value arg) {
		//if(arg.isCompatibleToInt())
			return new BoolVal((false));
	}
	
	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
		
	@Override
	protected Value addInt(IntVal arg) {
		return new IntVal(arg.getValue() + getValue());
	}
	
	@Override
	protected Value subInt(IntVal arg) {
		return new IntVal(arg.getValue() - getValue());
	}
	
	@Override
	protected Value mulInt(IntVal arg) {
		return new IntVal(arg.getValue() * getValue());
	}
	
	@Override
	protected Value divInt(IntVal arg) {
		return new IntVal(arg.getValue() / getValue());
	}
	
	@Override
	protected Value modInt(IntVal arg) {
		return new IntVal(arg.getValue() % getValue());
	}
	
	private Value convertToMoney() {
		return new MoneyVal(getValue());
	}
	
}
