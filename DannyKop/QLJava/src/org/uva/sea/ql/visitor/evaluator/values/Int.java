package org.uva.sea.ql.visitor.evaluator.values;
/**
 * Class: Int
 * @author Danny
 *
 */
public class Int extends Value {
	private final Integer value;
	/**
	 * Constructor
	 * @param v - value
	 */
	public Int(Integer v){
		this.value = v;
	}
	public Integer getValue(){
		return this.value;
	}
	@Override
	public Value add(Value arg){
		return arg.addInt(this);
	}
	@Override
	public Value mul(Value arg){
		return arg.mulInt(this);
	}
	@Override
	public Value sub(Value arg){
		return arg.subInt(this);
	}
	@Override
	public Value div(Value arg){
		return arg.divInt(this);
	}
	@Override
	public Value gEq(Value arg){
		return arg.gEqInt(this);
	}
	@Override
	public Value gt(Value arg){
		return arg.gtInt(this);
	}
	@Override
	public Value lEq(Value arg){
		return arg.lEqInt(this);
	}
	@Override
	public Value lt(Value arg){
		return arg.ltInt(this);
	}
	@Override
	public Value neg(Value arg){
		return arg.negInt(this);
	}
	@Override
	public Value pos(Value arg){
		return arg.posInt(this);
	}
	
	/**
	 * Below the arguments are reversed because of double dispatch
	 */
	@Override
	protected Value addInt(Int arg){
		return new Int(arg.getValue() + getValue());
	}
	@Override
	protected Value subInt(Int arg){
		return new Int(arg.getValue() - getValue());
	}
	@Override
	protected Value divInt(Int arg){
		return new Int(arg.getValue() / getValue());
	}
	@Override
	protected Value mulInt(Int arg){
		return new Int(arg.getValue() * getValue());
	}
	@Override
	protected Value gEqInt(Int arg){
		return new Bool(arg.getValue() >= getValue());
	}
	@Override
	protected Value gtInt(Int arg){
		return new Bool(arg.getValue() > getValue());
	}
	@Override
	protected Value lEqInt(Int arg){
		return new Bool(arg.getValue() <= getValue());
	}
	@Override
	protected Value ltInt(Int arg){
		return new Bool(arg.getValue() < getValue());
	}
	@Override
	protected Value negInt(Int arg){
		return new Int(-1 * getValue());
	}
	@Override
	protected Value posInt(Int arg){
		return new Int(getValue());
	}
}
