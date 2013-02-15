package org.uva.sea.ql.visitor.evaluator.values;
/**
 * Class: Bool
 * @author Danny
 *
 */
public class Bool extends Value {
	private final boolean value;
	/**
	 * Constructor
	 * @param v - value
	 */
	public Bool(boolean v){
		this.value = v;
	}
	public Boolean getValue(){
		return this.value;
	}
	@Override
	public Value and(Value arg){
		return arg.andBool(this);
	}
	@Override
	public Value or(Value arg){
		return arg.orBool(this);
	}
	@Override
	public Value eq(Value arg){
		return arg.eqBool(this);
	}
	@Override
	public Value nEq(Value arg){
		return arg.nEqBool(this);
	}
	@Override
	public Value not(Value arg){
		return arg.notBool(this);
	}
	/**
	 * Below the arguments are reversed because of double dispatch
	 */
	@Override
	protected Value andBool(Bool arg){
		return new Bool(arg.getValue() && getValue());
	}
	@Override
	protected Value orBool(Bool arg){
		return new Bool(arg.getValue() || getValue());
	}
	@Override
	protected Value eqBool(Bool arg){
		return new Bool(arg.getValue() == getValue());
	}
	@Override
	protected Value nEqBool(Bool arg){
		return new Bool(arg.getValue() != getValue());
	}
}
