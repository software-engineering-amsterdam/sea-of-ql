package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.interfaces.IVisitorType;

public class Int extends Numeric{

	@Override
	public String toString(){
		return "integer";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
}
