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
	public Value add(Value arg) {
		return arg.addInt(this);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}

	@Override
	public Value mod(Value arg) {
		return arg.modInt(this);
	}

	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
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
	public Value eq(Value arg) {
		return new BoolVal(arg.compareToInt(this) == 0);
	}

	@Override
	public Value neq(Value arg) {
		return new BoolVal(arg.compareToInt(this) != 0);
	}

	@Override
	public Value geq(Value arg) {
		return new BoolVal(arg.compareToInt(this) >= 0);
	}

	@Override
	public Value gt(Value arg) {
		return new BoolVal(arg.compareToInt(this) > 0);
	}

	@Override
	public Value leq(Value arg) {
		return new BoolVal(arg.compareToInt(this) <= 0);
	}

	@Override
	public Value lt(Value arg) {
		return new BoolVal(arg.compareToInt(this) < 0);
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
	
	@Override
	protected double compareToInt(IntVal arg) {
		return arg.getValue() - getValue();	
	}
	
	@Override
	protected double compareToMoney(MoneyVal arg) {
		return arg.getValue() - getValue();	
	}
}
