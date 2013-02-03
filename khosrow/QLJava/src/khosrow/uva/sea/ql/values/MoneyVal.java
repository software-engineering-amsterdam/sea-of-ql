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
	public int compareTo(Value value) {
		return (int) (getValue() - ((MoneyVal)value).getValue());
	}
	
	@Override
	public double convertToMoneyVal() {
		return getValue();
	}
	
	@Override
	public int convertToIntVal() {
		return getValue().intValue();
	}
}
