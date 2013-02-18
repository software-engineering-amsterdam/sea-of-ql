package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.IVisitorType;

public class Numeric extends Type{

	@Override
	public String toString(){
		return "numeric";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
}
