package org.uva.sea.ql.eval.value;


public class StrVal extends Value {

	private String value;
	
	public StrVal(String s){
		value = s;
	}
	
	
	public String getValue(){
		return value;
	}
	

	@Override
	public String toString(){
		return value;
	}
	
	// ----------- Generic Comparative-------------------------
	@Override
	public Value eq(Value arg) {
		return arg.eqStr(this);
	}

	@Override
	public Value nEq(Value arg) {
		return arg.nEqStr(this);
	}

	// ----------- Str Comparative -------------------------
	@Override
	protected Value eqStr(StrVal arg) {
		return new BoolVal(this.getValue().equals(arg.getValue()));
	}

	@Override
	protected Value nEqStr(StrVal arg) {
		return new BoolVal(!this.getValue().equals(arg.getValue()));
	}
}
