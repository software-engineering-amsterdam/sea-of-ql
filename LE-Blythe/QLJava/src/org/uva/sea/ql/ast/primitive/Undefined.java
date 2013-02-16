package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class Undefined extends Primitive {

	private Type type;
	
	public Undefined(){
		this.type = new org.uva.sea.ql.ast.types.Undefined();
	}
	
	
	public Undefined(Type t){
		this.type = t;
	}


	public boolean isDefined(){
		return false;
	}
	

	public Type typeOf(Environment env){
		return type;
	}
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
}
