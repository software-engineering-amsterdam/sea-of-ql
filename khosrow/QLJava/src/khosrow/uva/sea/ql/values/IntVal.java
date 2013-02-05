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
		return this.addMoney((MoneyVal)arg);
	}
	
	@Override
	public Value sub(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.subInt(this);
		return this.subMoney((MoneyVal)arg);
	}
	
	@Override
	public Value mul(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.mulInt(this);
		return this.mulMoney((MoneyVal)arg);
	}
	
	@Override
	public Value mod(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.modInt(this);
		return this.modMoney((MoneyVal)arg);
	}	
	
	@Override
	public Value div(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.divInt(this);
		return this.divMoney((MoneyVal)arg);
	}
	
	@Override
	public Value pos() {
		return this;
	}
	
	@Override
	public Value neg() {
		return new IntVal(-1 * getValue());
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
	
	@Override
	protected Value addMoney(MoneyVal arg) {
		return arg.add(this.convertToMoney());
	}
	
	@Override
	protected Value subMoney(MoneyVal arg) {
		return arg.sub(this.convertToMoney());
	}
	
	@Override
	protected Value mulMoney(MoneyVal arg) {
		return arg.mul(this.convertToMoney());
	}
	
	@Override
	protected Value divMoney(MoneyVal arg) {
		return arg.div(this.convertToMoney());
	}
	
	@Override
	protected Value modMoney(MoneyVal arg) {
		return arg.mod(this.convertToMoney());
	}
	
	private MoneyVal convertToMoney() {
		return new MoneyVal(getValue());
	}
	
}
