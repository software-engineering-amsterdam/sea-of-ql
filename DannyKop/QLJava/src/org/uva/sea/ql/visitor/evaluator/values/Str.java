package org.uva.sea.ql.visitor.evaluator.values;
/**
 * Class: Str
 * @author Danny
 *
 */
public class Str extends Value {
	private final String value;
	/**
	 * Constructor
	 * @param v - value
	 */
	public Str(String v){
		this.value = v;
	}
	public String getValue(){
		return this.value;
	}
	
	@Override
	public Value eq(Value arg){
		return arg.eqStr(this);
	}
	@Override
	public Value nEq(Value arg){
		return arg.nEqStr(this);
	}
	/**
	 * Below the arguments are reversed because of double dispatch
	 */
	@Override
	protected Value eqStr(Str arg){
		return new Bool(arg.getValue().equals(getValue()));
	}
	@Override
	protected Value nEqStr(Str arg){
		return new Bool(!arg.getValue().equals(getValue()));
	}
}
