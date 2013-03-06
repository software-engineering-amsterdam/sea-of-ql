package org.uva.sea.ql.values;

public class VBool extends Value{
	private final Boolean value;
	public VBool(Boolean value){
		this.value = value;
	}
	public Boolean getValue(){
		return this.value;
	}
	@Override
	public boolean isDefined() {
		if(this.value != null){
			return true;
		}
		return false;
	}
	
	@Override
	public Value and(Value val) {
		return val.andBool(this);
	}
	@Override
	public Value eq(Value val) {
		return val.eqBool(this);
	}
	@Override
	public Value neq(Value val) {
		return val.neqBool(this);
	}
	@Override
	public Value not(Value val) {
		return val.notBool(this);
	}
	@Override
	public Value or(Value val) {
		return val.orBool(this);
	}
	
	@Override
	protected Value andBool(VBool val) {
		return new VBool(val.getValue() && getValue());
	}
	@Override
	protected Value eqBool(VBool val) {
		return new VBool(val.getValue() == getValue());
	}
	@Override
	protected Value neqBool(VBool val) {
		return new VBool(val.getValue() != getValue());
	}
	@Override
	protected Value notBool(VBool val) {
		return new VBool(!val.getValue());
	}
	@Override
	protected Value orBool(VBool val) {
		return new VBool(val.getValue() || getValue());
	}
	@Override
	public String toString() {
		return "VBool:" +this.value.toString();
	}
}