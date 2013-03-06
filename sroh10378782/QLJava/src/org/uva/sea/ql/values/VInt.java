package org.uva.sea.ql.values;

public class VInt extends Value{
	private final Integer value;
	public VInt(Integer value){
		this.value = value;
	}
	public Integer getValue(){
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
	public Value add(Value val) {
		return val.addInt(this);
	}
	@Override
	public Value div(Value val) {
		return val.divInt(this);
	}
	@Override
	public Value mul(Value val) {
		return val.mulInt(this);
	}
	@Override
	public Value pos(Value val) {
		return val.posInt(this);
	}
	@Override
	public Value neg(Value val) {
		return val.negInt(this);
	}
	@Override
	public Value sub(Value val) {
		return val.subInt(this);
	}
	@Override
	protected Value addInt(VInt val) {
		return new VInt(val.getValue() + getValue());
	}
	@Override
	protected Value divInt(VInt val) {
		return new VInt(val.getValue() / getValue());
	}
	@Override
	protected Value mulInt(VInt val) {
		return new VInt(val.getValue() * getValue());
	}
	@Override
	protected Value subInt(VInt val) {
		return new VInt(val.getValue() - getValue());
	}
	@Override
	protected Value posInt(VInt val) {
		return new VInt(getValue() * -1);
	}
	@Override
	protected Value negInt(VInt val) {
		return new VInt(getValue() * -1);
	}
	
	@Override
	public String toString() {
		return "VInt: " + this.value.toString();
	}
}
