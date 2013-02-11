package khosrow.uva.sea.ql.values;

import java.math.BigDecimal;

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
		return arg.add(this);	
	}
	
	@Override
	public Value sub(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.subMoney(this);
		return arg.sub(this);
	}
	
	@Override
	public Value mul(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.mulMoney(this);
		return arg.mul(this);
	}
	
	@Override
	public Value mod(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.modMoney(this);
		return arg.mod(this);
	}	
	
	@Override
	public Value div(Value arg) {
		if(arg.isCompatibleToMoney())
			return arg.divMoney(this);
		return arg.div(this);
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
		BigDecimal a = new BigDecimal(arg.getValue());
	    BigDecimal b = new BigDecimal(getValue());
		
		return new MoneyVal(a.subtract(b).ROUND_FLOOR);
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
