package org.uva.sea.ql.values;

public class VMoney extends Value {
	private final Double value;
	public VMoney(Double value){
		this.value = value;
	}
	public Double getValue(){
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
		return val.addMoney(this);
	}
	@Override
	public Value div(Value val) {
		return val.divMoney(this);
	}
	@Override
	public Value mul(Value val) {
		return val.mulMoney(this);
	}
	@Override
	public Value pos(Value val) {
		return val.posMoney(this);
	}
	@Override
	public Value neg(Value val) {
		return val.negMoney(this);
	}
	@Override
	public Value sub(Value val) {
		return val.subMoney(this);
	}
	@Override
	protected Value addMoney(VMoney val) {
		return new VMoney(val.getValue() + getValue());
	}
	@Override
	protected Value divMoney(VMoney val) {
		return new VMoney(val.getValue() / getValue());
	}
	@Override
	protected Value mulMoney(VMoney val) {
		return new VMoney(val.getValue() * getValue());
	}
	@Override
	protected Value subMoney(VMoney val) {
		return new VMoney(val.getValue() - getValue());
	}
	@Override
	protected Value posMoney(VMoney val) {
		return new VMoney(getValue() * -1);
	}
	@Override
	protected Value negMoney(VMoney val) {
		return new VMoney(getValue() * -1);
	}
	@Override
	public String toString() {
		return "VMoney: " + this.value.toString();
	}
}
