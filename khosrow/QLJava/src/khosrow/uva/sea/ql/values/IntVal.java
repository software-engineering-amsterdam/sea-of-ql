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
	public int compareTo(Value value) {
		return getValue() - ((IntVal)value).getValue();
	}
	
	@Override
	public double convertToMoneyVal() {
		return getValue().doubleValue();
	}
	
	@Override
	public int convertToIntVal() {
		return getValue();
	}	
}
