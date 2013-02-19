package org.uva.sea.ql.visitor.evaluator.values;
/**
 * Class: Value
 * @author Danny
 *
 */
public abstract class Value {
	
	public Value add(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value and(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value div(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value mul(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value sub(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value or(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value eq(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value gEq(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value gt(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value lEq(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value lt(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value nEq(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value not(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value neg(Value arg){
		throw new UnsupportedOperationException();
	}
	public Value pos(Value arg){
		throw new UnsupportedOperationException();
	}
	/**
	 * Support real computations 
	 */
	
	protected Value addInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value mulInt(Int arg){
		throw new UnsupportedOperationException();
	}	
	protected Value subInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value divInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value gEqInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value gtInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value lEqInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value ltInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value negInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value posInt(Int arg){
		throw new UnsupportedOperationException();
	}
	protected Value andBool(Bool arg){
		throw new UnsupportedOperationException();
	}
	protected Value orBool(Bool arg){
		throw new UnsupportedOperationException();
	}
	protected Value eqBool(Bool arg){
		throw new UnsupportedOperationException();
	}
	protected Value nEqBool(Bool arg){
		throw new UnsupportedOperationException();
	}
	protected Value notBool(Bool arg){
		throw new UnsupportedOperationException();
	}
	protected Value eqStr(Str arg){
		throw new UnsupportedOperationException();
	}
	protected Value nEqStr(Str arg){
		throw new UnsupportedOperationException();
	}
}
