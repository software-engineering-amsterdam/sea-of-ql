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
	public Value add(Value arg) {
		return arg.addMoney(this);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subMoney(this);
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulMoney(this);
	}

	@Override
	public Value mod(Value arg) {
		return arg.modMoney(this);
	}

	@Override
	public Value div(Value arg) {
		return arg.divMoney(this);
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
	public Value eq(Value arg) {
		return new BoolVal(arg.compareToMoney(this) == 0);
	}

	@Override
	public Value neq(Value arg) {
		return new BoolVal(arg.compareToMoney(this) != 0);
	}

	@Override
	public Value geq(Value arg) {
		return new BoolVal(arg.compareToMoney(this) >= 0);
	}

	@Override
	public Value gt(Value arg) {
		return new BoolVal(arg.compareToMoney(this) > 0);
	}

	@Override
	public Value leq(Value arg) {
		return new BoolVal(arg.compareToMoney(this) <= 0);
	}

	@Override
	public Value lt(Value arg) {
		return new BoolVal(arg.compareToMoney(this) < 0);
	}

	@Override
	protected Value addInt(IntVal arg) {
		return new MoneyVal(arg.getValue() + getValue());
	}

	@Override
	protected Value subInt(IntVal arg) {
		return new MoneyVal(arg.getValue() - getValue());
	}

	@Override
	protected Value mulInt(IntVal arg) {
		return new MoneyVal(arg.getValue() * getValue());
	}

	@Override
	protected Value divInt(IntVal arg) {
		return new MoneyVal(arg.getValue() / getValue());
	}

	@Override
	protected Value modInt(IntVal arg) {
		return new MoneyVal(arg.getValue() % getValue());
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
