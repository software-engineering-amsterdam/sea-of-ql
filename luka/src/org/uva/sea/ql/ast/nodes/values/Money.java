package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;


public class Money extends Value{

	private final double value;
	
	public Money(double val){
		this.value = val;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Type typeOf(Map<Ident, Type> typeEnv) {
//		return new MoneyType();
//	}
//
//	@Override
//	public <T> T accept(Visitor<T> visitor) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
