package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;


public class Money extends Numeric {//Value{

//	private final Integer value;
	
	public Money(Integer val){
		super(val);
		this.value =  val;
	}
	
//	PUBLIC INTEGER GETVALUE(){
//		RETURN THIS.VALUE;
//	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new MoneyType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
//
//
//	@Override
//	public String toString() {
//		return "Money("+this.value+")";
//	}
//
//	@Override
//	public Value and(Value arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Value or(Value arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Value not() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value andBool(Bool arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value orBool(Bool arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value equBool(Bool arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value notBool(Bool arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Value pos() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value posInt(Numeric arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Value gEqInt(Numeric arg) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
