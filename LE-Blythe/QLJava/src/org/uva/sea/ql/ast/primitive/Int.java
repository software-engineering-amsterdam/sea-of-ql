package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Int extends Primitive {

	private Integer value;
	
	public Int(){
		value = null;
	}
	
	
	public Int(int n){
		value = n;
	}


	public boolean isDefined(){
		return value != null;
	}
	
	
	public Integer getValue(){
		return value;
	}
	
	
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Int();
	}
	
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}	
}
