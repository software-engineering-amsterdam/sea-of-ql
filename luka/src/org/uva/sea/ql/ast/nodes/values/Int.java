package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;


public class Int extends Value{

	private final int value;
	public Int(int val){
		this.value = val;
	}
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Type typeOf(Map<Ident, Type> typeEnv) {
//		return new IntType();
//	}
//
//	@Override
//	public <T> T accept(Visitor<T> visitor) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
