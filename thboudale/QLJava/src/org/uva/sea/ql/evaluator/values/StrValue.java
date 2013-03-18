package org.uva.sea.ql.evaluator.values;

public class StrValue extends AValue {
	private final String value;
	
	public StrValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public AValue eq(AValue arg) {
		return arg.eqStr(this);
	}
	
	@Override
	public AValue neq(AValue arg) {
		return arg.neqStr(this);
	}
	
	@Override
	protected AValue eqStr(StrValue arg) {
		return new BoolValue(arg.getValue() == this.getValue());
	}
	
	@Override
	protected AValue neqStr(StrValue arg) {
		return new BoolValue(arg.getValue() != this.getValue());
	}
}