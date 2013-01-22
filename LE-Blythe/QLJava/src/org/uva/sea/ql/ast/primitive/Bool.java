package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Bool extends Primitive {

	private final Boolean value;
	
	public Bool(){
		value = null;
	}
	
	
	public Bool(boolean b){
		value = b;
	}
	

	public boolean isDefined() {
		return value != null;
	}

	
	/**
	 * @precondition: isDefined() has been called to confirm the value in this object was
	 * initialized
	 */
	public boolean getValue(){
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
