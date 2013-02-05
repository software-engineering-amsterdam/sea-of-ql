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
	
	
	private MoneyVal convertToMoneyVal() {
		return new MoneyVal(getValue());
	}
	
	
	
	@Override
	public Value add(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.addInt(this);
		return arg.addMoney(this.convertToMoneyVal());
	}
	
	@Override
	public Value sub(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.subInt(this);
		return arg.subMoney(this.convertToMoneyVal());
	}
	
	@Override
	public Value mul(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.mulInt(this);
		return arg.mulMoney(this.convertToMoneyVal());
	}
	
	@Override
	public Value mod(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.modInt(this);
		return arg.modMoney(this.convertToMoneyVal());
	}	
	
	@Override
	public Value div(Value arg) {
		if(arg.isCompatibleToInt())
			return arg.divInt(this);
		return arg.divMoney(this.convertToMoneyVal());
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
		return new MoneyVal(arg.getValue() + getValue());
	}
	
	@Override
	protected Value subMoney(MoneyVal arg) {
		return new MoneyVal(arg.getValue() - getValue());
	}
	
	@Override
	protected Value mulMoney(MoneyVal arg) {
		return new MoneyVal(arg.getValue() * getValue());
	}
	
	@Override
	protected Value divMoney(MoneyVal arg) {
		return new MoneyVal(arg.getValue() / getValue());
	}
	
	@Override
	protected Value modMoney(MoneyVal arg) {
		return new MoneyVal(arg.getValue() % getValue());
	}
		
	
}
