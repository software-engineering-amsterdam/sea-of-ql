package khosrow.uva.sea.ql.values;

public class MoneyVal extends NumericVal {
	private final Double value;
	
	public MoneyVal(double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}
	
	@Override
	public boolean isCompatibleToMoney() { return true; }

	@Override
	public int compareTo(Value value) {
		return (int) (getValue() - ((MoneyVal)value).getValue());
	}
	
	@Override
	public Value add(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.addMoney(this);
		return this.addInt((IntVal)arg);
	}
	
	@Override
	public Value sub(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.subMoney(this);
		return this.subInt((IntVal)arg);
	}
	
	@Override
	public Value mul(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.mulMoney(this);
		return this.mulInt((IntVal)arg);
	}
	
	@Override
	public Value mod(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.modMoney(this);
		return this.modInt((IntVal)arg);
	}	
	
	@Override
	public Value div(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.divMoney(this);
		return this.divInt((IntVal)arg);
	}
	
	@Override
	public Value pos() {
		return this;
	}
	
	@Override
	public Value neg() {
		return new MoneyVal(-1 * getValue());
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
	
	@Override
	protected Value addInt(IntVal arg) {
		return arg.add(this);
	}
	
	@Override
	protected Value subInt(IntVal arg) {
		return arg.sub(this);
	}
	
	@Override
	protected Value mulInt(IntVal arg) {
		return arg.mul(this);
	}
	
	@Override
	protected Value divInt(IntVal arg) {
		return arg.div(this);
	}
	
	@Override
	protected Value modInt(IntVal arg) {
		return arg.mod(this);
	}
	
}
