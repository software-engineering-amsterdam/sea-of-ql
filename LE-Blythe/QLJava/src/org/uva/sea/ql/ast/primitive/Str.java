package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Str extends Primitive {

	private final String value;
	
	public Str(){
		value = null;
	}
	
	
	public Str(String s){
		value = s;
	}
	
	
	public String getValue(){
		return value;
	}
	
	
	public boolean isDefined(){
		return value != null;
	}
	
	
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Str();
	}
	
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
