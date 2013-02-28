package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IVisitorExpr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public class Undefined extends Primitive {

	private Type type;
	
	public Undefined(){
		this.type = new org.uva.sea.ql.ast.type.UndefinedType();
	}
	
	
	public Undefined(Type t){
		this.type = t;
	}


	public boolean isDefined(){
		return false;
	}

	@Override
	public Type typeOf(Environment<Ident, Type> env) {
		return type;
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Undefined";
	}
}
