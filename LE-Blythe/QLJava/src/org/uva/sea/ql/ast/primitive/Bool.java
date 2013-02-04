package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Bool extends Primitive {

	private boolean value;
	
	public Bool(boolean b){
		value = b;
	}
	
	
	public Boolean getValue(){
		return value;
	}
	
	
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Bool();
	}
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
